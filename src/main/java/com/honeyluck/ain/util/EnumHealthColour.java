package com.honeyluck.ain.util;

public enum EnumHealthColour {

    HEALTHY(1F, 139, 200, 68),
    GOOD(0.75F, 172, 200, 68),
    OKAY(0.625F, 200, 195, 68),
    MEDIUM(0.5F, 208, 200, 16),
    LOW(0.25F, 208, 104, 16),
    BAD(0F, 208, 16, 24);

    private int red;
    private int green;
    private int blue;
    private float percent;

    EnumHealthColour(float healthPercentage, int r, int g, int b) {
        red = r;
        green = g;
        blue = b;
        percent = healthPercentage;
    }

    public float getR() {
        return (float) this.red / 255;
    }

    public float getG() {
        return (float) this.green / 255;
    }

    public float getB() {
        return (float) this.blue / 255;
    }

    private float getPercent() {
        return this.percent;
    }

    public static EnumHealthColour getColour(float percent) {
        for (EnumHealthColour value : EnumHealthColour.values()) {
            if (value.getPercent() <= percent) {
                return value;
            }
        }
        return null;
    }

}
