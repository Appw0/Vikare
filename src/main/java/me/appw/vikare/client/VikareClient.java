package me.appw.vikare.client;

import com.sun.javafx.geom.Vec3d;
import me.appw.vikare.Vikare;
import me.appw.vikare.client.models.*;
import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.registry.Items;
import me.appw.vikare.core.registry.WingTypes;
import me.appw.vikare.core.registry.WingTypes.WingType;
import me.appw.vikare.core.util.ColorHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static me.appw.vikare.core.registry.Items.*;

@Mod.EventBusSubscriber(modid = Vikare.MODID, value = Dist.CLIENT, bus = Bus.MOD)
public class VikareClient {
    public static final Map<WingType, Class<?>> MODELS = new LinkedHashMap<>();
    private static double prevRollOffset;

    @SubscribeEvent
    public static void setupClient(FMLClientSetupEvent evt) {
        MODELS.put(WingTypes.FEATHERED, FeatheredWingsModel.class);
        MODELS.put(WingTypes.MECHANICAL_FEATHERED, FeatheredWingsModel.class);
        MODELS.put(WingTypes.DRAGON, LeatherWingsModel.class);
        MODELS.put(WingTypes.MECHANICAL_LEATHER, LeatherWingsModel.class);
        MODELS.put(WingTypes.LIGHT, LightWingsModel.class);
        MODELS.put(WingTypes.FLANDRES, FlandresWingsModel.class);
        MODELS.put(WingTypes.DISCORDS, DiscordsWingsModel.class);
        MODELS.put(WingTypes.ZANZAS, ZanzasWingsModel.class);
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

    @Mod.EventBusSubscriber(modid = Vikare.MODID, value = Dist.CLIENT, bus = Bus.FORGE)
    public static class CameraEventHandler {
        @SubscribeEvent
        public static void entityViewRender(EntityViewRenderEvent.CameraSetup event) {
            ClientPlayerEntity player = Minecraft.getInstance().player;
            Optional<ImmutableTriple<String, Integer, ItemStack>> equippedCurio = CuriosApi.getCuriosHelper().findEquippedCurio(stack -> stack.getItem() instanceof WingItem, player);
            if (player.isElytraFlying() && equippedCurio.isPresent()) {
                double strafingRollOffset = player.getLookVec().rotateYaw((float)Math.PI / 2F).dotProduct(player.getMotion()) * 15.0D;
                prevRollOffset = strafingRollOffset = MathHelper.lerp(event.getRenderPartialTicks(), prevRollOffset, strafingRollOffset);
                event.setRoll((float) strafingRollOffset * VikareConfig.COMMON.rollAmount.get());
            }
        }
    }
}
