package me.appw.vikare.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import me.appw.vikare.Vikare;
import me.appw.vikare.client.VikareClient;
import me.appw.vikare.client.models.WingsModel;
import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.capability.WingItemCapability;
import me.appw.vikare.core.registry.WingTypes.WingType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;
import top.theillusivec4.curios.api.type.capability.ICurio;

public class WingsRenderer<L extends LivingEntity> implements ICurioRenderer {

    private WingType wingType;

    private WingsModel<L> model;

    public WingsRenderer(WingType wingType) {
        this.wingType = wingType;
    }

    public WingsRenderer(WingsModel<L> model) {
        Vikare.LOGGER.info("CALLED!");
        this.model = model;
    }

    public WingsRenderer<L> createModel() {
        if (this.model == null)
            this.model = (WingsModel<L>) VikareClient.WING_MODELS.get(wingType).getLeft().apply(Minecraft.getInstance().getEntityModels().bakeLayer(VikareClient.WING_LAYERS.get(wingType)));
        return this;
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        L livingEntity = (L) slotContext.entity();
        WingItem wings = (WingItem) stack.getItem();
        LazyOptional<ICurio> curioOpt = CuriosApi.getCurio(stack);
        curioOpt.ifPresent((curio) -> {
            if (curio instanceof WingItemCapability wingCap) {

                float[] primaryColor = wings.getPrimaryColor().getTextureDiffuseColors();
                float[] secondaryColor = wings.getSecondaryColor().getTextureDiffuseColors();

                matrixStack.translate(0.0D, 0.0D, 0.125D);

                setupModel(livingEntity, ageInTicks, wingCap);

                VertexConsumer vertexBuilder = ItemRenderer.getFoilBuffer(renderTypeBuffer, model.renderType(wingType.layer2), false, stack.hasFoil());
                model.renderToBuffer(matrixStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY, secondaryColor[0], secondaryColor[1], secondaryColor[2], 1.0F);

                vertexBuilder = ItemRenderer.getFoilBuffer(renderTypeBuffer, model.renderType(wingType.layer1), false, stack.hasFoil());
                model.renderToBuffer(matrixStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY, primaryColor[0], primaryColor[1], primaryColor[2], 1.0F);

            }
        });
    }

    public void setupModel(LivingEntity livingEntity, float ageInTicks, WingItemCapability wingCap) {
        model.setupAnim((L) livingEntity, ageInTicks, wingCap.getWingState());
        if (livingEntity instanceof Player player) VikareClient.processFlap(player, wingCap);
    }
}
