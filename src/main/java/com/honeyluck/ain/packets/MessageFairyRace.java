package com.honeyluck.ain.packets;

import com.honeyluck.ain.common.capability.CapabilityFairy;
import com.honeyluck.ain.common.capability.IFairy;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageFairyRace implements IMessage {

    private int race;

    public MessageFairyRace(int ID) {
        this.race = ID;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(race);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.race = buf.readInt();
    }

    public static class Handler implements IMessageHandler<MessageFairyRace, IMessage> {
        public Handler() {}

        @Override
        public IMessage onMessage(MessageFairyRace message, MessageContext ctx) {
            ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> {
                IFairy capability = CapabilityFairy.get(ctx.getServerHandler().player);
                    if(capability != null) {
                        capability.setRace(message.race);
                    }
            });

            return null;
        }
    }
}
