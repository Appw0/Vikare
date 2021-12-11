package me.appw.vikare.client.models;



import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import javax.annotation.Nonnull;

public class FlandresWingsModel extends WingsModel {
    private final ModelRenderer leftWing01;
    private final ModelRenderer leftWing02;
    private final ModelRenderer leftWing03;
    private final ModelRenderer leftWing04;
    private final ModelRenderer leftWing05;
    private final ModelRenderer lGem7;
    private final ModelRenderer sideB_r1;
    private final ModelRenderer sideF_r1;
    private final ModelRenderer largeTop_r1;
    private final ModelRenderer point_r1;
    private final ModelRenderer top_r1;
    private final ModelRenderer lGem8;
    private final ModelRenderer sideB_r2;
    private final ModelRenderer sideF_r2;
    private final ModelRenderer largeTop_r2;
    private final ModelRenderer point_r2;
    private final ModelRenderer top_r2;
    private final ModelRenderer lGem5;
    private final ModelRenderer sideB_r3;
    private final ModelRenderer sideF_r3;
    private final ModelRenderer largeTop_r3;
    private final ModelRenderer point_r3;
    private final ModelRenderer top_r3;
    private final ModelRenderer lGem6;
    private final ModelRenderer sideB_r4;
    private final ModelRenderer sideF_r4;
    private final ModelRenderer largeTop_r4;
    private final ModelRenderer point_r4;
    private final ModelRenderer top_r4;
    private final ModelRenderer lGem4;
    private final ModelRenderer sideB_r5;
    private final ModelRenderer sideF_r5;
    private final ModelRenderer largeTop_r5;
    private final ModelRenderer point_r5;
    private final ModelRenderer top_r5;
    private final ModelRenderer lGem01;
    private final ModelRenderer sideB_r6;
    private final ModelRenderer sideF_r6;
    private final ModelRenderer largeTop_r6;
    private final ModelRenderer point_r6;
    private final ModelRenderer top_r6;
    private final ModelRenderer lGem2;
    private final ModelRenderer sideB_r7;
    private final ModelRenderer sideF_r7;
    private final ModelRenderer largeTop_r7;
    private final ModelRenderer point_r7;
    private final ModelRenderer top_r7;
    private final ModelRenderer lGem3;
    private final ModelRenderer sideB_r8;
    private final ModelRenderer sideF_r8;
    private final ModelRenderer largeTop_r8;
    private final ModelRenderer point_r8;
    private final ModelRenderer top_r8;
    private final ModelRenderer rightWing01;
    private final ModelRenderer rightWing02;
    private final ModelRenderer rightWing03;
    private final ModelRenderer rightWing04;
    private final ModelRenderer rightWing05;
    private final ModelRenderer rGem07;
    private final ModelRenderer sideB_r9;
    private final ModelRenderer sideF_r9;
    private final ModelRenderer largeTop_r9;
    private final ModelRenderer point_r9;
    private final ModelRenderer top_r9;
    private final ModelRenderer rGem08;
    private final ModelRenderer sideB_r10;
    private final ModelRenderer sideF_r10;
    private final ModelRenderer largeTop_r10;
    private final ModelRenderer point_r10;
    private final ModelRenderer top_r10;
    private final ModelRenderer rGem05;
    private final ModelRenderer sideB_r11;
    private final ModelRenderer sideF_r11;
    private final ModelRenderer largeTop_r11;
    private final ModelRenderer point_r11;
    private final ModelRenderer top_r11;
    private final ModelRenderer rGem06;
    private final ModelRenderer sideB_r12;
    private final ModelRenderer sideF_r12;
    private final ModelRenderer largeTop_r12;
    private final ModelRenderer point_r12;
    private final ModelRenderer top_r12;
    private final ModelRenderer rGem04;
    private final ModelRenderer sideB_r13;
    private final ModelRenderer sideF_r13;
    private final ModelRenderer largeTop_r13;
    private final ModelRenderer point_r13;
    private final ModelRenderer top_r13;
    private final ModelRenderer rGem01;
    private final ModelRenderer sideB_r14;
    private final ModelRenderer sideF_r14;
    private final ModelRenderer largeTop_r14;
    private final ModelRenderer point_r14;
    private final ModelRenderer top_r14;
    private final ModelRenderer rGem02;
    private final ModelRenderer sideB_r15;
    private final ModelRenderer sideF_r15;
    private final ModelRenderer largeTop_r15;
    private final ModelRenderer point_r15;
    private final ModelRenderer top_r15;
    private final ModelRenderer rGem03;
    private final ModelRenderer sideB_r16;
    private final ModelRenderer sideF_r16;
    private final ModelRenderer largeTop_r16;
    private final ModelRenderer point_r16;
    private final ModelRenderer top_r16;

    public FlandresWingsModel()
    {
        textureWidth = 64;
        textureHeight = 64;

        leftWing01 = new ModelRenderer(this);
        leftWing01.setRotationPoint(-6.0F, 0.0F, 0.0F);
        setRotationAngle(leftWing01, 0.0F, 1.5708F, 0.436332F);
        leftWing01.setTextureOffset(11, 0).addBox(-1.0F, -1.0F, -1.0F, 2, 3, 6,false);
        rightWing.addChild(leftWing01);

        leftWing02 = new ModelRenderer(this);
        leftWing02.setRotationPoint(0.0F, 0.5F, 5.0F);
        leftWing01.addChild(leftWing02);
        setRotationAngle(leftWing02, 0.2618F, 0.3054F, 0.0F);
        leftWing02.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -1.0F, 1, 2, 9,false);

