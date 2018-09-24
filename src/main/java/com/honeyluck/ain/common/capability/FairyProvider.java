package com.honeyluck.ain.common.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class FairyProvider implements ICapabilitySerializable<NBTTagCompound> {

    private IFairy capability;

    public FairyProvider(IFairy capability) {
        this.capability = capability;
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return CapabilityFairy.CAPABILITY != null && capability == CapabilityFairy.CAPABILITY;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityFairy.CAPABILITY ? CapabilityFairy.CAPABILITY.cast(this.capability) : null;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        return (NBTTagCompound) CapabilityFairy.CAPABILITY.getStorage().writeNBT(CapabilityFairy.CAPABILITY, capability, null);
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        CapabilityFairy.CAPABILITY.getStorage().readNBT(CapabilityFairy.CAPABILITY, capability, null, nbt);
    }
}

