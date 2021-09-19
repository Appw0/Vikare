package me.appw.vikare.client.models;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.Nonnull;

public class LightWingsModel<T extends LivingEntity> extends WingsModel<T> {
    private final ModelRenderer rWingMain;
    private final ModelRenderer rWing01;
    private final ModelRenderer rWing02;
    private final ModelRenderer rWing03;
    private final ModelRenderer rWing04;
    private final ModelRenderer rWing05;
    private final ModelRenderer lWingMain;
    private final ModelRenderer lWing01;
    private final ModelRenderer lWing02;
    private final ModelRenderer lWing03;
    private final ModelRenderer lWing04;
    private final ModelRenderer lWing05;

    public LightWingsModel()
    {
        textureWidth = 32;
        textureHeight = 32;
        rWingMain = new ModelRenderer(this);
        rWingMain.setRotationPoint(8.0F, 0.0F, 0.0F);
        setRotationAngle(rWingMain, 0.0F, 0.0F, -0.836332F);
        leftWing.addChild(rWingMain);

        rWing01 = new ModelRenderer(this);
        rWing01.setRotationPoint(-3.0F, -1.0F, 1.0F);
        rWingMain.addChild(rWing01);
        setRotationAngle(rWing01, 0.0F, 0.0F, 0.3054F);
        rWing01.setTextureOffset(26, 18).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 13.0F, 0.0F, 0.0F, true);

        rWing02 = new ModelRenderer(this);
        rWing02.setRotationPoint(-6.0F, -3.0F, 1.0F);
        rWingMain.addChild(rWing02);
        setRotationAngle(rWing02, 0.0F, 0.0F, 0.48F);
        rWing02.setTextureOffset(25, 12).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 19.0F, 0.0F, 0.0F, true);

        rWing03 = new ModelRenderer(this);
        rWing03.setRotationPoint(-9.5F, -5.0F, 1.0F);
        rWingMain.addChild(rWing03);
        setRotationAngle(rWing03, 0.0F, 0.0F, 0.6981F);
        rWing03.setTextureOffset(25, 8).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 23.0F, 0.0F, 0.0F, true);

        rWing04 = new ModelRenderer(this);
        rWing04.setRotationPoint(-12.0F, -7.75F, 1.0F);
        rWingMain.addChild(rWing04);
        setRotationAngle(rWing04, 0.0F, 0.0F, 0.9599F);
        rWing04.setTextureOffset(19, 16).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 15.0F, 0.0F, 0.0F, true);

        rWing05 = new ModelRenderer(this);
        rWing05.setRotationPoint(-12.25F, -11.75F, 1.0F);
        rWingMain.addChild(rWing05);
        setRotationAngle(rWing05, 0.0F, 0.0F, 1.0908F);
        rWing05.setTextureOffset(12, 21).addBox(-0.5F, -2.0F, 0.0F, 2.0F, 10.0F, 0.0F, 0.0F, true);

        lWingMain = new ModelRenderer(this);
        lWingMain.setRotationPoint(-8.0F, 0.0F, 0.0F);
        setRotationAngle(lWingMain, 0.0F, 0.0F, 0.836332F);
        rightWing.addChild(lWingMain);

        lWing01 = new ModelRenderer(this);
        lWing01.setRotationPoint(3.0F, -1.0F, 1.0F);
        lWingMain.addChild(lWing01);
        setRotationAngle(lWing01, 0.0F, 0.0F, -0.3054F);
        lWing01.setTextureOffset(26, 18).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 13.0F, 0.0F, 0.0F, false);

        lWing02 = new ModelRenderer(this);
        lWing02.setRotationPoint(6.0F, -3.0F, 1.0F);
        lWingMain.addChild(lWing02);
        setRotationAngle(lWing02, 0.0F, 0.0F, -0.48F);
        lWing02.setTextureOffset(25, 12).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 19.0F, 0.0F, 0.0F, false);

        lWing03 = new ModelRenderer(this);
        lWing03.setRotationPoint(9.5F, -5.0F, 1.0F);
        lWingMain.addChild(lWing03);
        setRotationAngle(lWing03, 0.0F, 0.0F, -0.6981F);
        lWing03.setTextureOffset(25, 8).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 23.0F, 0.0F, 0.0F, false);

        lWing04 = new ModelRenderer(this);
        lWing04.setRotationPoint(12.0F, -7.75F, 1.0F);
        lWingMain.addChild(lWing04);
        setRotationAngle(lWing04, 0.0F, 0.0F, -0.9599F);
        lWing04.setTextureOffset(19, 16).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 15.0F, 0.0F, 0.0F, false);

        lWing05 = new ModelRenderer(this);
        lWing05.setRotationPoint(12.25F, -11.75F, 1.0F);
        lWingMain.addChild(lWing05);
        setRotationAngle(lWing05, 0.0F, 0.0F, -1.0908F);
        lWing05.setTextureOffset(12, 21).addBox(-1.5F, -2.0F, 0.0F, 2.0F, 10.0F, 0.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(@Nonnull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float netHeadPitch) {
        super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, netHeadPitch);
    }

    public void setRotationAngle(ModelRenderer bone, float x, float y, float z)
    {
        bone.rotateAngleX = x;
        bone.rotateAngleY = y;
        bone.rotateAngleZ = z;
    }
}