        leftWing03 = new ModelRenderer(this);
        leftWing03.setRotationPoint(-0.5F, 0.5F, 8.0F);
        leftWing02.addChild(leftWing03);
        setRotationAngle(leftWing03, 0.7854F, 0.0F, 0.0F);
        leftWing03.setTextureOffset(0, 0).addBox(-0.6F, -1.8F, 0.0F, 1, 2, 9,false);

        leftWing04 = new ModelRenderer(this);
        leftWing04.setRotationPoint(0.0F, -1.0F, 9.0F);
        leftWing03.addChild(leftWing04);
        setRotationAngle(leftWing04, 0.6981F, 0.0F, 0.0F);
        leftWing04.setTextureOffset(0, 21).addBox(-0.7F, 0.0F, -0.6F, 1, 11, 1,false);

        leftWing05 = new ModelRenderer(this);
        leftWing05.setRotationPoint(0.0F, 10.8F, 0.0F);
        leftWing04.addChild(leftWing05);
        setRotationAngle(leftWing05, -0.3054F, 0.0F, 0.0F);
        leftWing05.setTextureOffset(0, 21).addBox(-0.8F, -0.3F, -0.7F, 1, 11, 1,false);

        lGem7 = new ModelRenderer(this);
        lGem7.setRotationPoint(0.0308F, 2.2372F, 0.0333F);
        leftWing05.addChild(lGem7);
        setRotationAngle(lGem7, -0.9599F, 0.0F, 0.0F);


        sideB_r1 = new ModelRenderer(this);
        sideB_r1.setRotationPoint(-0.5F, 6.0F, 2.0F);
        lGem7.addChild(sideB_r1);
        setRotationAngle(sideB_r1, -1.7453F, 0.0F, 0.0F);
        sideB_r1.setTextureOffset(36, 30).addBox(-0.89F, -0.7F, -0.5F, 2, 2, 5,false);

        sideF_r1 = new ModelRenderer(this);
        sideF_r1.setRotationPoint(-0.5F, 6.0F, -1.0F);
        lGem7.addChild(sideF_r1);
        setRotationAngle(sideF_r1, -1.3963F, 0.0F, 0.0F);
        sideF_r1.setTextureOffset(36, 30).addBox(-0.88F, -1.6F, -0.5F, 2, 2, 5,false);

        largeTop_r1 = new ModelRenderer(this);
        largeTop_r1.setRotationPoint(-0.5F, 4.0F, 0.5F);
        lGem7.addChild(largeTop_r1);
        setRotationAngle(largeTop_r1, -0.7854F, 0.0F, 0.0F);
        largeTop_r1.setTextureOffset(40, 37).addBox(-0.9F, -0.5F, -0.3F, 2, 3, 3,false);

        point_r1 = new ModelRenderer(this);
        point_r1.setRotationPoint(-0.5F, 10.0F, 0.5F);
        lGem7.addChild(point_r1);
        setRotationAngle(point_r1, -0.7854F, 0.0F, 0.0F);
//        point_r1.setTextureOffset(40, 43).addBox(-1.0F, -0.7F, -0.5F, 2.0F, 2.0F, 2.0F, -0.1F, false);

        top_r1 = new ModelRenderer(this);
        top_r1.setRotationPoint(-0.5F, 2.0F, 1.0F);
        lGem7.addChild(top_r1);
        setRotationAngle(top_r1, -0.7854F, 0.0F, 0.0F);
        top_r1.setTextureOffset(40, 43).addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2,false);

        lGem8 = new ModelRenderer(this);
        lGem8.setRotationPoint(0.4383F, 8.6075F, 0.5953F);
        leftWing05.addChild(lGem8);
        setRotationAngle(lGem8, -0.9599F, 0.0F, 0.0F);


        sideB_r2 = new ModelRenderer(this);
        sideB_r2.setRotationPoint(-0.5F, 6.0F, 2.0F);
        lGem8.addChild(sideB_r2);
        setRotationAngle(sideB_r2, -1.7453F, 0.0F, 0.0F);
        sideB_r2.setTextureOffset(0, 11).addBox(-0.89F, -0.7F, -0.5F, 2, 2, 5,false);

        sideF_r2 = new ModelRenderer(this);
        sideF_r2.setRotationPoint(-0.5F, 6.0F, -1.0F);
        lGem8.addChild(sideF_r2);
        setRotationAngle(sideF_r2, -1.3963F, 0.0F, 0.0F);
        sideF_r2.setTextureOffset(0, 11).addBox(-0.88F, -1.6F, -0.5F, 2, 2, 5,false);

        largeTop_r2 = new ModelRenderer(this);
        largeTop_r2.setRotationPoint(-0.5F, 4.0F, 0.5F);
        lGem8.addChild(largeTop_r2);
        setRotationAngle(largeTop_r2, -0.7854F, 0.0F, 0.0F);
        largeTop_r2.setTextureOffset(4, 18).addBox(-0.9F, -0.5F, -0.3F, 2, 3, 3,false);

        point_r2 = new ModelRenderer(this);
        point_r2.setRotationPoint(-0.5F, 10.0F, 0.5F);
        lGem8.addChild(point_r2);
        setRotationAngle(point_r2, -0.7854F, 0.0F, 0.0F);
