package me.appw.vikare.integration.jei;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.wrapper.ICraftingRecipeWrapper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;

import java.util.ArrayList;
import java.util.List;

public class RecipeWrapperShinyWings implements ICraftingRecipeWrapper {
    private final ItemStack wings;
    private final ItemStack outWings;

    public RecipeWrapperShinyWings(ItemStack wings) {
        this.wings = wings;
        this.wings.addEnchantment(Enchantments.MENDING, 0);
        this.outWings = wings.copy();
        outWings.setTagInfo("Dull", new NBTTagByte((byte) 1));
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        List<ItemStack> inputs = new ArrayList<>();

        inputs.add(wings);
        inputs.add(new ItemStack(Items.GLOWSTONE_DUST));

        ingredients.setInputs(VanillaTypes.ITEM, inputs);
        ingredients.setOutput(VanillaTypes.ITEM, outWings);
    }
}
