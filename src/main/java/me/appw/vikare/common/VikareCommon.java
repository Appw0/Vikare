package me.appw.vikare.common;

import me.appw.vikare.Vikare;
import me.appw.vikare.core.capability.WingItemCapability;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.network.NetworkWrapper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.RegistryManager;

import javax.annotation.Nullable;
import java.util.Map;

public class VikareCommon {
    public void preinit() {
        CapabilityManager.INSTANCE.register(WingItemCapability.class, new Capability.IStorage<WingItemCapability>() {
            @Nullable
            @Override
            public NBTBase writeNBT(Capability<WingItemCapability> capability, WingItemCapability instance, EnumFacing side) {return null;}
            @Override
            public void readNBT(Capability<WingItemCapability> capability, WingItemCapability instance, EnumFacing side, NBTBase nbt) {}
        }, WingItemCapability::new);

        NetworkWrapper.register();
    }

    public void postInit() {
        for (String ore : VikareConfig.waxWingOreDict) {
            for (ItemStack stack : OreDictionary.getOres(ore)) {
                OreDictionary.registerOre("waxWing", stack);
            }
        }
        if (OreDictionary.getOres("waxWing").size() == 0) {
            for (ItemStack stack : OreDictionary.getOres(VikareConfig.waxWingOreDictFallback)) {
                OreDictionary.registerOre("waxWing", stack);
            }
        }
    }
}
