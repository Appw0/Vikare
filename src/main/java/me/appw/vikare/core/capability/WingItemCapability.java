package me.appw.vikare.core.capability;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import me.appw.vikare.Vikare;
import me.appw.vikare.client.VikareClient;
import me.appw.vikare.client.models.WingsModel;
import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.network.client.CPlayerFlappingPacket;
import me.appw.vikare.core.network.client.CPlayerFlappingPacket.FlappingState;
import me.appw.vikare.core.registry.WingTypes.WingType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.settings.PointOfView;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.theillusivec4.caelus.api.CaelusApi;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nonnull;
import java.util.UUID;

public class WingItemCapability implements ICurio {
    private final ItemStack stack;
    private final WingItem wings;
    private final WingType wingType;
    private WingsModel<LivingEntity> wingsModel;
    private boolean forcedFlap = false;
    private boolean shouldSlowFall;
    private float last_movement = 0.0F;

    public WingItemCapability(ItemStack stack) {
        this.stack = stack;
        wings = (WingItem) stack.getItem();
        wingType = wings.getWingType();

        try {
            wingsModel = (WingsModel<LivingEntity>) VikareClient.MODELS.get(wingType).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            Vikare.LOGGER.error(e);
        } catch (NullPointerException ignored) {
        }
    }

    @Override
    public void curioTick(String identifier, int index, LivingEntity entity) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            if (player.getFoodStats().getFoodLevel() <= 6) { return; }

            if (player.isElytraFlying()) {
                if (player.moveForward > 0) {
                    if (wings.isUsable(stack)) applySpeed(player);
                    CPlayerFlappingPacket.send(last_movement == 0 ? FlappingState.STARTED : FlappingState.NONE);
                } else if (last_movement > 0) {
                    CPlayerFlappingPacket.send(FlappingState.ENDED);
                }
                last_movement = player.moveForward;

                if (player.isSneaking()) {
                    stopFlying(player);
                }
                if (player.getPosY() > player.world.getHeight() + 64 && player.ticksExisted % 20 == 0 && WingItem.MELTS.contains(wings)) {
                    stack.damageItem(1, player, p -> CuriosApi.getCuriosHelper().onBrokenCurio(identifier, index, p));
                }

                if (!wings.isUsable(stack)) {
                    wingsModel.setBroken();
                    ModifiableAttributeInstance gravity = player.getAttribute(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());
                    double adjustedLift = gravity.getValue() * -MathHelper.cos(player.rotationPitch * ((float)Math.PI / 180F));;
                    Vector3d velocity = player.getMotion().add(0.0D, adjustedLift, 0.0D);
                    player.setMotion(velocity.x, velocity.y, velocity.z);
                }
            } else {
                if (player.isOnGround() || player.isInWater()) {
                    shouldSlowFall = false;
                }
                if (shouldSlowFall) {
                    if (wingsModel != null) wingsModel.setSlowFall();
                        player.fallDistance = wings.isUsable(stack) ? 0F : Math.min(player.fallDistance, 10F);
                        player.setMotion(player.getMotion().x, wings.isUsable(stack) ? -0.4 : -1, player.getMotion().z);
                }
            }
            if (player.world.isRemote) {
                Minecraft minecraft = Minecraft.getInstance();
                if (minecraft.player == player && minecraft.gameSettings.getPointOfView() == PointOfView.FIRST_PERSON ) {
                    // these interesting shenanigans here are to continue to simulate wing-flapping while in first person
                    // even though the model is not rendered, to allow the wing-flap sound to still be played
                    wingsModel.setRotationAngles(player);
                }
                if (wingsModel.didFlap()) {
                    float vol = 10.0F;
                    if (Minecraft.getInstance().player == player) {
                        vol = 100.0F;
                    }
                    player.world.playSound(player.getPosX(), player.getPosY(), player.getPosZ(), wingType.flapSound.get(), SoundCategory.PLAYERS, vol, 0.9F + player.world.rand.nextFloat() * 0.2F, false);
                }
            }
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
        Multimap<Attribute, AttributeModifier> atts = LinkedHashMultimap.create();
        atts.put(CaelusApi.ELYTRA_FLIGHT.get(), new AttributeModifier(uuid, "Flight modifier", 1.0f, AttributeModifier.Operation.ADDITION));
        return atts;
    }

    @Nonnull
    @Override
    public ICurio.SoundInfo getEquipSound(SlotContext slotContext) {
        return new ICurio.SoundInfo(wingType.equipSound.get(), 1.0f, 1.0f);
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext) { return true; }

    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean canRender(String identifier, int index, LivingEntity livingEntity) { return true; }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void render(String identifier, int index, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light,
                       LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks,
                       float netHeadYaw, float headPitch) {
        float[] primaryColor = wings.getPrimaryColor().getColorComponentValues();
        float[] secondaryColor = wings.getSecondaryColor().getColorComponentValues();

        String wingTypeString = wings.getWingTypeName();

        // same with these TODO: put in registry
        ResourceLocation layer1 = new ResourceLocation(Vikare.MODID, "textures/entity/" + wingTypeString + "_wings.png");
        ResourceLocation layer2 = new ResourceLocation(Vikare.MODID, "textures/entity/" + wingTypeString + "_wings_2.png");

        matrixStack.translate(0.0D, 0.0D, 0.125D);

        if (Minecraft.getInstance().player == livingEntity) {
            wingsModel.setRotationAngles(livingEntity, limbSwing, limbSwingAmount, ageInTicks, headPitch, netHeadYaw);
        } else {
            wingsModel.setRotationAngles(livingEntity, limbSwing, limbSwingAmount, ageInTicks, headPitch, netHeadYaw, forcedFlap);
        }

        IVertexBuilder vertexBuilder = ItemRenderer.getBuffer(renderTypeBuffer, wingsModel.getRenderType(layer2), false, stack.hasEffect());
        wingsModel.render(matrixStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY, secondaryColor[0], secondaryColor[1], secondaryColor[2], 1.0F);

        vertexBuilder = ItemRenderer.getBuffer(renderTypeBuffer, wingsModel.getRenderType(layer1), false, stack.hasEffect());
        wingsModel.render(matrixStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY, primaryColor[0], primaryColor[1], primaryColor[2], 1.0F);
    }

    public void stopFlying(PlayerEntity player) {
        shouldSlowFall = true;
        player.stopFallFlying();
    }

    public void applySpeed(PlayerEntity player) {
        shouldSlowFall = false;
        Vector3d rotation = player.getLookVec();
        Vector3d velocity = player.getMotion();
        float modifier = VikareConfig.COMMON.armorSlows.get() ? MathHelper.clamp(player.getTotalArmorValue() / 10F, 1F, VikareConfig.COMMON.maxSlowedMultiplier.get()) : 1F;

        velocity = velocity.add(rotation.x * (wings.speed / modifier) + (rotation.x * 1.5D - velocity.x) * wings.acceleration, rotation.y * (wings.speed / modifier) + (rotation.y * 1.5D - velocity.y) * wings.acceleration, rotation.z * (wings.speed / modifier) + (rotation.z * 1.5D - velocity.z) * wings.acceleration);
        player.setMotion(velocity.x, velocity.y, velocity.z);
    }

    public void setForcedFlap(boolean forcedFlap) {
        this.forcedFlap = forcedFlap;
    }
}
