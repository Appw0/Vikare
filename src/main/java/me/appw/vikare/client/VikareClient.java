package me.appw.vikare.client;

import me.appw.vikare.Vikare;
import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.registry.Items;
import me.appw.vikare.core.util.ColorHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static me.appw.vikare.core.registry.Items.*;

@Mod.EventBusSubscriber(modid = Vikare.MODID, value = Dist.CLIENT, bus = Bus.MOD)
public class VikareClient {

    @SubscribeEvent
    public static void setupClient(FMLClientSetupEvent evt) {
    }

    @SubscribeEvent
    public static void registerItemColor(ColorHandlerEvent.Item event) {
        event.getItemColors().register((stack, color) -> color == 0 ? ColorHelper.dyeToDecimal(((WingItem) stack.getItem()).getPrimaryColor()): ColorHelper.dyeToDecimal(((WingItem) stack.getItem()).getSecondaryColor()),
                WHITE_FEATHERED_WINGS.get(), ORANGE_FEATHERED_WINGS.get(), MAGENTA_FEATHERED_WINGS.get(), LIGHT_BLUE_FEATHERED_WINGS.get(), YELLOW_FEATHERED_WINGS.get(), LIME_FEATHERED_WINGS.get(), PINK_FEATHERED_WINGS.get(), GREY_FEATHERED_WINGS.get(), LIGHT_GREY_FEATHERED_WINGS.get(), CYAN_FEATHERED_WINGS.get(), PURPLE_FEATHERED_WINGS.get(), BLUE_FEATHERED_WINGS.get(), BROWN_FEATHERED_WINGS.get(), GREEN_FEATHERED_WINGS.get(), RED_FEATHERED_WINGS.get(), BLACK_FEATHERED_WINGS.get(),
                WHITE_DRAGON_WINGS.get(), ORANGE_DRAGON_WINGS.get(), MAGENTA_DRAGON_WINGS.get(), LIGHT_BLUE_DRAGON_WINGS.get(), YELLOW_DRAGON_WINGS.get(), LIME_DRAGON_WINGS.get(), PINK_DRAGON_WINGS.get(), GREY_DRAGON_WINGS.get(), LIGHT_GREY_DRAGON_WINGS.get(), CYAN_DRAGON_WINGS.get(), PURPLE_DRAGON_WINGS.get(), BLUE_DRAGON_WINGS.get(), BROWN_DRAGON_WINGS.get(), GREEN_DRAGON_WINGS.get(), RED_DRAGON_WINGS.get(), BLACK_DRAGON_WINGS.get(),
                WHITE_MECHANICAL_FEATHERED_WINGS.get(), ORANGE_MECHANICAL_FEATHERED_WINGS.get(), MAGENTA_MECHANICAL_FEATHERED_WINGS.get(), LIGHT_BLUE_MECHANICAL_FEATHERED_WINGS.get(), YELLOW_MECHANICAL_FEATHERED_WINGS.get(), LIME_MECHANICAL_FEATHERED_WINGS.get(), PINK_MECHANICAL_FEATHERED_WINGS.get(), GREY_MECHANICAL_FEATHERED_WINGS.get(), LIGHT_GREY_MECHANICAL_FEATHERED_WINGS.get(), CYAN_MECHANICAL_FEATHERED_WINGS.get(), PURPLE_MECHANICAL_FEATHERED_WINGS.get(), BLUE_MECHANICAL_FEATHERED_WINGS.get(), BROWN_MECHANICAL_FEATHERED_WINGS.get(), GREEN_MECHANICAL_FEATHERED_WINGS.get(), RED_MECHANICAL_FEATHERED_WINGS.get(), BLACK_MECHANICAL_FEATHERED_WINGS.get(),
                WHITE_MECHANICAL_LEATHER_WINGS.get(), ORANGE_MECHANICAL_LEATHER_WINGS.get(), MAGENTA_MECHANICAL_LEATHER_WINGS.get(), LIGHT_BLUE_MECHANICAL_LEATHER_WINGS.get(), YELLOW_MECHANICAL_LEATHER_WINGS.get(), LIME_MECHANICAL_LEATHER_WINGS.get(), PINK_MECHANICAL_LEATHER_WINGS.get(), GREY_MECHANICAL_LEATHER_WINGS.get(), LIGHT_GREY_MECHANICAL_LEATHER_WINGS.get(), CYAN_MECHANICAL_LEATHER_WINGS.get(), PURPLE_MECHANICAL_LEATHER_WINGS.get(), BLUE_MECHANICAL_LEATHER_WINGS.get(), BROWN_MECHANICAL_LEATHER_WINGS.get(), GREEN_MECHANICAL_LEATHER_WINGS.get(), RED_MECHANICAL_LEATHER_WINGS.get(), BLACK_MECHANICAL_LEATHER_WINGS.get(),
                WHITE_LIGHT_WINGS.get(), ORANGE_LIGHT_WINGS.get(), MAGENTA_LIGHT_WINGS.get(), LIGHT_BLUE_LIGHT_WINGS.get(), YELLOW_LIGHT_WINGS.get(), LIME_LIGHT_WINGS.get(), PINK_LIGHT_WINGS.get(), GREY_LIGHT_WINGS.get(), LIGHT_GREY_LIGHT_WINGS.get(), CYAN_LIGHT_WINGS.get(), PURPLE_LIGHT_WINGS.get(), BLUE_LIGHT_WINGS.get(), BROWN_LIGHT_WINGS.get(), GREEN_LIGHT_WINGS.get(), RED_LIGHT_WINGS.get(), BLACK_LIGHT_WINGS.get());
    }
}
