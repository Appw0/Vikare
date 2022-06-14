package me.appw.vikare.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

import javax.annotation.Nonnull;

public class LeatherWingsModel<T extends LivingEntity> extends WingsModel<T> {

    public LeatherWingsModel(ModelPart root) {
        super(root);
    }

    @Override
    public void setupAnim(@Nonnull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float netHeadPitch) {
        super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, netHeadPitch);

//        if (state == State.IDLE || state == State.CROUCHING) {
//            leftWing03.xRot = (float) Math.toRadians(-60);
//        }
//        if (state == State.FLYING) {
//            leftWing03.xRot = (float) Math.toRadians(-32.5);
//        }
//        rightWing03.xRot = leftWing03.xRot;
    }

    public void setRotationAngle(ModelPart bone, float x, float y, float z)
    {
        bone.xRot = x;
        bone.yRot = y;
        bone.zRot = z;
    }
}
