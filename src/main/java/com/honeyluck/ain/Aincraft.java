package com.honeyluck.ain;

import com.honeyluck.ain.proxy.CommonProxy;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Aincraft.MOD_ID, name = Aincraft.MOD_NAME, version = Aincraft.MOD_VERSION, dependencies="required-after:lucraftcore")
public class Aincraft {
    public static final String MOD_ID = "ain";
    public static final String MOD_NAME = "Aincraft";
    public static final String MOD_VERSION = "Alpha 1.0";

    @SidedProxy(clientSide = "com.honeyluck.ain.proxy.ClientProxy", serverSide = "com.honeyluck.ain.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static Side side = FMLCommonHandler.instance().getSide();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {

    }
}
