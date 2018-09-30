package com.honeyluck.ain.proxy;

import com.honeyluck.ain.events.AincraftEvents;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

    public void init() {
        MinecraftForge.EVENT_BUS.register(new AincraftEvents());
    }
}
