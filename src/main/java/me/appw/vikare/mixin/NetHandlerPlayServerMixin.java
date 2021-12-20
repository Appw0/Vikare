package me.appw.vikare.mixin;

import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.ViCore;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetHandlerPlayServer.class)
public abstract class NetHandlerPlayServerMixin {
    @Shadow public EntityPlayerMP player;

    @Inject(at = @At(value = "INVOKE",
                target = "Lnet/minecraft/entity/player/EntityPlayerMP;getItemStackFromSlot(Lnet/minecraft/inventory/EntityEquipmentSlot;)Lnet/minecraft/item/ItemStack;"),
            method = "processEntityAction")
    private void processEntityAction_getItemStackFromSlot(CallbackInfo ci) {
        if (WingItem.hasWorkingWings(this.player)) {
            this.player.setElytraFlying();
        }
    }
}
