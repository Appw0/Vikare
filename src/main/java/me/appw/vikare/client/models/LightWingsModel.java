package me.appw.vikare.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.LivingEntity;

public class LightWingsModel<T extends LivingEntity> extends WingsModel<T> {

    private final ModelPart rightWingMain;
    private final ModelPart rightWing1;
    private final ModelPart rightWing2;
    private final ModelPart rightWing3;
    private final ModelPart rightWing4;
    private final ModelPart rightWing5;
    private final ModelPart leftWingMain;
    private final ModelPart leftWing1;
    private final ModelPart leftWing2;
    private final ModelPart leftWing3;
    private final ModelPart leftWing4;
    private final ModelPart leftWing5;

    public LightWingsModel(ModelPart root) {
        super(root);
        this.rightWingMain = rightWing.getChild("right_wing_main");
        this.rightWing1 = this.rightWingMain.getChild("right_wing1");
        this.rightWing2 = this.rightWingMain.getChild("right_wing2");
        this.rightWing3 = this.rightWingMain.getChild("right_wing3");
        this.rightWing4 = this.rightWingMain.getChild("right_wing4");
        this.rightWing5 = this.rightWingMain.getChild("right_wing5");
        this.leftWingMain = leftWing.getChild("left_wing_main");
        this.leftWing1 = this.leftWingMain.getChild("left_wing1");
        this.leftWing2 = this.leftWingMain.getChild("left_wing2");
        this.leftWing3 = this.leftWingMain.getChild("left_wing3");
        this.leftWing4 = this.leftWingMain.getChild("left_wing4");
        this.leftWing5 = this.leftWingMain.getChild("left_wing5");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDef = WingsModel.createPartialLayer();
        PartDefinition rootDef = meshDef.getRoot();
        PartDefinition rightWingDef = rootDef.getChild("right_wing");
        PartDefinition leftWingDef = rootDef.getChild("left_wing");

        PartDefinition rightWingMainDef = rightWingDef.addOrReplaceChild("right_wing_main", CubeListBuilder.create(),
                PartPose.offsetAndRotation(8.0f, 0.0f, 0.0f, 0.0f, 0.0f, -0.836332f));

        rightWingMainDef.addOrReplaceChild("right_wing1", CubeListBuilder.create()
                        .texOffs(26, 18).addBox(-1.0f, -4.0f, 0.0f, 2.0f, 13.0f, 0.001f, true),
                PartPose.offsetAndRotation(-3.0f, -1.0f, 1.0f, 0.0f, 0.0f, 0.3054f));

        rightWingMainDef.addOrReplaceChild("right_wing2", CubeListBuilder.create()
                        .texOffs(25, 12).addBox(-1.5f, -4.0f, 0.0f, 3.0f, 19.0f, 0.001f, true),
                PartPose.offsetAndRotation(-6.0f, -3.0f, 1.0f, 0.0f, 0.0f, 0.48f));

        rightWingMainDef.addOrReplaceChild("right_wing3", CubeListBuilder.create()
                        .texOffs(25, 8).addBox(-1.5f, -4.0f, 0.0f, 3.0f, 23.0f, 0.001f, true),
                PartPose.offsetAndRotation(-9.5f, -5.0f, 1.0f, 0.0f, 0.0f, 0.6981f));

        rightWingMainDef.addOrReplaceChild("right_wing4", CubeListBuilder.create()
                        .texOffs(19, 16).addBox(-1.0f, -4.0f, 0.0f, 2.0f, 15.0f, 0.001f, true),
                PartPose.offsetAndRotation(-12.0f, -7.75f, 1.0f, 0.0f, 0.0f, 0.9599f));

        rightWingMainDef.addOrReplaceChild("right_wing5", CubeListBuilder.create()
                        .texOffs(12, 21).addBox(-0.5f, -2.0f, 0.0f, 2.0f, 10.0f, 0.001f, true),
                PartPose.offsetAndRotation(-12.25f, -11.75f, 1.0f, 0.0f, 0.0f, 1.0908f));

        PartDefinition leftWingMainDef = leftWingDef.addOrReplaceChild("left_wing_main", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-8.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.836332f));

        leftWingMainDef.addOrReplaceChild("left_wing1", CubeListBuilder.create()
                        .texOffs(26, 18).addBox(-1.0f, -4.0f, 0.0f, 2.0f, 13.0f, 0.001f),
                PartPose.offsetAndRotation(3.0f, -1.0f, 1.0f, 0.0f, 0.0f, -0.3054f));

        leftWingMainDef.addOrReplaceChild("left_wing2", CubeListBuilder.create()
                        .texOffs(25, 12).addBox(-1.5f, -4.0f, 0.0f, 3.0f, 19.0f, 0.001f),
                PartPose.offsetAndRotation(6.0f, -3.0f, 1.0f, 0.0f, 0.0f, -0.48f));

        leftWingMainDef.addOrReplaceChild("left_wing3", CubeListBuilder.create()
                        .texOffs(25, 8).addBox(-1.5f, -4.0f, 0.0f, 3.0f, 23.0f, 0.001f),
                PartPose.offsetAndRotation(9.5f, -5.0f, 1.0f, 0.0f, 0.0f, -0.6981f));

        leftWingMainDef.addOrReplaceChild("left_wing4", CubeListBuilder.create()
                        .texOffs(19, 16).addBox(-1.0f, -4.0f, 0.0f, 2.0f, 15.0f, 0.001f),
                PartPose.offsetAndRotation(12.0f, -7.75f, 1.0f, 0.0f, 0.0f, -0.9599f));

        leftWingMainDef.addOrReplaceChild("left_wing5", CubeListBuilder.create()
                        .texOffs(12, 21).addBox(-1.5f, -2.0f, 0.0f, 2.0f, 10.0f, 0.001f),
                PartPose.offsetAndRotation(12.25f, -11.75f, 1.0f, 0.0f, 0.0f, -1.0908f));

        return LayerDefinition.create(meshDef, 32, 32);
    }
}
