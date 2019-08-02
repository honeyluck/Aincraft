package com.honeyluck.ain;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Aincraft.MOD_ID)
public class Aincraft {
    public static final String MOD_ID = "ain";
    public static final String MOD_NAME = "Aincraft";
    public static final String MOD_VERSION = "0.0.1";

    private static final Logger LOGGER = LogManager.getLogger();

    public Aincraft() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Performing Pre-Init Tasks for " + MOD_NAME);

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }
}