//        point_r2.setTextureOffset(4, 24).addBox(-1.0F, -0.7F, -0.5F, 2.0F, 2.0F, 2.0F, -0.1F, false);

        top_r2 = new ModelRenderer(this);
        top_r2.setRotationPoint(-0.5F, 2.0F, 1.0F);
        lGem8.addChild(top_r2);
        setRotationAngle(top_r2, -0.7854F, 0.0F, 0.0F);
        top_r2.setTextureOffset(4, 24).addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2,false);

        lGem5 = new ModelRenderer(this);
        lGem5.setRotationPoint(-0.142F, 0.7935F, 0.1272F);
        leftWing04.addChild(lGem5);
        setRotationAngle(lGem5, -1.0472F, 0.0F, 0.0F);


        sideB_r3 = new ModelRenderer(this);
        sideB_r3.setRotationPoint(-0.5F, 6.0F, 2.0F);
        lGem5.addChild(sideB_r3);
        setRotationAngle(sideB_r3, -1.7453F, 0.0F, 0.0F);
        sideB_r3.setTextureOffset(4, 30).addBox(-0.89F, -0.7F, -0.5F, 2, 2, 5,false);

        sideF_r3 = new ModelRenderer(this);
        sideF_r3.setRotationPoint(-0.5F, 6.0F, -1.0F);
        lGem5.addChild(sideF_r3);
        setRotationAngle(sideF_r3, -1.3963F, 0.0F, 0.0F);
        sideF_r3.setTextureOffset(4, 30).addBox(-0.88F, -1.6F, -0.5F, 2, 2, 5,false);

        largeTop_r3 = new ModelRenderer(this);
        largeTop_r3.setRotationPoint(-0.5F, 4.0F, 0.5F);
        lGem5.addChild(largeTop_r3);
        setRotationAngle(largeTop_r3, -0.7854F, 0.0F, 0.0F);
        largeTop_r3.setTextureOffset(8, 37).addBox(-0.9F, -0.5F, -0.3F, 2, 3, 3,false);

        point_r3 = new ModelRenderer(this);
        point_r3.setRotationPoint(-0.5F, 10.0F, 0.5F);
        lGem5.addChild(point_r3);
        setRotationAngle(point_r3, -0.7854F, 0.0F, 0.0F);
//        point_r3.setTextureOffset(8, 43).addBox(-1.0F, -0.7F, -0.5F, 2.0F, 2.0F, 2.0F, -0.1F, false);

        top_r3 = new ModelRenderer(this);
        top_r3.setRotationPoint(-0.5F, 2.0F, 1.0F);
        lGem5.addChild(top_r3);
        setRotationAngle(top_r3, -0.7854F, 0.0F, 0.0F);
        top_r3.setTextureOffset(8, 43).addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2,false);

        lGem6 = new ModelRenderer(this);
        lGem6.setRotationPoint(0.3039F, 5.7996F, 0.357F);
        leftWing04.addChild(lGem6);
        setRotationAngle(lGem6, -1.0472F, 0.0F, 0.0F);


        sideB_r4 = new ModelRenderer(this);
        sideB_r4.setRotationPoint(-0.5F, 6.0F, 2.0F);
        lGem6.addChild(sideB_r4);
        setRotationAngle(sideB_r4, -1.7453F, 0.0F, 0.0F);
        sideB_r4.setTextureOffset(20, 30).addBox(-0.89F, -0.7F, -0.5F, 2, 2, 5,false);

        sideF_r4 = new ModelRenderer(this);
        sideF_r4.setRotationPoint(-0.5F, 6.0F, -1.0F);
        lGem6.addChild(sideF_r4);
        setRotationAngle(sideF_r4, -1.3963F, 0.0F, 0.0F);
        sideF_r4.setTextureOffset(20, 30).addBox(-0.88F, -1.6F, -0.5F, 2, 2, 5,false);

        largeTop_r4 = new ModelRenderer(this);
        largeTop_r4.setRotationPoint(-0.5F, 4.0F, 0.5F);
        lGem6.addChild(largeTop_r4);
        setRotationAngle(largeTop_r4, -0.7854F, 0.0F, 0.0F);
        largeTop_r4.setTextureOffset(24, 37).addBox(-0.9F, -0.5F, -0.3F, 2, 3, 3,false);

        point_r4 = new ModelRenderer(this);
        point_r4.setRotationPoint(-0.5F, 10.0F, 0.5F);
        lGem6.addChild(point_r4);
        setRotationAngle(point_r4, -0.7854F, 0.0F, 0.0F);
//        point_r4.setTextureOffset(24, 43).addBox(-1.0F, -0.7F, -0.5F, 2.0F, 2.0F, 2.0F, -0.1F, false);

        top_r4 = new ModelRenderer(this);
        top_r4.setRotationPoint(-0.5F, 2.0F, 1.0F);
        lGem6.addChild(top_r4);
        setRotationAngle(top_r4, -0.7854F, 0.0F, 0.0F);
        top_r4.setTextureOffset(24, 43).addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2,false);

        lGem4 = new ModelRenderer(this);
        lGem4.setRotationPoint(-0.4345F, -0.814F, 3.3462F);
        leftWing03.addChild(lGem4);
        setRotationAngle(lGem4, -0.1309F, 0.0F, 0.0F);


        sideB_r5 = new ModelRenderer(this);
        sideB_r5.setRotationPoint(-0.5F, 6.0F, 2.0F);
        lGem4.addChild(sideB_r5);
        setRotationAngle(sideB_r5, -1.7453F, 0.0F, 0.0F);
        sideB_r5.setTextureOffset(45, 11).addBox(-0.89F, -0.7F, -0.5F, 2, 2, 5,false);

        sideF_r5 = new ModelRenderer(this);
        sideF_r5.setRotationPoint(-0.5F, 6.0F, -1.0F);
        lGem4.addChild(sideF_r5);
        setRotationAngle(sideF_r5, -1.3963F, 0.0F, 0.0F);
        sideF_r5.setTextureOffset(45, 11).addBox(-0.88F, -1.6F, -0.5F, 2, 2, 5,false);

        largeTop_r5 = new ModelRenderer(this);
        largeTop_r5.setRotationPoint(-0.5F, 4.0F, 0.5F);
        lGem4.addChild(largeTop_r5);
        setRotationAngle(largeTop_r5, -0.7854F, 0.0F, 0.0F);
        largeTop_r5.setTextureOffset(49, 18).addBox(-0.9F, -0.5F, -0.3F, 2, 3, 3,false);

        point_r5 = new ModelRenderer(this);
        point_r5.setRotationPoint(-0.5F, 10.0F, 0.5F);
        lGem4.addChild(point_r5);
        setRotationAngle(point_r5, -0.7854F, 0.0F, 0.0F);
