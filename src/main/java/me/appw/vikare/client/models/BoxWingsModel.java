package me.appw.vikare.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.LivingEntity;

public class BoxWingsModel<T extends LivingEntity> extends WingsModel<T> {
    public BoxWingsModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDef = new MeshDefinition();
        PartDefinition rootDef = meshDef.getRoot();
        rootDef.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(-8.0F, -1.0F, -1.0F, 10.0F, 20.0F, 2.0F), PartPose.offset(0.0f, 5.0f, 0.0f));
        rootDef.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(22, 22).addBox(-2.0F, -1.0F, -1.0F, 10.0F, 20.0F, 2.0F), PartPose.offset(0.0f, 5.0f, 0.0f));
        return LayerDefinition.create(meshDef, 64, 64);
    }
}
