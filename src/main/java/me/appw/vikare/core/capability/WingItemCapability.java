package me.appw.vikare.core.capability;


import baubles.api.IBauble;
import baubles.api.render.IRenderBauble;
import me.appw.vikare.Vikare;
import me.appw.vikare.client.VikareClient;
import me.appw.vikare.client.models.WingsModel;
import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.network.client.CPlayerFlappingPacket;
import me.appw.vikare.core.network.client.CPlayerFlappingPacket.FlappingState;
import me.appw.vikare.core.registry.Items;
import me.appw.vikare.core.registry.WingTypes.WingType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
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
        } catch (NoClassDefFoundError | NullPointerException ignored) {
        }
    }

    public void tick(EntityLivingBase entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (player.getFoodStats().getFoodLevel() <= 6) { return; }

            if (player.isElytraFlying()) {
                if (player.moveForward > 0) {
                    if (WingItem.isUsable(stack)) applySpeed(player);
                    CPlayerFlappingPacket.send(last_movement == 0 ? FlappingState.STARTED : FlappingState.NONE);
                } else if (last_movement > 0) {
                    CPlayerFlappingPacket.send(FlappingState.ENDED);
                }
                last_movement = player.moveForward;

                if (player.isSneaking()) {
                    stopFlying(player);
                }

                if (player.posY > player.world.getHeight() + 64 && player.ticksExisted % 20 == 0 && wingType.doesMelt()) {
                    stack.damageItem(1, player);
                }

                if (!WingItem.isUsable(stack)) {
                    wingsModel.setBroken();
                    double adjustedLift = 0.08D * -MathHelper.cos(player.rotationPitch * ((float)Math.PI / 180F));;
                    player.motionY += adjustedLift; // any mods that change gravity with their own code will totally cause bugs here
                }
            } else {
                if (player.onGround || player.isInWater()) {
                    shouldSlowFall = false;
                }
                if (shouldSlowFall) {
                    if (wingsModel != null) wingsModel.setSlowFall();
                        player.fallDistance = WingItem.isUsable(stack) ? 0F : Math.min(player.fallDistance, 10F);
                        player.motionY = WingItem.isUsable(stack) ? -0.4D : -1D;
                }
            }
            if (player.world.isRemote) {
                Minecraft minecraft = Minecraft.getMinecraft();
                if (minecraft.player == player && minecraft.gameSettings.thirdPersonView == 0) {
                    // these interesting shenanigans here are to continue to simulate wing-flapping while in first person
                    // even though the model is not rendered, to allow the wing-flap sound to still be played
                    wingsModel.setRotationAngles(player);
                }
                if (wingsModel.didFlap()) {
                    float vol = 10.0F;
                    if (Minecraft.getMinecraft().player == player) {
                        vol = 100.0F;
                    }
                    player.world.playSound(player.posX, player.posY, player.posZ, wingType.flapSound, SoundCategory.PLAYERS, vol, 0.9F + player.world.rand.nextFloat() * 0.2F, false);
                }
            }
        }
    }

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

    public void stopFlying(EntityPlayer player) {
        shouldSlowFall = true;
        if (player instanceof EntityPlayerMP) {
            ((EntityPlayerMP) player).clearElytraFlying();
        }
    }

    public void applySpeed(EntityPlayer player) {
        shouldSlowFall = false;
        Vec3d rotation = player.getLookVec();
        Vec3d velocity = new Vec3d(player.motionX, player.motionY, player.motionZ);
        double modifier = VikareConfig.armorSlows ? MathHelper.clamp(player.getTotalArmorValue() / 10D, 1D, VikareConfig.maxSlowedMultiplier) : 1D;

        velocity = velocity.add(rotation.x * (wings.speed / modifier) + (rotation.x * 1.5D - velocity.x) * wings.acceleration, rotation.y * (wings.speed / modifier) + (rotation.y * 1.5D - velocity.y) * wings.acceleration, rotation.z * (wings.speed / modifier) + (rotation.z * 1.5D - velocity.z) * wings.acceleration);
        player.motionX = velocity.x;
        player.motionY = velocity.y;
        player.motionZ = velocity.z;
    }

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
