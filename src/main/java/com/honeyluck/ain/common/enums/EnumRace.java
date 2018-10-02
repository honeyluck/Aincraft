package com.honeyluck.ain.common.enums;

public enum EnumRace {

    NONE(-1, "None"),
    SALAMANDER(0, "Salamander"),
    SPRIGGAN(1, "Spriggan"),
    SYLPH(2, "Sylph");

    private String raceName;
    private int ID;

    EnumRace(int ID, String raceName) {
        this.raceName = raceName;
        this.ID = ID;
    }

    public String getRaceName() {
        return raceName;
    }

    public int getID() {
        return ID;
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
