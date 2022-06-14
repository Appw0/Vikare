package me.appw.vikare.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

import javax.annotation.Nonnull;

public class LightWingsModel<T extends LivingEntity> extends WingsModel<T> {

    public LightWingsModel(ModelPart root) {
        super(root);
    }

    @Override
    public void setupAnim(@Nonnull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float netHeadPitch) {
        super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, netHeadPitch);
    }

    public void setRotationAngle(ModelPart bone, float x, float y, float z)
    {
        bone.xRot = x;
        bone.yRot = y;
        bone.zRot = z;
    }
}
