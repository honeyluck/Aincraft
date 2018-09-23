package com.honeyluck.ain.client;

import com.honeyluck.ain.Aincraft;
import com.honeyluck.ain.common.enums.EnumHealthColour;
import com.honeyluck.ain.util.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class HudRenderer {

    public static void render() {
        TextureManager textureManager = Minecraft.getMinecraft().getTextureManager();
        EntityPlayer player = Minecraft.getMinecraft().player;
        FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
        String name = player.getName();
        int nameWidth = fontRenderer.getStringWidth(name);
        float xScale = (float) 25 / nameWidth;
        float percent = (player.getHealth() / player.getMaxHealth());
        EnumHealthColour color = EnumHealthColour.getColour(percent);
        //System.out.println(percent);

        textureManager.bindTexture(new ResourceLocation(Aincraft.MOD_ID + ":textures/hud/health.png"));
        GlStateManager.pushMatrix();
        RenderUtils.setTransparent();
        RenderUtils.drawModalRectWithCustomSizedTexture(4,4, 0, 0, 156, 19, 256, 256);
        GlStateManager.color(color.getR(), color.getG(), color.getB());

        int width = (int) (119 * (player.getHealth() / player.getMaxHealth()));

        RenderUtils.drawModalRectWithCustomSizedTexture(36, 10, 32, 21, width, 3, 256, 256);
        if(width >= 60) {
            RenderUtils.drawModalRectWithCustomSizedTexture((int) (width + 36), 11, 151, 22, 1, 2, 256, 256);
        } else {
            RenderUtils.drawModalRectWithCustomSizedTexture((int) (width + 36), 11, 91, 22, 1, 2, 256, 256);
        }
        GlStateManager.color(1, 1, 1);
        GlStateManager.color((float) 72/255, (float) 140/255, (float) 172/255);
        RenderUtils.drawModalRectWithCustomSizedTexture(36, 14, 32, 24, 120, 3, 256, 256);

        GlStateManager.scale(xScale, 0.75, 1);
        fontRenderer.drawString(name, (int)(40/xScale - nameWidth) / 2, 15, 0xFFFFFFFF);
        GlStateManager.scale(1, 1, 1);
        GlStateManager.popMatrix();
    }


}
