package me.appw.vikare;

import me.appw.vikare.client.VikareClient;
import me.appw.vikare.common.VikareCommon;
import me.appw.vikare.core.capability.WingItemCapability;
import me.appw.vikare.core.registry.Items;
import me.appw.vikare.core.registry.WingTypes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(
        modid = Vikare.MODID,
        name = Vikare.NAME,
        version = Vikare.VERSION,
        acceptedMinecraftVersions = "[1.12.2,1.13)",
        dependencies = "required-after:forge@[14.23.5.2855,);" + "required-after:baubles@[1.5.2,);"
)
public class Vikare {

    public static final String MODID = "vikare";
    public static final String NAME = "Vikare";
    public static final String VERSION = "${version}";

    @SidedProxy(clientSide = "me.appw.vikare.client.VikareClient", serverSide = "me.appw.vikare.common.VikareCommon")
    public static VikareCommon proxy;

    public static final CreativeTabs TAB = (new CreativeTabs("vikare.general") {
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(Items.ORANGE_FEATHERED_WINGS);
        }
    });

    // Directly reference a log4j logger.
    public static Logger LOGGER = LogManager.getLogger(MODID);

    @CapabilityInject(WingItemCapability.class)
    public static Capability<WingItemCapability> WING_ITEM_CAPABILITY = null;

    public Vikare() {

    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        CapabilityManager.INSTANCE.register(WingItemCapability.class, new Capability.IStorage<WingItemCapability>() {
            @Nullable
            @Override
            public NBTBase writeNBT(Capability<WingItemCapability> capability, WingItemCapability instance, EnumFacing side) {return null;}
            @Override
            public void readNBT(Capability<WingItemCapability> capability, WingItemCapability instance, EnumFacing side, NBTBase nbt) {}
        }, WingItemCapability::new);

        proxy.preinit();

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        WingTypes.registerOreDictEntries();
    }

    @EventHandler
    public void loadComplete(FMLLoadCompleteEvent event) {
        LOGGER.info("winga dinga");
    }

//    private void setup(final FMLCommonSetupEvent event) {
//        LOGGER.info("winga dinga");
//        NetworkHandler.register();
//    }

//    private void enqueueIMC(final InterModEnqueueEvent event) {
//        // some example code to dispatch IMC to another mod
////        InterModComms.sendTo("Vikare", "helloworld", () -> {
////            LOGGER.info("Hello world from the MDK");
////            return "Hello world";
////        });
//        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("back").size(1).build());
//    }
}
