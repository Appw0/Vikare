package me.appw.vikare.client;

import me.appw.vikare.Vikare;
import me.appw.vikare.client.models.*;
import me.appw.vikare.client.renderer.WingsRenderer;
import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.capability.WingItemCapability;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.registry.WingTypes;
import me.appw.vikare.core.registry.WingTypes.WingType;
import me.appw.vikare.core.util.ColorHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.tuple.Pair;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import static me.appw.vikare.core.registry.Items.*;

@Mod.EventBusSubscriber(modid = Vikare.MODID, value = Dist.CLIENT, bus = Bus.MOD)
public class VikareClient {
    public static final Map<WingType, Pair<Function<ModelPart, WingsModel<?>>, Supplier<LayerDefinition>>> WING_MODELS = new LinkedHashMap<>();
    public static final Map<WingType, WingsRenderer<?>> WING_RENDERERS = new LinkedHashMap<>();
    public static final Map<WingType, ModelLayerLocation> WING_LAYERS = new LinkedHashMap<>();
    public static Minecraft minecraft = Minecraft.getInstance();

    private static double prevRollOffset;

    static {

//        WING_MODELS.put(WingTypes.BOX, Pair.of(BoxWingsModel::new, BoxWingsModel::createLayer));  // debug code

        WING_MODELS.put(WingTypes.FEATHERED, Pair.of(FeatheredWingsModel::new, FeatheredWingsModel::createLayer));
        WING_MODELS.put(WingTypes.MECHANICAL_FEATHERED, Pair.of(FeatheredWingsModel::new, FeatheredWingsModel::createLayer));
        WING_MODELS.put(WingTypes.DRAGON, Pair.of(LeatherWingsModel::new, LeatherWingsModel::createLayer));
        WING_MODELS.put(WingTypes.MECHANICAL_LEATHER, Pair.of(LeatherWingsModel::new, LeatherWingsModel::createLayer));
        WING_MODELS.put(WingTypes.LIGHT, Pair.of(LightWingsModel::new, LightWingsModel::createLayer));
        WING_MODELS.put(WingTypes.FLANDRES, Pair.of(FlandresWingsModel::new, FlandresWingsModel::createLayer));
        WING_MODELS.put(WingTypes.DISCORDS, Pair.of(DiscordsWingsModel::new, DiscordsWingsModel::createLayer));
        WING_MODELS.put(WingTypes.ZANZAS, Pair.of(ZanzasWingsModel::new, ZanzasWingsModel::createLayer));
    }

