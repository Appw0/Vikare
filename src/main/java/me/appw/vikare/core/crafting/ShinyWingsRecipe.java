package me.appw.vikare.core.crafting;

import me.appw.vikare.Vikare;
import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.registry.RecipeSerializers;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;

public class ShinyWingsRecipe extends SpecialRecipe {
    public static final ITag.INamedTag<Item> SHINE = ItemTags.makeWrapperTag(Vikare.MODID + ":shine");

    public ShinyWingsRecipe(ResourceLocation resourceLocation) { super(resourceLocation); }

    @Override
    public boolean matches(CraftingInventory inv, World world) {
        boolean hasWings = false;
        boolean hasShiny = false;
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty()) {
                if (stack.getItem() instanceof WingItem) {
                    if (hasWings) return false;
                    hasWings = true;
                } else if (SHINE.contains(stack.getItem())) {
                    if (hasShiny) return false;
                    hasShiny = true;
                }
            }
        }
        return hasWings && hasShiny;
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
