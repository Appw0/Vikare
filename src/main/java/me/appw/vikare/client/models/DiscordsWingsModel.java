package me.appw.vikare.client.models;

import me.appw.vikare.core.capability.WingItemCapability.State;
import me.appw.vikare.core.capability.WingItemCapability.WingsState;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.LivingEntity;

public class DiscordsWingsModel<T extends LivingEntity> extends WingsModel<T> {

    private final ModelPart leftWing1;
    private final ModelPart leftWing2;
    private final ModelPart leftWing3;
    private final ModelPart leftWing4;
    private final ModelPart leftWing5;
    private final ModelPart leftFeathers2;
    private final ModelPart leftBox1;
    private final ModelPart leftFeathers1;
    private final ModelPart leftBox2;
    private final ModelPart rightWing1;
    private final ModelPart rightWing2;
    private final ModelPart rightWing3;
    private final ModelPart rightWing4;
    private final ModelPart rightWing4Leather;
    private final ModelPart rightWingStrut1;
    private final ModelPart rightWingStrut1Leather;
    private final ModelPart rightWingStrut2;
    private final ModelPart rightWingStrut2Leather;
    private final ModelPart rightWingStrut3;
    private final ModelPart rightWingStrut3Leather;
    private final ModelPart rightStrutLowest;
    private final ModelPart rightStrutLowestLeather1;
    private final ModelPart rightStrutLowestLeather2;

    public DiscordsWingsModel(ModelPart root) {
        super(root);
        this.leftWing1 = leftWing.getChild("left_wing1");
        this.leftWing2 = this.leftWing1.getChild("left_wing2");
        this.leftWing3 = this.leftWing2.getChild("left_wing3");
        this.leftWing4 = this.leftWing3.getChild("left_wing4");
        this.leftWing5 = this.leftWing4.getChild("left_wing5");
        this.leftFeathers2 = this.leftWing4.getChild("left_feathers2");
        this.leftBox1 = this.leftFeathers2.getChild("left_box1");
        this.leftFeathers1 = this.leftWing2.getChild("left_feathers1");
        this.leftBox2 = this.leftFeathers1.getChild("left_box2");
        this.rightWing1 = rightWing.getChild("right_wing1");
        this.rightWing2 = this.rightWing1.getChild("right_wing2");
        this.rightWing3 = this.rightWing2.getChild("right_wing3");
        this.rightWing4 = this.rightWing3.getChild("right_wing4");
        this.rightWing4Leather = this.rightWing4.getChild("right_wing4_leather");
        this.rightWingStrut1 = this.rightWing3.getChild("right_wing_strut1");
        this.rightWingStrut1Leather = this.rightWingStrut1.getChild("right_wing_strut1_leather");
        this.rightWingStrut2 = this.rightWing3.getChild("right_wing_strut2");
        this.rightWingStrut2Leather = this.rightWingStrut2.getChild("right_wing_strut2_leather");
        this.rightWingStrut3 = this.rightWing3.getChild("right_wing_strut3");
        this.rightWingStrut3Leather = this.rightWingStrut3.getChild("right_wing_strut3_leather");
        this.rightStrutLowest = this.rightWing2.getChild("right_strut_lowest");
        this.rightStrutLowestLeather1 = this.rightStrutLowest.getChild("right_strut_lowest_leather1");
        this.rightStrutLowestLeather2 = this.rightStrutLowest.getChild("right_strut_lowest_leather2");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDef = WingsModel.createPartialLayer();
        PartDefinition rootDef = meshDef.getRoot();
        PartDefinition rightWingDef = rootDef.getChild("right_wing");
        PartDefinition leftWingDef = rootDef.getChild("left_wing");

        PartDefinition leftWing1Def = leftWingDef.addOrReplaceChild("left_wing1", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-1.0f, -2.0f, -1.0f, 2.0f, 4.0f, 6.0f),
                PartPose.offsetAndRotation(-6.0f, 0.0f, 0.0f, 0.0f, 1.5708f, 0.436332f));

