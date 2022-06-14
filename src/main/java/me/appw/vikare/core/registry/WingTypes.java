package me.appw.vikare.core.registry;

import me.appw.vikare.Vikare;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashSet;

public class WingTypes {
    public static final HashSet<WingType> WING_TYPES = new HashSet<>();

    public static final WingType BOX = new WingType("box", Sounds.ITEM_FEATHERED_WINGS_EQUIP, Sounds.ITEM_FEATHERED_WINGS_FLAP, Rarity.EPIC);

    public static final WingType FEATHERED = new WingType("feathered", Sounds.ITEM_FEATHERED_WINGS_EQUIP, Sounds.ITEM_FEATHERED_WINGS_FLAP);
    public static final WingType MECHANICAL_FEATHERED = new WingType("mechanical_feathered", Sounds.ITEM_MECHANICAL_FEATHERED_WINGS_EQUIP, Sounds.ITEM_FEATHERED_WINGS_FLAP);
    public static final WingType DRAGON = new WingType("dragon", Sounds.ITEM_DRAGON_WINGS_EQUIP, Sounds.ITEM_DRAGON_WINGS_FLAP);
    public static final WingType MECHANICAL_LEATHER = new WingType("mechanical_leather", Sounds.ITEM_MECHANICAL_LEATHER_WINGS_EQUIP, Sounds.ITEM_MECHANICAL_LEATHER_WINGS_FLAP);
    public static final WingType LIGHT = new WingType("light", Sounds.ITEM_LIGHT_WINGS_EQUIP, Sounds.ITEM_LIGHT_WINGS_FLAP);
    public static final WingType FLANDRES = new WingType("flandres", Sounds.ITEM_FLANDRES_WINGS_EQUIP, Sounds.ITEM_FLANDRES_WINGS_FLAP, Rarity.EPIC);
    public static final WingType DISCORDS = new WingType("discords", Sounds.ITEM_DISCORDS_WINGS_EQUIP, Sounds.ITEM_DISCORDS_WINGS_FLAP, Rarity.EPIC);
    public static final WingType ZANZAS = new WingType("zanzas", Sounds.ITEM_ZANZAS_WINGS_EQUIP, Sounds.ITEM_ZANZAS_WINGS_FLAP, Rarity.EPIC);

    public static class WingType {
        public final String name;
        public final Rarity rarity;
        public final ResourceLocation layer1;
        public final ResourceLocation layer2;
        public final RegistryObject<SoundEvent> equipSound;
        public final RegistryObject<SoundEvent> flapSound;
        public final TagKey<Item> repairItemsTag;

        WingType(String name, RegistryObject<SoundEvent> equipSound, RegistryObject<SoundEvent> flapSound) {
            this(name, equipSound, flapSound, Rarity.RARE);
//            this.name = name;
//            this.rarity = Rarity.RARE;
//            this.equipSound = equipSound;
//            this.flapSound = flapSound;
//            this.layer1 = new ResourceLocation(Vikare.MODID, "textures/entity/" + name + "_wings.png");
//            this.layer2 = new ResourceLocation(Vikare.MODID, "textures/entity/" + name + "_wings_2.png");
//            this.repairItemsTag = ItemTags.create(Vikare.resource(name + "_wings_repair_items"));
        }

        WingType (String name, RegistryObject<SoundEvent> equipSound, RegistryObject<SoundEvent> flapSound, Rarity rarity) {
            this.name = name;
            this.rarity = rarity;
            this.equipSound = equipSound;
            this.flapSound = flapSound;
            this.layer1 = new ResourceLocation(Vikare.MODID, "textures/entity/" + name + "_wings.png");
            this.layer2 = new ResourceLocation(Vikare.MODID, "textures/entity/" + name + "_wings_2.png");
            this.repairItemsTag = ItemTags.create(Vikare.resource(name + "_wings_repair_items"));
            WING_TYPES.add(this);
        }
    }
}
