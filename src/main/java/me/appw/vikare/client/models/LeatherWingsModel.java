package me.appw.vikare.client.models;


import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import javax.annotation.Nonnull;

public class LeatherWingsModel extends WingsModel {
    private final ModelRenderer leftWing01;
    private final ModelRenderer leftWing02;
    private final ModelRenderer leftWing03;
    private final ModelRenderer leftWing04;
    private final ModelRenderer leftWing04Leather;
    private final ModelRenderer leftWingStrut01;
    private final ModelRenderer leftWingStrut01Leather;
    private final ModelRenderer leftWingStrut02;
    private final ModelRenderer leftWingStrut02Leather;
    private final ModelRenderer leftWingStrut03;
    private final ModelRenderer leftWingStrut03Leather;
    private final ModelRenderer leftStrutLowest;
    private final ModelRenderer leftStrutLowestLeather01;
    private final ModelRenderer leftStrutLowestLeather02;
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

    public LeatherWingsModel()
    {
        textureWidth = 64;
        textureHeight = 64;

        leftWing01 = new ModelRenderer(this);
        leftWing01.setRotationPoint(-6.0F, 0.0F, 0.0F);
        setRotationAngle(leftWing01, 0.0F, 1.5708F, 0.436332F);
        leftWing01.setTextureOffset(21, 0).addBox(-1.001F, -1.0F, -1.0F, 2, 4, 5,false);
        rightWing.addChild(leftWing01);

        leftWing02 = new ModelRenderer(this);
        leftWing02.setRotationPoint(-0.5F, 0.0F, 3.5F);
        leftWing01.addChild(leftWing02);
        setRotationAngle(leftWing02, 0.6109F, 0.0F, 0.0F);
        leftWing02.setTextureOffset(0, 47).addBox(-0.5F, 0.0F, -1.5F, 1, 2, 8,false);

        leftWing03 = new ModelRenderer(this);
        leftWing03.setRotationPoint(0.0F, 1.0F, 6.5F);
        leftWing02.addChild(leftWing03);
        setRotationAngle(leftWing03, -0.5672F, 0.3054F, 0.0F);
        leftWing03.setTextureOffset(39, 0).addBox(-0.5F, -1.1F, -0.5F, 1, 2, 8,false);

        leftWing04 = new ModelRenderer(this);
        leftWing04.setRotationPoint(0.0F, 0.0F, 7.5F);
        leftWing03.addChild(leftWing04);
        setRotationAngle(leftWing04, -0.7418F, 0.0F, 0.0F);
        leftWing04.setTextureOffset(0, 0).addBox(-0.6F, -0.8F, -4.0F, 1, 1, 19,false);

        leftWing04Leather = new ModelRenderer(this);
        leftWing04Leather.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftWing04.addChild(leftWing04Leather);
        leftWing04Leather.setTextureOffset(0, 28);
        leftWing04Leather.cubeList.add(new ModelBoxPatched(leftWing04Leather, 0, 28, 0.0F, 0.0F, 0.0F, 0.001F, 5, 14, 0, false));

        leftWingStrut01 = new ModelRenderer(this);
        leftWingStrut01.setRotationPoint(0.0F, 1.0F, 7.0F);
        leftWing03.addChild(leftWingStrut01);
        setRotationAngle(leftWingStrut01, -1.0036F, 0.0F, 0.0F);
        leftWingStrut01.setTextureOffset(21, 0).addBox(-0.6F, -0.5F, -0.5F, 1, 1, 16,false);

        leftWingStrut01Leather = new ModelRenderer(this);
        leftWingStrut01Leather.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftWingStrut01.addChild(leftWingStrut01Leather);
        leftWingStrut01Leather.setTextureOffset(0, 22);
        leftWingStrut01Leather.cubeList.add(new ModelBoxPatched(leftWingStrut01Leather, 0, 22, -0.05F, 0.0F, 0.0F, 0.001F, 5, 14, 0, false));

        leftWingStrut02 = new ModelRenderer(this);
        leftWingStrut02.setRotationPoint(0.0F, 1.0F, 6.0F);
        leftWing03.addChild(leftWingStrut02);
        setRotationAngle(leftWingStrut02, -1.309F, 0.0F, 0.0F);
        leftWingStrut02.setTextureOffset(21, 0).addBox(-0.6F, -0.5F, -0.5F, 1, 1, 16,false);

        leftWingStrut02Leather = new ModelRenderer(this);
        leftWingStrut02Leather.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftWingStrut02.addChild(leftWingStrut02Leather);
        leftWingStrut02Leather.setTextureOffset(0, 4);
        leftWingStrut02Leather.cubeList.add(new ModelBoxPatched(leftWingStrut02Leather, 0, 4, -0.1F, 0.0F, -1.0F, 0.001F, 6, 16, 0, false));

        leftWingStrut03 = new ModelRenderer(this);
        leftWingStrut03.setRotationPoint(0.0F, 1.0F, 5.0F);
        leftWing03.addChild(leftWingStrut03);
        setRotationAngle(leftWingStrut03, -1.6581F, 0.0F, 0.0F);
        leftWingStrut03.setTextureOffset(21, 0).addBox(-0.6F, -0.5F, -0.5F, 1, 1, 16,false);

        leftWingStrut03Leather = new ModelRenderer(this);
        leftWingStrut03Leather.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftWingStrut03.addChild(leftWingStrut03Leather);
        leftWingStrut03Leather.setTextureOffset(0, 12);
        leftWingStrut03Leather.cubeList.add(new ModelBoxPatched(leftWingStrut03Leather, 0, 12, -0.15F, 0.0F, 0.0F, 0.001F, 6, 15, 0, false));

        leftStrutLowest = new ModelRenderer(this);
        leftStrutLowest.setRotationPoint(0.5F, 1.0F, 2.0F);
        leftWing02.addChild(leftStrutLowest);
        setRotationAngle(leftStrutLowest, -0.3491F, 0.0F, 0.0F);
        leftStrutLowest.setTextureOffset(12, 0).addBox(-1.1F, 0.0F, -0.5F, 1, 12, 1,false);

        leftStrutLowestLeather01 = new ModelRenderer(this);
        leftStrutLowestLeather01.setRotationPoint(-0.5F, 0.0F, 0.0F);
        leftStrutLowest.addChild(leftStrutLowestLeather01);
        leftStrutLowestLeather01.setTextureOffset(0, 0);
        leftStrutLowestLeather01.cubeList.add(new ModelBoxPatched(leftStrutLowestLeather01, 0, 0, 0.0F, -1.0F, 0.0F, 0.001F, 12, 6, 0, false));

        leftStrutLowestLeather02 = new ModelRenderer(this);
        leftStrutLowestLeather02.setRotationPoint(-0.5F, 0.0F, 0.0F);
        leftStrutLowest.addChild(leftStrutLowestLeather02);
        setRotationAngle(leftStrutLowestLeather02, 0.0F, -0.2618F, 0.0F);
        leftStrutLowestLeather02.setTextureOffset(28, 28);
        leftStrutLowestLeather02.cubeList.add(new ModelBoxPatched(leftStrutLowestLeather02, 28, 28, 0.0F, -1.0F, -9.0F, 0.001F, 12, 9, 0, false));

        rightWing01 = new ModelRenderer(this);
        rightWing01.setRotationPoint(6.0F, 0.0F, 0.0F);
        setRotationAngle(rightWing01, 0.0F, -1.5708F, -0.436332F);
        rightWing01.setTextureOffset(21, 0).addBox(-0.999F, -1.0F, -1.0F, 2, 4, 5,true);
        leftWing.addChild(rightWing01);

        rightWing02 = new ModelRenderer(this);
        rightWing02.setRotationPoint(0.5F, 0.0F, 3.5F);
        rightWing01.addChild(rightWing02);
        setRotationAngle(rightWing02, 0.6109F, 0.0F, 0.0F);
        rightWing02.setTextureOffset(0, 47).addBox(-0.5F, 0.0F, -1.5F, 1, 2, 8,true);

        rightWing03 = new ModelRenderer(this);
        rightWing03.setRotationPoint(0.0F, 1.0F, 6.5F);
        rightWing02.addChild(rightWing03);
        setRotationAngle(rightWing03, -0.5672F, -0.3054F, 0.0F);
        rightWing03.setTextureOffset(39, 0).addBox(-0.5F, -1.1F, -0.5F, 1, 2, 8,true);

        rightWing04 = new ModelRenderer(this);
        rightWing04.setRotationPoint(0.0F, 0.0F, 7.5F);
        rightWing03.addChild(rightWing04);
        setRotationAngle(rightWing04, -0.7418F, 0.0F, 0.0F);
        rightWing04.setTextureOffset(0, 0).addBox(-0.4F, -0.8F, -4.0F, 1, 1, 19,true);

        rightWing04Leather = new ModelRenderer(this);
        rightWing04Leather.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightWing04.addChild(rightWing04Leather);
        rightWing04Leather.setTextureOffset(0, 28);
        rightWing04Leather.cubeList.add(new ModelBoxPatched(rightWing04Leather, 0, 28, 0.0F, 0.0F, 0.0F, 0.001F, 5, 14, 0, true));

        rightWingStrut01 = new ModelRenderer(this);
        rightWingStrut01.setRotationPoint(0.0F, 1.0F, 7.0F);
        rightWing03.addChild(rightWingStrut01);
        setRotationAngle(rightWingStrut01, -1.0036F, 0.0F, 0.0F);
        rightWingStrut01.setTextureOffset(21, 0).addBox(-0.4F, -0.5F, -0.5F, 1, 1, 16,true);

        rightWingStrut01Leather = new ModelRenderer(this);
        rightWingStrut01Leather.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightWingStrut01.addChild(rightWingStrut01Leather);
        rightWingStrut01Leather.setTextureOffset(0, 22);
        rightWingStrut01Leather.cubeList.add(new ModelBoxPatched(rightWingStrut01Leather, 0, 22, 0.05F, 0.0F, 0.0F, 0.001F, 5, 14, 0, true));

        rightWingStrut02 = new ModelRenderer(this);
        rightWingStrut02.setRotationPoint(0.0F, 1.0F, 6.0F);
        rightWing03.addChild(rightWingStrut02);
        setRotationAngle(rightWingStrut02, -1.309F, 0.0F, 0.0F);
        rightWingStrut02.setTextureOffset(21, 0).addBox(-0.4F, -0.5F, -0.5F, 1, 1, 16,true);

        rightWingStrut02Leather = new ModelRenderer(this);
        rightWingStrut02Leather.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightWingStrut02.addChild(rightWingStrut02Leather);
        rightWingStrut02Leather.setTextureOffset(0, 4);
        rightWingStrut02Leather.cubeList.add(new ModelBoxPatched(rightWingStrut02Leather, 0, 4, 0.1F, 0.0F, -1.0F, 0.001F, 6, 16, 0, true));

        rightWingStrut03 = new ModelRenderer(this);
        rightWingStrut03.setRotationPoint(0.0F, 1.0F, 5.0F);
        rightWing03.addChild(rightWingStrut03);
        setRotationAngle(rightWingStrut03, -1.6581F, 0.0F, 0.0F);
        rightWingStrut03.setTextureOffset(21, 0).addBox(-0.4F, -0.5F, -0.5F, 1, 1, 16,true);

        rightWingStrut03Leather = new ModelRenderer(this);
        rightWingStrut03Leather.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightWingStrut03.addChild(rightWingStrut03Leather);
        rightWingStrut03Leather.setTextureOffset(0, 12);
        rightWingStrut03Leather.cubeList.add(new ModelBoxPatched(rightWingStrut03Leather, 0, 12, 0.15F, 0.0F, 0.0F, 0.001F, 6, 15, 0, true));

        rightStrutLowest = new ModelRenderer(this);
        rightStrutLowest.setRotationPoint(-0.5F, 1.0F, 2.0F);
        rightWing02.addChild(rightStrutLowest);
        setRotationAngle(rightStrutLowest, -0.3491F, 0.0F, 0.0F);
        rightStrutLowest.setTextureOffset(12, 0).addBox(0.1F, 0.0F, -0.5F, 1, 12, 1,true);

        rightStrutLowestLeather01 = new ModelRenderer(this);
        rightStrutLowestLeather01.setRotationPoint(0.5F, 0.0F, 0.0F);
        rightStrutLowest.addChild(rightStrutLowestLeather01);
        rightStrutLowestLeather01.setTextureOffset(0, 0);
        rightStrutLowestLeather01.cubeList.add(new ModelBoxPatched(rightStrutLowestLeather01, 0, 0, 0.0F, -1.0F, 0.0F, 0.001F, 12, 6, 0, true));

        rightStrutLowestLeather02 = new ModelRenderer(this);
        rightStrutLowestLeather02.setRotationPoint(0.5F, 0.0F, 0.0F);
        rightStrutLowest.addChild(rightStrutLowestLeather02);
        setRotationAngle(rightStrutLowestLeather02, 0.0F, 0.2618F, 0.0F);
        rightStrutLowestLeather02.setTextureOffset(28, 28);
        rightStrutLowestLeather02.cubeList.add(new ModelBoxPatched(rightStrutLowestLeather02, 28, 28, 0.0F, -1.0F, -9.0F, 0.001F, 12, 9, 0, true));
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
