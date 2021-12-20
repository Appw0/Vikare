package me.appw.vikare.mixin;

import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.ViCore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(EntityLivingBase.class)
public abstract class EntityLivingBaseMixin extends Entity {

    @Shadow protected abstract boolean isPlayer();

    public EntityLivingBaseMixin(World worldIn) {
        super(worldIn);
    }

    @ModifyVariable(method = "updateElytra",
            name = "flag",
            at = @At(value = "STORE", ordinal = 2))
    private boolean updateElytra_flag(boolean flag) {
        return WingItem.hasWorkingWings((EntityLivingBase)(Object)this); // hehe funni cast
    }
}
