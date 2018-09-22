package com.honeyluck.ain.events;

import com.honeyluck.ain.client.HudRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderEvents {

    @SubscribeEvent
    public void guiOverlayEventPre(RenderGameOverlayEvent.Pre e) {

        EntityPlayer player = Minecraft.getMinecraft().player;
        World world = Minecraft.getMinecraft().world;
        if(world != null && player!=null && !player.isCreative() && !player.isSpectator()) {

            if(e.getType() == ElementType.HEALTH || e.getType() == ElementType.EXPERIENCE || e.getType() == ElementType.FOOD || e.getType() == ElementType.ARMOR ) {
                //e.setCanceled(true);
            }

        }

    }

    @SubscribeEvent
    public void guiOverlayEventPost(RenderGameOverlayEvent.Post e) {
        EntityPlayer player = Minecraft.getMinecraft().player;
        World world = Minecraft.getMinecraft().world;
        if(world != null && player!=null && !player.isCreative() && !player.isSpectator()) {
            HudRenderer.render();
        }
    }

}
