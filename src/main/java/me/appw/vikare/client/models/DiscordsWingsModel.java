package me.appw.vikare.client.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import javax.annotation.Nonnull;

public class DiscordsWingsModel extends WingsModel {
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
    private final ModelRenderer rightWing04Leather;
    private final ModelRenderer rightWingStrut01;
    private final ModelRenderer rightWingStrut01Leather;
    private final ModelRenderer rightWingStrut02;
    private final ModelRenderer rightWingStrut02Leather;
    private final ModelRenderer rightWingStrut03;
    private final ModelRenderer rightWingStrut03Leather;
    private final ModelRenderer rightStrutLowest;
    private final ModelRenderer rightStrutLowestLeather01;
    private final ModelRenderer rightStrutLowestLeather02;

    public DiscordsWingsModel()
    {
        textureWidth = 128;
        textureHeight = 64;
        leftWing01 = new ModelRenderer(this);
        leftWing01.setRotationPoint(-6.0F, 0.0F, 0.0F);
        setRotationAngle(leftWing01, 0.0F, 1.5708F, 0.436332F);
        leftWing01.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2, 4, 6, false);
        rightWing.addChild(leftWing01);

        leftWing02 = new ModelRenderer(this);
        leftWing02.setRotationPoint(-0.5F, 0.0F, 3.5F);
        leftWing01.addChild(leftWing02);
        setRotationAngle(leftWing02, 0.6109F, 0.3054F, 0.0F);
        leftWing02.setTextureOffset(17, 0).addBox(-0.5F, -1.5F, 0.5F, 1, 2, 8, false);

        leftWing03 = new ModelRenderer(this);
        leftWing03.setRotationPoint(0.0F, -1.0F, 8.5F);
        leftWing02.addChild(leftWing03);
        setRotationAngle(leftWing03, -0.5672F, 0.3054F, 0.0F);
        leftWing03.setTextureOffset(36, 0).addBox(-0.5F, -0.1F, -0.5F, 1, 2, 8, false);

        leftWing04 = new ModelRenderer(this);
        leftWing04.setRotationPoint(0.0F, 0.5F, 7.2F);
        leftWing03.addChild(leftWing04);
        setRotationAngle(leftWing04, 1.0908F, 0.0F, 0.0F);
        leftWing04.setTextureOffset(55, 0).addBox(-0.7F, -0.2F, -0.5F, 1, 14, 1, true);

        leftWing05 = new ModelRenderer(this);
        leftWing05.setRotationPoint(-0.5F, 4.8F, -0.2F);
        leftWing04.addChild(leftWing05);
        leftWing05.setTextureOffset(32, 31);
        leftWing05.cubeList.add(new ModelBoxPatched(leftWing05, 32, 31, 0.4F, -4.0F, -12.3F, 0.001F, 20, 13, 0, true));

        lFeathers02 = new ModelRenderer(this);
        lFeathers02.setRotationPoint(0.0F, -3.5F, -3.2F);
        leftWing04.addChild(lFeathers02);
        setRotationAngle(lFeathers02, 0.0F, 0.0F, 0.0873F);

        Box_r1 = new ModelRenderer(this);
        Box_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        lFeathers02.addChild(Box_r1);
        setRotationAngle(Box_r1, 0.48F, 0.0F, 0.0F);
        Box_r1.setTextureOffset(0, 36).addBox(0.0F, -6.6F, -13.8F, 1, 14, 14, true);

        lFeathers01 = new ModelRenderer(this);
        lFeathers01.setRotationPoint(0.6F, 1.3F, 1.5F);
        leftWing02.addChild(lFeathers01);
        setRotationAngle(lFeathers01, -0.1745F, -0.0873F, 0.0F);

        Box_r2 = new ModelRenderer(this);
        Box_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
        lFeathers01.addChild(Box_r2);
        setRotationAngle(Box_r2, 0.1745F, 0.0F, 0.0F);
        Box_r2.setTextureOffset(0, 10).addBox(-0.5F, -0.8F, -8.1F, 1, 10, 16, true);

        rightWing01 = new ModelRenderer(this);
        rightWing01.setRotationPoint(6.0F, 0.0F, 0.0F);
        setRotationAngle(rightWing01, 0.0F, -1.5708F, -0.436332F);
        rightWing01.setTextureOffset(66, 0).addBox(-1.0F, -1.0F, -1.0F, 2, 4, 5, true);
        leftWing.addChild(rightWing01);

        rightWing02 = new ModelRenderer(this);
        rightWing02.setRotationPoint(0.5F, 0.0F, 3.5F);
        rightWing01.addChild(rightWing02);
        setRotationAngle(rightWing02, 0.6109F, -0.48F, 0.0F);
        rightWing02.setTextureOffset(81, 0).addBox(-0.5F, 0.0F, -1.5F, 1, 2, 8, true);

        rightWing03 = new ModelRenderer(this);
        rightWing03.setRotationPoint(0.0F, 1.0F, 6.5F);
        rightWing02.addChild(rightWing03);
        setRotationAngle(rightWing03, -0.5672F, -0.3054F, 0.0F);
        rightWing03.setTextureOffset(101, 0).addBox(-0.5F, -1.1F, -0.5F, 1, 2, 8, true);

