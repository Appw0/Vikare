package me.appw.vikare.core.capability;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import me.appw.vikare.common.items.WingItem;
import me.appw.vikare.core.config.VikareConfig;
import me.appw.vikare.core.network.client.CPlayerFlappingPacket;
import me.appw.vikare.core.network.client.CPlayerFlappingPacket.FlappingState;
import me.appw.vikare.core.registry.WingTypes.WingType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import top.theillusivec4.caelus.api.CaelusApi;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nonnull;
import java.util.UUID;

public class WingItemCapability implements ICurio {
    private final ItemStack stack;
    private final WingItem wings;
    private final WingType wingType;
    private final WingsState wingsState = new WingsState();
    private float last_movement = 0.0F;

    public WingItemCapability(ItemStack stack) {
        this.stack = stack;
        wings = (WingItem) stack.getItem();
        wingType = wings.getWingType();
    }

    @Override
    public ItemStack getStack() {
        return stack;
    }  // Why did this return null??? TODO: Look at old versions and see if this returned null there too. because it shouldn't!

    @Override
    public void curioTick(SlotContext context) {
        LivingEntity entity = context.entity();
        if (entity instanceof Player player) {
            boolean tooHungry = player.getFoodData().getFoodLevel() <= 6;   // TODO: backport this because it solves bugs

            if (player.isFallFlying()) {
                wingsState.status = State.FLYING;
                if (player.zza > 0 && !tooHungry) {
                    if (WingItem.isUsable(stack)) applySpeed(player);
                    CPlayerFlappingPacket.send(last_movement == 0 ? FlappingState.STARTED : FlappingState.NONE);
                } else if (last_movement > 0) {
                    CPlayerFlappingPacket.send(FlappingState.ENDED);   // TODO: check if this is getting spammed
                }
                last_movement = player.zza;

                if (player.isShiftKeyDown() && !tooHungry) {   // TODO: implement more assured client->client replication of slowFall. may become unsynced in rare cases?
                    stopFlying(player);
                }
                if (player.getY() > player.level().getMaxBuildHeight() + 64 && player.tickCount % 20 == 0 && stack.is(WingItem.MELTS)) {
                    stack.hurtAndBreak(1, player, p -> CuriosApi.broadcastCurioBreakEvent(context));
                }

                if (!WingItem.isUsable(stack)) {
                    wingsState.broken = true;
                    AttributeInstance gravity = player.getAttribute(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());
                    double adjustedLift = gravity.getValue() * -Mth.cos(player.getXRot() * ((float)Math.PI / 180F));;
                    Vec3 velocity = player.getDeltaMovement().add(0.0D, adjustedLift, 0.0D);
                    player.setDeltaMovement(velocity.x, velocity.y, velocity.z);
                } else {
                    wingsState.broken = false;
                }
            } else {
                if (player.onGround() || player.isInWater()) {
                    wingsState.status = player.isCrouching() ? State.CROUCHING : State.IDLE;
                } else if (wingsState.status == State.SLOWFALL) {
                    player.fallDistance = WingItem.isUsable(stack) ? 0F : Math.min(player.fallDistance, 10F);
                    player.setDeltaMovement(player.getDeltaMovement().x, WingItem.isUsable(stack) ? -0.4 : -1, player.getDeltaMovement().z);
                }
            }
        }
    }

//    @Override   // TODO: decide whether to keep/remove these two functions or to make them a config
//    public List<Component> getSlotsTooltip(List<Component> tooltips) {
//        return List.of();
//    }
//
//    @Override
//    public List<Component> getAttributesTooltip(List<Component> tooltips) {
//        tooltips.set(1, tooltips.get(1).plainCopy().withStyle(ChatFormatting.GRAY));
//        return tooltips;
//    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
        Multimap<Attribute, AttributeModifier> atts = LinkedHashMultimap.create();
        atts.put(CaelusApi.getInstance().getFlightAttribute(), new AttributeModifier(uuid, "Flight modifier", 1.0f, AttributeModifier.Operation.ADDITION));
        return atts;
    }

    @Nonnull
    @Override
    public ICurio.SoundInfo getEquipSound(SlotContext slotContext) {
        return new ICurio.SoundInfo(wingType.equipSound.get(), 1.0f, 1.0f);
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext) { return true; }

    public boolean isShiny() { // TODO: possibly replace this tag with an enchantment, or add tooltip
        return !stack.getOrCreateTag().getBoolean("Dull");
    }

    public WingType getWingType() { return this.wingType; }

    public void stopFlying(Player player) {
        wingsState.status = State.SLOWFALL;
        player.stopFallFlying();
    }

    public void applySpeed(Player player) {
        Vec3 rotation = player.getLookAngle();
        Vec3 velocity = player.getDeltaMovement();
        double modifier = VikareConfig.SERVER.armorSlows.get() ? Mth.clamp(player.getArmorValue() / 10F, 1F, VikareConfig.SERVER.maxSlowedMultiplier.get()) : 1F;
        modifier = player.isInWater() ? 200F : modifier; // TODO: backport this

        velocity = velocity.add(
                rotation.x * (wings.getSpeed() / modifier) + (rotation.x * 1.5D - velocity.x) * wings.getAcceleration(),
                rotation.y * (wings.getSpeed() / modifier) + (rotation.y * 1.5D - velocity.y) * wings.getAcceleration(),
                rotation.z * (wings.getSpeed() / modifier) + (rotation.z * 1.5D - velocity.z) * wings.getAcceleration()
        );

        player.setDeltaMovement(velocity.x, velocity.y, velocity.z);
    }

    public void setForcedFlap(boolean forcedFlap) {
        wingsState.forcedFlap = forcedFlap;
    }

    public WingsState getWingState() {
        return this.wingsState;
    }

    public boolean didFlap() {
        if (wingsState.flapStatus == FlapState.FLAP) {
            wingsState.flapStatus = FlapState.DONE;
            return true;
        }  else {
            return false;
        }
    }

    public static class WingsState {
        public State status = State.IDLE;
        public FlapState flapStatus = FlapState.IDLE;
        public boolean forcedFlap = false;
        public boolean broken = false;
        public float lastMovement = 0.0F;
    }

    public enum State {
        IDLE, CROUCHING, FLYING, SLOWFALL
    }

    public enum FlapState {
        IDLE, FLAP, DONE
    }
}
