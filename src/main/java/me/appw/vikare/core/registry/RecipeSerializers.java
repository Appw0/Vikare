package me.appw.vikare.core.registry;

import me.appw.vikare.Vikare;
import me.appw.vikare.core.crafting.ShinyWingsRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Vikare.MODID);

    public static final RegistryObject<SimpleRecipeSerializer<ShinyWingsRecipe>> SHINY_WINGS = RECIPE_SERIALIZERS.register("shiny_wings", () -> new SimpleRecipeSerializer<>(ShinyWingsRecipe::new));

    public static void register() { RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus()); }
}