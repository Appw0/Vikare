package me.appw.vikare.core.capability;


import baubles.api.IBauble;
import baubles.api.render.IRenderBauble;
import me.appw.vikare.Vikare;
import me.appw.vikare.client.VikareClient;
import me.appw.vikare.client.models.WingsModel;
import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.registry.Items;
import me.appw.vikare.core.registry.WingTypes.WingType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import static me.appw.vikare.Vikare.WING_ITEM_CAPABILITY;

public class WingItemCapability implements ICapabilityProvider {
    private final ItemStack stack;
    private final WingItem wings;
    private final WingType wingType;
    private WingsModel wingsModel;
    private boolean forcedFlap = false;
    private boolean shouldSlowFall;
    private float last_movement = 0.0F;

    public WingItemCapability() {
        this.stack = ItemStack.EMPTY;
        this.wings = (WingItem) Items.ORANGE_FEATHERED_WINGS;
        this.wingType = wings.getWingType();
    }
    public WingItemCapability(ItemStack stack) {
        this.stack = stack;
        wings = (WingItem) stack.getItem();
        wingType = wings.getWingType();

        try {
            wingsModel = (WingsModel) VikareClient.MODELS.get(wingType).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            Vikare.LOGGER.error(e);
        } catch (NullPointerException ignored) {
        }
    }

//    @Override
//    public void curioTick(String identifier, int index, LivingEntity entity) {
//        if (entity instanceof PlayerEntity) {
//            PlayerEntity player = (PlayerEntity) entity;
//            if (player.getFoodStats().getFoodLevel() <= 6) { return; }
//
//            if (player.isElytraFlying()) {
//                if (player.moveForward > 0) {
//                    if (wings.isUsable(stack)) applySpeed(player);
//                    CPlayerFlappingPacket.send(last_movement == 0 ? FlappingState.STARTED : FlappingState.NONE);
//                } else if (last_movement > 0) {
//                    CPlayerFlappingPacket.send(FlappingState.ENDED);
//                }
//                last_movement = player.moveForward;
//
//                if (player.isSneaking()) {
//                    stopFlying(player);
//                }
//                if (player.getPosY() > player.world.getHeight() + 64 && player.ticksExisted % 20 == 0 && WingItem.MELTS.contains(wings)) {
//                    stack.damageItem(1, player, p -> CuriosApi.getCuriosHelper().onBrokenCurio(identifier, index, p));
//                }
//
//                if (!wings.isUsable(stack)) {
//                    wingsModel.setBroken();
//                    ModifiableAttributeInstance gravity = player.getAttribute(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());
//                    double adjustedLift = gravity.getValue() * -MathHelper.cos(player.rotationPitch * ((float)Math.PI / 180F));;
//                    Vector3d velocity = player.getMotion().add(0.0D, adjustedLift, 0.0D);
//                    player.setMotion(velocity.x, velocity.y, velocity.z);
//                }
//            } else {
//                if (player.isOnGround() || player.isInWater()) {
//                    shouldSlowFall = false;
//                }
//                if (shouldSlowFall) {
//                    if (wingsModel != null) wingsModel.setSlowFall();
//                        player.fallDistance = wings.isUsable(stack) ? 0F : Math.min(player.fallDistance, 10F);
//                        player.setMotion(player.getMotion().x, wings.isUsable(stack) ? -0.4 : -1, player.getMotion().z);
//                }
//            }
//            if (player.world.isRemote) {
//                Minecraft minecraft = Minecraft.getInstance();
//                if (minecraft.player == player && minecraft.gameSettings.getPointOfView() == PointOfView.FIRST_PERSON ) {
//                    // these interesting shenanigans here are to continue to simulate wing-flapping while in first person
//                    // even though the model is not rendered, to allow the wing-flap sound to still be played
//                    wingsModel.setRotationAngles(player);
//                }
//                if (wingsModel.didFlap()) {
//                    float vol = 10.0F;
//                    if (Minecraft.getInstance().player == player) {
//                        vol = 100.0F;
//                    }
//                    player.world.playSound(player.getPosX(), player.getPosY(), player.getPosZ(), wingType.flapSound.get(), SoundCategory.PLAYERS, vol, 0.9F + player.world.rand.nextFloat() * 0.2F, false);
//                }
//            }
//        }
//    }
//
//    @Override
//    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
//        Multimap<Attribute, AttributeModifier> atts = LinkedHashMultimap.create();
//        atts.put(CaelusApi.ELYTRA_FLIGHT.get(), new AttributeModifier(uuid, "Flight modifier", 1.0f, AttributeModifier.Operation.ADDITION));
//        return atts;
//    }
//
//    @Nonnull
//    @Override
//    public ICurio.SoundInfo getEquipSound(SlotContext slotContext) {
//        return new ICurio.SoundInfo(wingType.equipSound.get(), 1.0f, 1.0f);
//    }
//
//    @Override
//    public boolean canEquipFromUse(SlotContext slotContext) { return true; }
//
    public void render(EntityPlayer player, float partialTicks) {
        Render<EntityPlayer> renderPlayer = Minecraft.getMinecraft().getRenderManager().getEntityRenderObject(player);
        if (renderPlayer == null) { return; }

        float[] primaryColor = wings.getPrimaryColor().getColorComponentValues();
        float[] secondaryColor = wings.getSecondaryColor().getColorComponentValues();

        String wingTypeString = wings.getWingTypeName();

        ResourceLocation layer1 = new ResourceLocation(Vikare.MODID, "textures/entity/" + wingTypeString + "_wings.png");
        ResourceLocation layer2 = new ResourceLocation(Vikare.MODID, "textures/entity/" + wingTypeString + "_wings_2.png");

        if (Minecraft.getMinecraft().player == player) {
            wingsModel.setRotationAngles(player);
        } else {
            wingsModel.setRotationAngles(player, forcedFlap);
        }

        GlStateManager.color(secondaryColor[0], secondaryColor[1], secondaryColor[2]);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        renderPlayer.bindTexture(layer2);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0D, 0.0D, 0.125D);
        wingsModel.render(player);
        if (stack.hasEffect()) {
            LayerArmorBase.renderEnchantedGlint((RenderLivingBase<?>) renderPlayer, player, wingsModel, player.limbSwing, player.limbSwingAmount, partialTicks, player.ticksExisted, player.rotationYawHead, player.rotationPitch, 0.0625F);
        }
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();

