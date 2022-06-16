package me.appw.vikare.core.network.client;

import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.network.NetworkHandler;
import me.appw.vikare.core.network.server.SPlayerFlappingPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.Optional;
import java.util.function.Supplier;

public class CPlayerFlappingPacket {

    private FlappingState state;

    public CPlayerFlappingPacket(FlappingState state) {
        this.state = state;
    }

    public static void encode(CPlayerFlappingPacket packet, FriendlyByteBuf buffer) {
        buffer.writeEnum(packet.state);
    }

    public static CPlayerFlappingPacket decode(FriendlyByteBuf buffer) { return new CPlayerFlappingPacket(buffer.readEnum(FlappingState.class)); }

    public static void send(FlappingState state) {
        NetworkHandler.INSTANCE.send(PacketDistributor.SERVER.noArg(), new CPlayerFlappingPacket(state));
    }

    public static void handle(CPlayerFlappingPacket message, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer sender = ctx.get().getSender();

            if (sender != null) {
                Optional<SlotResult> slotOpt = CuriosApi.getCuriosHelper().findFirstCurio(sender, stack -> stack.getItem() instanceof WingItem);
                slotOpt.ifPresent(slotResult -> {
                    ItemStack wings = slotResult.stack();
                    if (!sender.isCreative() && !wings.is(WingItem.FREE_FLIGHT)) {
                        sender.causeFoodExhaustion(VikareConfig.COMMON.exhaustionAmount.get());
                    }

                    if (message.state != FlappingState.NONE) {
                        SPlayerFlappingPacket.send(sender, message.state);
                    }

                    if (wings.is(WingItem.MELTS) && VikareConfig.COMMON.wingsDurability.get() > 0 && sender.tickCount % 20 == 0 && WingItem.isUsable(wings)) {
                        wings.hurtAndBreak(1, sender, p -> CuriosApi.getCuriosHelper().onBrokenCurio(slotResult.slotContext()));
                    }
                });
            }
        });
        ctx.get().setPacketHandled(true);
    }

    public enum FlappingState {
        NONE, STARTED, ENDED
    }
}
