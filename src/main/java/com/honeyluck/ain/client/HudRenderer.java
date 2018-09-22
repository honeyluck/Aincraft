package com.honeyluck.ain.client;

import com.honeyluck.ain.Aincraft;
import com.honeyluck.ain.util.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class HudRenderer {

    public static void render() {
        TextureManager textureManager = Minecraft.getMinecraft().getTextureManager();
        EntityPlayer player = Minecraft.getMinecraft().player;

        textureManager.bindTexture(new ResourceLocation(Aincraft.MOD_ID + ":textures/hud/health.png"));
        GlStateManager.pushMatrix();
        RenderUtils.setTransparent();
        RenderUtils.drawModalRectWithCustomSizedTexture(4,4, 0, 0, 156, 19, 256, 256);
        GlStateManager.color((float) 139/255, (float) 200/255, (float) 68/255);

        int width = (int) (118 * (player.getHealth() / player.getMaxHealth()));

        RenderUtils.drawModalRectWithCustomSizedTexture(36, 10, 32, 21, width, 3, 256, 256);
        if(width >= 59) {
            RenderUtils.drawModalRectWithCustomSizedTexture((int) (width + 36), 10, 150, 21, 2, 3, 256, 256);
        } else {
            RenderUtils.drawModalRectWithCustomSizedTexture((int) (width + 36), 10, 90, 21, 1, 3, 256, 256);
            RenderUtils.drawModalRectWithCustomSizedTexture((int) (width + 37), 11, 91, 22, 1, 3, 256, 256);
        }
        GlStateManager.color(1, 1, 1);
        GlStateManager.color((float) 72/255, (float) 140/255, (float) 172/255);
        RenderUtils.drawModalRectWithCustomSizedTexture(36, 14, 32, 24, 120, 3, 256, 256);

        GlStateManager.popMatrix();
    }
}