//        point_r5.setTextureOffset(49, 24).addBox(-1.0F, -0.7F, -0.5F, 2.0F, 2.0F, 2.0F, -0.1F, false);

        top_r5 = new ModelRenderer(this);
        top_r5.setRotationPoint(-0.5F, 2.0F, 1.0F);
        lGem4.addChild(top_r5);
        setRotationAngle(top_r5, -0.7854F, 0.0F, 0.0F);
        top_r5.setTextureOffset(49, 24).addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2,false);

        lGem01 = new ModelRenderer(this);
        lGem01.setRotationPoint(0.6635F, 0.2041F, -1.1535F);
        leftWing02.addChild(lGem01);


        sideB_r6 = new ModelRenderer(this);
        sideB_r6.setRotationPoint(-0.5F, 6.0F, 2.0F);
        lGem01.addChild(sideB_r6);
        setRotationAngle(sideB_r6, -1.7453F, 0.0F, 0.0F);
        sideB_r6.setTextureOffset(0, 11).addBox(-0.89F, -0.7F, -0.5F, 2, 2, 5,false);

        sideF_r6 = new ModelRenderer(this);
        sideF_r6.setRotationPoint(-0.5F, 6.0F, -1.0F);
        lGem01.addChild(sideF_r6);
        setRotationAngle(sideF_r6, -1.3963F, 0.0F, 0.0F);
        sideF_r6.setTextureOffset(0, 11).addBox(-0.88F, -1.6F, -0.5F, 2, 2, 5,false);

        largeTop_r6 = new ModelRenderer(this);
        largeTop_r6.setRotationPoint(-0.5F, 4.0F, 0.5F);
        lGem01.addChild(largeTop_r6);
        setRotationAngle(largeTop_r6, -0.7854F, 0.0F, 0.0F);
        largeTop_r6.setTextureOffset(4, 18).addBox(-0.9F, -0.5F, -0.3F, 2, 3, 3,false);

        point_r6 = new ModelRenderer(this);
        point_r6.setRotationPoint(-0.5F, 10.0F, 0.5F);
        lGem01.addChild(point_r6);
        setRotationAngle(point_r6, -0.7854F, 0.0F, 0.0F);
//        point_r6.setTextureOffset(4, 24).addBox(-1.0F, -0.7F, -0.5F, 2.0F, 2.0F, 2.0F, -0.1F, false);

        top_r6 = new ModelRenderer(this);
        top_r6.setRotationPoint(-0.5F, 2.0F, 1.0F);
        lGem01.addChild(top_r6);
        setRotationAngle(top_r6, -0.7854F, 0.0F, 0.0F);
        top_r6.setTextureOffset(4, 24).addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2,false);

        lGem2 = new ModelRenderer(this);
        lGem2.setRotationPoint(0.267F, -0.1566F, 4.027F);
        leftWing02.addChild(lGem2);
        setRotationAngle(lGem2, 0.0873F, 0.0F, 0.0F);


        sideB_r7 = new ModelRenderer(this);
        sideB_r7.setRotationPoint(-0.5F, 6.0F, 2.0F);
        lGem2.addChild(sideB_r7);
        setRotationAngle(sideB_r7, -1.7453F, 0.0F, 0.0F);
        sideB_r7.setTextureOffset(15, 11).addBox(-0.89F, -0.7F, -0.5F, 2, 2, 5,false);

        sideF_r7 = new ModelRenderer(this);
        sideF_r7.setRotationPoint(-0.5F, 6.0F, -1.0F);
        lGem2.addChild(sideF_r7);
        setRotationAngle(sideF_r7, -1.3963F, 0.0F, 0.0F);
        sideF_r7.setTextureOffset(15, 11).addBox(-0.88F, -1.6F, -0.5F, 2, 2, 5,false);

        largeTop_r7 = new ModelRenderer(this);
        largeTop_r7.setRotationPoint(-0.5F, 4.0F, 0.5F);
        lGem2.addChild(largeTop_r7);
        setRotationAngle(largeTop_r7, -0.7854F, 0.0F, 0.0F);
        largeTop_r7.setTextureOffset(19, 18).addBox(-0.9F, -0.5F, -0.3F, 2, 3, 3,false);

        point_r7 = new ModelRenderer(this);
        point_r7.setRotationPoint(-0.5F, 10.0F, 0.5F);
        lGem2.addChild(point_r7);
        setRotationAngle(point_r7, -0.7854F, 0.0F, 0.0F);
