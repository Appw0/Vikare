package me.appw.vikare.client.models;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.Nonnull;

public class FeatheredWingsModel<T extends LivingEntity> extends WingsModel<T> {
    private final ModelRenderer leftWing01;
    private final ModelRenderer leftWing02;
    private final ModelRenderer leftWing03;
    private final ModelRenderer leftWing04;
    private final ModelRenderer leftWing05;
    private final ModelRenderer lFeathers02;
    private final ModelRenderer Box_r1;
    private final ModelRenderer lFeathers01;
    private final ModelRenderer Box_r2;
    private final ModelRenderer rightWing01;
    private final ModelRenderer rightWing02;
    private final ModelRenderer rightWing03;
    private final ModelRenderer rightWing04;
    private final ModelRenderer rightWing05;
    private final ModelRenderer rFeathers02;
    private final ModelRenderer Box_r3;
    private final ModelRenderer rFeathers01;
    private final ModelRenderer Box_r4;

    public FeatheredWingsModel() {
        textureHeight = 64;
        textureWidth = 64;

        leftWing01 = new ModelRenderer(this);
        leftWing01.setRotationPoint(-6.0F, 0.0F, 0.0F);
        setRotationAngle(leftWing01, 0.0F, 1.5708F, 0.436332F);
        leftWing01.setTextureOffset(0,0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
        rightWing.addChild(leftWing01);

        leftWing02 = new ModelRenderer(this);
        leftWing02.setRotationPoint(-0.5F, 0.0F, 3.5F);
        leftWing01.addChild(leftWing02);
        setRotationAngle(leftWing02, 0.1309F, 0.3054F, 0.0F);
        leftWing02.setTextureOffset(0, 47).addBox(-0.5F, -1.5F, 0.5F, 1.0F, 2.0F, 8.0F, 0.0F, false);

        leftWing03 = new ModelRenderer(this);
        leftWing03.setRotationPoint(0.0F, -1.0F, 8.5F);
        leftWing02.addChild(leftWing03);
        setRotationAngle(leftWing03, -0.5672F, 0.3054F, 0.0F);
        leftWing03.setTextureOffset(39, 0).addBox(-0.5F, -0.1F, -0.5F, 1.0F, 2.0F, 8.0F, 0.0F, false);

        leftWing04 = new ModelRenderer(this);
        leftWing04.setRotationPoint(0.0F, 0.5F, 7.2F);
        leftWing03.addChild(leftWing04);
        setRotationAngle(leftWing04, 1.0908F, 0.0F, 0.0F);
        leftWing04.setTextureOffset(33, 25).addBox(-0.7F, -0.2F, -0.5F, 1.0F, 14.0F, 1.0F, 0.0F, true);

        leftWing05 = new ModelRenderer(this);
        leftWing05.setRotationPoint(-0.5F, 4.8F, -0.2F);
        leftWing04.addChild(leftWing05);
        leftWing05.setTextureOffset(0, 13).addBox(0.4F, -4.0F, -12.3F, 0.001F, 20.0F, 13.0F, 0.0F, true);

        lFeathers02 = new ModelRenderer(this);
        lFeathers02.setRotationPoint(0.0F, -3.5F, -3.2F);
        leftWing04.addChild(lFeathers02);
        setRotationAngle(lFeathers02, 0.0F, 0.0F, 0.0873F);

        Box_r1 = new ModelRenderer(this);
        Box_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        lFeathers02.addChild(Box_r1);
        setRotationAngle(Box_r1, 0.48F, 0.0F, 0.0F);
        Box_r1.setTextureOffset(26, 26).addBox(0.0F, -6.6F, -13.8F, 1.0F, 14.0F, 14.0F, 0.0F, true);

        lFeathers01 = new ModelRenderer(this);
        lFeathers01.setRotationPoint(0.6F, 1.3F, 1.5F);
        leftWing02.addChild(lFeathers01);
        setRotationAngle(lFeathers01, -0.1745F, -0.0873F, 0.0F);

        Box_r2 = new ModelRenderer(this);
        Box_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
        lFeathers01.addChild(Box_r2);
        setRotationAngle(Box_r2, 0.1745F, 0.0F, 0.0F);
        Box_r2.setTextureOffset(0, 0).addBox(-0.5F, -0.8F, -8.1F, 1.0F, 10.0F, 16.0F, 0.0F, true);

        rightWing01 = new ModelRenderer(this);
        rightWing01.setRotationPoint(6.0F, 0.0F, 0.0F);
        setRotationAngle(rightWing01, 0.0F, -1.5708F, -0.436332F);
        rightWing01.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 6.0F, 0.0F, true);
        leftWing.addChild(rightWing01);

        rightWing02 = new ModelRenderer(this);
        rightWing02.setRotationPoint(0.5F, 0.0F, 3.5F);
        rightWing01.addChild(rightWing02);
        setRotationAngle(rightWing02, 0.1309F, -0.3054F, 0.0F);
        rightWing02.setTextureOffset(0, 47).addBox(-0.5F, -1.5F, 0.5F, 1.0F, 2.0F, 8.0F, 0.0F, true);

        rightWing03 = new ModelRenderer(this);
        rightWing03.setRotationPoint(0.0F, -1.0F, 8.5F);
        rightWing02.addChild(rightWing03);
        setRotationAngle(rightWing03, -0.5672F, -0.3054F, 0.0F);
        rightWing03.setTextureOffset(39, 0).addBox(-0.5F, -0.1F, -0.5F, 1.0F, 2.0F, 8.0F, 0.0F, true);

        rightWing04 = new ModelRenderer(this);
        rightWing04.setRotationPoint(0.0F, 0.5F, 7.2F);
        rightWing03.addChild(rightWing04);
        setRotationAngle(rightWing04, 1.0908F, 0.0F, 0.0F);
        rightWing04.setTextureOffset(33, 25).addBox(-0.3F, -0.2F, -0.5F, 1.0F, 14.0F, 1.0F, 0.0F, false);

        rightWing05 = new ModelRenderer(this);
        rightWing05.setRotationPoint(0.5F, 4.8F, -0.2F);
        rightWing04.addChild(rightWing05);
        rightWing05.setTextureOffset(0, 13).addBox(-0.4F, -4.0F, -12.3F, 0.001F, 20.0F, 13.0F, 0.0F, false);

        rFeathers02 = new ModelRenderer(this);
        rFeathers02.setRotationPoint(0.0F, -3.5F, -3.2F);
        rightWing04.addChild(rFeathers02);
        setRotationAngle(rFeathers02, 0.0F, 0.0F, -0.0873F);

        Box_r3 = new ModelRenderer(this);
        Box_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
        rFeathers02.addChild(Box_r3);
        setRotationAngle(Box_r3, 0.48F, 0.0F, 0.0F);
        Box_r3.setTextureOffset(26, 26).addBox(-1.0F, -6.6F, -13.8F, 1.0F, 14.0F, 14.0F, 0.0F, false);

        rFeathers01 = new ModelRenderer(this);
        rFeathers01.setRotationPoint(-0.6F, 1.3F, 1.5F);
        rightWing02.addChild(rFeathers01);
        setRotationAngle(rFeathers01, -0.1745F, 0.0873F, 0.0F);

        Box_r4 = new ModelRenderer(this);
        Box_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
        rFeathers01.addChild(Box_r4);
        setRotationAngle(Box_r4, 0.1745F, 0.0F, 0.0F);
        Box_r4.setTextureOffset(0, 0).addBox(-0.5F, -0.8F, -8.1F, 1.0F, 10.0F, 16.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(@Nonnull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float netHeadPitch) {
        super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, netHeadPitch);

        if (state == State.IDLE || state == State.CROUCHING) {
            leftWing03.rotateAngleX = (float) Math.toRadians(-60);
        }
        if (state == State.FLYING) {
            leftWing03.rotateAngleX = (float) Math.toRadians(-32.5);
        }
        rightWing03.rotateAngleX = leftWing03.rotateAngleX;
    }

    public void setRotationAngle(ModelRenderer bone, float x, float y, float z)
    {
        bone.rotateAngleX = x;
        bone.rotateAngleY = y;
        bone.rotateAngleZ = z;
    }
}
