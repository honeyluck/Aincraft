package com.honeyluck.ain.config;

import com.honeyluck.ain.Aincraft;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Aincraft.MOD_ID, name = "Aincraft")
public class AincraftConfig {

    @Config.LangKey("config.misc")
    public static final Misc MISC = new Misc();

    public static class Misc {

        @Config.LangKey("config.misc.font")
        public boolean font = true;
    }

    @Mod.EventBusSubscriber(modid = Aincraft.MOD_ID)
    private static class EventHandler {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(Aincraft.MOD_ID)) {
                ConfigManager.sync(Aincraft.MOD_ID, Config.Type.INSTANCE);
            }
        }
    }
}