//        point_r7.setTextureOffset(19, 24).addBox(-1.0F, -0.7F, -0.5F, 2.0F, 2.0F, 2.0F, -0.1F, false);

        top_r7 = new ModelRenderer(this);
        top_r7.setRotationPoint(-0.5F, 2.0F, 1.0F);
        lGem2.addChild(top_r7);
        setRotationAngle(top_r7, -0.7854F, 0.0F, 0.0F);
        top_r7.setTextureOffset(19, 24).addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2,false);

        lGem3 = new ModelRenderer(this);
        lGem3.setRotationPoint(0.1582F, -0.1549F, 7.1073F);
        leftWing02.addChild(lGem3);
        setRotationAngle(lGem3, 0.48F, 0.0F, 0.0F);


        sideB_r8 = new ModelRenderer(this);
        sideB_r8.setRotationPoint(-0.5F, 6.0F, 2.0F);
        lGem3.addChild(sideB_r8);
        setRotationAngle(sideB_r8, -1.7453F, 0.0F, 0.0F);
        sideB_r8.setTextureOffset(30, 11).addBox(-0.89F, -0.7F, -0.5F, 2, 2, 5,false);

        sideF_r8 = new ModelRenderer(this);
        sideF_r8.setRotationPoint(-0.5F, 6.0F, -1.0F);
        lGem3.addChild(sideF_r8);
        setRotationAngle(sideF_r8, -1.3963F, 0.0F, 0.0F);
        sideF_r8.setTextureOffset(30, 11).addBox(-0.88F, -1.6F, -0.5F, 2, 2, 5,false);

        largeTop_r8 = new ModelRenderer(this);
        largeTop_r8.setRotationPoint(-0.5F, 4.0F, 0.5F);
        lGem3.addChild(largeTop_r8);
        setRotationAngle(largeTop_r8, -0.7854F, 0.0F, 0.0F);
        largeTop_r8.setTextureOffset(34, 18).addBox(-0.9F, -0.5F, -0.3F, 2, 3, 3,false);

        point_r8 = new ModelRenderer(this);
        point_r8.setRotationPoint(-0.5F, 10.0F, 0.5F);
        lGem3.addChild(point_r8);
        setRotationAngle(point_r8, -0.7854F, 0.0F, 0.0F);
//        point_r8.setTextureOffset(34, 24).addBox(-1.0F, -0.7F, -0.5F, 2.0F, 2.0F, 2.0F, -0.1F, false);

        top_r8 = new ModelRenderer(this);
        top_r8.setRotationPoint(-0.5F, 2.0F, 1.0F);
        lGem3.addChild(top_r8);
        setRotationAngle(top_r8, -0.7854F, 0.0F, 0.0F);
        top_r8.setTextureOffset(34, 24).addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2,false);

        rightWing01 = new ModelRenderer(this);
        rightWing01.setRotationPoint(6.0F, 0.0F, 0.0F);
        setRotationAngle(rightWing01, 0.0F, -1.5708F, -0.436332F);
        rightWing01.setTextureOffset(11, 0).addBox(-1.0F, -1.0F, -1.0F, 2, 3, 6,true);
        leftWing.addChild(rightWing01);

        rightWing02 = new ModelRenderer(this);
        rightWing02.setRotationPoint(0.0F, 0.5F, 5.0F);
        rightWing01.addChild(rightWing02);
        setRotationAngle(rightWing02, 0.2618F, -0.3054F, 0.0F);
        rightWing02.setTextureOffset(0, 0).addBox(0.0F, -1.0F, -1.0F, 1, 2, 9,true);

        rightWing03 = new ModelRenderer(this);
        rightWing03.setRotationPoint(0.5F, 0.5F, 8.0F);
        rightWing02.addChild(rightWing03);
        setRotationAngle(rightWing03, 0.7854F, 0.0F, 0.0F);
        rightWing03.setTextureOffset(0, 0).addBox(-0.4F, -1.8F, 0.0F, 1, 2, 9,true);

        rightWing04 = new ModelRenderer(this);
        rightWing04.setRotationPoint(0.0F, -1.0F, 9.0F);
        rightWing03.addChild(rightWing04);
        setRotationAngle(rightWing04, 0.6981F, 0.0F, 0.0F);
        rightWing04.setTextureOffset(0, 21).addBox(-0.3F, 0.0F, -0.6F, 1, 11, 1,true);

        rightWing05 = new ModelRenderer(this);
        rightWing05.setRotationPoint(0.0F, 10.8F, 0.0F);
        rightWing04.addChild(rightWing05);
        setRotationAngle(rightWing05, -0.3054F, 0.0F, 0.0F);
        rightWing05.setTextureOffset(0, 21).addBox(-0.2F, -0.3F, -0.7F, 1, 11, 1,true);

        rGem07 = new ModelRenderer(this);
        rGem07.setRotationPoint(-0.0308F, 2.2372F, 0.0333F);
        rightWing05.addChild(rGem07);
        setRotationAngle(rGem07, -0.9599F, 0.0F, 0.0F);


        sideB_r9 = new ModelRenderer(this);
        sideB_r9.setRotationPoint(0.5F, 6.0F, 2.0F);
        rGem07.addChild(sideB_r9);
        setRotationAngle(sideB_r9, -1.7453F, 0.0F, 0.0F);
        sideB_r9.setTextureOffset(36, 30).addBox(-1.11F, -0.7F, -0.5F, 2, 2, 5,true);

        sideF_r9 = new ModelRenderer(this);
        sideF_r9.setRotationPoint(0.5F, 6.0F, -1.0F);
        rGem07.addChild(sideF_r9);
        setRotationAngle(sideF_r9, -1.3963F, 0.0F, 0.0F);
        sideF_r9.setTextureOffset(36, 30).addBox(-1.12F, -1.6F, -0.5F, 2, 2, 5,true);

        largeTop_r9 = new ModelRenderer(this);
        largeTop_r9.setRotationPoint(0.5F, 4.0F, 0.5F);
        rGem07.addChild(largeTop_r9);
        setRotationAngle(largeTop_r9, -0.7854F, 0.0F, 0.0F);
        largeTop_r9.setTextureOffset(40, 37).addBox(-1.1F, -0.5F, -0.3F, 2, 3, 3,true);

        point_r9 = new ModelRenderer(this);
        point_r9.setRotationPoint(0.5F, 10.0F, 0.5F);
        rGem07.addChild(point_r9);
        setRotationAngle(point_r9, -0.7854F, 0.0F, 0.0F);
