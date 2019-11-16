package com.honeyluck.ain;

import com.honeyluck.ain.events.Registries;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Aincraft.MOD_ID)
public class Aincraft {
    public static final String MOD_ID = "ain";
    public static final String MOD_NAME = "Aincraft";
    public static final String MOD_VERSION = "0.0.1";

    public ItemGroup tabItems = new ItemGroup("AinItems"){
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Registries.blackIron);
        }
    };

    public Aincraft() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }
}
