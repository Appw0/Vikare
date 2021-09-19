package me.appw.vikare.core.network.client;

import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.network.NetworkHandler;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.util.ICuriosHelper;

import java.util.Optional;
import java.util.function.Supplier;

public class CPlayerFlappingPacket {

    public static void encode(CPlayerFlappingPacket packet, PacketBuffer buffer) {
    }

    public static CPlayerFlappingPacket decode(PacketBuffer buffer) {
        return new CPlayerFlappingPacket();
    }

    public static void send() {
        NetworkHandler.INSTANCE.send(PacketDistributor.SERVER.noArg(), new CPlayerFlappingPacket());
    }

    public static void handle(CPlayerFlappingPacket message, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity sender = ctx.get().getSender();

            if (sender != null) {
                sender.addExhaustion(VikareConfig.COMMON.exhaustionAmount.get());

                if (VikareConfig.COMMON.wingsDurability.get() > 0 && sender.ticksExisted % 20 == 0) {
                    Optional<ImmutableTriple<String, Integer, ItemStack>> equippedCurio = CuriosApi.getCuriosHelper().findEquippedCurio(stack -> WingItem.MELTS.contains(stack.getItem()), sender);
                    if (equippedCurio.isPresent()) {
                        equippedCurio.get().right.damageItem(1, sender, p -> CuriosApi.getCuriosHelper().onBrokenCurio(equippedCurio.get().left, equippedCurio.get().middle, p));
                    }
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
