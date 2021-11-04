package me.appw.vikare.core.crafting;

import me.appw.vikare.Vikare;
import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.registry.RecipeSerializers;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;

public class ShinyWingsRecipe extends SpecialRecipe {
    public ShinyWingsRecipe(ResourceLocation resourceLocation) { super(resourceLocation); }

    @Override
    public boolean matches(CraftingInventory inv, World world) {
        boolean hasWings = false;
        boolean hasGlowstone = false;
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty()) {
                    if (stack.getItem() instanceof WingItem) {
                        if (hasWings) return false;
                        hasWings = true;
                } else {
                    if (Tags.Items.DUSTS_GLOWSTONE.contains(stack.getItem())) {
                        if (hasGlowstone) return false;
                        hasGlowstone = true;
                    }
                }
            }
        }
        return hasWings && hasGlowstone;
    }

    @Override
    public ItemStack getCraftingResult(CraftingInventory inv) {
        ItemStack wings = ItemStack.EMPTY;
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty() && stack.getItem() instanceof WingItem) {
                wings = stack.copy();
                wings.getOrCreateTag().putBoolean("Dull", !wings.getOrCreateTag().getBoolean("Dull"));
            }
        }
        return wings;
    }

    @Override
    public boolean canFit(int width, int height) { return width * height >= 2; }

    @Override
    public IRecipeSerializer<?> getSerializer() { return RecipeSerializers.SHINY_WINGS.get(); }
}
