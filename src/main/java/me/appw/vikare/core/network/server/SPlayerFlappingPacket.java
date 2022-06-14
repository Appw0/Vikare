package me.appw.vikare.core.network.server;

import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.capability.WingItemCapability;
import me.appw.vikare.core.network.NetworkHandler;
import me.appw.vikare.core.network.client.CPlayerFlappingPacket.FlappingState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;
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

    public static void encode(SPlayerFlappingPacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.entityId);
        buffer.writeBoolean(packet.isFlapping);
    }

    public static SPlayerFlappingPacket decode(FriendlyByteBuf buffer) {
        return new SPlayerFlappingPacket(buffer.readInt(), buffer.readBoolean());
    }

    public static void send(ServerPlayer player, FlappingState startedFlying) {
        NetworkHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY.with(() -> player), new SPlayerFlappingPacket(player.getId(), startedFlying == FlappingState.STARTED));
    }

    public static void handle(SPlayerFlappingPacket message, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ClientLevel world = Minecraft.getInstance().level;

            if (world != null) {
                Entity entity = world.getEntity(message.entityId);
                if (entity instanceof Player && entity != Minecraft.getInstance().player) {
                    Player player = (Player) entity;
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
