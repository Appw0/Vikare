package me.appw.vikare.core.crafting;

import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.config.VikareConfig;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ShinyWingsRecipe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {
    public static final NonNullList<ItemStack> shinyOre = OreDictionary.getOres(VikareConfig.shineItemOreDict);

    @Override
    public boolean matches(InventoryCrafting inv, World world) {
        boolean hasWings = false;
        boolean hasShiny = false;
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty()) {
                    if (stack.getItem() instanceof WingItem) {
                        if (hasWings) return false;
                        hasWings = true;
                } else {
                    if (OreDictionary.containsMatch(false, shinyOre, stack)) {
                        if (hasShiny) return false;
                        hasShiny = true;
                    }
                }
            }
        }
        return hasWings && hasShiny;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        ItemStack wings = ItemStack.EMPTY;
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty() && stack.getItem() instanceof WingItem) {
                wings = stack.copy();
                if (wings.hasTagCompound()) {
                    wings.getTagCompound().setBoolean("Dull", !wings.getTagCompound().getBoolean("Dull"));
                } else {
                    wings.setTagInfo("Dull", new NBTTagByte((byte) 0));
                }
            }
        }
        return wings;
    }

    @Override
    public ItemStack getRecipeOutput()
    {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canFit(int width, int height) { return width * height >= 2; }
}
