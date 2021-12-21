package me.appw.vikare.integration.jei;

import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.registry.Items;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IVanillaRecipeFactory;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JEIPlugin
public class JustEnoughItems implements IModPlugin {

    @Override
    public void register(IModRegistry registry) {
        registry.addRecipeRegistryPlugin(new RecipeRegistryPluginShinyWings());

        List<IRecipeWrapper> anvilRecipes = new ArrayList<>();
        for (WingItem item : Items.WINGS) {
            IVanillaRecipeFactory factory = registry.getJeiHelpers().getVanillaRecipeFactory();

            ItemStack damaged1 = new ItemStack(item);
            damaged1.setItemDamage(damaged1.getMaxDamage());
            ItemStack damaged2 = new ItemStack(item);
            damaged2.setItemDamage(damaged2.getMaxDamage() * 3/4);
            ItemStack damaged3 = new ItemStack(item);
            damaged3.setItemDamage(damaged3.getMaxDamage() * 2/4);

            NonNullList<ItemStack> repairMaterials = OreDictionary.getOres(item.getWingType().repairItemsOreDictKey);

            if (!repairMaterials.isEmpty()) {
                anvilRecipes.add(factory.createAnvilRecipe(damaged1, repairMaterials, Collections.nCopies(repairMaterials.size(), damaged2)));
            }

            anvilRecipes.add(factory.createAnvilRecipe(damaged2, Collections.singletonList(damaged2), Collections.singletonList(damaged3)));
        }
        registry.addRecipes(anvilRecipes, VanillaRecipeCategoryUid.ANVIL);
    }
}