//        point_r9.setTextureOffset(40, 43).addBox(-1.0F, -0.7F, -0.5F, 2.0F, 2.0F, 2.0F, -0.1F, true);

        top_r9 = new ModelRenderer(this);
        top_r9.setRotationPoint(0.5F, 2.0F, 1.0F);
        rGem07.addChild(top_r9);
        setRotationAngle(top_r9, -0.7854F, 0.0F, 0.0F);
        top_r9.setTextureOffset(40, 43).addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2,true);

        rGem08 = new ModelRenderer(this);
        rGem08.setRotationPoint(-0.4383F, 8.6075F, 0.5953F);
        rightWing05.addChild(rGem08);
        setRotationAngle(rGem08, -0.9599F, 0.0F, 0.0F);


        sideB_r10 = new ModelRenderer(this);
        sideB_r10.setRotationPoint(0.5F, 6.0F, 2.0F);
        rGem08.addChild(sideB_r10);
        setRotationAngle(sideB_r10, -1.7453F, 0.0F, 0.0F);
        sideB_r10.setTextureOffset(0, 11).addBox(-1.11F, -0.7F, -0.5F, 2, 2, 5,true);

        sideF_r10 = new ModelRenderer(this);
        sideF_r10.setRotationPoint(0.5F, 6.0F, -1.0F);
        rGem08.addChild(sideF_r10);
        setRotationAngle(sideF_r10, -1.3963F, 0.0F, 0.0F);
        sideF_r10.setTextureOffset(0, 11).addBox(-1.12F, -1.6F, -0.5F, 2, 2, 5,true);

        largeTop_r10 = new ModelRenderer(this);
        largeTop_r10.setRotationPoint(0.5F, 4.0F, 0.5F);
        rGem08.addChild(largeTop_r10);
        setRotationAngle(largeTop_r10, -0.7854F, 0.0F, 0.0F);
        largeTop_r10.setTextureOffset(4, 18).addBox(-1.1F, -0.5F, -0.3F, 2, 3, 3,true);

        point_r10 = new ModelRenderer(this);
        point_r10.setRotationPoint(0.5F, 10.0F, 0.5F);
        rGem08.addChild(point_r10);
        setRotationAngle(point_r10, -0.7854F, 0.0F, 0.0F);
//        point_r10.setTextureOffset(4, 24).addBox(-1.0F, -0.7F, -0.5F, 2.0F, 2.0F, 2.0F, -0.1F, true);

        top_r10 = new ModelRenderer(this);
        top_r10.setRotationPoint(0.5F, 2.0F, 1.0F);
        rGem08.addChild(top_r10);
        setRotationAngle(top_r10, -0.7854F, 0.0F, 0.0F);
        top_r10.setTextureOffset(4, 24).addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2,true);

        rGem05 = new ModelRenderer(this);
        rGem05.setRotationPoint(0.142F, 0.7935F, 0.1272F);
        rightWing04.addChild(rGem05);
        setRotationAngle(rGem05, -1.0472F, 0.0F, 0.0F);


        sideB_r11 = new ModelRenderer(this);
        sideB_r11.setRotationPoint(0.5F, 6.0F, 2.0F);
        rGem05.addChild(sideB_r11);
        setRotationAngle(sideB_r11, -1.7453F, 0.0F, 0.0F);
        sideB_r11.setTextureOffset(4, 30).addBox(-1.11F, -0.7F, -0.5F, 2, 2, 5,true);

        sideF_r11 = new ModelRenderer(this);
        sideF_r11.setRotationPoint(0.5F, 6.0F, -1.0F);
        rGem05.addChild(sideF_r11);
        setRotationAngle(sideF_r11, -1.3963F, 0.0F, 0.0F);
        sideF_r11.setTextureOffset(4, 30).addBox(-1.12F, -1.6F, -0.5F, 2, 2, 5,true);

        largeTop_r11 = new ModelRenderer(this);
        largeTop_r11.setRotationPoint(0.5F, 4.0F, 0.5F);
        rGem05.addChild(largeTop_r11);
        setRotationAngle(largeTop_r11, -0.7854F, 0.0F, 0.0F);
        largeTop_r11.setTextureOffset(8, 37).addBox(-1.1F, -0.5F, -0.3F, 2, 3, 3,true);

        point_r11 = new ModelRenderer(this);
        point_r11.setRotationPoint(0.5F, 10.0F, 0.5F);
        rGem05.addChild(point_r11);
        setRotationAngle(point_r11, -0.7854F, 0.0F, 0.0F);
