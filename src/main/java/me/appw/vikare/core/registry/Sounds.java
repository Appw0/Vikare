package me.appw.vikare.core.registry;

import me.appw.vikare.Vikare;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Sounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Vikare.MODID);

    public static final RegistryObject<SoundEvent> ITEM_FEATHERED_WINGS_FLAP = register("item.feathered_wings.flap");
    public static final RegistryObject<SoundEvent> ITEM_MECHANICAL_FEATHERED_WINGS_FLAP = register("item.mechanical_feathered_wings.flap");
    public static final RegistryObject<SoundEvent> ITEM_DRAGON_WINGS_FLAP = register("item.dragon_wings.flap");
    public static final RegistryObject<SoundEvent> ITEM_MECHANICAL_LEATHER_WINGS_FLAP = register("item.mechanical_leather_wings.flap");
    public static final RegistryObject<SoundEvent> ITEM_LIGHT_WINGS_FLAP = register("item.light_wings.flap");
    public static final RegistryObject<SoundEvent> ITEM_FLANDRES_WINGS_FLAP = register("item.flandres_wings.flap");
    public static final RegistryObject<SoundEvent> ITEM_DISCORDS_WINGS_FLAP = register("item.discords_wings.flap");
    public static final RegistryObject<SoundEvent> ITEM_ZANZAS_WINGS_FLAP = register("item.zanzas_wings.flap");

    public static final RegistryObject<SoundEvent> ITEM_FEATHERED_WINGS_EQUIP = register("item.feathered_wings.equip");
    public static final RegistryObject<SoundEvent> ITEM_MECHANICAL_FEATHERED_WINGS_EQUIP = register("item.mechanical_feathered_wings.equip");
    public static final RegistryObject<SoundEvent> ITEM_DRAGON_WINGS_EQUIP = register("item.dragon_wings.equip");
    public static final RegistryObject<SoundEvent> ITEM_MECHANICAL_LEATHER_WINGS_EQUIP = register("item.mechanical_leather_wings.equip");
    public static final RegistryObject<SoundEvent> ITEM_LIGHT_WINGS_EQUIP = register("item.light_wings.equip");
    public static final RegistryObject<SoundEvent> ITEM_FLANDRES_WINGS_EQUIP = register("item.flandres_wings.equip");
    public static final RegistryObject<SoundEvent> ITEM_DISCORDS_WINGS_EQUIP = register("item.discords_wings.equip");
    public static final RegistryObject<SoundEvent> ITEM_ZANZAS_WINGS_EQUIP = register("item.zanzas_wings.equip");

    public static void register() {
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private static RegistryObject<SoundEvent> register(String key) {
        return SOUNDS.register(key, () -> new SoundEvent(new ResourceLocation(Vikare.MODID + ":" + key)));
    }
}
