package com.honeyluck.ain.proxy;

import com.honeyluck.ain.events.RenderEvents;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

    @Override
    public void init() {
        MinecraftForge.EVENT_BUS.register(new RenderEvents());
    }
}
