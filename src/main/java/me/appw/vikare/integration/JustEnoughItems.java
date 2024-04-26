package me.appw.vikare.integration;

import me.appw.vikare.Vikare;
import me.appw.vikare.common.items.WingItem;
//import me.appw.vikare.core.crafting.ShinyWingsRecipe;
//import me.appw.vikare.core.registry.RecipeSerializers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.ICraftingGridHelper;
import mezz.jei.api.recipe.IFocus;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.extensions.vanilla.crafting.ICraftingCategoryExtension;
import mezz.jei.api.recipe.vanilla.IJeiAnvilRecipe;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IVanillaCategoryExtensionRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static me.appw.vikare.core.registry.Items.WINGS;

@JeiPlugin()
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class JustEnoughItems implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return Vikare.resource("jei_plugin");
    }

//    @Override
//    public void registerVanillaCategoryExtensions(IVanillaCategoryExtensionRegistration registration) {
//        registration.getCraftingCategory().addCategoryExtension(ShinyWingsRecipe.class, ShinyRecipeVanillaExtension::new);
//    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        List<IJeiAnvilRecipe> anvilRecipes = new ArrayList<>();
        WINGS.getEntries().forEach(rItem -> {
            WingItem item = (WingItem) rItem.get();
            ItemStack damaged1 = new ItemStack(item);
            damaged1.setDamageValue(damaged1.getMaxDamage());
            ItemStack damaged2 = new ItemStack(item);
            damaged2.setDamageValue(damaged2.getMaxDamage() * 3/4);
            ItemStack damaged3 = new ItemStack(item);
            damaged3.setDamageValue(damaged3.getMaxDamage() * 2/4);

            List<ItemStack> repairMaterials = item.getRepairItemStacks();

            if (!repairMaterials.isEmpty()) {
                IJeiAnvilRecipe repairWithMaterial = registration.getVanillaRecipeFactory().createAnvilRecipe(damaged1, repairMaterials, List.of(damaged2));
                anvilRecipes.add(repairWithMaterial);
            }
            IJeiAnvilRecipe repairWithSame = registration.getVanillaRecipeFactory().createAnvilRecipe(damaged2, List.of(damaged2), List.of(damaged3));
            anvilRecipes.add(repairWithSame);
        });

        registration.addRecipes(RecipeTypes.ANVIL, anvilRecipes);
    }

//    public static class ShinyRecipeVanillaExtension implements ICraftingCategoryExtension {
//
//        public ShinyRecipeVanillaExtension(ShinyWingsRecipe recipe) {
//        }
//
//        private List<ItemStack> getShinies() {
//            return ForgeRegistries.ITEMS.tags().getTag(ShinyWingsRecipe.SHINE).stream().map(ItemStack::new).collect(Collectors.toList());
//        }
//
//        @Override
//        public void setRecipe(IRecipeLayoutBuilder builder, ICraftingGridHelper craftingGridHelper, IFocusGroup focuses) {
//            if (focuses.isEmpty()) {
//                List<ItemStack> inputs = new ArrayList<>();
//                List<ItemStack> outputs = new ArrayList<>();
//
//                WINGS.getEntries().forEach(item -> {
//                    inputs.add(new ItemStack(item.get()));
//                    outputs.add(new ItemStack(item.get()));
//                });
//
//                craftingGridHelper.setInputs(builder, VanillaTypes.ITEM_STACK, Arrays.asList(getShinies(), inputs), 0, 0);
//                craftingGridHelper.setOutputs(builder, VanillaTypes.ITEM_STACK, outputs);
//            } else {
//                IFocus<ItemStack> stackFocus = focuses.getFocuses(VanillaTypes.ITEM_STACK).toList().get(0);
//                ItemStack stack = stackFocus.getTypedValue().getIngredient();
//
//                if (stack.is(ShinyWingsRecipe.SHINE)) {
//                    List<ItemStack> inputs = new ArrayList<>();  // TODO: backport this, in old versions there is an empty JEI recipe
//                    List<ItemStack> outputs = new ArrayList<>();
//
//                    WINGS.getEntries().forEach(item -> {
//                        inputs.add(new ItemStack(item.get()));
//                        outputs.add(new ItemStack(item.get()));
//                    });
//
//                    craftingGridHelper.setInputs(builder, VanillaTypes.ITEM_STACK, Arrays.asList(inputs, getShinies()), 0, 0);
//                    craftingGridHelper.setOutputs(builder, VanillaTypes.ITEM_STACK, outputs);
//                } else {
//                    ItemStack outStack = stack.copy();
//
//                    ItemStack invertDull = stackFocus.getRole() == RecipeIngredientRole.OUTPUT ? stack : outStack;
//                    invertDull.getOrCreateTag().putBoolean("Dull", !invertDull.getOrCreateTag().getBoolean("Dull"));
//
//                    craftingGridHelper.setInputs(builder, VanillaTypes.ITEM_STACK, Arrays.asList(List.of(stack), getShinies()), 0, 0);
//                    craftingGridHelper.setOutputs(builder, VanillaTypes.ITEM_STACK, List.of(outStack));
//                }
//            }
//        }
//
//        @Override
//        public @Nullable ResourceLocation getRegistryName() {
//            return RecipeSerializers.SHINY_WINGS.getId();
//        }
//    }
}
