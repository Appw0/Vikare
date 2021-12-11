package me.appw.vikare.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JEIPlugin;

@JEIPlugin()
public class JustEnoughItems implements IModPlugin {

//    @Override
//    public void registerRecipes(IRecipeRegistration registration) {
//        List<Object> anvilRecipes = new ArrayList<>();
//        List<Object> shinyRecipes = new ArrayList<>();
//        Items.ITEMS.getEntries().forEach(rItem -> {
//            WingItem item = (WingItem) rItem.get();
//            ItemStack damaged1 = new ItemStack(item);
//            damaged1.setDamage(damaged1.getMaxDamage());
//            ItemStack damaged2 = new ItemStack(item);
//            damaged2.setDamage(damaged2.getMaxDamage() * 3/4);
//            ItemStack damaged3 = new ItemStack(item);
//            damaged3.setDamage(damaged3.getMaxDamage() * 2/4);
//
//            List<ItemStack> repairMaterials = item.getRepairItemStacks();
//
//            if (!repairMaterials.isEmpty()) {
//                Object repairWithMaterial = registration.getVanillaRecipeFactory().createAnvilRecipe(damaged1, repairMaterials, Collections.singletonList(damaged2));
//                anvilRecipes.add(repairWithMaterial);
//            }
//            Object repairWithSame = registration.getVanillaRecipeFactory().createAnvilRecipe(damaged2, Collections.singletonList(damaged2), Collections.singletonList(damaged3));
//            anvilRecipes.add(repairWithSame);
//
//            ItemStack shinyItem = new ItemStack(item);
//            shinyItem.addEnchantment(Enchantments.MENDING, 1);
//            ItemStack dullItem = new ItemStack(item);
//            dullItem.addEnchantment(Enchantments.MENDING, 1);
//            dullItem.getOrCreateTag().putBoolean("Dull", true);
//            NonNullList<Ingredient> inputsShine = NonNullList.from(Ingredient.EMPTY, Ingredient.fromStacks(dullItem), Ingredient.fromTag(Tags.Items.DUSTS_GLOWSTONE));
//            ResourceLocation idShine = new ResourceLocation(Vikare.MODID, "jei.wings.shine." + rItem.getId().getPath());
//            ShapelessRecipe recipeShine = new ShapelessRecipe(idShine, "jei.wings.shine", shinyItem, inputsShine);
//            shinyRecipes.add(recipeShine);
//            NonNullList<Ingredient> inputsDull = NonNullList.from(Ingredient.EMPTY, Ingredient.fromStacks(shinyItem), Ingredient.fromTag(Tags.Items.DUSTS_GLOWSTONE));
//            ResourceLocation idDull = new ResourceLocation(Vikare.MODID, "jei.wings.dull." + rItem.getId().getPath());
//            ShapelessRecipe recipeDull = new ShapelessRecipe(idDull, "jei.wings.dull", dullItem, inputsDull);
//            shinyRecipes.add(recipeDull);
//        });
//        registration.addRecipes(anvilRecipes, VanillaRecipeCategoryUid.ANVIL);
//        registration.addRecipes(shinyRecipes, VanillaRecipeCategoryUid.CRAFTING);
//    }
}
