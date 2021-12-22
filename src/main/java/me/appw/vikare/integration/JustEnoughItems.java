package me.appw.vikare.integration;

import me.appw.vikare.Vikare;
import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.crafting.ShinyWingsRecipe;
import me.appw.vikare.core.registry.RecipeSerializers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.MethodsReturnNonnullByDefault;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IFocus;
import mezz.jei.api.recipe.category.extensions.vanilla.crafting.ICustomCraftingCategoryExtension;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IVanillaCategoryExtensionRegistration;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.Size2i;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static me.appw.vikare.core.registry.Items.WINGS;

@JeiPlugin()
@MethodsReturnNonnullByDefault
public class JustEnoughItems implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Vikare.MODID, "jei_plugin");
    }

    @Override
    public void registerVanillaCategoryExtensions(IVanillaCategoryExtensionRegistration registration) {
        registration.getCraftingCategory().addCategoryExtension(ShinyWingsRecipe.class, ShinyRecipeVanillaExtension::new);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        List<Object> anvilRecipes = new ArrayList<>();
        WINGS.getEntries().forEach(rItem -> {
            WingItem item = (WingItem) rItem.get();
            ItemStack damaged1 = new ItemStack(item);
            damaged1.setDamage(damaged1.getMaxDamage());
            ItemStack damaged2 = new ItemStack(item);
            damaged2.setDamage(damaged2.getMaxDamage() * 3/4);
            ItemStack damaged3 = new ItemStack(item);
            damaged3.setDamage(damaged3.getMaxDamage() * 2/4);

            List<ItemStack> repairMaterials = item.getRepairItemStacks();

            if (!repairMaterials.isEmpty()) {
                Object repairWithMaterial = registration.getVanillaRecipeFactory().createAnvilRecipe(damaged1, repairMaterials, Collections.singletonList(damaged2));
                anvilRecipes.add(repairWithMaterial);
            }
            Object repairWithSame = registration.getVanillaRecipeFactory().createAnvilRecipe(damaged2, Collections.singletonList(damaged2), Collections.singletonList(damaged3));
            anvilRecipes.add(repairWithSame);
        });

        registration.addRecipes(anvilRecipes, VanillaRecipeCategoryUid.ANVIL);
    }

    public static class ShinyRecipeVanillaExtension implements ICustomCraftingCategoryExtension {

        public ShinyRecipeVanillaExtension(ShinyWingsRecipe recipe) {
        }

        @Override
        public void setRecipe(IRecipeLayout recipeLayout, IIngredients ingredients) {
            IFocus<ItemStack> focus = recipeLayout.getFocus(VanillaTypes.ITEM);
            ItemStack stack = focus.getValue().copy();
            if (!stack.isEnchanted()) return;
            ItemStack outStack = stack.copy();

            ItemStack invertDull = focus.getMode() == IFocus.Mode.OUTPUT ? stack : outStack;
            invertDull.getOrCreateTag().putBoolean("Dull", !invertDull.getOrCreateTag().getBoolean("Dull"));

            recipeLayout.getIngredientsGroup(VanillaTypes.ITEM).set(1, stack);
            recipeLayout.getIngredientsGroup(VanillaTypes.ITEM).set(2, ShinyWingsRecipe.SHINE.getAllElements().stream().map(ItemStack::new).collect(Collectors.toList()));
            recipeLayout.getIngredientsGroup(VanillaTypes.ITEM).set(0, outStack);
        }

        @Override
        public void setIngredients(IIngredients ingredients) {
            List<ItemStack> inputs = new ArrayList<>();
            List<ItemStack> outputs = new ArrayList<>();

            WINGS.getEntries().forEach(item -> {
                inputs.add(new ItemStack(item.get()));
                outputs.add(new ItemStack(item.get()));
            });

            ingredients.setOutputs(VanillaTypes.ITEM, outputs);
            ingredients.setInputLists(VanillaTypes.ITEM, Arrays.asList(ShinyWingsRecipe.SHINE.getAllElements().stream().map(ItemStack::new).collect(Collectors.toList()), inputs));
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return RecipeSerializers.SHINY_WINGS.getId();
        }

        @Nullable
        @Override
        public Size2i getSize() {
            return new Size2i(2, 1);
        }
    }
}