        rightWing04 = new ModelRenderer(this);
        rightWing04.setRotationPoint(0.0F, 0.0F, 7.5F);
        rightWing03.addChild(rightWing04);
        setRotationAngle(rightWing04, -0.7418F, 0.0F, 0.0F);
        rightWing04.setTextureOffset(60, 13).addBox(-0.4F, -0.8F, -4.0F, 1, 1, 19, true);

        rightWing04Leather = new ModelRenderer(this);
        rightWing04Leather.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightWing04.addChild(rightWing04Leather);
        rightWing04Leather.setTextureOffset(95, 40);
        rightWing04Leather.cubeList.add(new ModelBoxPatched(rightWing04Leather, 95, 40, 0.0F, 0.0F, 0.0F, 0.001F, 5, 14, 0, true));

        rightWingStrut01 = new ModelRenderer(this);
        rightWingStrut01.setRotationPoint(0.0F, 1.0F, 7.0F);
        rightWing03.addChild(rightWingStrut01);
        setRotationAngle(rightWingStrut01, -1.0036F, 0.0F, 0.0F);
        rightWingStrut01.setTextureOffset(83, 12).addBox(-0.4F, -0.5F, -0.5F, 1, 1, 16, true);

        rightWingStrut01Leather = new ModelRenderer(this);
        rightWingStrut01Leather.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightWingStrut01.addChild(rightWingStrut01Leather);
        rightWingStrut01Leather.setTextureOffset(95, 34);
        rightWingStrut01Leather.cubeList.add(new ModelBoxPatched(rightWingStrut01Leather, 95, 34, 0.05F, 0.0F, 0.0F, 0.001F, 5, 14, 0, true));

        rightWingStrut02 = new ModelRenderer(this);
        rightWingStrut02.setRotationPoint(0.0F, 1.0F, 6.0F);
        rightWing03.addChild(rightWingStrut02);
        setRotationAngle(rightWingStrut02, -1.309F, 0.0F, 0.0F);
        rightWingStrut02.setTextureOffset(83, 12).addBox(-0.4F, -0.5F, -0.5F, 1, 1, 16, true);

        rightWingStrut02Leather = new ModelRenderer(this);
        rightWingStrut02Leather.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightWingStrut02.addChild(rightWingStrut02Leather);
        rightWingStrut02Leather.setTextureOffset(93, 25);
        rightWingStrut02Leather.cubeList.add(new ModelBoxPatched(rightWingStrut02Leather, 93, 25, 0.1F, 0.0F, -1.0F, 0.001F, 6, 16, 0, true));

        rightWingStrut03 = new ModelRenderer(this);
        rightWingStrut03.setRotationPoint(0.0F, 1.0F, 5.0F);
        rightWing03.addChild(rightWingStrut03);
        setRotationAngle(rightWingStrut03, -1.6581F, 0.0F, 0.0F);
        rightWingStrut03.setTextureOffset(83, 12).addBox(-0.4F, -0.5F, -0.5F, 1, 1, 16, true);

        rightWingStrut03Leather = new ModelRenderer(this);
        rightWingStrut03Leather.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightWingStrut03.addChild(rightWingStrut03Leather);
        rightWingStrut03Leather.setTextureOffset(93, 19);
        rightWingStrut03Leather.cubeList.add(new ModelBoxPatched(rightWingStrut03Leather, 93, 19, 0.15F, 0.0F, 0.0F, 0.001F, 6, 15, 0, true));

        rightStrutLowest = new ModelRenderer(this);
        rightStrutLowest.setRotationPoint(-0.5F, 1.0F, 2.0F);
        rightWing02.addChild(rightStrutLowest);
        setRotationAngle(rightStrutLowest, -0.3491F, 0.0F, 0.0F);
        rightStrutLowest.setTextureOffset(104, 12).addBox(0.1F, 0.0F, -0.5F, 1, 12, 1, true);

        rightStrutLowestLeather01 = new ModelRenderer(this);
        rightStrutLowestLeather01.setRotationPoint(0.5F, 0.0F, 0.0F);
        rightStrutLowest.addChild(rightStrutLowestLeather01);
        rightStrutLowestLeather01.setTextureOffset(79, 28);
        rightStrutLowestLeather01.cubeList.add(new ModelBoxPatched(rightStrutLowestLeather01, 79, 28, 0.0F, -1.0F, 0.0F, 0.001F, 12, 6, 0, true));

        rightStrutLowestLeather02 = new ModelRenderer(this);
        rightStrutLowestLeather02.setRotationPoint(0.5F, 0.0F, 0.0F);
        rightStrutLowest.addChild(rightStrutLowestLeather02);
        setRotationAngle(rightStrutLowestLeather02, 0.0F, 0.2618F, 0.0F);
        rightStrutLowestLeather02.setTextureOffset(60, 25);
        rightStrutLowestLeather02.cubeList.add(new ModelBoxPatched(rightStrutLowestLeather02, 60, 25, 0.0F, -1.0F, -9.0F, 0.001F, 12, 9, 0, true));
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);

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
