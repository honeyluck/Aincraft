package com.honeyluck.ain.common.enums;

public enum EnumRace {

    SALAMANDER("Salamander"),
    SPRIGGAN("Spriggan"),
    SYLPH("Sylph");

    private String raceName;

    EnumRace(String raceName) {
        this.raceName = raceName;
    }

    public String getRaceName() {
        return raceName;
    }
}
