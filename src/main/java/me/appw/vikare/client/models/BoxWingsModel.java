package me.appw.vikare.client.models;


public class BoxWingsModel extends WingsModel {

    public BoxWingsModel() {
        textureHeight = 64;
        textureWidth = 64;

        rightWing.setTextureOffset(22, 0).addBox(-8.0F, -1.0F, -1.0F, 10, 20, 2, true);
        leftWing.setTextureOffset(22, 22).addBox(-2.0F, -1.0F, -1.0F, 10, 20, 2, false);
    }
}
