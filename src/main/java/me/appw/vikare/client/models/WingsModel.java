package me.appw.vikare.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sun.javafx.geom.Vec3d;
import me.appw.vikare.Vikare;
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
    public FlapState flapState = FlapState.IDLE;

    private boolean slowfall = false;
    private float last_movement = -1;
    private float movement_override = -10.0F;

    public WingsModel() {
        textureHeight = 64;
        textureWidth = 64;

        rightWing = new ModelRenderer(this);
        rightWing.setRotationPoint(0.0F, 5.0F, 0.0F);

        leftWing = new ModelRenderer(this);
        leftWing.setRotationPoint(0.0F, 5.0F, 0.0F);
    }


    public void setRotationAngles(@Nonnull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float netHeadPitch, boolean forceFlapping) {
        movement_override = forceFlapping ? 1.0F : 0.0F;
        this.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, netHeadPitch);
    }

    public void setRotationAngles(@Nonnull T entity) {
        movement_override = -10.0F;
        this.setRotationAngles(entity, entity.limbSwing, entity.limbSwingAmount, entity.ticksExisted, entity.rotationYawHead, entity.rotationPitch);
    }

    @Override
    public void setRotationAngles(@Nonnull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float netHeadPitch) {
        state = State.IDLE;
        float flap_speed = 0.125F;
        float flap_distance = 0.1F;
        float wing_pitch = 0.3F;
        float wing_roll = -0.7F;
        float yaw_pivot = -1.0F;
        float wing_yaw = 0.0F;
        float movement = entity.moveForward;

        if (movement_override != -10.0F) { movement = movement_override; }

        if (entity.isElytraFlying()) {
            state = State.FLYING;
            float dive_tuck = 1.0F;
            Vector3d motionVec = entity.getMotion();

            if (motionVec.y < 0.0D) {
                Vector3d motionVecNorm = motionVec.normalize();
                dive_tuck = 1.0F - (float) Math.pow(-motionVecNorm.y, 1.5D);
            }

            wing_pitch = dive_tuck * 0.35F + (1.0F - dive_tuck) * wing_pitch;
            wing_roll = dive_tuck * -1.6F + (0.3F - dive_tuck) * wing_roll;

            if (movement > 0) {
                flap_speed = 0.4F;
                flap_distance = 1.0F;
            }
            if (movement > this.last_movement && this.last_movement == 0.0) {
//                Vikare.LOGGER.debug("move flap?");
                flapState = FlapState.FLAP;
            }
//            Vikare.LOGGER.debug(this.last_movement);
            this.last_movement = movement;
        } else if (entity.isSneaking()) {
            state = State.CROUCHING;
            wing_pitch = 0.7F;
            yaw_pivot = 0.0F;
            wing_yaw = 0.09F;
        } else if (slowfall) {
            state = State.SLOWFALL;
            slowfall = false;
            flap_speed = 1.0F;
            flap_distance = 2.0F;
        }

        float normalized_flap = MathHelper.sin(ageInTicks * flap_speed);
        if (state == State.SLOWFALL || (state == State.FLYING && movement > 0)) {
            if (normalized_flap > 0 && flapState == FlapState.DONE) {
                flapState = FlapState.IDLE;
            } else if (normalized_flap < 0 && flapState == FlapState.IDLE) {
//                Vikare.LOGGER.debug("anim flap");
                flapState = FlapState.FLAP;
            }
        }

        wing_pitch += normalized_flap * flap_distance;
        this.rightWing.rotationPointX = 7.0F;
        this.rightWing.rotationPointY = yaw_pivot;

        if (entity instanceof ClientPlayerEntity) {
            AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) entity;
            player.rotateElytraX = (player.rotateElytraX + (wing_pitch - player.rotateElytraX) * 0.1F);
            player.rotateElytraY = (player.rotateElytraY + (wing_yaw - player.rotateElytraY) * 0.1F);
            player.rotateElytraZ = (player.rotateElytraZ + (wing_roll - player.rotateElytraZ) * 0.1F);
            this.rightWing.rotateAngleX = player.rotateElytraX; // X -> pitch
            this.rightWing.rotateAngleY = player.rotateElytraY; // Y -> yaw
            this.rightWing.rotateAngleZ = player.rotateElytraZ; // Z -> roll
        } else {
            this.rightWing.rotateAngleX = (this.rightWing.rotateAngleX + (wing_pitch - this.rightWing.rotateAngleX) * 0.1F);
            this.rightWing.rotateAngleY = (this.rightWing.rotateAngleY + (wing_yaw - this.rightWing.rotateAngleY) * 0.1F);
            this.rightWing.rotateAngleZ = (this.rightWing.rotateAngleZ + (wing_roll - this.rightWing.rotateAngleZ) * 0.1F);
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

    public boolean didFlap() {
        if (this.flapState == FlapState.FLAP) {
            this.flapState = FlapState.DONE;
            return true;
        } else {
            return false;
        }
    }

    public void setSlowFall() {
        slowfall = true;
    }

    public enum State {
        IDLE, CROUCHING, FLYING, SLOWFALL
    }

    public enum FlapState {
        IDLE, FLAP, DONE
    }
}
