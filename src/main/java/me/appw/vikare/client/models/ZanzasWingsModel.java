package me.appw.vikare.client.models;


import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import javax.annotation.Nonnull;

public class ZanzasWingsModel extends WingsModel {
    private final ModelRenderer lWing01;
    private final ModelRenderer lWing02;
    private final ModelRenderer lWingCircle;
    private final ModelRenderer cube_r1;
    private final ModelRenderer rWing01;
    private final ModelRenderer rWing02;
    private final ModelRenderer rWingCircle;
    private final ModelRenderer cube_r2;

    public ZanzasWingsModel()
    {
        textureWidth = 64;
        textureHeight = 64;
        lWing01 = new ModelRenderer(this);
        lWing01.setRotationPoint(-6.0F, 0.0F, 0.0F);
        setRotationAngle(lWing01, 0.0F, 0.0F, 0.436332F);
        lWing01.setTextureOffset(0, 18).addBox(0.0F, -5.0F, 0.25F, 14, 15, 0,false);
//        lWing01.setTextureOffset(0, 18).addBox(0.0F, -5.0F, 0.25F, 14.0F, 15.0F, 0.001F, 0.0F, false);
        rightWing.addChild(lWing01);

        lWing02 = new ModelRenderer(this);
        lWing02.setRotationPoint(14.0F, 0.0F, 0.0F);
        lWing01.addChild(lWing02);
        setRotationAngle(lWing02, 0.0F, -0.2182F, 0.0F);
        lWing02.setTextureOffset(29, 17).addBox(0.0F, -6.0F, 0.25F, 17, 17, 0,false);
//        lWing02.setTextureOffset(29, 17).addBox(0.0F, -6.0F, 0.25F, 17.0F, 17.0F, 0.001F, 0.0F, false);

        lWingCircle = new ModelRenderer(this);
        lWingCircle.setRotationPoint(2.0F, 6.0F, 1.0F);
        lWing02.addChild(lWingCircle);
        setRotationAngle(lWingCircle, 0.0F, 0.0F, 0.0436F);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        lWingCircle.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, -2.3562F);
        cube_r1.setTextureOffset(0, 34).addBox(-7.5F, -8.5F, 0.25F, 13, 13, 0,false);
//        cube_r1.setTextureOffset(0, 34).addBox(-7.5F, -8.5F, 0.25F, 13.0F, 13.0F, 0.001F, 0.0F, false);

        rWing01 = new ModelRenderer(this);
        rWing01.setRotationPoint(6.0F, 0.0F, 0.0F);
        setRotationAngle(rWing01, 0.0F, 0.0F, -0.436332F);
        rWing01.setTextureOffset(0, 18).addBox(-14.0F, -5.0F, 0.25F, 14, 15, 0,true);
//        rWing01.setTextureOffset(0, 18).addBox(-14.0F, -5.0F, 0.25F, 14.0F, 15.0F, 0.001F, 0.0F, true);
        leftWing.addChild(rWing01);

        rWing02 = new ModelRenderer(this);
        rWing02.setRotationPoint(-14.0F, 0.0F, 0.0F);
        rWing01.addChild(rWing02);
        setRotationAngle(rWing02, 0.0F, 0.2182F, 0.0F);
        rWing02.setTextureOffset(29, 17).addBox(-17.0F, -6.0F, 0.25F, 17, 17, 0,true);
//        rWing02.setTextureOffset(29, 17).addBox(-17.0F, -6.0F, 0.25F, 17.0F, 17.0F, 0.001F, 0.0F, true);

        rWingCircle = new ModelRenderer(this);
        rWingCircle.setRotationPoint(-2.0F, 6.0F, 1.0F);
        rWing02.addChild(rWingCircle);
        setRotationAngle(rWingCircle, 0.0F, 0.0F, -0.0436F);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
        rWingCircle.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, 2.3562F);
        cube_r2.setTextureOffset(0, 34).addBox(-5.5F, -8.5F, 0.25F, 13, 13, 0,true);
//        cube_r2.setTextureOffset(0, 34).addBox(-5.5F, -8.5F, 0.25F, 13.0F, 13.0F, 0.001F, 0.0F, true);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
    }

    public void setRotationAngle(ModelRenderer bone, float x, float y, float z)
    {
        bone.rotateAngleX = x;
        bone.rotateAngleY = y;
        bone.rotateAngleZ = z;
    }
}