        GlStateManager.color(primaryColor[0], primaryColor[1], primaryColor[2]);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        renderPlayer.bindTexture(layer1);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0D, 0.0D, 0.125D);
        wingsModel.render(player);
        if (stack.hasEffect()) {
            LayerArmorBase.renderEnchantedGlint((RenderLivingBase<?>) renderPlayer, player, wingsModel, player.limbSwing, player.limbSwingAmount, partialTicks, player.ticksExisted, player.rotationYawHead, player.rotationPitch, 0.0625F);
        }
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }
//
//    public boolean isShiny() {
//        return !stack.getOrCreateTag().getBoolean("Dull");
//    }
//
//    public void stopFlying(PlayerEntity player) {
//        shouldSlowFall = true;
//        player.stopFallFlying();
//    }
//
//    public void applySpeed(PlayerEntity player) {
//        shouldSlowFall = false;
//        Vector3d rotation = player.getLookVec();
//        Vector3d velocity = player.getMotion();
//        float modifier = VikareConfig.COMMON.armorSlows.get() ? MathHelper.clamp(player.getTotalArmorValue() / 10F, 1F, VikareConfig.COMMON.maxSlowedMultiplier.get()) : 1F;
//
//        velocity = velocity.add(rotation.x * (wings.speed / modifier) + (rotation.x * 1.5D - velocity.x) * wings.acceleration, rotation.y * (wings.speed / modifier) + (rotation.y * 1.5D - velocity.y) * wings.acceleration, rotation.z * (wings.speed / modifier) + (rotation.z * 1.5D - velocity.z) * wings.acceleration);
//        player.setMotion(velocity.x, velocity.y, velocity.z);
//    }
//
    public void setForcedFlap(boolean forcedFlap) {
        this.forcedFlap = forcedFlap;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == WING_ITEM_CAPABILITY;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return hasCapability(capability, facing) ? (T) this : null;
    }
}
