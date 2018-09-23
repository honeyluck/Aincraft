package com.honeyluck.ain.common.capability;

import com.honeyluck.ain.Aincraft;
import com.honeyluck.ain.common.enums.EnumRace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Aincraft.MOD_ID)
public class CapabilityFairy implements IFairy {

    private EntityPlayer player;
    private boolean isFlying;
    private float mana, maxMana;
    private int flyingTicks;
    private String raceName;

    public CapabilityFairy(EntityPlayer player) {
        this.player = player;
    }

    @Override
    public EntityPlayer getPlayer() {
        return this.player;
    }

    @Override
    public void update() {
        if(isFlying()) {
            if(getTicksFlying() >= 0) {
                setTicksFlying(getTicksFlying() + 1);
            }

            if(getTicksFlying() >= 500) {
                setFlying(false);
                setTicksFlying(500);
            }
        }
        if(isFlying() == false) {
            if(getTicksFlying() > 0 && getTicksFlying() <= 500) {
                setTicksFlying(getTicksFlying() - 1);
            }
        }
    }

    @Override
    public float getMana() {
        return this.mana;
    }

    @Override
    public void setMana(float mana) {
        this.mana = mana;
    }

    @Override
    public void setMaxMana(float mana) {
        this.maxMana = mana;
    }

    @Override
    public float getMaxMana() {
        return this.maxMana;
    }

    @Override
    public int getTicksFlying() {
        return flyingTicks;
    }

    @Override
    public void setTicksFlying(int ticks) {
        flyingTicks = ticks;
    }

    @Override
    public boolean isFlying() {
        return this.isFlying;
    }

    @Override
    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    @Override
    public void setRace(String name) {
        this.raceName = name;
    }

    @Override
    public EnumRace getRace() {
        return EnumRace.valueOf(raceName);
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound nbt = new NBTTagCompound();

        nbt.setBoolean("isFlying", isFlying);
        nbt.setInteger("ticksFlying", flyingTicks);
        nbt.setFloat("mana", mana);
        nbt.setFloat("maxMana", maxMana);
        nbt.setString("race", raceName);

        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        setFlying(nbt.getBoolean("isFlying"));
        setTicksFlying(nbt.getInteger("ticksFlying"));
        setMana(nbt.getFloat("mana"));
        setMaxMana(nbt.getFloat("maxMana"));
        setRace(nbt.getString("race"));
    }


}
