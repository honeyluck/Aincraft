package com.honeyluck.ain.client.gui;

import com.honeyluck.ain.common.capability.CapabilityFairy;
import com.honeyluck.ain.common.capability.IFairy;
import com.honeyluck.ain.common.enums.EnumRace;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

public class GuiRaceSelect extends GuiScreen {

    public static EnumRace[] races = new EnumRace[] {EnumRace.SALAMANDER, EnumRace.SPRIGGAN, EnumRace.SYLPH};
    private EntityPlayer player = Minecraft.getMinecraft().player;
    private IFairy handler = CapabilityFairy.get(player);


    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void onGuiClosed() {
        if(handler.getRace() != null) {
            super.onGuiClosed();
        }
    }
}
