package me.appw.vikare.core.crafting;

import me.appw.vikare.common.items.WingItem;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ShinyWingsRecipe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {
    public static final NonNullList<ItemStack> dustGlowstone = OreDictionary.getOres("dustGlowstone");

    @Override
    public boolean matches(InventoryCrafting inv, World world) {
        boolean hasWings = false;
        boolean hasGlowstone = false;
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty()) {
                    if (stack.getItem() instanceof WingItem) {
                        if (hasWings) return false;
                        hasWings = true;
                } else {
                    if (OreDictionary.containsMatch(false, dustGlowstone, stack)) {
                        if (hasGlowstone) return false;
                        hasGlowstone = true;
                    }
                }
            }
        }
        return hasWings && hasGlowstone;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        ItemStack wings = ItemStack.EMPTY;
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty() && stack.getItem() instanceof WingItem) {
                wings = stack.copy();
                if (wings.hasTagCompound())
                    wings.getTagCompound().setBoolean("Dull", !wings.getTagCompound().getBoolean("Dull"));
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
