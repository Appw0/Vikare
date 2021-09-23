package me.appw.vikare.core.network.server;

import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.capability.WingItemCapability;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.network.NetworkHandler;
import me.appw.vikare.core.network.client.CPlayerFlappingPacket.FlappingState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;

import java.util.Optional;
import java.util.function.Supplier;

public class SPlayerFlappingPacket {
    private int entityId;
    private boolean isFlapping;

    public SPlayerFlappingPacket(int entityId, boolean isFlapping) {
        this.entityId = entityId;
        this.isFlapping = isFlapping;
    }

    public static void encode(SPlayerFlappingPacket packet, PacketBuffer buffer) {
        buffer.writeInt(packet.entityId);
        buffer.writeBoolean(packet.isFlapping);
    }

    public static SPlayerFlappingPacket decode(PacketBuffer buffer) {
        return new SPlayerFlappingPacket(buffer.readInt(), buffer.readBoolean());
    }

    public static void send(ServerPlayerEntity player, FlappingState startedFlying) {
        NetworkHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY.with(() -> player), new SPlayerFlappingPacket(player.getEntityId(), startedFlying == FlappingState.STARTED));
    }

    public static void handle(SPlayerFlappingPacket message, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ClientWorld world = Minecraft.getInstance().world;

            if (world != null) {
                Entity entity = world.getEntityByID(message.entityId);
                if (entity instanceof PlayerEntity && entity != Minecraft.getInstance().player) {
                    PlayerEntity player = (PlayerEntity) entity;
                    Optional<ImmutableTriple<String, Integer, ItemStack>> equippedCurio = CuriosApi.getCuriosHelper().findEquippedCurio(stack -> stack.getItem() instanceof WingItem, player);
                    if (equippedCurio.isPresent()) {
                        WingItemCapability wingCap = (WingItemCapability) equippedCurio.get().right.getCapability(CuriosCapability.ITEM).resolve().get();
                        wingCap.setForcedFlap(message.isFlapping);
                    }
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
