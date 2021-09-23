package me.appw.vikare.common.items;

import me.appw.vikare.Vikare;
import me.appw.vikare.core.capability.WingItemCapability;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.registry.WingTypes.WingType;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.*;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class WingItem extends Item { //, IDyeableArmorItem {
    private final DyeColor primaryColor; // TODO: maybe one day this could be NBT values?
    private final DyeColor secondaryColor;
    private final WingType wingType;
    public static final INamedTag<Item> FREE_FLIGHT = ItemTags.makeWrapperTag(Vikare.MODID + ":free_flight");
    public static final INamedTag<Item> MELTS = ItemTags.makeWrapperTag(Vikare.MODID + ":melts");
    public final double speed;
    public final double acceleration;

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
                .rarity(wingType.rarity)
        );
        this.speed = VikareConfig.COMMON.wingsSpeed.get();
        this.acceleration = VikareConfig.COMMON.wingsAcceleration.get();
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.wingType = wingType;
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
        return new ICapabilityProvider() {
            final LazyOptional<ICurio> capability = LazyOptional.of(() -> new WingItemCapability(stack));
            @Nonnull
            @Override
            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
                return CuriosCapability.ITEM.orEmpty(cap, this.capability);
            }
        };
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.PHANTOM_MEMBRANE; // wait what about feathers?? membrane for feathered wings only makes sense balance wise
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

    public String getWingTypeName() { return wingType.name.toLowerCase(); }
}
