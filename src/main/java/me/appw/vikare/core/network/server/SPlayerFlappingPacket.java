package me.appw.vikare.core.network.server;


import io.netty.buffer.ByteBuf;
import me.appw.vikare.Vikare;
import me.appw.vikare.core.ViCore;
import me.appw.vikare.core.capability.WingItemCapability;
import me.appw.vikare.core.network.NetworkWrapper;
import me.appw.vikare.core.network.client.CPlayerFlappingPacket.FlappingState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SPlayerFlappingPacket implements IMessage {
    private int entityId;
    private boolean isFlapping;

    public SPlayerFlappingPacket() {}

    public SPlayerFlappingPacket(int entityId, boolean isFlapping) {
        this.entityId = entityId;
        this.isFlapping = isFlapping;
    }

    @Override
    public void toBytes(ByteBuf buffer) {
        buffer.writeInt(this.entityId);
        buffer.writeBoolean(this.isFlapping);
    }

    @Override
    public void fromBytes(ByteBuf buffer) {
        this.entityId = buffer.readInt();
        this.isFlapping = buffer.readBoolean();
    }

    public static void send(EntityPlayerMP player, boolean startedFlapping) {
        NetworkWrapper.INSTANCE.sendToAllTracking(new SPlayerFlappingPacket(player.getEntityId(), startedFlapping), player);
    }

    public static class SPlayerFlappingPacketHandler implements IMessageHandler<SPlayerFlappingPacket, IMessage> {
        @Override
        public IMessage onMessage(SPlayerFlappingPacket message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                WorldClient world = Minecraft.getMinecraft().world;
                if (world != null) {
                    Entity entity = world.getEntityByID(message.entityId);
                    if (entity instanceof EntityPlayer && entity != Minecraft.getMinecraft().player) {
                        ItemStack wings = ViCore.getWings((EntityPlayer) entity);
                        if (!wings.isEmpty()) {
                            WingItemCapability wingCap = wings.getCapability(Vikare.WING_ITEM_CAPABILITY, null);
                            if (wingCap != null) {
                                wingCap.setForcedFlap(message.isFlapping);
                            }
                        }
                    }
                }
            });

            return null;
        }
    }
}
