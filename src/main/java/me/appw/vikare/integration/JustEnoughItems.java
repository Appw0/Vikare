package me.appw.vikare.integration;

import me.appw.vikare.Vikare;
import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.registry.Items;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.MethodsReturnNonnullByDefault;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JeiPlugin()
@MethodsReturnNonnullByDefault
public class JustEnoughItems implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Vikare.MODID, "jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        List<Object> anvilRecipes = new ArrayList<>();
        List<Object> shinyRecipes = new ArrayList<>();
        Items.WINGS.getEntries().forEach(rItem -> {
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

            ItemStack shinyItem = new ItemStack(item);
            shinyItem.addEnchantment(Enchantments.MENDING, 1);
            ItemStack dullItem = new ItemStack(item);
            dullItem.addEnchantment(Enchantments.MENDING, 1);
            dullItem.getOrCreateTag().putBoolean("Dull", true);
            NonNullList<Ingredient> inputsShine = NonNullList.from(Ingredient.EMPTY, Ingredient.fromStacks(dullItem), Ingredient.fromTag(Tags.Items.DUSTS_GLOWSTONE));
            ResourceLocation idShine = new ResourceLocation(Vikare.MODID, "jei.wings.shine." + rItem.getId().getPath());
            ShapelessRecipe recipeShine = new ShapelessRecipe(idShine, "jei.wings.shine", shinyItem, inputsShine);
            shinyRecipes.add(recipeShine);
            NonNullList<Ingredient> inputsDull = NonNullList.from(Ingredient.EMPTY, Ingredient.fromStacks(shinyItem), Ingredient.fromTag(Tags.Items.DUSTS_GLOWSTONE));
            ResourceLocation idDull = new ResourceLocation(Vikare.MODID, "jei.wings.dull." + rItem.getId().getPath());
            ShapelessRecipe recipeDull = new ShapelessRecipe(idDull, "jei.wings.dull", dullItem, inputsDull);
            shinyRecipes.add(recipeDull);
        });
        registration.addRecipes(anvilRecipes, VanillaRecipeCategoryUid.ANVIL);
        registration.addRecipes(shinyRecipes, VanillaRecipeCategoryUid.CRAFTING);
    }
}
