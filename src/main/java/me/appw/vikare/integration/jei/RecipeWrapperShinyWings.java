package me.appw.vikare.integration.jei;

import me.appw.vikare.core.crafting.ShinyWingsRecipe;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IFocus;
import mezz.jei.api.recipe.wrapper.ICraftingRecipeWrapper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecipeWrapperShinyWings implements ICraftingRecipeWrapper {
    private final ItemStack wings;
    private final ItemStack outWings;

    public RecipeWrapperShinyWings(ItemStack wings, IFocus.Mode mode) {
        this.wings = wings.copy();
        outWings = wings.copy();
        ItemStack invertDull = mode == IFocus.Mode.OUTPUT ? this.wings : this.outWings;
        NBTTagCompound nbt = invertDull.getTagCompound();
        if (nbt == null) nbt = new NBTTagCompound();
        nbt.setBoolean("Dull", !nbt.getBoolean("Dull"));
        invertDull.setTagCompound(nbt);
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        List<List<ItemStack>> inputLists = new ArrayList<>();

        inputLists.add(Collections.singletonList(wings));
        inputLists.add(ShinyWingsRecipe.shinyOre);

        ingredients.setInputLists(VanillaTypes.ITEM, inputLists);
        ingredients.setOutput(VanillaTypes.ITEM, outWings);
    }
}
