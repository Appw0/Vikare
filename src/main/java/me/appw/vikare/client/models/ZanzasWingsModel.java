package me.appw.vikare.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.LivingEntity;

public class ZanzasWingsModel<T extends LivingEntity> extends WingsModel<T> {

    private final ModelPart leftWing1;
    private final ModelPart leftWing2;
    private final ModelPart leftWingCircle;
    private final ModelPart leftWingCube;
    private final ModelPart rightWing1;
    private final ModelPart rightWing2;
    private final ModelPart rightWingCircle;
    private final ModelPart rightWingCube;

    public ZanzasWingsModel(ModelPart root) {
        super(root);
        this.leftWing1 = leftWing.getChild("left_wing1");
        this.leftWing2 = this.leftWing1.getChild("left_wing2");
        this.leftWingCircle = this.leftWing2.getChild("left_wing_circle");
        this.leftWingCube = this.leftWingCircle.getChild("left_wing_cube");
        this.rightWing1 = rightWing.getChild("right_wing1");
        this.rightWing2 = this.rightWing1.getChild("right_wing2");
        this.rightWingCircle = this.rightWing2.getChild("right_wing_circle");
        this.rightWingCube = this.rightWingCircle.getChild("right_wing_cube");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDef = WingsModel.createPartialLayer();
        PartDefinition rootDef = meshDef.getRoot();
        PartDefinition rightWingDef = rootDef.getChild("right_wing");
        PartDefinition leftWingDef = rootDef.getChild("left_wing");

        PartDefinition leftWing1Def = leftWingDef.addOrReplaceChild("left_wing1", CubeListBuilder.create()
                        .texOffs(0, 18).addBox(0.0f, -5.0f, 0.25f, 14.0f, 15.0f, 0.001f),
                PartPose.offsetAndRotation(-6.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.436332f));

        PartDefinition leftWing2Def = leftWing1Def.addOrReplaceChild("left_wing2", CubeListBuilder.create()
                        .texOffs(29, 17).addBox(0.0f, -6.0f, 0.25f, 17.0f, 17.0f, 0.001f),
                PartPose.offsetAndRotation(14.0f, 0.0f, 0.0f, 0.0f, -0.2182f, 0.0f));

        PartDefinition leftWingCircleDef = leftWing2Def.addOrReplaceChild("left_wing_circle", CubeListBuilder.create(),
                PartPose.offsetAndRotation(2.0f, 6.0f, 1.0f, 0.0f, 0.0f, 0.0436f));

        leftWingCircleDef.addOrReplaceChild("left_wing_cube", CubeListBuilder.create()
                        .texOffs(0, 34).addBox(-7.5f, -8.5f, 0.25f, 13.0f, 13.0f, 0.001f),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -2.3562f));

        PartDefinition rightWing1Def = rightWingDef.addOrReplaceChild("right_wing1", CubeListBuilder.create()
                        .texOffs(0, 18).addBox(-14.0f, -5.0f, 0.25f, 14.0f, 15.0f, 0.001f).mirror(),
                PartPose.offsetAndRotation(6.0f, 0.0f, 0.0f, 0.0f, 0.0f, -0.436332f));

        PartDefinition rightWing2Def = rightWing1Def.addOrReplaceChild("right_wing2", CubeListBuilder.create()
                        .texOffs(29, 17).addBox(-17.0f, -6.0f, 0.25f, 17.0f, 17.0f, 0.001f).mirror(),
                PartPose.offsetAndRotation(-14.0f, 0.0f, 0.0f, 0.0f, 0.2182f, 0.0f));

        PartDefinition rightWingCircleDef = rightWing2Def.addOrReplaceChild("right_wing_circle", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-2.0f, 6.0f, 1.0f, 0.0f, 0.0f, -0.0436f));

        rightWingCircleDef.addOrReplaceChild("right_wing_cube", CubeListBuilder.create()
                        .texOffs(0, 34).addBox(-5.5f, -8.5f, 0.25f, 13.0f, 13.0f, 0.001f).mirror(),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 2.3562f));

        return LayerDefinition.create(meshDef, 64, 64);
    }
}
