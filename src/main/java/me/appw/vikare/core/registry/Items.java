package me.appw.vikare.core.registry;

import me.appw.vikare.common.items.WingItem;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashSet;
import java.util.Set;

import static me.appw.vikare.Vikare.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class Items {
    public static final Set<WingItem> WINGS = new HashSet<>();

    public static final Item WHITE_FEATHERED_WINGS = create("white_feathered_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.WHITE, WingTypes.FEATHERED));
    public static final Item ORANGE_FEATHERED_WINGS = create("orange_feathered_wings", new WingItem(EnumDyeColor.ORANGE, EnumDyeColor.ORANGE, WingTypes.FEATHERED));
    public static final Item MAGENTA_FEATHERED_WINGS = create("magenta_feathered_wings", new WingItem(EnumDyeColor.MAGENTA, EnumDyeColor.MAGENTA, WingTypes.FEATHERED));
    public static final Item LIGHT_BLUE_FEATHERED_WINGS = create("light_blue_feathered_wings", new WingItem(EnumDyeColor.LIGHT_BLUE, EnumDyeColor.LIGHT_BLUE, WingTypes.FEATHERED));
    public static final Item YELLOW_FEATHERED_WINGS = create("yellow_feathered_wings", new WingItem(EnumDyeColor.YELLOW, EnumDyeColor.YELLOW, WingTypes.FEATHERED));
    public static final Item LIME_FEATHERED_WINGS = create("lime_feathered_wings", new WingItem(EnumDyeColor.LIME, EnumDyeColor.LIME, WingTypes.FEATHERED));
    public static final Item PINK_FEATHERED_WINGS = create("pink_feathered_wings", new WingItem(EnumDyeColor.PINK, EnumDyeColor.PINK, WingTypes.FEATHERED));
    public static final Item GREY_FEATHERED_WINGS = create("grey_feathered_wings", new WingItem(EnumDyeColor.GRAY, EnumDyeColor.GRAY, WingTypes.FEATHERED));
    public static final Item LIGHT_GREY_FEATHERED_WINGS = create("light_grey_feathered_wings", new WingItem(EnumDyeColor.SILVER, EnumDyeColor.SILVER, WingTypes.FEATHERED));
    public static final Item CYAN_FEATHERED_WINGS = create("cyan_feathered_wings", new WingItem(EnumDyeColor.CYAN, EnumDyeColor.CYAN, WingTypes.FEATHERED));
    public static final Item PURPLE_FEATHERED_WINGS = create("purple_feathered_wings", new WingItem(EnumDyeColor.PURPLE, EnumDyeColor.PURPLE, WingTypes.FEATHERED));
    public static final Item BLUE_FEATHERED_WINGS = create("blue_feathered_wings", new WingItem(EnumDyeColor.BLUE, EnumDyeColor.BLUE, WingTypes.FEATHERED));
    public static final Item BROWN_FEATHERED_WINGS = create("brown_feathered_wings", new WingItem(EnumDyeColor.BROWN, EnumDyeColor.BROWN, WingTypes.FEATHERED));
    public static final Item GREEN_FEATHERED_WINGS = create("green_feathered_wings", new WingItem(EnumDyeColor.GREEN, EnumDyeColor.GREEN, WingTypes.FEATHERED));
    public static final Item RED_FEATHERED_WINGS = create("red_feathered_wings", new WingItem(EnumDyeColor.RED, EnumDyeColor.RED, WingTypes.FEATHERED));
    public static final Item BLACK_FEATHERED_WINGS = create("black_feathered_wings", new WingItem(EnumDyeColor.BLACK, EnumDyeColor.BLACK, WingTypes.FEATHERED));

    public static final Item WHITE_DRAGON_WINGS = create("white_dragon_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.WHITE, WingTypes.DRAGON));
    public static final Item ORANGE_DRAGON_WINGS = create("orange_dragon_wings", new WingItem(EnumDyeColor.ORANGE, EnumDyeColor.ORANGE, WingTypes.DRAGON));
    public static final Item MAGENTA_DRAGON_WINGS = create("magenta_dragon_wings", new WingItem(EnumDyeColor.MAGENTA, EnumDyeColor.PINK, WingTypes.DRAGON));
    public static final Item LIGHT_BLUE_DRAGON_WINGS = create("light_blue_dragon_wings", new WingItem(EnumDyeColor.LIGHT_BLUE, EnumDyeColor.WHITE, WingTypes.DRAGON));
    public static final Item YELLOW_DRAGON_WINGS = create("yellow_dragon_wings", new WingItem(EnumDyeColor.YELLOW, EnumDyeColor.YELLOW, WingTypes.DRAGON));
    public static final Item LIME_DRAGON_WINGS = create("lime_dragon_wings", new WingItem(EnumDyeColor.LIME, EnumDyeColor.PINK, WingTypes.DRAGON));
    public static final Item PINK_DRAGON_WINGS = create("pink_dragon_wings", new WingItem(EnumDyeColor.PINK, EnumDyeColor.WHITE, WingTypes.DRAGON));
    public static final Item GREY_DRAGON_WINGS = create("grey_dragon_wings", new WingItem(EnumDyeColor.GRAY, EnumDyeColor.SILVER, WingTypes.DRAGON));
    public static final Item LIGHT_GREY_DRAGON_WINGS = create("light_grey_dragon_wings", new WingItem(EnumDyeColor.SILVER, EnumDyeColor.WHITE, WingTypes.DRAGON));
    public static final Item CYAN_DRAGON_WINGS = create("cyan_dragon_wings", new WingItem(EnumDyeColor.CYAN, EnumDyeColor.LIGHT_BLUE, WingTypes.DRAGON));
    public static final Item PURPLE_DRAGON_WINGS = create("purple_dragon_wings", new WingItem(EnumDyeColor.PURPLE, EnumDyeColor.MAGENTA, WingTypes.DRAGON));
    public static final Item BLUE_DRAGON_WINGS = create("blue_dragon_wings", new WingItem(EnumDyeColor.BLUE, EnumDyeColor.LIGHT_BLUE, WingTypes.DRAGON));
    public static final Item BROWN_DRAGON_WINGS = create("brown_dragon_wings", new WingItem(EnumDyeColor.BROWN, EnumDyeColor.ORANGE, WingTypes.DRAGON));
    public static final Item GREEN_DRAGON_WINGS = create("green_dragon_wings", new WingItem(EnumDyeColor.GREEN, EnumDyeColor.LIME, WingTypes.DRAGON));
    public static final Item RED_DRAGON_WINGS = create("red_dragon_wings", new WingItem(EnumDyeColor.RED, EnumDyeColor.YELLOW, WingTypes.DRAGON));
    public static final Item BLACK_DRAGON_WINGS = create("black_dragon_wings", new WingItem(EnumDyeColor.BLACK, EnumDyeColor.PURPLE, WingTypes.DRAGON));

    public static final Item WHITE_MECHANICAL_FEATHERED_WINGS = create("white_mechanical_feathered_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.WHITE, WingTypes.MECHANICAL_FEATHERED));
    public static final Item ORANGE_MECHANICAL_FEATHERED_WINGS = create("orange_mechanical_feathered_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.ORANGE, WingTypes.MECHANICAL_FEATHERED));
    public static final Item MAGENTA_MECHANICAL_FEATHERED_WINGS = create("magenta_mechanical_feathered_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.MAGENTA, WingTypes.MECHANICAL_FEATHERED));
    public static final Item LIGHT_BLUE_MECHANICAL_FEATHERED_WINGS = create("light_blue_mechanical_feathered_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.LIGHT_BLUE, WingTypes.MECHANICAL_FEATHERED));
    public static final Item YELLOW_MECHANICAL_FEATHERED_WINGS = create("yellow_mechanical_feathered_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.YELLOW, WingTypes.MECHANICAL_FEATHERED));
    public static final Item LIME_MECHANICAL_FEATHERED_WINGS = create("lime_mechanical_feathered_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.LIME, WingTypes.MECHANICAL_FEATHERED));
    public static final Item PINK_MECHANICAL_FEATHERED_WINGS = create("pink_mechanical_feathered_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.PINK, WingTypes.MECHANICAL_FEATHERED));
    public static final Item GREY_MECHANICAL_FEATHERED_WINGS = create("grey_mechanical_feathered_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.GRAY, WingTypes.MECHANICAL_FEATHERED));
    public static final Item LIGHT_GREY_MECHANICAL_FEATHERED_WINGS = create("light_grey_mechanical_feathered_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.SILVER, WingTypes.MECHANICAL_FEATHERED));
    public static final Item CYAN_MECHANICAL_FEATHERED_WINGS = create("cyan_mechanical_feathered_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.CYAN, WingTypes.MECHANICAL_FEATHERED));
    public static final Item PURPLE_MECHANICAL_FEATHERED_WINGS = create("purple_mechanical_feathered_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.PURPLE, WingTypes.MECHANICAL_FEATHERED));
    public static final Item BLUE_MECHANICAL_FEATHERED_WINGS = create("blue_mechanical_feathered_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.BLUE, WingTypes.MECHANICAL_FEATHERED));
    public static final Item BROWN_MECHANICAL_FEATHERED_WINGS = create("brown_mechanical_feathered_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.BROWN, WingTypes.MECHANICAL_FEATHERED));
    public static final Item GREEN_MECHANICAL_FEATHERED_WINGS = create("green_mechanical_feathered_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.GREEN, WingTypes.MECHANICAL_FEATHERED));
    public static final Item RED_MECHANICAL_FEATHERED_WINGS = create("red_mechanical_feathered_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.RED, WingTypes.MECHANICAL_FEATHERED));
    public static final Item BLACK_MECHANICAL_FEATHERED_WINGS = create("black_mechanical_feathered_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.BLACK, WingTypes.MECHANICAL_FEATHERED));

    public static final Item WHITE_MECHANICAL_LEATHER_WINGS = create("white_mechanical_leather_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.WHITE, WingTypes.MECHANICAL_LEATHER));
    public static final Item ORANGE_MECHANICAL_LEATHER_WINGS = create("orange_mechanical_leather_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.ORANGE, WingTypes.MECHANICAL_LEATHER));
    public static final Item MAGENTA_MECHANICAL_LEATHER_WINGS = create("magenta_mechanical_leather_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.MAGENTA, WingTypes.MECHANICAL_LEATHER));
    public static final Item LIGHT_BLUE_MECHANICAL_LEATHER_WINGS = create("light_blue_mechanical_leather_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.LIGHT_BLUE, WingTypes.MECHANICAL_LEATHER));
    public static final Item YELLOW_MECHANICAL_LEATHER_WINGS = create("yellow_mechanical_leather_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.YELLOW, WingTypes.MECHANICAL_LEATHER));
    public static final Item LIME_MECHANICAL_LEATHER_WINGS = create("lime_mechanical_leather_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.LIME, WingTypes.MECHANICAL_LEATHER));
    public static final Item PINK_MECHANICAL_LEATHER_WINGS = create("pink_mechanical_leather_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.PINK, WingTypes.MECHANICAL_LEATHER));
    public static final Item GREY_MECHANICAL_LEATHER_WINGS = create("grey_mechanical_leather_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.GRAY, WingTypes.MECHANICAL_LEATHER));
    public static final Item LIGHT_GREY_MECHANICAL_LEATHER_WINGS = create("light_grey_mechanical_leather_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.SILVER, WingTypes.MECHANICAL_LEATHER));
    public static final Item CYAN_MECHANICAL_LEATHER_WINGS = create("cyan_mechanical_leather_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.CYAN, WingTypes.MECHANICAL_LEATHER));
    public static final Item PURPLE_MECHANICAL_LEATHER_WINGS = create("purple_mechanical_leather_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.PURPLE, WingTypes.MECHANICAL_LEATHER));
    public static final Item BLUE_MECHANICAL_LEATHER_WINGS = create("blue_mechanical_leather_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.BLUE, WingTypes.MECHANICAL_LEATHER));
    public static final Item BROWN_MECHANICAL_LEATHER_WINGS = create("brown_mechanical_leather_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.BROWN, WingTypes.MECHANICAL_LEATHER));
    public static final Item GREEN_MECHANICAL_LEATHER_WINGS = create("green_mechanical_leather_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.GREEN, WingTypes.MECHANICAL_LEATHER));
    public static final Item RED_MECHANICAL_LEATHER_WINGS = create("red_mechanical_leather_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.RED, WingTypes.MECHANICAL_LEATHER));
    public static final Item BLACK_MECHANICAL_LEATHER_WINGS = create("black_mechanical_leather_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.BLACK, WingTypes.MECHANICAL_LEATHER));

    public static final Item WHITE_LIGHT_WINGS = create("white_light_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.WHITE, WingTypes.LIGHT));
    public static final Item ORANGE_LIGHT_WINGS = create("orange_light_wings", new WingItem(EnumDyeColor.ORANGE, EnumDyeColor.ORANGE, WingTypes.LIGHT));
    public static final Item MAGENTA_LIGHT_WINGS = create("magenta_light_wings", new WingItem(EnumDyeColor.MAGENTA, EnumDyeColor.MAGENTA, WingTypes.LIGHT));
    public static final Item LIGHT_BLUE_LIGHT_WINGS = create("light_blue_light_wings", new WingItem(EnumDyeColor.LIGHT_BLUE, EnumDyeColor.LIGHT_BLUE, WingTypes.LIGHT));
    public static final Item YELLOW_LIGHT_WINGS = create("yellow_light_wings", new WingItem(EnumDyeColor.YELLOW, EnumDyeColor.YELLOW, WingTypes.LIGHT));
    public static final Item LIME_LIGHT_WINGS = create("lime_light_wings", new WingItem(EnumDyeColor.LIME, EnumDyeColor.LIME, WingTypes.LIGHT));
    public static final Item PINK_LIGHT_WINGS = create("pink_light_wings", new WingItem(EnumDyeColor.PINK, EnumDyeColor.PINK, WingTypes.LIGHT));
    public static final Item GREY_LIGHT_WINGS = create("grey_light_wings", new WingItem(EnumDyeColor.GRAY, EnumDyeColor.GRAY, WingTypes.LIGHT));
    public static final Item LIGHT_GREY_LIGHT_WINGS = create("light_grey_light_wings", new WingItem(EnumDyeColor.SILVER, EnumDyeColor.SILVER, WingTypes.LIGHT));
    public static final Item CYAN_LIGHT_WINGS = create("cyan_light_wings", new WingItem(EnumDyeColor.CYAN, EnumDyeColor.CYAN, WingTypes.LIGHT));
    public static final Item PURPLE_LIGHT_WINGS = create("purple_light_wings", new WingItem(EnumDyeColor.PURPLE, EnumDyeColor.PURPLE, WingTypes.LIGHT));
    public static final Item BLUE_LIGHT_WINGS = create("blue_light_wings", new WingItem(EnumDyeColor.BLUE, EnumDyeColor.BLUE, WingTypes.LIGHT));
    public static final Item BROWN_LIGHT_WINGS = create("brown_light_wings", new WingItem(EnumDyeColor.BROWN, EnumDyeColor.BROWN, WingTypes.LIGHT));
    public static final Item GREEN_LIGHT_WINGS = create("green_light_wings", new WingItem(EnumDyeColor.GREEN, EnumDyeColor.GREEN, WingTypes.LIGHT));
    public static final Item RED_LIGHT_WINGS = create("red_light_wings", new WingItem(EnumDyeColor.RED, EnumDyeColor.RED, WingTypes.LIGHT));
    public static final Item BLACK_LIGHT_WINGS = create("black_light_wings", new WingItem(EnumDyeColor.BLACK, EnumDyeColor.BLACK, WingTypes.LIGHT));

    public static final Item FLANDRES_WINGS = create("flandres_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.WHITE, WingTypes.FLANDRES));
    public static final Item DISCORDS_WINGS = create("discords_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.WHITE, WingTypes.DISCORDS));
    public static final Item ZANZAS_WINGS = create("zanzas_wings", new WingItem(EnumDyeColor.WHITE, EnumDyeColor.WHITE, WingTypes.ZANZAS));

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (WingItem item : WINGS) {
            event.getRegistry().register(item);
        }
    }

    private static Item create(String name, WingItem item) {
        item.setRegistryName(new ResourceLocation(MODID, name));
        item.setTranslationKey(MODID + "." + name);
        WINGS.add(item);
        return item;
    }
}
