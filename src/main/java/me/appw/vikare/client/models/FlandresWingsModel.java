package me.appw.vikare.client.models;

import me.appw.vikare.core.capability.WingItemCapability.State;
import me.appw.vikare.core.capability.WingItemCapability.WingsState;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class FlandresWingsModel<T extends LivingEntity> extends WingsModel<T> {

    private final ModelPart leftWing1;
    private final ModelPart leftWing2;
    private final ModelPart leftWing3;
    private final ModelPart leftWing4;
    private final ModelPart leftWing5;
    private final ModelPart leftGem7;
    private final ModelPart gemHalfA1;
    private final ModelPart gemHalfB1;
    private final ModelPart gemCenter1;
    private final ModelPart gemPoint1;
    private final ModelPart gem_top1;
    private final ModelPart leftGem8;
    private final ModelPart gemHalfA2;
    private final ModelPart gemHalfB2;
    private final ModelPart gemCenter2;
    private final ModelPart gemPoint2;
    private final ModelPart gem_top2;
    private final ModelPart leftGem5;
    private final ModelPart gemHalfA3;
    private final ModelPart gemHalfB3;
    private final ModelPart gemCenter3;
    private final ModelPart gemPoint3;
    private final ModelPart gem_top3;
    private final ModelPart leftGem6;
    private final ModelPart gemHalfA4;
    private final ModelPart gemHalfB4;
    private final ModelPart gemCenter4;
    private final ModelPart gemPoint4;
    private final ModelPart gem_top4;
    private final ModelPart leftGem4;
    private final ModelPart gemHalfA5;
    private final ModelPart gemHalfB5;
    private final ModelPart gemCenter5;
    private final ModelPart gemPoint5;
    private final ModelPart gem_top5;
    private final ModelPart leftGem1;
    private final ModelPart gemHalfA6;
    private final ModelPart gemHalfB6;
    private final ModelPart gemCenter6;
    private final ModelPart gemPoint6;
    private final ModelPart gem_top6;
    private final ModelPart leftGem2;
    private final ModelPart gemHalfA7;
    private final ModelPart gemHalfB7;
    private final ModelPart gemCenter7;
    private final ModelPart gemPoint7;
    private final ModelPart gem_top7;
    private final ModelPart leftGem3;
    private final ModelPart gemHalfA8;
    private final ModelPart gemHalfB8;
    private final ModelPart gemCenter8;
    private final ModelPart gemPoint8;
    private final ModelPart gem_top8;
    private final ModelPart rightWing1;
    private final ModelPart rightWing2;
    private final ModelPart rightWing3;
    private final ModelPart rightWing4;
    private final ModelPart rightWing5;
    private final ModelPart rightGem7;
    private final ModelPart gemHalfA9;
    private final ModelPart gemHalfB9;
    private final ModelPart gemCenter9;
    private final ModelPart gemPoint9;
    private final ModelPart gem_top9;
    private final ModelPart rightGem8;
    private final ModelPart gemHalfA10;
    private final ModelPart gemHalfB10;
    private final ModelPart gemCenter10;
    private final ModelPart gemPoint10;
    private final ModelPart gem_top10;
    private final ModelPart rightGem5;
    private final ModelPart gemHalfA11;
    private final ModelPart gemHalfB11;
    private final ModelPart gemCenter11;
    private final ModelPart gemPoint11;
    private final ModelPart gem_top11;
    private final ModelPart rightGem6;
    private final ModelPart gemHalfA12;
    private final ModelPart gemHalfB12;
    private final ModelPart gemCenter12;
    private final ModelPart gemPoint12;
    private final ModelPart gem_top12;
    private final ModelPart rightGem4;
    private final ModelPart gemHalfA13;
    private final ModelPart gemHalfB13;
    private final ModelPart gemCenter13;
    private final ModelPart gemPoint13;
    private final ModelPart gem_top13;
    private final ModelPart rightGem1;
    private final ModelPart gemHalfA14;
    private final ModelPart gemHalfB14;
    private final ModelPart gemCenter14;
    private final ModelPart gemPoint14;
    private final ModelPart gem_top14;
    private final ModelPart rightGem2;
    private final ModelPart gemHalfA15;
    private final ModelPart gemHalfB15;
    private final ModelPart gemCenter15;
    private final ModelPart gemPoint15;
    private final ModelPart gem_top15;
    private final ModelPart rightGem3;
    private final ModelPart gemHalfA16;
    private final ModelPart gemHalfB16;
    private final ModelPart gemCenter16;
    private final ModelPart gemPoint16;
    private final ModelPart gem_top16;

    public FlandresWingsModel(ModelPart root) {
        super(root);
        this.leftWing1 = leftWing.getChild("left_wing1");
        this.leftWing2 = this.leftWing1.getChild("left_wing2");
        this.leftWing3 = this.leftWing2.getChild("left_wing3");
        this.leftWing4 = this.leftWing3.getChild("left_wing4");
        this.leftWing5 = this.leftWing4.getChild("left_wing5");
        this.leftGem7 = this.leftWing5.getChild("left_gem7");
        this.gemHalfA1 = this.leftGem7.getChild("gem_half_a1");
        this.gemHalfB1 = this.leftGem7.getChild("gem_half_b");
        this.gemCenter1 = this.leftGem7.getChild("gem_center1");
        this.gemPoint1 = this.leftGem7.getChild("gem_point1");
        this.gem_top1 = this.leftGem7.getChild("gem_top1");
        this.leftGem8 = this.leftWing5.getChild("left_gem8");
        this.gemHalfA2 = this.leftGem8.getChild("gem_half_a2");
        this.gemHalfB2 = this.leftGem8.getChild("side_f_r2");
        this.gemCenter2 = this.leftGem8.getChild("gem_center2");
        this.gemPoint2 = this.leftGem8.getChild("gem_point2");
        this.gem_top2 = this.leftGem8.getChild("gem_top2");
        this.leftGem5 = this.leftWing4.getChild("left_gem5");
        this.gemHalfA3 = this.leftGem5.getChild("gem_half_a3");
        this.gemHalfB3 = this.leftGem5.getChild("side_f_r3");
        this.gemCenter3 = this.leftGem5.getChild("gem_center3");
        this.gemPoint3 = this.leftGem5.getChild("gem_point3");
        this.gem_top3 = this.leftGem5.getChild("gem_top3");
        this.leftGem6 = this.leftWing4.getChild("left_gem6");
        this.gemHalfA4 = this.leftGem6.getChild("gem_half_a4");
        this.gemHalfB4 = this.leftGem6.getChild("side_f_r4");
        this.gemCenter4 = this.leftGem6.getChild("gem_center4");
        this.gemPoint4 = this.leftGem6.getChild("gem_point4");
        this.gem_top4 = this.leftGem6.getChild("gem_top4");
        this.leftGem4 = this.leftWing3.getChild("left_gem4");
        this.gemHalfA5 = this.leftGem4.getChild("gem_half_a5");
        this.gemHalfB5 = this.leftGem4.getChild("side_f_r5");
        this.gemCenter5 = this.leftGem4.getChild("gem_center5");
        this.gemPoint5 = this.leftGem4.getChild("gem_point5");
        this.gem_top5 = this.leftGem4.getChild("gem_top5");
        this.leftGem1 = this.leftWing2.getChild("left_gem1");
        this.gemHalfA6 = this.leftGem1.getChild("gem_half_a6");
        this.gemHalfB6 = this.leftGem1.getChild("side_f_r6");
        this.gemCenter6 = this.leftGem1.getChild("gem_center6");
        this.gemPoint6 = this.leftGem1.getChild("gem_point6");
        this.gem_top6 = this.leftGem1.getChild("gem_top6");
        this.leftGem2 = this.leftWing2.getChild("left_gem2");
        this.gemHalfA7 = this.leftGem2.getChild("gem_half_a7");
        this.gemHalfB7 = this.leftGem2.getChild("side_f_r7");
        this.gemCenter7 = this.leftGem2.getChild("gem_center7");
        this.gemPoint7 = this.leftGem2.getChild("gem_point7");
        this.gem_top7 = this.leftGem2.getChild("gem_top7");
        this.leftGem3 = this.leftWing2.getChild("left_gem3");
        this.gemHalfA8 = this.leftGem3.getChild("gem_half_a8");
        this.gemHalfB8 = this.leftGem3.getChild("side_f_r8");
        this.gemCenter8 = this.leftGem3.getChild("gem_center8");
        this.gemPoint8 = this.leftGem3.getChild("gem_point8");
        this.gem_top8 = this.leftGem3.getChild("gem_top8");
        this.rightWing1 = rightWing.getChild("right_wing1");
        this.rightWing2 = this.rightWing1.getChild("right_wing2");
        this.rightWing3 = this.rightWing2.getChild("right_wing3");
        this.rightWing4 = this.rightWing3.getChild("right_wing4");
        this.rightWing5 = this.rightWing4.getChild("right_wing5");
        this.rightGem7 = this.rightWing5.getChild("right_gem7");
        this.gemHalfA9 = this.rightGem7.getChild("gem_half_a9");
        this.gemHalfB9 = this.rightGem7.getChild("side_f_r9");
        this.gemCenter9 = this.rightGem7.getChild("gem_center9");
        this.gemPoint9 = this.rightGem7.getChild("gem_point9");
        this.gem_top9 = this.rightGem7.getChild("gem_top9");
        this.rightGem8 = this.rightWing5.getChild("right_gem8");
        this.gemHalfA10 = this.rightGem8.getChild("gem_half_a10");
        this.gemHalfB10 = this.rightGem8.getChild("gem_half_b0");
        this.gemCenter10 = this.rightGem8.getChild("gem_center10");
        this.gemPoint10 = this.rightGem8.getChild("gem_point10");
        this.gem_top10 = this.rightGem8.getChild("gem_top10");
        this.rightGem5 = this.rightWing4.getChild("right_gem5");
        this.gemHalfA11 = this.rightGem5.getChild("gem_half_a11");
        this.gemHalfB11 = this.rightGem5.getChild("gem_half_b1");
        this.gemCenter11 = this.rightGem5.getChild("gem_center11");
        this.gemPoint11 = this.rightGem5.getChild("gem_point11");
        this.gem_top11 = this.rightGem5.getChild("gem_top11");
        this.rightGem6 = this.rightWing4.getChild("right_gem6");
        this.gemHalfA12 = this.rightGem6.getChild("gem_half_a12");
        this.gemHalfB12 = this.rightGem6.getChild("gem_half_b2");
        this.gemCenter12 = this.rightGem6.getChild("gem_center12");
        this.gemPoint12 = this.rightGem6.getChild("gem_point12");
        this.gem_top12 = this.rightGem6.getChild("gem_top12");
        this.rightGem4 = this.rightWing3.getChild("right_gem4");
        this.gemHalfA13 = this.rightGem4.getChild("gem_half_a13");
        this.gemHalfB13 = this.rightGem4.getChild("gem_half_b3");
        this.gemCenter13 = this.rightGem4.getChild("gem_center13");
        this.gemPoint13 = this.rightGem4.getChild("gem_point13");
        this.gem_top13 = this.rightGem4.getChild("gem_top13");
        this.rightGem1 = this.rightWing2.getChild("right_gem1");
        this.gemHalfA14 = this.rightGem1.getChild("gem_half_a14");
        this.gemHalfB14 = this.rightGem1.getChild("gem_half_b4");
        this.gemCenter14 = this.rightGem1.getChild("gem_center14");
        this.gemPoint14 = this.rightGem1.getChild("gem_point14");
        this.gem_top14 = this.rightGem1.getChild("gem_top14");
        this.rightGem2 = this.rightWing2.getChild("right_gem2");
        this.gemHalfA15 = this.rightGem2.getChild("gem_half_a15");
        this.gemHalfB15 = this.rightGem2.getChild("gem_half_b5");
        this.gemCenter15 = this.rightGem2.getChild("gem_center15");
        this.gemPoint15 = this.rightGem2.getChild("gem_point15");
        this.gem_top15 = this.rightGem2.getChild("gem_top15");
        this.rightGem3 = this.rightWing2.getChild("right_gem3");
        this.gemHalfA16 = this.rightGem3.getChild("gem_half_a16");
        this.gemHalfB16 = this.rightGem3.getChild("gem_half_b6");
        this.gemCenter16 = this.rightGem3.getChild("gem_center16");
        this.gemPoint16 = this.rightGem3.getChild("gem_point16");
        this.gem_top16 = this.rightGem3.getChild("gem_top16");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDef = WingsModel.createPartialLayer();
        PartDefinition rootDef = meshDef.getRoot();
        PartDefinition rightWingDef = rootDef.getChild("right_wing");
        PartDefinition leftWingDef = rootDef.getChild("left_wing");

        PartDefinition leftWing1Def = leftWingDef.addOrReplaceChild("left_wing1", CubeListBuilder.create()
                        .texOffs(11, 0).addBox(-1.0f, -1.0f, -1.0f, 2.0f, 3.0f, 6.0f),
                PartPose.offsetAndRotation(-6.0f, 0.0f, 0.0f, 0.0f, 1.5708f, 0.436332f));

        PartDefinition leftWing2Def = leftWing1Def.addOrReplaceChild("left_wing2", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-1.0f, -1.0f, -1.0f, 1.0f, 2.0f, 9.0f),
                PartPose.offsetAndRotation(0.0f, 0.5f, 5.0f, 0.2618f, 0.3054f, 0.0f));

        PartDefinition leftWing3Def = leftWing2Def.addOrReplaceChild("left_wing3", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-0.6f, -1.8f, 0.0f, 1.0f, 2.0f, 9.0f),
                PartPose.offsetAndRotation(-0.5f, 0.5f, 8.0f, 0.7854f, 0.0f, 0.0f));

        PartDefinition leftWing4Def = leftWing3Def.addOrReplaceChild("left_wing4", CubeListBuilder.create()
                        .texOffs(0, 21).addBox(-0.7f, 0.0f, -0.6f, 1.0f, 11.0f, 1.0f),
                PartPose.offsetAndRotation(0.0f, -1.0f, 9.0f, 0.6981f, 0.0f, 0.0f));

        PartDefinition leftWing5Def = leftWing4Def.addOrReplaceChild("left_wing5", CubeListBuilder.create()
                        .texOffs(0, 21).addBox(-0.8f, -0.3f, -0.7f, 1.0f, 11.0f, 1.0f),
                PartPose.offsetAndRotation(0.0f, 10.8f, 0.0f, -0.3054f, 0.0f, 0.0f));

        PartDefinition leftGem7Def = leftWing5Def.addOrReplaceChild("left_gem7", CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0308f, 2.2372f, 0.0333f, -0.9599f, 0.0f, 0.0f));

        leftGem7Def.addOrReplaceChild("gem_half_a1", CubeListBuilder.create()
                        .texOffs(36, 30).addBox(-0.89f, -0.7f, -0.5f, 2.0f, 2.0f, 5.0f),
                PartPose.offsetAndRotation(-0.5f, 6.0f, 2.0f, -1.7453f, 0.0f, 0.0f));

        leftGem7Def.addOrReplaceChild("gem_half_b", CubeListBuilder.create()
                        .texOffs(36, 30).addBox(-0.88f, -1.6f, -0.5f, 2.0f, 2.0f, 5.0f),
                PartPose.offsetAndRotation(-0.5f, 6.0f, -1.0f, -1.3963f, 0.0f, 0.0f));

        leftGem7Def.addOrReplaceChild("gem_center1", CubeListBuilder.create()
                        .texOffs(40, 37).addBox(-0.9f, -0.5f, -0.3f, 2.0f, 3.0f, 3.0f),
                PartPose.offsetAndRotation(-0.5f, 4.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        leftGem7Def.addOrReplaceChild("gem_point1", CubeListBuilder.create()
                        .texOffs(40, 43).addBox(-1.0f, -0.7f, -0.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(-0.10f)),
                PartPose.offsetAndRotation(-0.5f, 10.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        leftGem7Def.addOrReplaceChild("gem_top1", CubeListBuilder.create()
                        .texOffs(40, 43).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 2.0f, 2.0f),
                PartPose.offsetAndRotation(-0.5f, 2.0f, 1.0f, -0.7854f, 0.0f, 0.0f));

        PartDefinition leftGem8Def = leftWing5Def.addOrReplaceChild("left_gem8", CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.4383f, 8.6075f, 0.5953f, -0.9599f, 0.0f, 0.0f));

        leftGem8Def.addOrReplaceChild("gem_half_a2", CubeListBuilder.create()
                        .texOffs(0, 11).addBox(-0.89f, -0.7f, -0.5f, 2.0f, 2.0f, 5.0f),
                PartPose.offsetAndRotation(-0.5f, 6.0f, 2.0f, -1.7453f, 0.0f, 0.0f));

        leftGem8Def.addOrReplaceChild("side_f_r2", CubeListBuilder.create()
                        .texOffs(0, 11).addBox(-0.88f, -1.6f, -0.5f, 2.0f, 2.0f, 5.0f),
                PartPose.offsetAndRotation(-0.5f, 6.0f, -1.0f, -1.3963f, 0.0f, 0.0f));

        leftGem8Def.addOrReplaceChild("gem_center2", CubeListBuilder.create()
                        .texOffs(4, 18).addBox(-0.9f, -0.5f, -0.3f, 2.0f, 3.0f, 3.0f),
                PartPose.offsetAndRotation(-0.5f, 4.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        leftGem8Def.addOrReplaceChild("gem_point2", CubeListBuilder.create()
                        .texOffs(4, 24).addBox(-1.0f, -0.7f, -0.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(-0.10f)),
                PartPose.offsetAndRotation(-0.5f, 10.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        leftGem8Def.addOrReplaceChild("gem_top2", CubeListBuilder.create()
                        .texOffs(4, 24).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 2.0f, 2.0f),
                PartPose.offsetAndRotation(-0.5f, 2.0f, 1.0f, -0.7854f, 0.0f, 0.0f));

        PartDefinition leftGem5Def = leftWing4Def.addOrReplaceChild("left_gem5", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-0.142f, 0.7935f, 0.1272f, -1.0472f, 0.0f, 0.0f));

        leftGem5Def.addOrReplaceChild("gem_half_a3", CubeListBuilder.create()
                        .texOffs(4, 30).addBox(-0.89f, -0.7f, -0.5f, 2.0f, 2.0f, 5.0f),
                PartPose.offsetAndRotation(-0.5f, 6.0f, 2.0f, -1.7453f, 0.0f, 0.0f));

        leftGem5Def.addOrReplaceChild("side_f_r3", CubeListBuilder.create()
                        .texOffs(4, 30).addBox(-0.88f, -1.6f, -0.5f, 2.0f, 2.0f, 5.0f),
                PartPose.offsetAndRotation(-0.5f, 6.0f, -1.0f, -1.3963f, 0.0f, 0.0f));

        leftGem5Def.addOrReplaceChild("gem_center3", CubeListBuilder.create()
                        .texOffs(8, 37).addBox(-0.9f, -0.5f, -0.3f, 2.0f, 3.0f, 3.0f),
                PartPose.offsetAndRotation(-0.5f, 4.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        leftGem5Def.addOrReplaceChild("gem_point3", CubeListBuilder.create()
                        .texOffs(8, 43).addBox(-1.0f, -0.7f, -0.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(-0.10f)),
                PartPose.offsetAndRotation(-0.5f, 10.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        leftGem5Def.addOrReplaceChild("gem_top3", CubeListBuilder.create()
                        .texOffs(8, 43).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 2.0f, 2.0f),
                PartPose.offsetAndRotation(-0.5f, 2.0f, 1.0f, -0.7854f, 0.0f, 0.0f));

        PartDefinition leftGem6Def = leftWing4Def.addOrReplaceChild("left_gem6", CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.3039f, 5.7996f, 0.357f, -1.0472f, 0.0f, 0.0f));

        leftGem6Def.addOrReplaceChild("gem_half_a4", CubeListBuilder.create()
                        .texOffs(20, 30).addBox(-0.89f, -0.7f, -0.5f, 2.0f, 2.0f, 5.0f),
                PartPose.offsetAndRotation(-0.5f, 6.0f, 2.0f, -1.7453f, 0.0f, 0.0f));

        leftGem6Def.addOrReplaceChild("side_f_r4", CubeListBuilder.create()
                        .texOffs(20, 30).addBox(-0.88f, -1.6f, -0.5f, 2.0f, 2.0f, 5.0f),
                PartPose.offsetAndRotation(-0.5f, 6.0f, -1.0f, -1.3963f, 0.0f, 0.0f));

        leftGem6Def.addOrReplaceChild("gem_center4", CubeListBuilder.create()
                        .texOffs(24, 37).addBox(-0.9f, -0.5f, -0.3f, 2.0f, 3.0f, 3.0f),
                PartPose.offsetAndRotation(-0.5f, 4.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        leftGem6Def.addOrReplaceChild("gem_point4", CubeListBuilder.create()
                        .texOffs(24, 43).addBox(-1.0f, -0.7f, -0.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(-0.10f)),
                PartPose.offsetAndRotation(-0.5f, 10.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        leftGem6Def.addOrReplaceChild("gem_top4", CubeListBuilder.create()
                        .texOffs(24, 43).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 2.0f, 2.0f),
                PartPose.offsetAndRotation(-0.5f, 2.0f, 1.0f, -0.7854f, 0.0f, 0.0f));

        PartDefinition leftGem4Def = leftWing3Def.addOrReplaceChild("left_gem4", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-0.4345f, -0.814f, 3.3462f, -0.1309f, 0.0f, 0.0f));

        leftGem4Def.addOrReplaceChild("gem_half_a5", CubeListBuilder.create()
                        .texOffs(45, 11).addBox(-0.89f, -0.7f, -0.5f, 2.0f, 2.0f, 5.0f),
                PartPose.offsetAndRotation(-0.5f, 6.0f, 2.0f, -1.7453f, 0.0f, 0.0f));

        leftGem4Def.addOrReplaceChild("side_f_r5", CubeListBuilder.create()
                        .texOffs(45, 11).addBox(-0.88f, -1.6f, -0.5f, 2.0f, 2.0f, 5.0f),
                PartPose.offsetAndRotation(-0.5f, 6.0f, -1.0f, -1.3963f, 0.0f, 0.0f));

        leftGem4Def.addOrReplaceChild("gem_center5", CubeListBuilder.create()
                        .texOffs(49, 18).addBox(-0.9f, -0.5f, -0.3f, 2.0f, 3.0f, 3.0f),
                PartPose.offsetAndRotation(-0.5f, 4.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        leftGem4Def.addOrReplaceChild("gem_point5", CubeListBuilder.create()
                        .texOffs(49, 24).addBox(-1.0f, -0.7f, -0.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(-0.10f)),
                PartPose.offsetAndRotation(-0.5f, 10.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        leftGem4Def.addOrReplaceChild("gem_top5", CubeListBuilder.create()
                        .texOffs(49, 24).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 2.0f, 2.0f),
                PartPose.offsetAndRotation(-0.5f, 2.0f, 1.0f, -0.7854f, 0.0f, 0.0f));

        PartDefinition leftGem1Def = leftWing2Def.addOrReplaceChild("left_gem1", CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.6635f, 0.2041f, -1.1535f, 0.0f, 0.0f, 0.0f));

        leftGem1Def.addOrReplaceChild("gem_half_a6", CubeListBuilder.create()
                        .texOffs(0, 11).addBox(-0.89f, -0.7f, -0.5f, 2.0f, 2.0f, 5.0f),
                PartPose.offsetAndRotation(-0.5f, 6.0f, 2.0f, -1.7453f, 0.0f, 0.0f));

        leftGem1Def.addOrReplaceChild("side_f_r6", CubeListBuilder.create()
                        .texOffs(0, 11).addBox(-0.88f, -1.6f, -0.5f, 2.0f, 2.0f, 5.0f),
                PartPose.offsetAndRotation(-0.5f, 6.0f, -1.0f, -1.3963f, 0.0f, 0.0f));

        leftGem1Def.addOrReplaceChild("gem_center6", CubeListBuilder.create()
                        .texOffs(4, 18).addBox(-0.9f, -0.5f, -0.3f, 2.0f, 3.0f, 3.0f),
                PartPose.offsetAndRotation(-0.5f, 4.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        leftGem1Def.addOrReplaceChild("gem_point6", CubeListBuilder.create()
                        .texOffs(4, 24).addBox(-1.0f, -0.7f, -0.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(-0.10f)),
                PartPose.offsetAndRotation(-0.5f, 10.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        leftGem1Def.addOrReplaceChild("gem_top6", CubeListBuilder.create()
                        .texOffs(4, 24).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 2.0f, 2.0f),
                PartPose.offsetAndRotation(-0.5f, 2.0f, 1.0f, -0.7854f, 0.0f, 0.0f));

        PartDefinition leftGem2Def = leftWing2Def.addOrReplaceChild("left_gem2", CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.267f, -0.1566f, 4.027f, 0.0873f, 0.0f, 0.0f));

        leftGem2Def.addOrReplaceChild("gem_half_a7", CubeListBuilder.create()
                        .texOffs(15, 11).addBox(-0.89f, -0.7f, -0.5f, 2.0f, 2.0f, 5.0f),
                PartPose.offsetAndRotation(-0.5f, 6.0f, 2.0f, -1.7453f, 0.0f, 0.0f));

        leftGem2Def.addOrReplaceChild("side_f_r7", CubeListBuilder.create()
                        .texOffs(15, 11).addBox(-0.88f, -1.6f, -0.5f, 2.0f, 2.0f, 5.0f),
                PartPose.offsetAndRotation(-0.5f, 6.0f, -1.0f, -1.3963f, 0.0f, 0.0f));

        leftGem2Def.addOrReplaceChild("gem_center7", CubeListBuilder.create()
                        .texOffs(19, 18).addBox(-0.9f, -0.5f, -0.3f, 2.0f, 3.0f, 3.0f),
                PartPose.offsetAndRotation(-0.5f, 4.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        leftGem2Def.addOrReplaceChild("gem_point7", CubeListBuilder.create()
                        .texOffs(19, 24).addBox(-1.0f, -0.7f, -0.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(-0.10f)),
                PartPose.offsetAndRotation(-0.5f, 10.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        leftGem2Def.addOrReplaceChild("gem_top7", CubeListBuilder.create()
                        .texOffs(19, 24).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 2.0f, 2.0f),
                PartPose.offsetAndRotation(-0.5f, 2.0f, 1.0f, -0.7854f, 0.0f, 0.0f));

        PartDefinition leftGem3Def = leftWing2Def.addOrReplaceChild("left_gem3", CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.1582f, -0.1549f, 7.1073f, 0.48f, 0.0f, 0.0f));

        leftGem3Def.addOrReplaceChild("gem_half_a8", CubeListBuilder.create()
                        .texOffs(30, 11).addBox(-0.89f, -0.7f, -0.5f, 2.0f, 2.0f, 5.0f),
                PartPose.offsetAndRotation(-0.5f, 6.0f, 2.0f, -1.7453f, 0.0f, 0.0f));

        leftGem3Def.addOrReplaceChild("side_f_r8", CubeListBuilder.create()
                        .texOffs(30, 11).addBox(-0.88f, -1.6f, -0.5f, 2.0f, 2.0f, 5.0f),
                PartPose.offsetAndRotation(-0.5f, 6.0f, -1.0f, -1.3963f, 0.0f, 0.0f));

        leftGem3Def.addOrReplaceChild("gem_center8", CubeListBuilder.create()
                        .texOffs(34, 18).addBox(-0.9f, -0.5f, -0.3f, 2.0f, 3.0f, 3.0f),
                PartPose.offsetAndRotation(-0.5f, 4.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        leftGem3Def.addOrReplaceChild("gem_point8", CubeListBuilder.create()
                        .texOffs(34, 24).addBox(-1.0f, -0.7f, -0.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(-0.10f)),
                PartPose.offsetAndRotation(-0.5f, 10.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        leftGem3Def.addOrReplaceChild("gem_top8", CubeListBuilder.create()
                        .texOffs(34, 24).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 2.0f, 2.0f),
                PartPose.offsetAndRotation(-0.5f, 2.0f, 1.0f, -0.7854f, 0.0f, 0.0f));

        PartDefinition rightWing1Def = rightWingDef.addOrReplaceChild("right_wing1", CubeListBuilder.create()
                        .texOffs(11, 0).addBox(-1.0f, -1.0f, -1.0f, 2.0f, 3.0f, 6.0f, true),
                PartPose.offsetAndRotation(6.0f, 0.0f, 0.0f, 0.0f, -1.5708f, -0.436332f));

        PartDefinition rightWing2Def = rightWing1Def.addOrReplaceChild("right_wing2", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(0.0f, -1.0f, -1.0f, 1.0f, 2.0f, 9.0f, true),
                PartPose.offsetAndRotation(0.0f, 0.5f, 5.0f, 0.2618f, -0.3054f, 0.0f));

        PartDefinition rightWing3Def = rightWing2Def.addOrReplaceChild("right_wing3", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-0.4f, -1.8f, 0.0f, 1.0f, 2.0f, 9.0f, true),
                PartPose.offsetAndRotation(0.5f, 0.5f, 8.0f, 0.7854f, 0.0f, 0.0f));

        PartDefinition rightWing4Def = rightWing3Def.addOrReplaceChild("right_wing4", CubeListBuilder.create()
                        .texOffs(0, 21).addBox(-0.3f, 0.0f, -0.6f, 1.0f, 11.0f, 1.0f, true),
                PartPose.offsetAndRotation(0.0f, -1.0f, 9.0f, 0.6981f, 0.0f, 0.0f));

        PartDefinition rightWing5Def = rightWing4Def.addOrReplaceChild("right_wing5", CubeListBuilder.create()
                        .texOffs(0, 21).addBox(-0.2f, -0.3f, -0.7f, 1.0f, 11.0f, 1.0f, true),
                PartPose.offsetAndRotation(0.0f, 10.8f, 0.0f, -0.3054f, 0.0f, 0.0f));

        PartDefinition rightGem7Def = rightWing5Def.addOrReplaceChild("right_gem7", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-0.0308f, 2.2372f, 0.0333f, -0.9599f, 0.0f, 0.0f));

        rightGem7Def.addOrReplaceChild("gem_half_a9", CubeListBuilder.create()
                        .texOffs(36, 30).addBox(-1.11f, -0.7f, -0.5f, 2.0f, 2.0f, 5.0f, true),
                PartPose.offsetAndRotation(0.5f, 6.0f, 2.0f, -1.7453f, 0.0f, 0.0f));

        rightGem7Def.addOrReplaceChild("side_f_r9", CubeListBuilder.create()
                        .texOffs(36, 30).addBox(-1.12f, -1.6f, -0.5f, 2.0f, 2.0f, 5.0f, true),
                PartPose.offsetAndRotation(0.5f, 6.0f, -1.0f, -1.3963f, 0.0f, 0.0f));

        rightGem7Def.addOrReplaceChild("gem_center9", CubeListBuilder.create()
                        .texOffs(40, 37).addBox(-1.1f, -0.5f, -0.3f, 2.0f, 3.0f, 3.0f, true),
                PartPose.offsetAndRotation(0.5f, 4.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        rightGem7Def.addOrReplaceChild("gem_point9", CubeListBuilder.create()
                        .texOffs(40, 43).addBox(-1.0f, -0.7f, -0.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(-0.10f)).mirror(),
                PartPose.offsetAndRotation(0.5f, 10.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        rightGem7Def.addOrReplaceChild("gem_top9", CubeListBuilder.create()
                        .texOffs(40, 43).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 2.0f, 2.0f, true),
                PartPose.offsetAndRotation(0.5f, 2.0f, 1.0f, -0.7854f, 0.0f, 0.0f));

        PartDefinition rightGem8Def = rightWing5Def.addOrReplaceChild("right_gem8", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-0.4383f, 8.6075f, 0.5953f, -0.9599f, 0.0f, 0.0f));

        rightGem8Def.addOrReplaceChild("gem_half_a10", CubeListBuilder.create()
                        .texOffs(0, 11).addBox(-1.11f, -0.7f, -0.5f, 2.0f, 2.0f, 5.0f, true),
                PartPose.offsetAndRotation(0.5f, 6.0f, 2.0f, -1.7453f, 0.0f, 0.0f));

        rightGem8Def.addOrReplaceChild("gem_half_b0", CubeListBuilder.create()
                        .texOffs(0, 11).addBox(-1.12f, -1.6f, -0.5f, 2.0f, 2.0f, 5.0f, true),
                PartPose.offsetAndRotation(0.5f, 6.0f, -1.0f, -1.3963f, 0.0f, 0.0f));

        rightGem8Def.addOrReplaceChild("gem_center10", CubeListBuilder.create()
                        .texOffs(4, 18).addBox(-1.1f, -0.5f, -0.3f, 2.0f, 3.0f, 3.0f, true),
                PartPose.offsetAndRotation(0.5f, 4.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        rightGem8Def.addOrReplaceChild("gem_point10", CubeListBuilder.create()
                        .texOffs(4, 24).addBox(-1.0f, -0.7f, -0.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(-0.10f)).mirror(),
                PartPose.offsetAndRotation(0.5f, 10.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        rightGem8Def.addOrReplaceChild("gem_top10", CubeListBuilder.create()
                        .texOffs(4, 24).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 2.0f, 2.0f, true),
                PartPose.offsetAndRotation(0.5f, 2.0f, 1.0f, -0.7854f, 0.0f, 0.0f));

        PartDefinition rightGem5Def = rightWing4Def.addOrReplaceChild("right_gem5", CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.142f, 0.7935f, 0.1272f, -1.0472f, 0.0f, 0.0f));

        rightGem5Def.addOrReplaceChild("gem_half_a11", CubeListBuilder.create()
                        .texOffs(4, 30).addBox(-1.11f, -0.7f, -0.5f, 2.0f, 2.0f, 5.0f, true),
                PartPose.offsetAndRotation(0.5f, 6.0f, 2.0f, -1.7453f, 0.0f, 0.0f));

        rightGem5Def.addOrReplaceChild("gem_half_b1", CubeListBuilder.create()
                        .texOffs(4, 30).addBox(-1.12f, -1.6f, -0.5f, 2.0f, 2.0f, 5.0f, true),
                PartPose.offsetAndRotation(0.5f, 6.0f, -1.0f, -1.3963f, 0.0f, 0.0f));

        rightGem5Def.addOrReplaceChild("gem_center11", CubeListBuilder.create()
                        .texOffs(8, 37).addBox(-1.1f, -0.5f, -0.3f, 2.0f, 3.0f, 3.0f, true),
                PartPose.offsetAndRotation(0.5f, 4.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        rightGem5Def.addOrReplaceChild("gem_point11", CubeListBuilder.create()
                        .texOffs(8, 43).addBox(-1.0f, -0.7f, -0.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(-0.10f)).mirror(),
                PartPose.offsetAndRotation(0.5f, 10.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        rightGem5Def.addOrReplaceChild("gem_top11", CubeListBuilder.create()
                        .texOffs(8, 43).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 2.0f, 2.0f, true),
                PartPose.offsetAndRotation(0.5f, 2.0f, 1.0f, -0.7854f, 0.0f, 0.0f));

        PartDefinition rightGem6Def = rightWing4Def.addOrReplaceChild("right_gem6", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-0.3039f, 5.7996f, 0.357f, -1.0472f, 0.0f, 0.0f));

        rightGem6Def.addOrReplaceChild("gem_half_a12", CubeListBuilder.create()
                        .texOffs(20, 30).addBox(-1.11f, -0.7f, -0.5f, 2.0f, 2.0f, 5.0f, true),
                PartPose.offsetAndRotation(0.5f, 6.0f, 2.0f, -1.7453f, 0.0f, 0.0f));

        rightGem6Def.addOrReplaceChild("gem_half_b2", CubeListBuilder.create()
                        .texOffs(20, 30).addBox(-1.12f, -1.6f, -0.5f, 2.0f, 2.0f, 5.0f, true),
                PartPose.offsetAndRotation(0.5f, 6.0f, -1.0f, -1.3963f, 0.0f, 0.0f));

        rightGem6Def.addOrReplaceChild("gem_center12", CubeListBuilder.create()
                        .texOffs(24, 37).addBox(-1.1f, -0.5f, -0.3f, 2.0f, 3.0f, 3.0f, true),
                PartPose.offsetAndRotation(0.5f, 4.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        rightGem6Def.addOrReplaceChild("gem_point12", CubeListBuilder.create()
                        .texOffs(24, 43).addBox(-1.0f, -0.7f, -0.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(-0.10f)).mirror(),
                PartPose.offsetAndRotation(0.5f, 10.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        rightGem6Def.addOrReplaceChild("gem_top12", CubeListBuilder.create()
                        .texOffs(24, 43).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 2.0f, 2.0f, true),
                PartPose.offsetAndRotation(0.5f, 2.0f, 1.0f, -0.7854f, 0.0f, 0.0f));

        PartDefinition rightGem4Def = rightWing3Def.addOrReplaceChild("right_gem4", CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.4345f, -0.814f, 3.3462f, -0.1309f, 0.0f, 0.0f));

        rightGem4Def.addOrReplaceChild("gem_half_a13", CubeListBuilder.create()
                        .texOffs(45, 11).addBox(-1.11f, -0.7f, -0.5f, 2.0f, 2.0f, 5.0f, true),
                PartPose.offsetAndRotation(0.5f, 6.0f, 2.0f, -1.7453f, 0.0f, 0.0f));

        rightGem4Def.addOrReplaceChild("gem_half_b3", CubeListBuilder.create()
                        .texOffs(45, 11).addBox(-1.12f, -1.6f, -0.5f, 2.0f, 2.0f, 5.0f, true),
                PartPose.offsetAndRotation(0.5f, 6.0f, -1.0f, -1.3963f, 0.0f, 0.0f));

        rightGem4Def.addOrReplaceChild("gem_center13", CubeListBuilder.create()
                        .texOffs(49, 18).addBox(-1.1f, -0.5f, -0.3f, 2.0f, 3.0f, 3.0f, true),
                PartPose.offsetAndRotation(0.5f, 4.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        rightGem4Def.addOrReplaceChild("gem_point13", CubeListBuilder.create()
                        .texOffs(49, 24).addBox(-1.0f, -0.7f, -0.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(-0.10f)).mirror(),
                PartPose.offsetAndRotation(0.5f, 10.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        rightGem4Def.addOrReplaceChild("gem_top13", CubeListBuilder.create()
                        .texOffs(49, 24).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 2.0f, 2.0f, true),
                PartPose.offsetAndRotation(0.5f, 2.0f, 1.0f, -0.7854f, 0.0f, 0.0f));

        PartDefinition rightGem1Def = rightWing2Def.addOrReplaceChild("right_gem1", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-0.6635f, 0.2041f, -1.1535f, 0.0f, 0.0f, 0.0f));

        rightGem1Def.addOrReplaceChild("gem_half_a14", CubeListBuilder.create()
                        .texOffs(0, 11).addBox(-1.11f, -0.7f, -0.5f, 2.0f, 2.0f, 5.0f, true),
                PartPose.offsetAndRotation(0.5f, 6.0f, 2.0f, -1.7453f, 0.0f, 0.0f));

        rightGem1Def.addOrReplaceChild("gem_half_b4", CubeListBuilder.create()
                        .texOffs(0, 11).addBox(-1.12f, -1.6f, -0.5f, 2.0f, 2.0f, 5.0f, true),
                PartPose.offsetAndRotation(0.5f, 6.0f, -1.0f, -1.3963f, 0.0f, 0.0f));

        rightGem1Def.addOrReplaceChild("gem_center14", CubeListBuilder.create()
                        .texOffs(4, 18).addBox(-1.1f, -0.5f, -0.3f, 2.0f, 3.0f, 3.0f, true),
                PartPose.offsetAndRotation(0.5f, 4.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        rightGem1Def.addOrReplaceChild("gem_point14", CubeListBuilder.create()
                        .texOffs(4, 24).addBox(-1.0f, -0.7f, -0.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(-0.10f)).mirror(),
                PartPose.offsetAndRotation(0.5f, 10.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        rightGem1Def.addOrReplaceChild("gem_top14", CubeListBuilder.create()
                        .texOffs(4, 24).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 2.0f, 2.0f, true),
                PartPose.offsetAndRotation(0.5f, 2.0f, 1.0f, -0.7854f, 0.0f, 0.0f));

        PartDefinition rightGem2Def = rightWing2Def.addOrReplaceChild("right_gem2", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-0.267f, -0.1566f, 4.027f, 0.0873f, 0.0f, 0.0f));

        rightGem2Def.addOrReplaceChild("gem_half_a15", CubeListBuilder.create()
                        .texOffs(15, 11).addBox(-1.11f, -0.7f, -0.5f, 2.0f, 2.0f, 5.0f, true),
                PartPose.offsetAndRotation(0.5f, 6.0f, 2.0f, -1.7453f, 0.0f, 0.0f));

        rightGem2Def.addOrReplaceChild("gem_half_b5", CubeListBuilder.create()
                        .texOffs(15, 11).addBox(-1.12f, -1.6f, -0.5f, 2.0f, 2.0f, 5.0f, true),
                PartPose.offsetAndRotation(0.5f, 6.0f, -1.0f, -1.3963f, 0.0f, 0.0f));

        rightGem2Def.addOrReplaceChild("gem_center15", CubeListBuilder.create()
                        .texOffs(19, 18).addBox(-1.1f, -0.5f, -0.3f, 2.0f, 3.0f, 3.0f, true),
                PartPose.offsetAndRotation(0.5f, 4.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        rightGem2Def.addOrReplaceChild("gem_point15", CubeListBuilder.create()
                        .texOffs(19, 24).addBox(-1.0f, -0.7f, -0.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(-0.10f)).mirror(),
                PartPose.offsetAndRotation(0.5f, 10.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        rightGem2Def.addOrReplaceChild("gem_top15", CubeListBuilder.create()
                        .texOffs(19, 24).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 2.0f, 2.0f, true),
                PartPose.offsetAndRotation(0.5f, 2.0f, 1.0f, -0.7854f, 0.0f, 0.0f));

        PartDefinition rightGem3Def = rightWing2Def.addOrReplaceChild("right_gem3", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-0.1582f, -0.1549f, 7.1073f, 0.48f, 0.0f, 0.0f));

        rightGem3Def.addOrReplaceChild("gem_half_a16", CubeListBuilder.create()
                        .texOffs(30, 11).addBox(-1.11f, -0.7f, -0.5f, 2.0f, 2.0f, 5.0f, true),
                PartPose.offsetAndRotation(0.5f, 6.0f, 2.0f, -1.7453f, 0.0f, 0.0f));

        rightGem3Def.addOrReplaceChild("gem_half_b6", CubeListBuilder.create()
                        .texOffs(30, 11).addBox(-1.12f, -1.6f, -0.5f, 2.0f, 2.0f, 5.0f, true),
                PartPose.offsetAndRotation(0.5f, 6.0f, -1.0f, -1.3963f, 0.0f, 0.0f));

        rightGem3Def.addOrReplaceChild("gem_center16", CubeListBuilder.create()
                        .texOffs(34, 18).addBox(-1.1f, -0.5f, -0.3f, 2.0f, 3.0f, 3.0f, true),
                PartPose.offsetAndRotation(0.5f, 4.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        rightGem3Def.addOrReplaceChild("gem_point16", CubeListBuilder.create()
                        .texOffs(34, 24).addBox(-1.0f, -0.7f, -0.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(-0.10f)).mirror(),
                PartPose.offsetAndRotation(0.5f, 10.0f, 0.5f, -0.7854f, 0.0f, 0.0f));

        rightGem3Def.addOrReplaceChild("gem_top16", CubeListBuilder.create()
                        .texOffs(34, 24).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 2.0f, 2.0f, true),
                PartPose.offsetAndRotation(0.5f, 2.0f, 1.0f, -0.7854f, 0.0f, 0.0f));

        return LayerDefinition.create(meshDef, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float ageInTicks, WingsState state) {
        super.setupAnim(entity, ageInTicks, state);

        if (state.status == State.IDLE || state.status == State.CROUCHING) {
            leftWing3.xRot = (float) Math.toRadians(-50);
        }
        if (state.status == State.FLYING) {
            leftWing3.xRot = (float) Math.toRadians(45);
        }
        rightWing3.xRot = leftWing3.xRot;
    }
}
