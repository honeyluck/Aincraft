package com.honeyluck.ain.client.gui;

import com.honeyluck.ain.common.capability.CapabilityFairy;
import com.honeyluck.ain.common.capability.IFairy;
import com.honeyluck.ain.common.enums.EnumRace;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.config.GuiButtonExt;

import java.io.IOException;

public class GuiRaceSelect extends GuiScreen {

    public static EnumRace[] races = new EnumRace[]{EnumRace.SALAMANDER, EnumRace.SPRIGGAN, EnumRace.SYLPH};
    private EntityPlayer player = Minecraft.getMinecraft().player;
    private IFairy handler = CapabilityFairy.get(player);
    private int index = 0;


    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawCenteredString(mc.fontRenderer, races[index].getRaceName(), 100, 200, 0xFFFFFFFF);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void onGuiClosed() {
        if (handler.getRace() != null) {
            super.onGuiClosed();
        }
    }


    @Override
    public void initGui() {

        buttonList.clear();
        String select = "Select";
        buttonList.add(new GuiButtonExt(0, this.width / 2 - (mc.fontRenderer.getStringWidth(select) * 2) / 2, (this.height / 2 - mc.fontRenderer.FONT_HEIGHT / 2) + 60, mc.fontRenderer.getStringWidth(select) * 2, mc.fontRenderer.FONT_HEIGHT * 2, select));
        String next = ">";
        buttonList.add(new GuiButtonExt(1, (this.width / 2 - (mc.fontRenderer.getStringWidth(next) * 2) / 2) + 40, (this.height / 2 - mc.fontRenderer.FONT_HEIGHT * 2) + 74, mc.fontRenderer.getStringWidth(next) * 2, mc.fontRenderer.FONT_HEIGHT * 2, next));
        String previous = "<";
        buttonList.add(new GuiButtonExt(2, (this.width / 2 - mc.fontRenderer.getStringWidth(previous)) - 40, (this.height / 2 - mc.fontRenderer.FONT_HEIGHT) + 65, mc.fontRenderer.getStringWidth(previous) * 2, mc.fontRenderer.FONT_HEIGHT * 2, previous));
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case 0:
                handler.setRace(races[index].getRaceName());
                Minecraft.getMinecraft().displayGuiScreen(null);
                System.out.println(player.getName() + " selected: " + races[index].getRaceName());
            case 1:
                int i = index + 1;
                if(i > races.length - 1) {
                    index = 0;
                } else {
                    index++;
                }
            case 2:
                int j = index - 1;
                if(j < 0) {
                    index = races.length - 1;
                } else {
                    index--;
                }
        }
        super.actionPerformed(button);
    }
}
