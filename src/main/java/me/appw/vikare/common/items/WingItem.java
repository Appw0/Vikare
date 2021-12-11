package me.appw.vikare.common.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.api.render.IRenderBauble;
import me.appw.vikare.Vikare;
import me.appw.vikare.core.capability.WingItemCapability;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.registry.WingTypes.WingType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.IRarity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static me.appw.vikare.Vikare.WING_ITEM_CAPABILITY;

public class WingItem extends Item implements IBauble, IRenderBauble { //, IDyeableArmorItem {
    private final EnumDyeColor primaryColor; // TODO: maybe one day this could be NBT values?
    private final EnumDyeColor secondaryColor;
    private final WingType wingType;
//    public static final INamedTag<Item> FREE_FLIGHT = ItemTags.makeWrapperTag(Vikare.MODID + ":free_flight");
//    public static final INamedTag<Item> MELTS = ItemTags.makeWrapperTag(Vikare.MODID + ":melts");
    public final double speed;
    public final double acceleration;

    public WingItem(EnumDyeColor primaryColor, EnumDyeColor secondaryColor, WingType wingType) {
        this.setMaxStackSize(1);
        this.setMaxDamage(255);
        this.setCreativeTab(Vikare.TAB);
//        super(new Item.Properties()
//                .maxStackSize(1)
//                .maxDamage(VikareConfig.COMMON.wingsDurability.get())
//                .group(Vikare.ITEM_GROUP)
//                .rarity(wingType.rarity)
//        );
        this.speed = 1;
        this.acceleration = 1;
//        this.speed = VikareConfig.COMMON.wingsSpeed.get();
//        this.acceleration = VikareConfig.COMMON.wingsAcceleration.get();
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.wingType = wingType;
    }

    @Override
    public IRarity getForgeRarity(ItemStack stack)
    {
        return wingType.rarity;
    }

    @Override
    public BaubleType getBaubleType(ItemStack stack) {
        return BaubleType.BODY;
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
        return new WingItemCapability(stack);
    }

    @Override
    public void onPlayerBaubleRender(ItemStack stack, EntityPlayer player, RenderType type, float partialTicks) {
        WingItemCapability cap = stack.getCapability(WING_ITEM_CAPABILITY, null);
        if (cap != null && type == RenderType.BODY) {
            cap.render(player, partialTicks);
        }
    }

//    @ParametersAreNonnullByDefault
//    @Override
//    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
//        return wingType.repairItemsTag.contains(repair.getItem());
//    }

//    public List<ItemStack> getRepairItemStacks() {
//        List<ItemStack> itemStacks = new ArrayList<>();
//        wingType.repairItemsTag.getAllElements().forEach(item -> {
//            itemStacks.add(new ItemStack(item));
//        });
//        return itemStacks;
//    }

//    @Override
//    public boolean hasEffect(ItemStack stack) {
//        Optional<ICurio> curio = stack.getCapability(CuriosCapability.ITEM).resolve();
//        if (curio.isPresent()) {
//            return super.hasEffect(stack) && ((WingItemCapability) curio.get()).isShiny();
//            // NOTE: If some dumb mod calls this function directly on the wrong item, it will probably scream with errors
//            // hmmm
//        } else {
//            return super.hasEffect(stack);
//        }
//    }

    public boolean isUsable(ItemStack stack) {
        return stack.getItemDamage() < stack.getMaxDamage() - 1;
    }

    public EnumDyeColor getPrimaryColor() {
        return this.primaryColor;
    }

    public EnumDyeColor getSecondaryColor() {
        return this.secondaryColor;
    }

    public WingType getWingType() {
        return this.wingType;
    }

    public String getWingTypeName() { return wingType.name.toLowerCase(); }
}
