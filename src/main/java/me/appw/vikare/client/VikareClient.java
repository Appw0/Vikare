package me.appw.vikare.client;

import me.appw.vikare.Vikare;
import me.appw.vikare.client.models.*;
import me.appw.vikare.common.VikareCommon;
import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.registry.WingTypes;
import me.appw.vikare.core.registry.WingTypes.WingType;
import me.appw.vikare.core.util.ColorHelper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static me.appw.vikare.Vikare.MODID;
import static me.appw.vikare.core.registry.Items.ITEMS;

//@Mod.EventBusSubscriber(modid = Vikare.MODID, value = Dist.CLIENT, bus = Bus.MOD)
@Mod.EventBusSubscriber(modid = MODID, value = Side.CLIENT)
public class VikareClient extends VikareCommon {
    public static final Map<WingType, Class<?>> MODELS = new LinkedHashMap<>();
    private static double prevRollOffset;

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        for  (Item item : ITEMS) {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }

    @Override
    public void preinit() {
        MODELS.put(WingTypes.FEATHERED, FeatheredWingsModel.class);
        MODELS.put(WingTypes.MECHANICAL_FEATHERED, FeatheredWingsModel.class);
        MODELS.put(WingTypes.DRAGON, LeatherWingsModel.class);
        MODELS.put(WingTypes.MECHANICAL_LEATHER, LeatherWingsModel.class);
        MODELS.put(WingTypes.LIGHT, LightWingsModel.class);
        MODELS.put(WingTypes.FLANDRES, FlandresWingsModel.class);
        MODELS.put(WingTypes.DISCORDS, DiscordsWingsModel.class);
        MODELS.put(WingTypes.ZANZAS, ZanzasWingsModel.class);
    }
//
    @SubscribeEvent
    public static void registerItemColor(ColorHandlerEvent.Item event) {
        event.getItemColors().registerItemColorHandler(new IItemColor() {
            @Override
            public int colorMultiplier(ItemStack stack, int tintIndex) {
                return tintIndex == 0 ? ColorHelper.dyeToDecimal(((WingItem)stack.getItem()).getPrimaryColor()) : ColorHelper.dyeToDecimal(((WingItem)stack.getItem()).getSecondaryColor());
            }
        }, ITEMS.toArray(new Item[0]));
    }

    public static void entityViewRender(EntityViewRenderEvent.CameraSetup event) {
        // camera stuff
    }
//
//    @Mod.EventBusSubscriber(modid = Vikare.MODID, value = Dist.CLIENT, bus = Bus.FORGE)
//    public static class CameraEventHandler {
//        @SubscribeEvent
//        public static void entityViewRender(EntityViewRenderEvent.CameraSetup event) {
//            ClientPlayerEntity player = Minecraft.getInstance().player;
//            Optional<ImmutableTriple<String, Integer, ItemStack>> equippedCurio = CuriosApi.getCuriosHelper().findEquippedCurio(stack -> stack.getItem() instanceof WingItem, player);
//            if (player.isElytraFlying() && equippedCurio.isPresent()) {
//                double strafingRollOffset = player.getLookVec().rotateYaw((float)Math.PI / 2F).dotProduct(player.getMotion()) * 15.0D;
//                prevRollOffset = strafingRollOffset = MathHelper.lerp(event.getRenderPartialTicks(), prevRollOffset, strafingRollOffset);
//                event.setRoll((float) strafingRollOffset * VikareConfig.COMMON.rollAmount.get());
//            }
//        }
//    }
}
