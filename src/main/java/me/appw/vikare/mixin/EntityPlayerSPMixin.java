package me.appw.vikare.mixin;

import com.mojang.authlib.GameProfile;
import me.appw.vikare.Vikare;
import me.appw.vikare.core.ViCore;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.world.World;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayerSP.class)
public abstract class EntityPlayerSPMixin extends EntityPlayer {

    @Shadow @Final public NetHandlerPlayClient connection;

    public EntityPlayerSPMixin(World worldIn, GameProfile gameProfileIn) {
        super(worldIn, gameProfileIn);
    }

    @Inject(at = @At(value = "INVOKE_ASSIGN",
                target = "Lnet/minecraft/client/entity/EntityPlayerSP;getItemStackFromSlot(Lnet/minecraft/inventory/EntityEquipmentSlot;)Lnet/minecraft/item/ItemStack;"),
            method = "onLivingUpdate")
    private void onLivingUpdate_getItemStackFromSlot(CallbackInfo ci) {
        ItemStack chestStack = this.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
        if (!(chestStack.getItem() == Items.ELYTRA && ItemElytra.isUsable(chestStack)) && ViCore.hasWorkingWings(this)) {
            this.connection.sendPacket(new CPacketEntityAction(this, CPacketEntityAction.Action.START_FALL_FLYING));
        }
    }
}
