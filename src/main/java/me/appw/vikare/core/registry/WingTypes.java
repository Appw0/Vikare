package me.appw.vikare.core.registry;

import me.appw.vikare.Vikare;
import me.appw.vikare.core.config.VikareConfig;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class WingTypes {
    public static final WingType FEATHERED = new WingType("feathered", Sounds.ITEM_FEATHERED_WINGS_EQUIP, Sounds.ITEM_FEATHERED_WINGS_FLAP);
    public static final WingType MECHANICAL_FEATHERED = new WingType("mechanical_feathered", Sounds.ITEM_MECHANICAL_FEATHERED_WINGS_EQUIP, Sounds.ITEM_FEATHERED_WINGS_FLAP);
    public static final WingType DRAGON = new WingType("dragon", Sounds.ITEM_DRAGON_WINGS_EQUIP, Sounds.ITEM_DRAGON_WINGS_FLAP);
    public static final WingType MECHANICAL_LEATHER = new WingType("mechanical_leather", Sounds.ITEM_MECHANICAL_LEATHER_WINGS_EQUIP, Sounds.ITEM_MECHANICAL_LEATHER_WINGS_FLAP);
    public static final WingType LIGHT = new WingType("light", Sounds.ITEM_LIGHT_WINGS_EQUIP, Sounds.ITEM_LIGHT_WINGS_FLAP);
    public static final WingType FLANDRES = new WingType("flandres", Sounds.ITEM_FLANDRES_WINGS_EQUIP, Sounds.ITEM_FLANDRES_WINGS_FLAP, EnumRarity.EPIC);
    public static final WingType DISCORDS = new WingType("discords", Sounds.ITEM_DISCORDS_WINGS_EQUIP, Sounds.ITEM_DISCORDS_WINGS_FLAP, EnumRarity.EPIC);
    public static final WingType ZANZAS = new WingType("zanzas", Sounds.ITEM_ZANZAS_WINGS_EQUIP, Sounds.ITEM_ZANZAS_WINGS_FLAP, EnumRarity.EPIC);

    public static void registerOreDictEntries() {
        OreDictionary.registerOre(FEATHERED.repairItemsOreDictKey, Items.FEATHER);
        OreDictionary.registerOre(MECHANICAL_FEATHERED.repairItemsOreDictKey, Items.FEATHER);
        OreDictionary.registerOre(DRAGON.repairItemsOreDictKey, Items.LEATHER);
        OreDictionary.registerOre(MECHANICAL_LEATHER.repairItemsOreDictKey, Items.LEATHER);
        OreDictionary.registerOre(LIGHT.repairItemsOreDictKey, Items.GLOWSTONE_DUST);
        OreDictionary.registerOre(FLANDRES.repairItemsOreDictKey, Items.DIAMOND);
        OreDictionary.registerOre(FLANDRES.repairItemsOreDictKey, Items.EMERALD);
        OreDictionary.registerOre(DISCORDS.repairItemsOreDictKey, Items.FEATHER);
        OreDictionary.registerOre(DISCORDS.repairItemsOreDictKey, Items.LEATHER);
        OreDictionary.registerOre(ZANZAS.repairItemsOreDictKey, Items.GLOWSTONE_DUST);
    }

    public static class WingType {
        public final String name;
        public final EnumRarity rarity;
        public final ResourceLocation layer1;
        public final ResourceLocation layer2;
        public final SoundEvent equipSound;
        public final SoundEvent flapSound;
        public final String repairItemsOreDictKey;
        public final String oreDictKey;

        WingType(String name, SoundEvent equipSound, SoundEvent flapSound) {
            this(name, equipSound, flapSound, EnumRarity.RARE);
        }

        WingType (String name, SoundEvent equipSound, SoundEvent flapSound, EnumRarity rarity) {
            this.name = name;
            this.rarity = rarity;
            this.equipSound = equipSound;
            this.flapSound = flapSound;
            this.layer1 = new ResourceLocation(Vikare.MODID, "textures/entity/" + name + "_wings.png");
            this.layer2 = new ResourceLocation(Vikare.MODID, "textures/entity/" + name + "_wings_2.png");
            String[] pieces = name.split("_");
            String oreBase = StringUtils.capitalize(pieces.length > 1 ? pieces[1] : "")+StringUtils.capitalize(pieces[0]);
            this.repairItemsOreDictKey = "itemRepairWings"+oreBase;
            this.oreDictKey = "wings"+oreBase;
        }

        public boolean doesMelt() {
            for (String type : VikareConfig.melts) {
                if (name.equals(type)) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFreeFlight() {
            for (String type : VikareConfig.freeFlight) {
                if (name.equals(type)) {
                    return true;
                }
            }
            return false;
        }
    }
}
