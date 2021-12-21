package me.appw.vikare.integration.jei;

import me.appw.vikare.Vikare;
import me.appw.vikare.common.items.WingItem;
import mezz.jei.api.recipe.*;
import mezz.jei.plugins.vanilla.crafting.CraftingRecipeCategory;
import net.minecraft.item.ItemStack;

import java.util.Collections;
import java.util.List;

public class RecipeRegistryPluginShinyWings implements IRecipeRegistryPlugin {
    @Override
    public <V> List<String> getRecipeCategoryUids(IFocus<V> focus) {
        if (focus.getValue() instanceof ItemStack) {
            if (((ItemStack) focus.getValue()).getItem() instanceof WingItem) {
                return Collections.singletonList(VanillaRecipeCategoryUid.CRAFTING);
            }
        }
        return Collections.emptyList();
    }

    @Override
    public <T extends IRecipeWrapper, V> List<T> getRecipeWrappers(IRecipeCategory<T> recipeCategory, IFocus<V> focus) {
        if (recipeCategory instanceof CraftingRecipeCategory && focus.getValue() instanceof ItemStack) {
            ItemStack stack = (ItemStack) focus.getValue();
            if (stack.getItem() instanceof WingItem && stack.isItemEnchanted()) {
                return Collections.singletonList((T) new RecipeWrapperShinyWings(stack, focus.getMode()));
            }
        }
        return Collections.emptyList();
    }

    @Override
    public <T extends IRecipeWrapper> List<T> getRecipeWrappers(IRecipeCategory<T> recipeCategory) {
        return Collections.emptyList();
    }
}
