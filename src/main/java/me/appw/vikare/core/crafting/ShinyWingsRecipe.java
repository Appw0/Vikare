package me.appw.vikare.core.crafting;

import me.appw.vikare.Vikare;
import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.registry.RecipeSerializers;
import net.minecraft.tags.TagKey;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.tags.Tag;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class ShinyWingsRecipe extends CustomRecipe {
    public static final TagKey<Item> SHINE = ItemTags.create(Vikare.resource("shine"));

    public ShinyWingsRecipe(ResourceLocation resourceLocation) { super(resourceLocation); }

    @Override
    public boolean matches(CraftingContainer inv, Level world) {
        boolean hasWings = false;
        boolean hasShiny = false;
        for (int i = 0; i < inv.getContainerSize(); i++) {
            ItemStack stack = inv.getItem(i);
            if (!stack.isEmpty()) {
                if (stack.getItem() instanceof WingItem) {
                    if (hasWings) return false;
                    hasWings = true;
                } else if (stack.is(SHINE)) {
                    if (hasShiny) return false;
                    hasShiny = true;
                }
            }
        }
        return hasWings && hasShiny;
    }

    @Override
    public ItemStack assemble(CraftingContainer inv) {
        ItemStack wings = ItemStack.EMPTY;
        for (int i = 0; i < inv.getContainerSize(); i++) {
            ItemStack stack = inv.getItem(i);
            if (!stack.isEmpty() && stack.getItem() instanceof WingItem) {
                wings = stack.copy();
                wings.getOrCreateTag().putBoolean("Dull", !wings.getOrCreateTag().getBoolean("Dull"));
            }
        }
        return wings;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) { return width * height >= 2; }

    @Override
    public RecipeSerializer<?> getSerializer() { return RecipeSerializers.SHINY_WINGS.get(); }
}