//        point_r11.setTextureOffset(8, 43).addBox(-1.0F, -0.7F, -0.5F, 2.0F, 2.0F, 2.0F, -0.1F, true);

        top_r11 = new ModelRenderer(this);
        top_r11.setRotationPoint(0.5F, 2.0F, 1.0F);
        rGem05.addChild(top_r11);
        setRotationAngle(top_r11, -0.7854F, 0.0F, 0.0F);
        top_r11.setTextureOffset(8, 43).addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2,true);

        rGem06 = new ModelRenderer(this);
        rGem06.setRotationPoint(-0.3039F, 5.7996F, 0.357F);
        rightWing04.addChild(rGem06);
        setRotationAngle(rGem06, -1.0472F, 0.0F, 0.0F);


        sideB_r12 = new ModelRenderer(this);
        sideB_r12.setRotationPoint(0.5F, 6.0F, 2.0F);
        rGem06.addChild(sideB_r12);
        setRotationAngle(sideB_r12, -1.7453F, 0.0F, 0.0F);
        sideB_r12.setTextureOffset(20, 30).addBox(-1.11F, -0.7F, -0.5F, 2, 2, 5,true);

        sideF_r12 = new ModelRenderer(this);
        sideF_r12.setRotationPoint(0.5F, 6.0F, -1.0F);
        rGem06.addChild(sideF_r12);
        setRotationAngle(sideF_r12, -1.3963F, 0.0F, 0.0F);
        sideF_r12.setTextureOffset(20, 30).addBox(-1.12F, -1.6F, -0.5F, 2, 2, 5,true);

        largeTop_r12 = new ModelRenderer(this);
        largeTop_r12.setRotationPoint(0.5F, 4.0F, 0.5F);
        rGem06.addChild(largeTop_r12);
        setRotationAngle(largeTop_r12, -0.7854F, 0.0F, 0.0F);
        largeTop_r12.setTextureOffset(24, 37).addBox(-1.1F, -0.5F, -0.3F, 2, 3, 3,true);

        point_r12 = new ModelRenderer(this);
        point_r12.setRotationPoint(0.5F, 10.0F, 0.5F);
        rGem06.addChild(point_r12);
        setRotationAngle(point_r12, -0.7854F, 0.0F, 0.0F);
//        point_r12.setTextureOffset(24, 43).addBox(-1.0F, -0.7F, -0.5F, 2.0F, 2.0F, 2.0F, -0.1F, true);

        top_r12 = new ModelRenderer(this);
        top_r12.setRotationPoint(0.5F, 2.0F, 1.0F);
        rGem06.addChild(top_r12);
        setRotationAngle(top_r12, -0.7854F, 0.0F, 0.0F);
        top_r12.setTextureOffset(24, 43).addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2,true);

        rGem04 = new ModelRenderer(this);
        rGem04.setRotationPoint(0.4345F, -0.814F, 3.3462F);
        rightWing03.addChild(rGem04);
        setRotationAngle(rGem04, -0.1309F, 0.0F, 0.0F);


        sideB_r13 = new ModelRenderer(this);
        sideB_r13.setRotationPoint(0.5F, 6.0F, 2.0F);
        rGem04.addChild(sideB_r13);
        setRotationAngle(sideB_r13, -1.7453F, 0.0F, 0.0F);
        sideB_r13.setTextureOffset(45, 11).addBox(-1.11F, -0.7F, -0.5F, 2, 2, 5,true);

        sideF_r13 = new ModelRenderer(this);
        sideF_r13.setRotationPoint(0.5F, 6.0F, -1.0F);
        rGem04.addChild(sideF_r13);
        setRotationAngle(sideF_r13, -1.3963F, 0.0F, 0.0F);
        sideF_r13.setTextureOffset(45, 11).addBox(-1.12F, -1.6F, -0.5F, 2, 2, 5,true);

        largeTop_r13 = new ModelRenderer(this);
        largeTop_r13.setRotationPoint(0.5F, 4.0F, 0.5F);
        rGem04.addChild(largeTop_r13);
        setRotationAngle(largeTop_r13, -0.7854F, 0.0F, 0.0F);
        largeTop_r13.setTextureOffset(49, 18).addBox(-1.1F, -0.5F, -0.3F, 2, 3, 3,true);

        point_r13 = new ModelRenderer(this);
        point_r13.setRotationPoint(0.5F, 10.0F, 0.5F);
        rGem04.addChild(point_r13);
        setRotationAngle(point_r13, -0.7854F, 0.0F, 0.0F);
//        point_r13.setTextureOffset(49, 24).addBox(-1.0F, -0.7F, -0.5F, 2.0F, 2.0F, 2.0F, -0.1F, true);

        top_r13 = new ModelRenderer(this);
        top_r13.setRotationPoint(0.5F, 2.0F, 1.0F);
        rGem04.addChild(top_r13);
        setRotationAngle(top_r13, -0.7854F, 0.0F, 0.0F);
        top_r13.setTextureOffset(49, 24).addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2,true);

        rGem01 = new ModelRenderer(this);
        rGem01.setRotationPoint(-0.6635F, 0.2041F, -1.1535F);
        rightWing02.addChild(rGem01);


        sideB_r14 = new ModelRenderer(this);
        sideB_r14.setRotationPoint(0.5F, 6.0F, 2.0F);
        rGem01.addChild(sideB_r14);
        setRotationAngle(sideB_r14, -1.7453F, 0.0F, 0.0F);
        sideB_r14.setTextureOffset(0, 11).addBox(-1.11F, -0.7F, -0.5F, 2, 2, 5,true);

        sideF_r14 = new ModelRenderer(this);
        sideF_r14.setRotationPoint(0.5F, 6.0F, -1.0F);
        rGem01.addChild(sideF_r14);
        setRotationAngle(sideF_r14, -1.3963F, 0.0F, 0.0F);
        sideF_r14.setTextureOffset(0, 11).addBox(-1.12F, -1.6F, -0.5F, 2, 2, 5,true);

        largeTop_r14 = new ModelRenderer(this);
        largeTop_r14.setRotationPoint(0.5F, 4.0F, 0.5F);
        rGem01.addChild(largeTop_r14);
        setRotationAngle(largeTop_r14, -0.7854F, 0.0F, 0.0F);
        largeTop_r14.setTextureOffset(4, 18).addBox(-1.1F, -0.5F, -0.3F, 2, 3, 3,true);

        point_r14 = new ModelRenderer(this);
        point_r14.setRotationPoint(0.5F, 10.0F, 0.5F);
        rGem01.addChild(point_r14);
        setRotationAngle(point_r14, -0.7854F, 0.0F, 0.0F);