    @SubscribeEvent
    public static void setupClient(FMLClientSetupEvent evt) {

        for (WingType wingType : WingTypes.WING_TYPES) {
            WING_RENDERERS.put(wingType, new WingsRenderer<>(wingType));
        }

        for (RegistryObject<Item> wingItem : WINGS.getEntries()) {
            CuriosRendererRegistry.register(wingItem.get(), () -> WING_RENDERERS.get(((WingItem) wingItem.get()).getWingType()).createModel());
        }
    }

    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        for (WingType wingType : WingTypes.WING_TYPES) {
            ModelLayerLocation layer = new ModelLayerLocation(Vikare.resource(wingType.name), "main");
            WING_LAYERS.put(wingType, layer);
            event.registerLayerDefinition(layer, WING_MODELS.get(wingType).getRight());
        }
    }

    @SubscribeEvent
    public static void registerItemColor(RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register((stack, color) -> color == 0 ? ColorHelper.dyeToDecimal(((WingItem) stack.getItem()).getPrimaryColor()): ColorHelper.dyeToDecimal(((WingItem) stack.getItem()).getSecondaryColor()),
                WHITE_FEATHERED_WINGS.get(), ORANGE_FEATHERED_WINGS.get(), MAGENTA_FEATHERED_WINGS.get(), LIGHT_BLUE_FEATHERED_WINGS.get(), YELLOW_FEATHERED_WINGS.get(), LIME_FEATHERED_WINGS.get(), PINK_FEATHERED_WINGS.get(), GREY_FEATHERED_WINGS.get(), LIGHT_GREY_FEATHERED_WINGS.get(), CYAN_FEATHERED_WINGS.get(), PURPLE_FEATHERED_WINGS.get(), BLUE_FEATHERED_WINGS.get(), BROWN_FEATHERED_WINGS.get(), GREEN_FEATHERED_WINGS.get(), RED_FEATHERED_WINGS.get(), BLACK_FEATHERED_WINGS.get(),
                WHITE_DRAGON_WINGS.get(), ORANGE_DRAGON_WINGS.get(), MAGENTA_DRAGON_WINGS.get(), LIGHT_BLUE_DRAGON_WINGS.get(), YELLOW_DRAGON_WINGS.get(), LIME_DRAGON_WINGS.get(), PINK_DRAGON_WINGS.get(), GREY_DRAGON_WINGS.get(), LIGHT_GREY_DRAGON_WINGS.get(), CYAN_DRAGON_WINGS.get(), PURPLE_DRAGON_WINGS.get(), BLUE_DRAGON_WINGS.get(), BROWN_DRAGON_WINGS.get(), GREEN_DRAGON_WINGS.get(), RED_DRAGON_WINGS.get(), BLACK_DRAGON_WINGS.get(),
                WHITE_MECHANICAL_FEATHERED_WINGS.get(), ORANGE_MECHANICAL_FEATHERED_WINGS.get(), MAGENTA_MECHANICAL_FEATHERED_WINGS.get(), LIGHT_BLUE_MECHANICAL_FEATHERED_WINGS.get(), YELLOW_MECHANICAL_FEATHERED_WINGS.get(), LIME_MECHANICAL_FEATHERED_WINGS.get(), PINK_MECHANICAL_FEATHERED_WINGS.get(), GREY_MECHANICAL_FEATHERED_WINGS.get(), LIGHT_GREY_MECHANICAL_FEATHERED_WINGS.get(), CYAN_MECHANICAL_FEATHERED_WINGS.get(), PURPLE_MECHANICAL_FEATHERED_WINGS.get(), BLUE_MECHANICAL_FEATHERED_WINGS.get(), BROWN_MECHANICAL_FEATHERED_WINGS.get(), GREEN_MECHANICAL_FEATHERED_WINGS.get(), RED_MECHANICAL_FEATHERED_WINGS.get(), BLACK_MECHANICAL_FEATHERED_WINGS.get(),
                WHITE_MECHANICAL_LEATHER_WINGS.get(), ORANGE_MECHANICAL_LEATHER_WINGS.get(), MAGENTA_MECHANICAL_LEATHER_WINGS.get(), LIGHT_BLUE_MECHANICAL_LEATHER_WINGS.get(), YELLOW_MECHANICAL_LEATHER_WINGS.get(), LIME_MECHANICAL_LEATHER_WINGS.get(), PINK_MECHANICAL_LEATHER_WINGS.get(), GREY_MECHANICAL_LEATHER_WINGS.get(), LIGHT_GREY_MECHANICAL_LEATHER_WINGS.get(), CYAN_MECHANICAL_LEATHER_WINGS.get(), PURPLE_MECHANICAL_LEATHER_WINGS.get(), BLUE_MECHANICAL_LEATHER_WINGS.get(), BROWN_MECHANICAL_LEATHER_WINGS.get(), GREEN_MECHANICAL_LEATHER_WINGS.get(), RED_MECHANICAL_LEATHER_WINGS.get(), BLACK_MECHANICAL_LEATHER_WINGS.get(),
                WHITE_LIGHT_WINGS.get(), ORANGE_LIGHT_WINGS.get(), MAGENTA_LIGHT_WINGS.get(), LIGHT_BLUE_LIGHT_WINGS.get(), YELLOW_LIGHT_WINGS.get(), LIME_LIGHT_WINGS.get(), PINK_LIGHT_WINGS.get(), GREY_LIGHT_WINGS.get(), LIGHT_GREY_LIGHT_WINGS.get(), CYAN_LIGHT_WINGS.get(), PURPLE_LIGHT_WINGS.get(), BLUE_LIGHT_WINGS.get(), BROWN_LIGHT_WINGS.get(), GREEN_LIGHT_WINGS.get(), RED_LIGHT_WINGS.get(), BLACK_LIGHT_WINGS.get());
        // TODO: replace this horrifying line with a loop, would go best with converting dyes to NBT colors
    }

    public static void processFlap(Player player, WingItemCapability wingCap) {
        RenderEventHandler.renderedPlayers.add((AbstractClientPlayer) player);
        if (wingCap.didFlap()) {
            float vol = 10.0F;
            if (Minecraft.getInstance().player == player) {
                vol = 100.0F;   // extra volume for the player's own wings because sounds don't move, but the player is going fast!
            }
            player.level().playLocalSound(player.getX(), player.getY(), player.getZ(), wingCap.getWingType().flapSound.get(), SoundSource.PLAYERS, vol, 0.9F + player.level().random.nextFloat() * 0.2F, false);
        }
    }

    public static void setDebugMessage(String message) {
        minecraft.gui.setOverlayMessage(Component.literal(message), false);
    }

    @Mod.EventBusSubscriber(modid = Vikare.MODID, value = Dist.CLIENT, bus = Bus.FORGE)
    public static class RenderEventHandler {

        private static final HashSet<AbstractClientPlayer> renderedPlayers = new HashSet<>();

        @SubscribeEvent
        public static void entityViewRender(ViewportEvent.ComputeCameraAngles event) {
            LocalPlayer player = minecraft.player;

            renderedPlayers.clear();

            if (player == minecraft.player && player.isFallFlying()) { // TODO: Backport roll fix and clamping. No clue what goofy ah math I was doing before
                double strafingRollOffset = player.getForward().cross(player.getUpVector(1.0f)).normalize().dot(player.getDeltaMovement()) * -15;
                strafingRollOffset = Mth.clamp(strafingRollOffset, -70, 70);
                prevRollOffset = strafingRollOffset = Mth.lerp(event.getPartialTick(), prevRollOffset, strafingRollOffset);
                event.setRoll((float)(strafingRollOffset * VikareConfig.COMMON.rollAmount.get()));
            }
        }

        @SubscribeEvent
        public static void renderLast(RenderLevelStageEvent event) {
            if (event.getStage().equals(RenderLevelStageEvent.Stage.AFTER_ENTITIES)) {
                minecraft.level.players().stream().filter(player -> !renderedPlayers.contains(player)).forEach(player ->
                        CuriosApi.getCuriosHelper().findFirstCurio(player, stack -> stack.getItem() instanceof WingItem)
                                .flatMap(slotResult -> CuriosApi.getCuriosHelper().getCurio(slotResult.stack()).filter(curio -> curio instanceof WingItemCapability))
                                .ifPresent(curio -> {
                                    WingItemCapability wingCap = (WingItemCapability) curio;
                                    WING_RENDERERS.get(wingCap.getWingType()).setupModel(player, player.tickCount, wingCap);
                                })
                );
            }
        }
    }
}
