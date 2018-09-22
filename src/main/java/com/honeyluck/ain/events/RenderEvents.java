package com.honeyluck.ain.events;

import com.honeyluck.ain.Aincraft;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderEvents {

    @SubscribeEvent
    public void guiOverlayEventPre(RenderGameOverlayEvent.Pre e) {

        EntityPlayer player = Minecraft.getMinecraft().player;
        World world = Minecraft.getMinecraft().world;
        if(world != null && player!=null && !player.isCreative() && !player.isSpectator()) {

            if(e.getType() == ElementType.HEALTH || e.getType() == ElementType.EXPERIENCE || e.getType() == ElementType.FOOD || e.getType() == ElementType.ARMOR ) {
                e.setCanceled(true);
            }

        }

    }

}
