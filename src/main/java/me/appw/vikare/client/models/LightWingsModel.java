package me.appw.vikare.client.models;


import me.appw.vikare.client.VikareClient;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import javax.annotation.Nonnull;

public class LightWingsModel extends WingsModel {
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
        rWing01.setTextureOffset(26, 18);
        rWing01.cubeList.add(new ModelBoxPatched(rWing01, 26, 18, -1.0F, -4.0F, 0.0F, 2, 13, 0.001F, 0, true));

        rWing02 = new ModelRenderer(this);
        rWing02.setRotationPoint(-6.0F, -3.0F, 1.0F);
        rWingMain.addChild(rWing02);
        setRotationAngle(rWing02, 0.0F, 0.0F, 0.48F);
        rWing02.setTextureOffset(25, 12);
        rWing02.cubeList.add(new ModelBoxPatched(rWing02, 25, 12, -1.5F, -4.0F, 0.0F, 3, 19, 0.001F, 0,true));

        rWing03 = new ModelRenderer(this);
        rWing03.setRotationPoint(-9.5F, -5.0F, 1.0F);
        rWingMain.addChild(rWing03);
        setRotationAngle(rWing03, 0.0F, 0.0F, 0.6981F);
        rWing03.setTextureOffset(25, 8);
        rWing03.cubeList.add(new ModelBoxPatched(rWing03, 25, 8, -1.5F, -4.0F, 0.0F, 3, 23, 0.001F, 0, true));

        rWing04 = new ModelRenderer(this);
        rWing04.setRotationPoint(-12.0F, -7.75F, 1.0F);
        rWingMain.addChild(rWing04);
        setRotationAngle(rWing04, 0.0F, 0.0F, 0.9599F);
        rWing04.setTextureOffset(19, 16);
        rWing04.cubeList.add(new ModelBoxPatched(rWing04, 19, 16, -1.0F, -4.0F, 0.0F, 2, 15, 0.001F, 0, true));

        rWing05 = new ModelRenderer(this);
        rWing05.setRotationPoint(-12.25F, -11.75F, 1.0F);
        rWingMain.addChild(rWing05);
        setRotationAngle(rWing05, 0.0F, 0.0F, 1.0908F);
        rWing05.setTextureOffset(12, 21);
        rWing05.cubeList.add(new ModelBoxPatched(rWing05, 12, 21, -0.5F, -2.0F, 0.0F, 2, 10, 0.001F, 0, true));

        lWingMain = new ModelRenderer(this);
        lWingMain.setRotationPoint(-8.0F, 0.0F, 0.0F);
        setRotationAngle(lWingMain, 0.0F, 0.0F, 0.836332F);
        rightWing.addChild(lWingMain);

        lWing01 = new ModelRenderer(this);
        lWing01.setRotationPoint(3.0F, -1.0F, 1.0F);
        lWingMain.addChild(lWing01);
        setRotationAngle(lWing01, 0.0F, 0.0F, -0.3054F);
        lWing01.setTextureOffset(26, 18);
        lWing01.cubeList.add(new ModelBoxPatched(lWing01, 26, 18, -1.0F, -4.0F, 0.0F, 2, 13, 0.001F, 0, false));

        lWing02 = new ModelRenderer(this);
        lWing02.setRotationPoint(6.0F, -3.0F, 1.0F);
        lWingMain.addChild(lWing02);
        setRotationAngle(lWing02, 0.0F, 0.0F, -0.48F);
        lWing02.setTextureOffset(25, 12);
        lWing02.cubeList.add(new ModelBoxPatched(lWing02, 25, 12, -1.5F, -4.0F, 0.0F, 3, 19, 0.001F, 0, false));

        lWing03 = new ModelRenderer(this);
        lWing03.setRotationPoint(9.5F, -5.0F, 1.0F);
        lWingMain.addChild(lWing03);
        setRotationAngle(lWing03, 0.0F, 0.0F, -0.6981F);
        lWing03.setTextureOffset(25, 8);
        lWing03.cubeList.add(new ModelBoxPatched(lWing03, 25, 8, -1.5F, -4.0F, 0.0F, 3, 23, 0.001F, 0, false));

        lWing04 = new ModelRenderer(this);
        lWing04.setRotationPoint(12.0F, -7.75F, 1.0F);
        lWingMain.addChild(lWing04);
        setRotationAngle(lWing04, 0.0F, 0.0F, -0.9599F);
        lWing04.setTextureOffset(19, 16);
        lWing04.cubeList.add(new ModelBoxPatched(lWing04, 19, 16, -1.0F, -4.0F, 0.0F, 2, 15, 0.001F, 0, false));

        lWing05 = new ModelRenderer(this);
        lWing05.setRotationPoint(12.25F, -11.75F, 1.0F);
        lWingMain.addChild(lWing05);
        setRotationAngle(lWing05, 0.0F, 0.0F, -1.0908F);
        lWing05.setTextureOffset(12, 21);
        lWing05.cubeList.add(new ModelBoxPatched(lWing05, 12, 21, -1.5F, -2.0F, 0.0F, 2, 10, 0.001F, 0, false));
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
