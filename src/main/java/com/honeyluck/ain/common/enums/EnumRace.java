package com.honeyluck.ain.common.enums;

public enum EnumRace {

    NONE("None"),
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

    public static EnumRace getRace(String name) {
        for(EnumRace race : EnumRace.values()) {
            if(race.getRaceName() == name) {
                return race;
            }
        }
        return null;
    }
}
