package me.appw.vikare.core.network.client;


import io.netty.buffer.ByteBuf;
import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.ViCore;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.network.NetworkWrapper;
import me.appw.vikare.core.network.server.SPlayerFlappingPacket;
import me.appw.vikare.core.registry.WingTypes;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.PacketThreadUtil;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.Arrays;

public class CPlayerFlappingPacket implements IMessage {

    public FlappingState state;

    public CPlayerFlappingPacket() {}

    public CPlayerFlappingPacket(FlappingState state) {
        this.state = state;
    }

    @Override
    public void toBytes(ByteBuf buffer) {
        buffer.writeInt(state.ordinal());
    }

    @Override
    public void fromBytes(ByteBuf buffer) {
        this.state = FlappingState.values()[buffer.readInt()];
    }

    public static void send(FlappingState state) {
        NetworkWrapper.INSTANCE.sendToServer(new CPlayerFlappingPacket(state));
    }

    public static class CPlayerFlappingPacketHandler implements IMessageHandler<CPlayerFlappingPacket, IMessage> {
        @Override
        public IMessage onMessage(CPlayerFlappingPacket message, MessageContext ctx) {

            ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> {
                EntityPlayerMP player = ctx.getServerHandler().player;
                ItemStack wings = ViCore.getWings(player);
                WingTypes.WingType wingType = ((WingItem) wings.getItem()).getWingType();
                if (!wings.isEmpty()) {
                    if (!player.isCreative() && wingType.hasFreeFlight()) {
                        player.addExhaustion((float) VikareConfig.exhaustionAmount);
                    }
                }

                if (message.state != FlappingState.NONE) {
                    SPlayerFlappingPacket.send(player, message.state == FlappingState.STARTED);
                }

                if (wingType.doesMelt() && VikareConfig.wingsDurability > 0 && player.ticksExisted % 20 == 0 && WingItem.isUsable(wings)) {
                    wings.damageItem(1, player);
                }
            });

            return null;
        }
    }

     public enum FlappingState {
        NONE, STARTED, ENDED
    }
}
