package com.honeyluck.ain.events;

import com.honeyluck.ain.Aincraft;
import com.honeyluck.ain.client.gui.GuiRaceSelect;
import com.honeyluck.ain.common.capability.CapabilityFairy;
import com.honeyluck.ain.common.capability.FairyProvider;
import com.honeyluck.ain.common.capability.IFairy;
import com.honeyluck.ain.common.enums.EnumRace;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Aincraft.MOD_ID)
public class AincraftEvents {


    @SubscribeEvent
    public static void onPlayerUpdate(LivingEvent.LivingUpdateEvent e) {
        if(e.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.getEntityLiving();
            IFairy handler = CapabilityFairy.get(player);
            handler.update();
            if(handler.getRace() == EnumRace.NONE) {
                Minecraft.getMinecraft().displayGuiScreen(new GuiRaceSelect());
            }
        }
    }

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> e) {
        Entity entity = e.getObject();
        if (entity instanceof EntityPlayer) {
            e.addCapability(new ResourceLocation(Aincraft.MOD_ID, "fairy"), new FairyProvider(new CapabilityFairy((EntityPlayer) entity)));
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        NBTTagCompound nbt = (NBTTagCompound) CapabilityFairy.CAPABILITY.getStorage().writeNBT(CapabilityFairy.CAPABILITY, event.getOriginal().getCapability(CapabilityFairy.CAPABILITY, null), null);
        CapabilityFairy.CAPABILITY.getStorage().readNBT(CapabilityFairy.CAPABILITY, event.getEntityPlayer().getCapability(CapabilityFairy.CAPABILITY, null), null, nbt);
    }


}
