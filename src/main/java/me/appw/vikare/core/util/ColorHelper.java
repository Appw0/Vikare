package me.appw.vikare.core.util;

import net.minecraft.item.EnumDyeColor;

public class ColorHelper {
    public static int rgbToDecimal(float[] rgb) {
        return (((int) (rgb[0] * 255F) << 16) | ((int) (rgb[1] * 255F) << 8) | (int) (rgb[2] * 255F));
    }

    public static int dyeToDecimal(EnumDyeColor color) {
        float[] rgb = color.getColorComponentValues();

        return (((int) (rgb[0] * 255F) << 16) | ((int) (rgb[1] * 255F) << 8) | (int) (rgb[2] * 255F));
    }
}
