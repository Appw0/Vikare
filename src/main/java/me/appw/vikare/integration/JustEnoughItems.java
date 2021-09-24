package me.appw.vikare.integration;

import me.appw.vikare.Vikare;
import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.registry.Items;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.MethodsReturnNonnullByDefault;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

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
        List<Object> recipes = new ArrayList<>();
        Items.ITEMS.getEntries().forEach(rItem -> {
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
                recipes.add(repairWithMaterial);
            }
            Object repairWithSame = registration.getVanillaRecipeFactory().createAnvilRecipe(damaged2, Collections.singletonList(damaged2), Collections.singletonList(damaged3));
            recipes.add(repairWithSame);
        });
        registration.addRecipes(recipes, VanillaRecipeCategoryUid.ANVIL);
    }
}