        PartDefinition leftWing2Def = leftWing1Def.addOrReplaceChild("left_wing2", CubeListBuilder.create()
                        .texOffs(17, 0).addBox(-0.5f, -1.5f, 0.5f, 1.0f, 2.0f, 8.0f),
                PartPose.offsetAndRotation(-0.5f, 0.0f, 3.5f, 0.6109f, 0.3054f, 0.0f));

        PartDefinition leftWing3Def = leftWing2Def.addOrReplaceChild("left_wing3", CubeListBuilder.create()
                        .texOffs(36, 0).addBox(-0.5f, -0.1f, -0.5f, 1.0f, 2.0f, 8.0f),
                PartPose.offsetAndRotation(0.0f, -1.0f, 8.5f, -0.5672f, 0.3054f, 0.0f));

        PartDefinition leftWing4Def = leftWing3Def.addOrReplaceChild("left_wing4", CubeListBuilder.create()
                        .texOffs(55, 0).addBox(-0.7f, -0.2f, -0.5f, 1.0f, 14.0f, 1.0f, true),
                PartPose.offsetAndRotation(0.0f, 0.5f, 7.2f, 1.0908f, 0.0f, 0.0f));

        leftWing4Def.addOrReplaceChild("left_wing5", CubeListBuilder.create()
                        .texOffs(32, 31).addBox(0.4f, -4.0f, -12.3f, 0.001f, 20.0f, 13.0f, true),
                PartPose.offsetAndRotation(-0.5f, 4.8f, -0.2f, 0.0f, 0.0f, 0.0f));

