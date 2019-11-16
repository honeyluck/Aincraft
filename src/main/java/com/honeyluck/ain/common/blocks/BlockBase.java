package com.honeyluck.ain.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
public class BlockBase extends Block{

    public BlockBase(Properties properties, SoundType sound, float hardness, float resistance) {
        super(properties.hardnessAndResistance(hardness, resistance).sound(sound));
    }
}
