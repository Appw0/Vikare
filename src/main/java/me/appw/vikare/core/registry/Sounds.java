package me.appw.vikare.core.registry;

import me.appw.vikare.Vikare;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashSet;
import java.util.Set;

import static me.appw.vikare.Vikare.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class Sounds {
    public static final Set<SoundEvent> SOUNDS = new HashSet<>();

    public static final SoundEvent ITEM_FEATHERED_WINGS_FLAP = register("item.feathered_wings.flap");
    public static final SoundEvent ITEM_MECHANICAL_FEATHERED_WINGS_FLAP = register("item.mechanical_feathered_wings.flap");
    public static final SoundEvent ITEM_DRAGON_WINGS_FLAP = register("item.dragon_wings.flap");
    public static final SoundEvent ITEM_MECHANICAL_LEATHER_WINGS_FLAP = register("item.mechanical_leather_wings.flap");
    public static final SoundEvent ITEM_LIGHT_WINGS_FLAP = register("item.light_wings.flap");
    public static final SoundEvent ITEM_FLANDRES_WINGS_FLAP = register("item.flandres_wings.flap");
    public static final SoundEvent ITEM_DISCORDS_WINGS_FLAP = register("item.discords_wings.flap");
    public static final SoundEvent ITEM_ZANZAS_WINGS_FLAP = register("item.zanzas_wings.flap");

    public static final SoundEvent ITEM_FEATHERED_WINGS_EQUIP = register("item.feathered_wings.equip");
    public static final SoundEvent ITEM_MECHANICAL_FEATHERED_WINGS_EQUIP = register("item.mechanical_feathered_wings.equip");
    public static final SoundEvent ITEM_DRAGON_WINGS_EQUIP = register("item.dragon_wings.equip");
    public static final SoundEvent ITEM_MECHANICAL_LEATHER_WINGS_EQUIP = register("item.mechanical_leather_wings.equip");
    public static final SoundEvent ITEM_LIGHT_WINGS_EQUIP = register("item.light_wings.equip");
    public static final SoundEvent ITEM_FLANDRES_WINGS_EQUIP = register("item.flandres_wings.equip");
    public static final SoundEvent ITEM_DISCORDS_WINGS_EQUIP = register("item.discords_wings.equip");
    public static final SoundEvent ITEM_ZANZAS_WINGS_EQUIP = register("item.zanzas_wings.equip");

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        for (SoundEvent sevt : SOUNDS) {
            event.getRegistry().register(sevt);
        }
    }

    private static SoundEvent register(String key) {
        ResourceLocation location = new ResourceLocation(MODID + ":" + key);
        SoundEvent event = new SoundEvent(location);
        SOUNDS.add(event.setRegistryName(location));
        return event;
    }
}
