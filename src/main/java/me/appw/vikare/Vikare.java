package me.appw.vikare;

import com.mojang.logging.LogUtils;
import me.appw.vikare.client.VikareClient;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.network.NetworkHandler;
import me.appw.vikare.core.registry.Items;
//import me.appw.vikare.core.registry.RecipeSerializers;
//import me.appw.vikare.core.registry.Sounds;
import me.appw.vikare.core.registry.Sounds;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("vikare")
public class Vikare {

    public static final String MODID = "vikare";

    public static CreativeModeTab ITEM_TAB;

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogUtils.getLogger();

    public Vikare() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerLayers);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerTabs);
        // Register the processIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, VikareConfig.COMMON_SPEC);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        Sounds.register();
        Items.register();
//        RecipeSerializers.register();
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("winga dinga");

        // This is not good
        // TODO: Find a better solution to this
        Items.WINGS.getEntries().forEach(wings -> wings.get().maxDamage = VikareConfig.COMMON.wingsDurability.get());

        NetworkHandler.register();
    }

//    private void doClientStuff(final FMLClientSetupEvent event) {
//        // do something that can only be done on the client
////        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
//    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
//        InterModComms.sendTo("Vikare", "helloworld", () -> {
//            LOGGER.info("Hello world from the MDK");
//            return "Hello world";
//        });
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("back").size(1).build());
    }

    private void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        VikareClient.registerLayers(event);
    }

    private void registerTabs(CreativeModeTabEvent.Register event) {
        ITEM_TAB = event.registerCreativeModeTab(resource("general"), builder -> builder
                .icon(() -> new ItemStack(Items.ORANGE_FEATHERED_WINGS.get()))
                .title(Component.translatable("tabs.vikare.general"))
                .displayItems((featureFlags, output) -> Items.WINGS.getEntries().forEach(wings -> output.accept(wings.get())))
        );
    }

    public static ResourceLocation resource(String location) {
        return new ResourceLocation(MODID, location);
    }

//    private void processIMC(final InterModProcessEvent event) {
//        // some example code to receive and process InterModComms from other mods
////        LOGGER.info("Got IMC {}", event.getIMCStream().
////                map(m -> m.getMessageSupplier().get()).
////                collect(Collectors.toList()));
//    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public void onServerStarting(FMLServerStartingEvent event) {
//        // do something when the server starts
//        LOGGER.info("winga dinga 2");
//        LOGGER.info(new ResourceLocation(Vikare.MOD_ID, "melts").toString());
//        LOGGER.info(WingItem.FREE_FLIGHT.getAllElements());
//    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
//    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
//    public static class RegistryEvents {
//        @SubscribeEvent
//        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
//            // register a new block here
////            LOGGER.info("HELLO from Register Block");
//        }
//    }
}