        PartDefinition leftFeathers2Def = leftWing4Def.addOrReplaceChild("left_feathers2", CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0f, -3.5f, -3.2f, 0.0f, 0.0f, 0.0873f));

        leftFeathers2Def.addOrReplaceChild("left_box1", CubeListBuilder.create()
                        .texOffs(0, 36).addBox(0.0f, -6.6f, -13.8f, 1.0f, 14.0f, 14.0f, true),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.48f, 0.0f, 0.0f));

        PartDefinition leftFeathers1Def = leftWing2Def.addOrReplaceChild("left_feathers1", CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.6f, 1.3f, 1.5f, -0.1745f, -0.0873f, 0.0f));

        leftFeathers1Def.addOrReplaceChild("left_box2", CubeListBuilder.create()
                        .texOffs(0, 10).addBox(-0.5f, -0.8f, -8.1f, 1.0f, 10.0f, 16.0f, true),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.1745f, 0.0f, 0.0f));

        PartDefinition rightWing1Def = rightWingDef.addOrReplaceChild("right_wing1", CubeListBuilder.create()
                        .texOffs(66, 0).addBox(-1.0f, -1.0f, -1.0f, 2.0f, 4.0f, 5.0f, true),
                PartPose.offsetAndRotation(6.0f, 0.0f, 0.0f, 0.0f, -1.5708f, -0.436332f));

        PartDefinition rightWing2Def = rightWing1Def.addOrReplaceChild("right_wing2", CubeListBuilder.create()
                        .texOffs(81, 0).addBox(-0.5f, 0.0f, -1.5f, 1.0f, 2.0f, 8.0f, true),
                PartPose.offsetAndRotation(0.5f, 0.0f, 3.5f, 0.6109f, -0.48f, 0.0f));

        PartDefinition rightWing3Def = rightWing2Def.addOrReplaceChild("right_wing3", CubeListBuilder.create()
                        .texOffs(101, 0).addBox(-0.5f, -1.1f, -0.5f, 1.0f, 2.0f, 8.0f, true),
                PartPose.offsetAndRotation(0.0f, 1.0f, 6.5f, -0.5672f, -0.3054f, 0.0f));

        PartDefinition rightWing4Def = rightWing3Def.addOrReplaceChild("right_wing4", CubeListBuilder.create()
                        .texOffs(60, 13).addBox(-0.4f, -0.8f, -4.0f, 1.0f, 1.0f, 19.0f, true),
                PartPose.offsetAndRotation(0.0f, 0.0f, 7.5f, -0.7418f, 0.0f, 0.0f));

        rightWing4Def.addOrReplaceChild("right_wing4_leather", CubeListBuilder.create()
                        .texOffs(95, 40).addBox(0.0f, 0.0f, 0.0f, 0.001f, 5.0f, 14.0f, true),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));

        PartDefinition rightWingStrut1Def = rightWing3Def.addOrReplaceChild("right_wing_strut1", CubeListBuilder.create()
                        .texOffs(83, 12).addBox(-0.4f, -0.5f, -0.5f, 1.0f, 1.0f, 16.0f, true),
                PartPose.offsetAndRotation(0.0f, 1.0f, 7.0f, -1.0036f, 0.0f, 0.0f));

        rightWingStrut1Def.addOrReplaceChild("right_wing_strut1_leather", CubeListBuilder.create()
                        .texOffs(95, 34).addBox(0.05f, 0.0f, 0.0f, 0.001f, 5.0f, 14.0f, true),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));

        PartDefinition rightWingStrut2Def = rightWing3Def.addOrReplaceChild("right_wing_strut2", CubeListBuilder.create()
                        .texOffs(83, 12).addBox(-0.4f, -0.5f, -0.5f, 1.0f, 1.0f, 16.0f, true),
                PartPose.offsetAndRotation(0.0f, 1.0f, 6.0f, -1.309f, 0.0f, 0.0f));

        rightWingStrut2Def.addOrReplaceChild("right_wing_strut2_leather", CubeListBuilder.create()
                        .texOffs(93, 25).addBox(0.1f, 0.0f, -1.0f, 0.001f, 6.0f, 16.0f, true),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));

        PartDefinition rightWingStrut3Def = rightWing3Def.addOrReplaceChild("right_wing_strut3", CubeListBuilder.create()
                        .texOffs(83, 12).addBox(-0.4f, -0.5f, -0.5f, 1.0f, 1.0f, 16.0f, true),
                PartPose.offsetAndRotation(0.0f, 1.0f, 5.0f, -1.6581f, 0.0f, 0.0f));

        rightWingStrut3Def.addOrReplaceChild("right_wing_strut3_leather", CubeListBuilder.create()
                        .texOffs(93, 19).addBox(0.15f, 0.0f, 0.0f, 0.001f, 6.0f, 15.0f, true),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));

        PartDefinition rightStrutLowestDef = rightWing2Def.addOrReplaceChild("right_strut_lowest", CubeListBuilder.create()
                        .texOffs(104, 12).addBox(0.1f, 0.0f, -0.5f, 1.0f, 12.0f, 1.0f, true),
                PartPose.offsetAndRotation(-0.5f, 1.0f, 2.0f, -0.3491f, 0.0f, 0.0f));

        rightStrutLowestDef.addOrReplaceChild("right_strut_lowest_leather1", CubeListBuilder.create()
                        .texOffs(79, 28).addBox(0.0f, -1.0f, 0.0f, 0.001f, 12.0f, 6.0f, true),
                PartPose.offsetAndRotation(0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));

        rightStrutLowestDef.addOrReplaceChild("right_strut_lowest_leather2", CubeListBuilder.create()
                        .texOffs(60, 25).addBox(0.0f, -1.0f, -9.0f, 0.001f, 12.0f, 9.0f, true),
                PartPose.offsetAndRotation(0.5f, 0.0f, 0.0f, 0.0f, 0.2618f, 0.0f));

        return LayerDefinition.create(meshDef, 128, 64);
    }

    @Override
    public void setupAnim(T entity, float ageInTicks, WingsState state) {
        super.setupAnim(entity, ageInTicks, state);

        if (state.status == State.IDLE || state.status == State.CROUCHING) {
            leftWing3.xRot = (float) Math.toRadians(-60);
        }
        if (state.status == State.FLYING) {
            leftWing3.xRot = (float) Math.toRadians(-32.5);
        }
        rightWing3.xRot = leftWing3.xRot;
    }
}
