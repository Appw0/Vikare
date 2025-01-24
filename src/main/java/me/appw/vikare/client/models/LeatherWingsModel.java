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

public class LeatherWingsModel<T extends LivingEntity> extends WingsModel<T> {

    private final ModelPart leftWing1;
    private final ModelPart leftWing2;
    private final ModelPart leftWing3;
    private final ModelPart leftWing4;
    private final ModelPart leftWing4Leather;
    private final ModelPart leftWingStrut1;
    private final ModelPart leftWingStrut1Leather;
    private final ModelPart leftWingStrut2;
    private final ModelPart leftWingStrut2Leather;
    private final ModelPart leftWingStrut3;
    private final ModelPart leftWingStrut3Leather;
    private final ModelPart leftStrutLowest;
    private final ModelPart leftStrutLowestLeather1;
    private final ModelPart leftStrutLowestLeather2;
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

    public LeatherWingsModel(ModelPart root) {
        super(root);
        this.leftWing1 = leftWing.getChild("left_wing1");
        this.leftWing2 = this.leftWing1.getChild("left_wing2");
        this.leftWing3 = this.leftWing2.getChild("left_wing3");
        this.leftWing4 = this.leftWing3.getChild("left_wing4");
        this.leftWing4Leather = this.leftWing4.getChild("left_wing4_leather");
        this.leftWingStrut1 = this.leftWing3.getChild("left_wing_strut1");
        this.leftWingStrut1Leather = this.leftWingStrut1.getChild("left_wing_strut1_leather");
        this.leftWingStrut2 = this.leftWing3.getChild("left_wing_strut2");
        this.leftWingStrut2Leather = this.leftWingStrut2.getChild("left_wing_strut2_leather");
        this.leftWingStrut3 = this.leftWing3.getChild("left_wing_strut3");
        this.leftWingStrut3Leather = this.leftWingStrut3.getChild("left_wing_strut3_leather");
        this.leftStrutLowest = this.leftWing2.getChild("left_strut_lowest");
        this.leftStrutLowestLeather1 = this.leftStrutLowest.getChild("left_strut_lowest_leather1");
        this.leftStrutLowestLeather2 = this.leftStrutLowest.getChild("left_strut_lowest_leather2");
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
                        .texOffs(21, 0).addBox(-1.001f, -1.0f, -1.0f, 2.0f, 4.0f, 5.0f),
                PartPose.offsetAndRotation(-6.0f, 0.0f, 0.0f, 0.0f, 1.5708f, 0.436332f));

        PartDefinition leftWing2Def = leftWing1Def.addOrReplaceChild("left_wing2", CubeListBuilder.create()
                        .texOffs(0, 47).addBox(-0.5f, 0.0f, -1.5f, 1.0f, 2.0f, 8.0f),
                PartPose.offsetAndRotation(-0.5f, 0.0f, 3.5f, 0.6109f, 0.0f, 0.0f));

        PartDefinition leftWing3Def = leftWing2Def.addOrReplaceChild("left_wing3", CubeListBuilder.create()
                        .texOffs(39, 0).addBox(-0.5f, -1.1f, -0.5f, 1.0f, 2.0f, 8.0f),
                PartPose.offsetAndRotation(0.0f, 1.0f, 6.5f, -0.5672f, 0.3054f, 0.0f));