//        point_r14.setTextureOffset(4, 24).addBox(-1.0F, -0.7F, -0.5F, 2.0F, 2.0F, 2.0F, -0.1F, true);

        top_r14 = new ModelRenderer(this);
        top_r14.setRotationPoint(0.5F, 2.0F, 1.0F);
        rGem01.addChild(top_r14);
        setRotationAngle(top_r14, -0.7854F, 0.0F, 0.0F);
        top_r14.setTextureOffset(4, 24).addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2,true);

        rGem02 = new ModelRenderer(this);
        rGem02.setRotationPoint(-0.267F, -0.1566F, 4.027F);
        rightWing02.addChild(rGem02);
        setRotationAngle(rGem02, 0.0873F, 0.0F, 0.0F);


        sideB_r15 = new ModelRenderer(this);
        sideB_r15.setRotationPoint(0.5F, 6.0F, 2.0F);
        rGem02.addChild(sideB_r15);
        setRotationAngle(sideB_r15, -1.7453F, 0.0F, 0.0F);
        sideB_r15.setTextureOffset(15, 11).addBox(-1.11F, -0.7F, -0.5F, 2, 2, 5,true);

        sideF_r15 = new ModelRenderer(this);
        sideF_r15.setRotationPoint(0.5F, 6.0F, -1.0F);
        rGem02.addChild(sideF_r15);
        setRotationAngle(sideF_r15, -1.3963F, 0.0F, 0.0F);
        sideF_r15.setTextureOffset(15, 11).addBox(-1.12F, -1.6F, -0.5F, 2, 2, 5,true);

        largeTop_r15 = new ModelRenderer(this);
        largeTop_r15.setRotationPoint(0.5F, 4.0F, 0.5F);
        rGem02.addChild(largeTop_r15);
        setRotationAngle(largeTop_r15, -0.7854F, 0.0F, 0.0F);
        largeTop_r15.setTextureOffset(19, 18).addBox(-1.1F, -0.5F, -0.3F, 2, 3, 3,true);

        point_r15 = new ModelRenderer(this);
        point_r15.setRotationPoint(0.5F, 10.0F, 0.5F);
        rGem02.addChild(point_r15);
        setRotationAngle(point_r15, -0.7854F, 0.0F, 0.0F);
//        point_r15.setTextureOffset(19, 24).addBox(-1.0F, -0.7F, -0.5F, 2.0F, 2.0F, 2.0F, -0.1F, true);

        top_r15 = new ModelRenderer(this);
        top_r15.setRotationPoint(0.5F, 2.0F, 1.0F);
        rGem02.addChild(top_r15);
        setRotationAngle(top_r15, -0.7854F, 0.0F, 0.0F);
        top_r15.setTextureOffset(19, 24).addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2,true);

        rGem03 = new ModelRenderer(this);
        rGem03.setRotationPoint(-0.1582F, -0.1549F, 7.1073F);
        rightWing02.addChild(rGem03);
        setRotationAngle(rGem03, 0.48F, 0.0F, 0.0F);


        sideB_r16 = new ModelRenderer(this);
        sideB_r16.setRotationPoint(0.5F, 6.0F, 2.0F);
        rGem03.addChild(sideB_r16);
        setRotationAngle(sideB_r16, -1.7453F, 0.0F, 0.0F);
        sideB_r16.setTextureOffset(30, 11).addBox(-1.11F, -0.7F, -0.5F, 2, 2, 5,true);

        sideF_r16 = new ModelRenderer(this);
        sideF_r16.setRotationPoint(0.5F, 6.0F, -1.0F);
        rGem03.addChild(sideF_r16);
        setRotationAngle(sideF_r16, -1.3963F, 0.0F, 0.0F);
        sideF_r16.setTextureOffset(30, 11).addBox(-1.12F, -1.6F, -0.5F, 2, 2, 5,true);

        largeTop_r16 = new ModelRenderer(this);
        largeTop_r16.setRotationPoint(0.5F, 4.0F, 0.5F);
        rGem03.addChild(largeTop_r16);
        setRotationAngle(largeTop_r16, -0.7854F, 0.0F, 0.0F);
        largeTop_r16.setTextureOffset(34, 18).addBox(-1.1F, -0.5F, -0.3F, 2, 3, 3,true);

        point_r16 = new ModelRenderer(this);
        point_r16.setRotationPoint(0.5F, 10.0F, 0.5F);
        rGem03.addChild(point_r16);
        setRotationAngle(point_r16, -0.7854F, 0.0F, 0.0F);
//        point_r16.setTextureOffset(34, 24).addBox(-1.0F, -0.7F, -0.5F, 2.0F, 2.0F, 2.0F, -0.1F, true);

        top_r16 = new ModelRenderer(this);
        top_r16.setRotationPoint(0.5F, 2.0F, 1.0F);
        rGem03.addChild(top_r16);
        setRotationAngle(top_r16, -0.7854F, 0.0F, 0.0F);
        top_r16.setTextureOffset(34, 24).addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2,true);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);

        if (state == State.IDLE || state == State.CROUCHING) {
            leftWing03.rotateAngleX = (float) Math.toRadians(-50);
        }
        if (state == State.FLYING) {
            leftWing03.rotateAngleX = (float) Math.toRadians(45);
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
