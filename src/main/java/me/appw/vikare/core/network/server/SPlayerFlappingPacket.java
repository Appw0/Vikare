package me.appw.vikare.core.network.server;

import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.capability.WingItemCapability;
import me.appw.vikare.core.network.NetworkHandler;
import me.appw.vikare.core.network.client.CPlayerFlappingPacket.FlappingState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

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
                if (entity instanceof Player player && entity != Minecraft.getInstance().player) {
                    Optional<SlotResult> slotOpt = CuriosApi.getCuriosHelper().findFirstCurio(player, stack -> stack.getItem() instanceof WingItem);
                    slotOpt.flatMap(slotResult -> CuriosApi.getCuriosHelper().getCurio(slotResult.stack())
                                    .filter(curio -> curio instanceof WingItemCapability))
                            .ifPresent(curio -> ((WingItemCapability) curio).setForcedFlap(message.isFlapping));
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
