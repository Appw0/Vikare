package me.appw.vikare.client.models;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.Nonnull;

public class BoxWingsModel<T extends LivingEntity> extends WingsModel<T> {

    public BoxWingsModel() {
        textureHeight = 64;
        textureWidth = 64;

        rightWing.setTextureOffset(22, 0).addBox(-8.0F, -1.0F, -1.0F, 10.0F, 20.0F, 2.0F, 0.0F, true);
        leftWing.setTextureOffset(22, 22).addBox(-2.0F, -1.0F, -1.0F, 10.0F, 20.0F, 2.0F, 0.0F, false);
    }
}
