package me.appw.vikare;

import com.mojang.logging.LogUtils;
import me.appw.vikare.client.VikareClient;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.network.NetworkHandler;
import me.appw.vikare.core.registry.Items;
import me.appw.vikare.core.registry.RecipeSerializers;
import me.appw.vikare.core.registry.Sounds;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("vikare")
public class Vikare {

    public static final String MODID = "vikare";

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogUtils.getLogger();

    public Vikare() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerLayers);
        // Register the processIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(VikareConfig::onConfigUpdate);

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, VikareConfig.SERVER_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, VikareConfig.CLIENT_SPEC);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        Sounds.register();
        Items.register();
        RecipeSerializers.register();
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("winga dinga");
        NetworkHandler.register();
    }

    private void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        VikareClient.registerLayers(event);
    }

    public static ResourceLocation resource(String location) {
        return new ResourceLocation(MODID, location);
    }
}
