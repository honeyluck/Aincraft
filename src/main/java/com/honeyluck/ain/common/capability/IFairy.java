package com.honeyluck.ain.common.capability;

import com.honeyluck.ain.common.enums.EnumRace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

public interface IFairy extends INBTSerializable<NBTTagCompound> {

    void update();

    //Flight Stuff
    int getTicksFlying();
    void setTicksFlying(int ticks);
    boolean isFlying();
    void setFlying(boolean flying);

    //Races
    EnumRace getRace();
    void setRace(String name);

    //Returns Player
    EntityPlayer getPlayer();

    //Mana
    float getMana();
    void setMana(float mana);
    float getMaxMana();
    void setMaxMana(float mana);

    //Exp
    int getExp();
    void setExp(int exp);
    int getLevel();
    void setLevel(int level);
}
