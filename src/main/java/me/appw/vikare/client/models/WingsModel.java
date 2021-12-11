package me.appw.vikare.client.models;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nonnull;
import javax.vecmath.Vector3d;

public class WingsModel extends ModelBase {

    public final ModelRenderer rightWing;
    public final ModelRenderer leftWing;
    public State state = State.IDLE;
    public FlapState flapState = FlapState.IDLE;

    private boolean slowfall = false;
    private boolean broken = false;
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


    public void setRotationAngles(EntityPlayer player, boolean forceFlapping) {
        movement_override = forceFlapping ? 1.0F : 0.0F;
        this.setRotationAngles(player.limbSwing, player.limbSwingAmount, player.ticksExisted, player.rotationYawHead, player.rotationPitch, 1, player);
    }

    public void setRotationAngles(EntityPlayer player) {
        movement_override = -10.0F;
        this.setRotationAngles(player.limbSwing, player.limbSwingAmount, player.ticksExisted, player.rotationYawHead, player.rotationPitch, 1, player);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        if (!(entity instanceof EntityLivingBase)) {
            return;
        }
        EntityLivingBase livingEntity = (EntityLivingBase) entity;

        state = State.IDLE;
        float flap_speed = 0.125F;
        float flap_distance = 0.1F;
        float wing_pitch = 0.3F;
        float wing_roll = -0.7F;
        float yaw_pivot = -1.0F;
        float wing_yaw = 0.0F;
        float movement = livingEntity.moveForward;

        if (movement_override != -10.0F) { movement = movement_override; }

        if (livingEntity.isElytraFlying()) {
            state = State.FLYING;
            float dive_tuck = 1.0F;
            Vector3d motionVec = new Vector3d(livingEntity.motionX, livingEntity.motionY, livingEntity.motionZ);

            if (motionVec.y < 0.0D) {
                Vector3d motionVecNorm = new Vector3d();
                motionVecNorm.normalize(motionVec);
                dive_tuck = 1.0F - (float) Math.pow(-motionVecNorm.y, 1.5D);
            }

            wing_pitch = dive_tuck * 0.35F + (1.0F - dive_tuck) * wing_pitch;
            wing_roll = dive_tuck * -1.6F + (0.3F - dive_tuck) * wing_roll;

            if (movement > 0) {
                flap_speed = 0.4F;
                flap_distance = 1.0F;
            }
            if (broken) {
                state = State.BROKEN;
                broken = false;
                flap_speed = 1.0F;
                flap_distance = 3.0F;
            }
            if (movement > this.last_movement && this.last_movement == 0.0) {
                flapState = FlapState.FLAP;
            }
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
        if (state == State.SLOWFALL || state == State.BROKEN || (state == State.FLYING && movement > 0)) {
            if (normalized_flap > 0 && flapState == FlapState.DONE) {
                flapState = FlapState.IDLE;
            } else if (normalized_flap < 0 && flapState == FlapState.IDLE) {
                flapState = FlapState.FLAP;
            }
        }

        wing_pitch += normalized_flap * flap_distance;
        this.rightWing.rotationPointX = 7.0F;
        this.rightWing.rotationPointY = yaw_pivot;

        if (entity instanceof AbstractClientPlayer) {
            AbstractClientPlayer player = (AbstractClientPlayer) entity;
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

        this.leftWing.rotationPointX = -this.rightWing.rotationPointX;
        this.leftWing.rotateAngleY = -this.rightWing.rotateAngleY;
        this.leftWing.rotationPointY = this.rightWing.rotationPointY;
        this.leftWing.rotateAngleX = this.rightWing.rotateAngleX;
        this.leftWing.rotateAngleZ = -this.rightWing.rotateAngleZ;
    }

    public void render(EntityPlayer player) {
        render(player, player.limbSwing, player.limbSwingAmount, player.ticksExisted, player.rotationYawHead, player.rotationPitch, 0.0625F);
    }
    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableCull();
        this.rightWing.render(scale);
        this.leftWing.render(scale);
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

    public void setBroken() { broken = true; }

    public enum State {
        IDLE, CROUCHING, FLYING, SLOWFALL, BROKEN
    }

    public enum FlapState {
        IDLE, FLAP, DONE
    }
}
