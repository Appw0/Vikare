package me.appw.vikare.common.items;

import me.appw.vikare.Vikare;
import me.appw.vikare.core.capability.WingItemCapability;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.registry.WingTypes.WingType;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.registries.ForgeRegistries;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WingItem extends Item { //, IDyeableArmorItem {
    private final DyeColor primaryColor; // TODO: maybe one day this could be NBT values?
    private final DyeColor secondaryColor;
    private final WingType wingType;
    public static final TagKey<Item> FREE_FLIGHT = ItemTags.create(Vikare.resource("free_flight"));
    public static final TagKey<Item> MELTS = ItemTags.create(Vikare.resource("melts"));
    public final double speed;
    public final double acceleration;

    public WingItem(DyeColor primaryColor, DyeColor secondaryColor, WingType wingType) {
        super(new Item.Properties()
                .stacksTo(1)
                .durability(VikareConfig.COMMON.wingsDurability.get())
                .tab(Vikare.ITEM_GROUP)
                .rarity(wingType.rarity)
        );
        this.speed = VikareConfig.COMMON.wingsSpeed.get();
        this.acceleration = VikareConfig.COMMON.wingsAcceleration.get();
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.wingType = wingType;
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundTag nbt) {
        return new ICapabilityProvider() {
            final LazyOptional<ICurio> capability = LazyOptional.of(() -> new WingItemCapability(stack));
            @Nonnull
            @Override
            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
                return CuriosCapability.ITEM.orEmpty(cap, this.capability);
            }
        };
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(wingType.repairItemsTag);
    }

    public List<ItemStack> getRepairItemStacks() {
        List<ItemStack> itemStacks = new ArrayList<>();
        ForgeRegistries.ITEMS.tags().getTag(wingType.repairItemsTag).stream().forEach(item -> itemStacks.add(new ItemStack(item)));
        return itemStacks;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        Optional<ICurio> curio = stack.getCapability(CuriosCapability.ITEM).resolve();
        if (curio.isPresent()) {
            return super.isFoil(stack) && ((WingItemCapability) curio.get()).isShiny();
            // NOTE: If some dumb mod calls this function directly on the wrong item, it will probably scream with errors
            // hmmm
        } else {
            return super.isFoil(stack);
        }
    }

    public static boolean isUsable(ItemStack stack) {
        return stack.getDamageValue() < stack.getMaxDamage() - 1;
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
