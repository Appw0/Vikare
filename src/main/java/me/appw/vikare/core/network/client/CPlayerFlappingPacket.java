package me.appw.vikare.core.network.client;

import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.network.NetworkHandler;
import me.appw.vikare.core.network.server.SPlayerFlappingPacket;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.util.ICuriosHelper;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CPlayerFlappingPacket {

    private FlappingState state;

    public CPlayerFlappingPacket(FlappingState state) {
        this.state = state;
    }

    public static void encode(CPlayerFlappingPacket packet, PacketBuffer buffer) {
        buffer.writeEnumValue(packet.state);
    }

    public static CPlayerFlappingPacket decode(PacketBuffer buffer) { return new CPlayerFlappingPacket(buffer.readEnumValue(FlappingState.class)); }

    public static void send(FlappingState state) {
        NetworkHandler.INSTANCE.send(PacketDistributor.SERVER.noArg(), new CPlayerFlappingPacket(state));
    }

    public static void handle(CPlayerFlappingPacket message, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity sender = ctx.get().getSender();

            if (sender != null) {
                Optional<ImmutableTriple<String, Integer, ItemStack>> equippedCurio = CuriosApi.getCuriosHelper().findEquippedCurio(stack -> stack.getItem() instanceof WingItem, sender);
                if (equippedCurio.isPresent()) {
                    ImmutableTriple<String, Integer, ItemStack> equippedWings = equippedCurio.get();
                    WingItem wingItem = (WingItem) equippedWings.right.getItem();
                    if (!sender.isCreative() && !WingItem.FREE_FLIGHT.contains(wingItem)) {
                        sender.addExhaustion(VikareConfig.COMMON.exhaustionAmount.get());
                    }

                    if (message.state != FlappingState.NONE) {
                        SPlayerFlappingPacket.send(sender, message.state);
                    }

                    if (WingItem.MELTS.contains(wingItem) && VikareConfig.COMMON.wingsDurability.get() > 0 && sender.ticksExisted % 20 == 0 && wingItem.isUsable(equippedWings.right)) {
                        equippedWings.right.damageItem(1, sender, p -> CuriosApi.getCuriosHelper().onBrokenCurio(equippedWings.left, equippedWings.middle, p));
                    }
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }

    public enum FlappingState {
        NONE, STARTED, ENDED
    }
}
