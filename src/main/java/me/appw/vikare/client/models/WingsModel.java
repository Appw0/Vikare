package me.appw.vikare.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import me.appw.vikare.core.capability.WingItemCapability.FlapState;
import me.appw.vikare.core.capability.WingItemCapability.State;
import me.appw.vikare.core.capability.WingItemCapability.WingsState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class WingsModel<T extends LivingEntity> extends EntityModel<T> {

    public final ModelPart rightWing;
    public final ModelPart leftWing;

    public WingsModel(ModelPart root) {
        rightWing = root.getChild("right_wing");
        leftWing = root.getChild("left_wing");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDef = createPartialLayer();
        return LayerDefinition.create(meshDef, 64, 64);
    }

    public static MeshDefinition createPartialLayer() {
        MeshDefinition meshDef = new MeshDefinition();
        PartDefinition rootDef = meshDef.getRoot();
        rootDef.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offset(0.0f, 5.0f, 0.0f));
        rootDef.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offset(0.0f, 5.0f, 0.0f));
        return meshDef;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float netHeadPitch) {
        setupAnim(entity, ageInTicks, new WingsState());
    }

    public void setupAnim(T entity, float ageInTicks, WingsState state) {
        float flap_speed = 0.125F;
        float flap_distance = 0.1F;
        float wing_pitch = 0.3F;
        float wing_roll = -0.7F;
        float yaw_pivot = -1.0F;
        float wing_yaw = 0.0F;
        float movement = entity.zza;

        if (state.forcedFlap) movement = 1.0F;

        if (state.status == State.FLYING) {
            float dive_tuck = 1.0F;
            Vec3 motionVec = entity.getDeltaMovement();

            if (motionVec.y < 0.0D) {
                Vec3 motionVecNorm = motionVec.normalize();
                dive_tuck = 1.0F - (float) Math.pow(-motionVecNorm.y, 1.5D);
            }

            wing_pitch = dive_tuck * 0.35F + (1.0F - dive_tuck) * wing_pitch;
            wing_roll = dive_tuck * -1.6F + (0.3F - dive_tuck) * wing_roll;

            if (movement > 0) {
                flap_speed = 0.4F;
                flap_distance = 1.0F;
            }
            if (state.broken) {
                flap_speed = 1.0F;
                flap_distance = 3.0F;
            }
            if (movement > state.lastMovement && state.lastMovement == 0.0) {
                state.flapStatus = FlapState.FLAP;
            }
            state.lastMovement = movement;
        } else if (state.status == State.CROUCHING) {
            wing_pitch = 0.7F;
            yaw_pivot = 0.0F;
            wing_yaw = 0.09F;
        } else if (state.status == State.SLOWFALL) {
            flap_speed = 1.0F;
            flap_distance = 2.0F;
        }

        float normalized_flap = Mth.sin(ageInTicks * flap_speed);
        if (state.status == State.SLOWFALL || (state.status == State.FLYING && (movement > 0 || state.broken))) {
            if (normalized_flap > 0 && state.flapStatus == FlapState.DONE) {
                state.flapStatus = FlapState.IDLE;
            } else if (normalized_flap < 0 && state.flapStatus == FlapState.IDLE) {
                state.flapStatus = FlapState.FLAP;
            }
        }

        wing_pitch += normalized_flap * flap_distance;
        this.leftWing.x = 7.0F;
        this.leftWing.y = yaw_pivot;

        if (entity instanceof AbstractClientPlayer player) {  // TODO: backport the removal of the else statement
            player.elytraRotX = (player.elytraRotX + (wing_pitch - player.elytraRotX) * 0.1F);
            player.elytraRotY = (player.elytraRotY + (wing_yaw - player.elytraRotY) * 0.1F);
            player.elytraRotZ = (player.elytraRotZ + (wing_roll - player.elytraRotZ) * 0.1F);
            this.leftWing.xRot = player.elytraRotX; // X -> pitch
            this.leftWing.yRot = player.elytraRotY; // Y -> yaw
            this.leftWing.zRot = player.elytraRotZ; // Z -> roll
        }

        this.rightWing.x = -this.leftWing.x;
        this.rightWing.yRot = -this.leftWing.yRot;
        this.rightWing.y = this.leftWing.y;
        this.rightWing.xRot = this.leftWing.xRot;
        this.rightWing.zRot = -this.leftWing.zRot;
    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer vertexBuilder, int light, int overlay, float red, float green, float blue, float alpha) {
        this.rightWing.render(matrixStack, vertexBuilder, light, overlay, red, green, blue, alpha);
        this.leftWing.render(matrixStack, vertexBuilder, light, overlay, red, green, blue, alpha);
    }
}