        PartDefinition leftWing4Def = leftWing3Def.addOrReplaceChild("left_wing4", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-0.6f, -0.8f, -4.0f, 1.0f, 1.0f, 19.0f),
                PartPose.offsetAndRotation(0.0f, 0.0f, 7.5f, -0.7418f, 0.0f, 0.0f));

        leftWing4Def.addOrReplaceChild("left_wing4_leather", CubeListBuilder.create()
                        .texOffs(0, 28).addBox(0.0f, 0.0f, 0.0f, 0.001f, 5.0f, 14.0f),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));

        PartDefinition leftWingStrut1Def = leftWing3Def.addOrReplaceChild("left_wing_strut1", CubeListBuilder.create()
                        .texOffs(21, 0).addBox(-0.6f, -0.5f, -0.5f, 1.0f, 1.0f, 16.0f),
                PartPose.offsetAndRotation(0.0f, 1.0f, 7.0f, -1.0036f, 0.0f, 0.0f));

        leftWingStrut1Def.addOrReplaceChild("left_wing_strut1_leather", CubeListBuilder.create()
                        .texOffs(0, 22).addBox(-0.05f, 0.0f, 0.0f, 0.001f, 5.0f, 14.0f),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));

        PartDefinition leftWingStrut2Def = leftWing3Def.addOrReplaceChild("left_wing_strut2", CubeListBuilder.create()
                        .texOffs(21, 0).addBox(-0.6f, -0.5f, -0.5f, 1.0f, 1.0f, 16.0f),
                PartPose.offsetAndRotation(0.0f, 1.0f, 6.0f, -1.309f, 0.0f, 0.0f));

        leftWingStrut2Def.addOrReplaceChild("left_wing_strut2_leather", CubeListBuilder.create()
                        .texOffs(0, 4).addBox(-0.1f, 0.0f, -1.0f, 0.001f, 6.0f, 16.0f),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));

        PartDefinition leftWingStrut3Def = leftWing3Def.addOrReplaceChild("left_wing_strut3", CubeListBuilder.create()
                        .texOffs(21, 0).addBox(-0.6f, -0.5f, -0.5f, 1.0f, 1.0f, 16.0f),
                PartPose.offsetAndRotation(0.0f, 1.0f, 5.0f, -1.6581f, 0.0f, 0.0f));

        leftWingStrut3Def.addOrReplaceChild("left_wing_strut3_leather", CubeListBuilder.create()
                        .texOffs(0, 12).addBox(-0.15f, 0.0f, 0.0f, 0.001f, 6.0f, 15.0f),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));

        PartDefinition leftStrutLowestDef = leftWing2Def.addOrReplaceChild("left_strut_lowest", CubeListBuilder.create()
                        .texOffs(12, 0).addBox(-1.1f, 0.0f, -0.5f, 1.0f, 12.0f, 1.0f),
                PartPose.offsetAndRotation(0.5f, 1.0f, 2.0f, -0.3491f, 0.0f, 0.0f));

        leftStrutLowestDef.addOrReplaceChild("left_strut_lowest_leather1", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(0.0f, -1.0f, 0.0f, 0.001f, 12.0f, 6.0f),
                PartPose.offsetAndRotation(-0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));

        leftStrutLowestDef.addOrReplaceChild("left_strut_lowest_leather2", CubeListBuilder.create()
                        .texOffs(28, 28).addBox(0.0f, -1.0f, -9.0f, 0.001f, 12.0f, 9.0f),
                PartPose.offsetAndRotation(-0.5f, 0.0f, 0.0f, 0.0f, -0.2618f, 0.0f));

        PartDefinition rightWing1Def = rightWingDef.addOrReplaceChild("right_wing1", CubeListBuilder.create()
                        .texOffs(21, 0).addBox(-0.999f, -1.0f, -1.0f, 2.0f, 4.0f, 5.0f, true),
                PartPose.offsetAndRotation(6.0f, 0.0f, 0.0f, 0.0f, -1.5708f, -0.436332f));

        PartDefinition rightWing2Def = rightWing1Def.addOrReplaceChild("right_wing2", CubeListBuilder.create()
                        .texOffs(0, 47).addBox(-0.5f, 0.0f, -1.5f, 1.0f, 2.0f, 8.0f, true),
                PartPose.offsetAndRotation(0.5f, 0.0f, 3.5f, 0.6109f, 0.0f, 0.0f));

        PartDefinition rightWing3Def = rightWing2Def.addOrReplaceChild("right_wing3", CubeListBuilder.create()
                        .texOffs(39, 0).addBox(-0.5f, -1.1f, -0.5f, 1.0f, 2.0f, 8.0f, true),
                PartPose.offsetAndRotation(0.0f, 1.0f, 6.5f, -0.5672f, -0.3054f, 0.0f));

        PartDefinition rightWing4Def = rightWing3Def.addOrReplaceChild("right_wing4", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-0.4f, -0.8f, -4.0f, 1.0f, 1.0f, 19.0f, true),
                PartPose.offsetAndRotation(0.0f, 0.0f, 7.5f, -0.7418f, 0.0f, 0.0f));

        rightWing4Def.addOrReplaceChild("right_wing4_leather", CubeListBuilder.create()
                        .texOffs(0, 28).addBox(0.0f, 0.0f, 0.0f, 0.001f, 5.0f, 14.0f, true),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));

        PartDefinition rightWingStrut1Def = rightWing3Def.addOrReplaceChild("right_wing_strut1", CubeListBuilder.create()
                        .texOffs(21, 0).addBox(-0.4f, -0.5f, -0.5f, 1.0f, 1.0f, 16.0f, true),
                PartPose.offsetAndRotation(0.0f, 1.0f, 7.0f, -1.0036f, 0.0f, 0.0f));

        rightWingStrut1Def.addOrReplaceChild("right_wing_strut1_leather", CubeListBuilder.create()
                        .texOffs(0, 22).addBox(0.05f, 0.0f, 0.0f, 0.001f, 5.0f, 14.0f, true),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));

        PartDefinition rightWingStrut2Def = rightWing3Def.addOrReplaceChild("right_wing_strut2", CubeListBuilder.create()
                        .texOffs(21, 0).addBox(-0.4f, -0.5f, -0.5f, 1.0f, 1.0f, 16.0f, true),
                PartPose.offsetAndRotation(0.0f, 1.0f, 6.0f, -1.309f, 0.0f, 0.0f));

        rightWingStrut2Def.addOrReplaceChild("right_wing_strut2_leather", CubeListBuilder.create()
                        .texOffs(0, 4).addBox(0.1f, 0.0f, -1.0f, 0.001f, 6.0f, 16.0f, true),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));

        PartDefinition rightWingStrut3Def = rightWing3Def.addOrReplaceChild("right_wing_strut3", CubeListBuilder.create()
                        .texOffs(21, 0).addBox(-0.4f, -0.5f, -0.5f, 1.0f, 1.0f, 16.0f, true),
                PartPose.offsetAndRotation(0.0f, 1.0f, 5.0f, -1.6581f, 0.0f, 0.0f));

        rightWingStrut3Def.addOrReplaceChild("right_wing_strut3_leather", CubeListBuilder.create()
                        .texOffs(0, 12).addBox(0.15f, 0.0f, 0.0f, 0.001f, 6.0f, 15.0f, true),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));

        PartDefinition rightStrutLowestDef = rightWing2Def.addOrReplaceChild("right_strut_lowest", CubeListBuilder.create()
                        .texOffs(12, 0).addBox(0.1f, 0.0f, -0.5f, 1.0f, 12.0f, 1.0f, true),
                PartPose.offsetAndRotation(-0.5f, 1.0f, 2.0f, -0.3491f, 0.0f, 0.0f));

        rightStrutLowestDef.addOrReplaceChild("right_strut_lowest_leather1", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(0.0f, -1.0f, 0.0f, 0.001f, 12.0f, 6.0f, true),
                PartPose.offsetAndRotation(0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));

        rightStrutLowestDef.addOrReplaceChild("right_strut_lowest_leather2", CubeListBuilder.create()
                        .texOffs(28, 28).addBox(0.0f, -1.0f, -9.0f, 0.001f, 12.0f, 9.0f, true),
                PartPose.offsetAndRotation(0.5f, 0.0f, 0.0f, 0.0f, 0.2618f, 0.0f));

        return LayerDefinition.create(meshDef, 64, 64);
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
