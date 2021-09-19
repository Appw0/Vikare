package me.appw.vikare.common.items;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import me.appw.vikare.Vikare;
import me.appw.vikare.client.models.*;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.network.client.CPlayerFlappingPacket;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
//import net.minecraft.tags.ItemTags;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.theillusivec4.caelus.api.CaelusApi;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import javax.annotation.Nonnull;
import java.util.Locale;
import java.util.UUID;

public class WingItem extends Item implements ICurioItem { //, IDyeableArmorItem {
    private final DyeColor primaryColor;
    private final DyeColor secondaryColor;
    private final WingType wingType;
    private boolean shouldSlowFall;
    public static final INamedTag<Item> FREE_FLIGHT = ItemTags.makeWrapperTag(Vikare.MODID + ":free_flight");
    public static final INamedTag<Item> MELTS = ItemTags.makeWrapperTag(Vikare.MODID + ":melts");
    private final double speed;
    private final double acceleration;
    private Object model;

//    public WingItem(double speed, double acceleration, DyeColor primaryColor, DyeColor secondaryColor, WingType wingType) {
//        super(new Item.Properties()
//                .maxStackSize(1)
//                .maxDamage(VikareConfig.COMMON.wingsDurability.get())
//                .group(Vikare.ITEM_GROUP)
//                .rarity(wingType == WingType.UNIQUE ? Rarity.EPIC : Rarity.RARE)
//        );
//        this.speed = speed;
//        this.acceleration = acceleration;
//        this.primaryColor = primaryColor;
//        this.secondaryColor = secondaryColor;
//        this.wingType = wingType;
//    }

    public WingItem(DyeColor primaryColor, DyeColor secondaryColor, WingType wingType) {
        super(new Item.Properties()
                .maxStackSize(1)
                .maxDamage(VikareConfig.COMMON.wingsDurability.get())
                .group(Vikare.ITEM_GROUP)
                .rarity(wingType == WingType.UNIQUE ? Rarity.EPIC : Rarity.RARE)
        );
        this.speed = VikareConfig.COMMON.wingsSpeed.get();
        this.acceleration = VikareConfig.COMMON.wingsAcceleration.get();
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.wingType = wingType;
    }

    @Override
    public void curioTick(String identifier, int index, LivingEntity entity, ItemStack stack) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            if (player.getFoodStats().getFoodLevel() <= 6) { return; }

            if (player.isElytraFlying()) {
                if (player.moveForward > 0) {
                    applySpeed(player);

                    if (!FREE_FLIGHT.contains(this) && !player.isCreative()) {
                        CPlayerFlappingPacket.send();
                    }
                }
                if (player.isSneaking()) {
                    stopFlying(player);
                }
                if (player.getPosY() > player.world.getHeight() + 64 && player.ticksExisted % 20 == 0 && MELTS.contains(this)) {
                    stack.damageItem(1, player, p -> CuriosApi.getCuriosHelper().onBrokenCurio(identifier, index, p));
                }
            } else {
                if (player.isOnGround() || player.isInWater()) {
                    shouldSlowFall = false;
                }

                if (shouldSlowFall) {
                    player.fallDistance = 0F;
                    player.setVelocity(player.getMotion().x, -0.4, player.getMotion().z);
                }
            }
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> atts = LinkedHashMultimap.create();
        atts.put(CaelusApi.ELYTRA_FLIGHT.get(), new AttributeModifier(uuid, "Flight modifier", 1.0f, AttributeModifier.Operation.ADDITION));
        return atts;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.PHANTOM_MEMBRANE;
    }

    public DyeColor getPrimaryColor() {
        return this.primaryColor;
    }

    public DyeColor getSecondaryColor() {
        return this.secondaryColor;
    }

    public WingType getWingType() {
        return this.wingType;
    }

    public String getWingTypeName() {
        return wingType != WingType.UNIQUE ? wingType.toString().toLowerCase() : this.getRegistryName().getPath().replaceAll("_wings", "");
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

        velocity = velocity.add(rotation.x * (speed / modifier) + (rotation.x * 1.5D - velocity.x) * acceleration, rotation.y * (speed / modifier) + (rotation.y * 1.5D - velocity.y) * acceleration, rotation.z * (speed / modifier) + (rotation.z * 1.5D - velocity.z) * acceleration);
        player.setVelocity(velocity.x, velocity.y, velocity.z);
    }

    @Nonnull
    @Override
    public ICurio.SoundInfo getEquipSound(SlotContext slotContext, ItemStack stack) {
        return new ICurio.SoundInfo(SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 1.0f, 1.0f);
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean canRender(String identifier, int index, LivingEntity livingEntity, ItemStack stack) {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void render(String identifier, int index, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light,
                       LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks,
                       float netHeadYaw, float headPitch, ItemStack stack) {
        float[] primaryColor = this.getPrimaryColor().getColorComponentValues();
        float[] secondaryColor = this.getSecondaryColor().getColorComponentValues();

        String wingTypeString = this.getWingTypeName();
//        wingTypeString = "feathered"; // feathered

        if (!(this.model instanceof WingsModel)) {
            if (wingType == WingType.FEATHERED || wingType == WingType.MECHANICAL_FEATHERED) {
                model = new FeatheredWingsModel<>();
            } else if (wingType == WingType.DRAGON || wingType == WingType.MECHANICAL_LEATHER) {
                model = new LeatherWingsModel<>();
            } else if (wingType == WingType.LIGHT) {
                model = new LightWingsModel<>();
            } else if (wingTypeString.equals("flandres")) {
                model = new FlandresWingsModel<>();
            } else if (wingTypeString.equals("discords")) {
                model = new DiscordsWingsModel<>();
            } else if (wingTypeString.equals("zanzas")) {
                model = new ZanzasWingsModel<>();
            } else if (wingTypeString.equals("box")) {
                model = new BoxWingsModel<>();
            } else {
                model = new WingsModel<>();
            }
        }
        WingsModel<LivingEntity> wingsModel = (WingsModel<LivingEntity>) this.model;

        ResourceLocation layer1 = new ResourceLocation(Vikare.MODID, "textures/entity/" + wingTypeString + "_wings.png");
        ResourceLocation layer2 = new ResourceLocation(Vikare.MODID, "textures/entity/" + wingTypeString + "_wings_2.png");

//        matrixStack.push();
        matrixStack.translate(0.0D, 0.0D, 0.125D);
//        wingsModel

        wingsModel.setRotationAngles(livingEntity, limbSwing, limbSwingAmount, ageInTicks, headPitch, netHeadYaw);

        IVertexBuilder vertexBuilder = ItemRenderer.getBuffer(renderTypeBuffer, wingsModel.getRenderType(layer2), false, stack.hasEffect());
        wingsModel.render(matrixStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY, secondaryColor[0], secondaryColor[1], secondaryColor[2], 1.0F);

        vertexBuilder = ItemRenderer.getBuffer(renderTypeBuffer, wingsModel.getRenderType(layer1), false, stack.hasEffect());
        wingsModel.render(matrixStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY, primaryColor[0], primaryColor[1], primaryColor[2], 1.0F);
    }

    public enum WingType {
        FEATHERED, DRAGON, MECHANICAL_FEATHERED, MECHANICAL_LEATHER, LIGHT, UNIQUE
    }
}
