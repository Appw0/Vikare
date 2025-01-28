package me.appw.vikare.mixin;

import me.appw.vikare.core.config.VikareConfig;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Redirect(method = "turn", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Mth;clamp(FFF)F"))
    private float turn_wrapPitch(float number, float lower, float upper) {
        if ((Object) this instanceof LivingEntity entity) {
            if (entity.isFallFlying() && VikareConfig.SERVER.allowLoop.get()) {
                return Mth.wrapDegrees(number);
            }
        }
        return Mth.clamp(number, lower, upper);
    }
}
