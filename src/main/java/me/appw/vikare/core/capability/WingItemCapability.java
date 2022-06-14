package me.appw.vikare.core.capability;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.network.client.CPlayerFlappingPacket;
import me.appw.vikare.core.network.client.CPlayerFlappingPacket.FlappingState;
import me.appw.vikare.core.registry.WingTypes.WingType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
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
    private final WingsState wingsState = new WingsState();
//    private WingsModel<LivingEntity> wingsModel;
//    private boolean forcedFlap = false;
//    private boolean shouldSlowFall;
    private float last_movement = 0.0F;

    public WingItemCapability(ItemStack stack) {
        this.stack = stack;
        wings = (WingItem) stack.getItem();
        wingType = wings.getWingType();

//        try {  // this is Stupid dumb hack glad its gone
//            wingsModel = VikareClient.MODELS.get(wingType).getDeclaredConstructor().newInstance();
//        } catch (InstantiationException | IllegalAccessException e) {
//            Vikare.LOGGER.error(String.valueOf(e));
//        } catch (NullPointerException ignored) {
//        }
    }

    @Override
    public ItemStack getStack() {
        return stack;
    }  // Why did this return null??? TODO: Look at old versions and see if this returned null there too. because it shouldn't!

    @Override
    public void curioTick(SlotContext context) {
        LivingEntity entity = context.entity();
        if (entity instanceof Player player) {
            if (player.getFoodData().getFoodLevel() <= 6) { return; }

            if (player.isFallFlying()) {
                wingsState.status = State.FLYING;
                if (player.zza > 0) {
                    if (WingItem.isUsable(stack)) applySpeed(player);
                    CPlayerFlappingPacket.send(last_movement == 0 ? FlappingState.STARTED : FlappingState.NONE);
                } else if (last_movement > 0) {
                    CPlayerFlappingPacket.send(FlappingState.ENDED);
                }
                last_movement = player.zza;

                if (player.isShiftKeyDown()) {
                    stopFlying(player);
                }
                if (player.getY() > player.level.getMaxBuildHeight() + 64 && player.tickCount % 20 == 0 && stack.is(WingItem.MELTS)) {
                    stack.hurtAndBreak(1, player, p -> CuriosApi.getCuriosHelper().onBrokenCurio(context));
                }

                if (!WingItem.isUsable(stack)) {
                    wingsState.broken = true;
                    AttributeInstance gravity = player.getAttribute(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());
                    double adjustedLift = gravity.getValue() * -Mth.cos(player.getXRot() * ((float)Math.PI / 180F));;
                    Vec3 velocity = player.getDeltaMovement().add(0.0D, adjustedLift, 0.0D);
                    player.setDeltaMovement(velocity.x, velocity.y, velocity.z);
                } else {
                    wingsState.broken = false;
                }
            } else {
                if (player.isOnGround() || player.isInWater()) {
                    wingsState.status = State.IDLE;
                }
                if (wingsState.status == State.SLOWFALL) {
                    player.fallDistance = WingItem.isUsable(stack) ? 0F : Math.min(player.fallDistance, 10F);
                    player.setDeltaMovement(player.getDeltaMovement().x, WingItem.isUsable(stack) ? -0.4 : -1, player.getDeltaMovement().z);
                }
            }
//            if (player.level.isClientSide) {  // TODO: move this to client code!
//                Minecraft minecraft = Minecraft.getInstance();
//                if (minecraft.player == player && minecraft.options.getCameraType() == CameraType.FIRST_PERSON ) {
//                    // these interesting shenanigans here are to continue to simulate wing-flapping while in first person
//                    // even though the model is not rendered, to allow the wing-flap sound to still be played
//                    wingsModel.setupAnim(player);
//                }
//                if (wingsModel.didFlap()) {
//                    float vol = 10.0F;
//                    if (Minecraft.getInstance().player == player) {
//                        vol = 100.0F;
//                    }
//                    player.level.playLocalSound(player.getX(), player.getY(), player.getZ(), wingType.flapSound.get(), SoundSource.PLAYERS, vol, 0.9F + player.level.random.nextFloat() * 0.2F, false);
//                }
//            }
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
        Multimap<Attribute, AttributeModifier> atts = LinkedHashMultimap.create();
        atts.put(CaelusApi.getInstance().getFlightAttribute(), new AttributeModifier(uuid, "Flight modifier", 1.0f, AttributeModifier.Operation.ADDITION));
        return atts;
    }

    @Nonnull
    @Override
    public ICurio.SoundInfo getEquipSound(SlotContext slotContext) {
        return new ICurio.SoundInfo(wingType.equipSound.get(), 1.0f, 1.0f);
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext) { return true; }

//    @OnlyIn(Dist.CLIENT)
//    @Override
//    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack,
//                                                                          RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light,
//                                                                          float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw,
//                                                                          float headPitch) {
//        LivingEntity livingEntity = slotContext.entity();
//        float[] primaryColor = wings.getPrimaryColor().getTextureDiffuseColors();
//        float[] secondaryColor = wings.getSecondaryColor().getTextureDiffuseColors();
//
//        String wingTypeString = wings.getWingTypeName();
//
//        // same with these TODO: put in registry
//        ResourceLocation layer1 = new ResourceLocation(Vikare.MODID, "textures/entity/" + wingTypeString + "_wings.png");
//        ResourceLocation layer2 = new ResourceLocation(Vikare.MODID, "textures/entity/" + wingTypeString + "_wings_2.png");
//
//        matrixStack.translate(0.0D, 0.0D, 0.125D);
//
//        if (Minecraft.getInstance().player == renderLayerParent) {
//            wingsModel.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, headPitch, netHeadYaw);
//        } else {
//            wingsModel.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, headPitch, netHeadYaw, forcedFlap);
//        }
//
//        VertexConsumer vertexBuilder = ItemRenderer.getFoilBuffer(renderTypeBuffer, wingsModel.renderType(layer2), false, stack.hasFoil());
//        wingsModel.renderToBuffer(matrixStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY, secondaryColor[0], secondaryColor[1], secondaryColor[2], 1.0F);
//
//        vertexBuilder = ItemRenderer.getFoilBuffer(renderTypeBuffer, wingsModel.renderType(layer1), false, stack.hasFoil());
//        wingsModel.renderToBuffer(matrixStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY, primaryColor[0], primaryColor[1], primaryColor[2], 1.0F);
//    }

    public boolean isShiny() {
        return !stack.getOrCreateTag().getBoolean("Dull");
    }

    public void stopFlying(Player player) {
        wingsState.status = State.SLOWFALL;
        player.stopFallFlying();
    }

    public void applySpeed(Player player) {
        Vec3 rotation = player.getLookAngle();
        Vec3 velocity = player.getDeltaMovement();
        float modifier = VikareConfig.COMMON.armorSlows.get() ? Mth.clamp(player.getArmorValue() / 10F, 1F, VikareConfig.COMMON.maxSlowedMultiplier.get()) : 1F;

        velocity = velocity.add(rotation.x * (wings.speed / modifier) + (rotation.x * 1.5D - velocity.x) * wings.acceleration, rotation.y * (wings.speed / modifier) + (rotation.y * 1.5D - velocity.y) * wings.acceleration, rotation.z * (wings.speed / modifier) + (rotation.z * 1.5D - velocity.z) * wings.acceleration);
        player.setDeltaMovement(velocity.x, velocity.y, velocity.z);
    }

    public void setForcedFlap(boolean forcedFlap) {
        wingsState.forcedFlap = forcedFlap;
    }

    public WingsState getWingState() {
        return this.wingsState;
    }

    public static class WingsState {
        public State status = State.IDLE;
        public FlapState flapStatus = FlapState.IDLE;
        public boolean forcedFlap = false;
        public boolean broken = false;
        public float lastMovement = 0.0F;
    }

    public enum State {
        IDLE, CROUCHING, FLYING, SLOWFALL
    }

    public enum FlapState {
        IDLE, FLAP, DONE
    }
}
