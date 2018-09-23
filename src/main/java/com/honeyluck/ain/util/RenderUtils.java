package com.honeyluck.ain.util;

import com.honeyluck.ain.Aincraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;

public class RenderUtils {

    public static void setTransparent() {
        GlStateManager.color(1.0F, 1.0F, 1.0F);
        GlStateManager.enableBlendProfile(GlStateManager.Profile.TRANSPARENT_MODEL);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
    }



    /**
     * Draws a textured rectangle at z = 0. Args: x, y, u, v, width, height, textureWidth, textureHeight
     */
    public static void drawModalRectWithCustomSizedTexture(int x, int y, float u, float v, int width, int height, float textureWidth, float textureHeight)
    {
        float f = 1.0F / textureWidth;
        float f1 = 1.0F / textureHeight;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.pos((double)x, (double)(y + height), 0.0D).tex((double)(u * f), (double)((v + (float)height) * f1)).endVertex();
        bufferbuilder.pos((double)(x + width), (double)(y + height), 0.0D).tex((double)((u + (float)width) * f), (double)((v + (float)height) * f1)).endVertex();
        bufferbuilder.pos((double)(x + width), (double)y, 0.0D).tex((double)((u + (float)width) * f), (double)(v * f1)).endVertex();
        bufferbuilder.pos((double)x, (double)y, 0.0D).tex((double)(u * f), (double)(v * f1)).endVertex();
        tessellator.draw();
    }

    public static void setFont(boolean enabled) {
        Minecraft minecraft = Minecraft.getMinecraft();

        if (minecraft.fontRenderer == null) return;

        ResourceLocation fontLocation = null;

        if(enabled) {
            fontLocation = new ResourceLocation(Aincraft.MOD_ID, "textures/hud/sao font.png");
        }
        else{
            fontLocation = new ResourceLocation("textures/font/ascii.png");
        }

        GameSettings gamesettings = minecraft.gameSettings;
        minecraft.fontRenderer = new FontRenderer(gamesettings, fontLocation, minecraft.getTextureManager(), false);
        if (gamesettings.language != null) {
            minecraft.fontRenderer.setUnicodeFlag(minecraft.isUnicode());
            minecraft.fontRenderer.setBidiFlag(minecraft.getLanguageManager().isCurrentLanguageBidirectional());
        }
        ((IReloadableResourceManager) minecraft.getResourceManager()).registerReloadListener(minecraft.fontRenderer);
    }
}
