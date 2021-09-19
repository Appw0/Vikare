package me.appw.vikare.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sun.javafx.geom.Vec3d;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;

import javax.annotation.Nonnull;

public class WingsModel<T extends LivingEntity> extends EntityModel<T> {

    public final ModelRenderer rightWing;
    public final ModelRenderer leftWing;
    public State state = State.IDLE;

    public WingsModel() {
        textureHeight = 64;
        textureWidth = 64;

        rightWing = new ModelRenderer(this);
        rightWing.setRotationPoint(0.0F, 5.0F, 0.0F);

        leftWing = new ModelRenderer(this);
        leftWing.setRotationPoint(0.0F, 5.0F, 0.0F);
    }

    @Override
    public void setRotationAngles(@Nonnull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float netHeadPitch) {
        state = State.IDLE;
        float a = 0.125F;
        float b = 0.1F;
        float k = 0.3F;
        float l = -0.7F;
        float m = -1.0F;
        float n = 0.0F;

        if (entity.isElytraFlying()) {
            state = State.FLYING;
            float o = 1.0F;
            Vector3d motionVec = entity.getMotion();

            if (motionVec.y < 0.0D) {
                Vector3d motionVecNorm = motionVec.normalize();
                o = 1.0F - (float) Math.pow(-motionVecNorm.y, 1.5D);
            }

            k = o * 0.35F + (1.0F - o) * k;
            l = o * -1.6F + (0.3F - o) * l;

            if (entity.moveForward > 0) {
                a = 0.4F;
                b = 1.0F;
            }
        } else if (entity.isSneaking()) {
            state = State.CROUCHING;
            k = 0.7F;
            m = 0.0F;
            n = 0.09F;
        }

        k += MathHelper.sin(ageInTicks * a) * b;
        this.rightWing.rotationPointX = 7.0F;
        this.rightWing.rotationPointY = m;

        if (entity instanceof ClientPlayerEntity) {
            AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) entity;
            player.rotateElytraX = (player.rotateElytraX + (k - player.rotateElytraX) * 0.1F);
            player.rotateElytraY = (player.rotateElytraY + (n - player.rotateElytraY) * 0.1F);
            player.rotateElytraZ = (player.rotateElytraZ + (l - player.rotateElytraZ) * 0.1F);
            this.rightWing.rotateAngleX = player.rotateElytraX; // X pitch?
            this.rightWing.rotateAngleY = player.rotateElytraY; // Y yaw?
            this.rightWing.rotateAngleZ = player.rotateElytraZ; // Z roll?
        } else {
            this.rightWing.rotateAngleX = k;
            this.rightWing.rotateAngleY = n;
            this.rightWing.rotateAngleZ = l;
        }

//        this.leftWing.rotationPointX = -this.rightWing.rotationPointX;
//        this.leftWing.rotateAngleY = -this.rightWing.rotateAngleY;
//        this.leftWing.rotationPointY = this.rightWing.rotationPointY;
//        this.leftWing.rotateAngleX = this.rightWing.rotateAngleX;
//        this.leftWing.rotateAngleZ = -this.rightWing.rotationPointZ;

        this.leftWing.rotationPointX = -this.rightWing.rotationPointX;
        this.leftWing.rotateAngleY = -this.rightWing.rotateAngleY;
        this.leftWing.rotationPointY = this.rightWing.rotationPointY;
        this.leftWing.rotateAngleX = this.rightWing.rotateAngleX;
        this.leftWing.rotateAngleZ = -this.rightWing.rotateAngleZ;

    }

    @Override
    public void render(@Nonnull MatrixStack matrixStack, @Nonnull IVertexBuilder vertexBuilder, int light, int overlay, float red, float green, float blue, float alpha) {
        this.rightWing.render(matrixStack, vertexBuilder, light, overlay, red, green, blue, alpha);
        this.leftWing.render(matrixStack, vertexBuilder, light, overlay, red, green, blue, alpha);
    }

    public enum State
    {
        IDLE, CROUCHING, FLYING
    }
}
