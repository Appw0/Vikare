package me.appw.vikare.core;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import me.appw.vikare.Vikare;
import me.appw.vikare.common.items.WingItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.12.2")
@IFMLLoadingPlugin.Name("Vikare")
public class ViCore implements IFMLLoadingPlugin {

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        MixinBootstrap.init();
        Mixins.addConfiguration(Vikare.MODID + ".mixins.json");
        MixinEnvironment.getDefaultEnvironment().setObfuscationContext("searge");
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

    public static ItemStack getWings(EntityLivingBase entity) {
        if (entity instanceof EntityPlayer) {
            IBaublesItemHandler handler = BaublesApi.getBaublesHandler((EntityPlayer) entity);
            for(int i = 0; i < handler.getSlots(); i++) {
                if (!handler.getStackInSlot(i).isEmpty() && handler.getStackInSlot(i).getItem() instanceof WingItem) {
                    return handler.getStackInSlot(i);
                }
            }
        }
        return ItemStack.EMPTY;
    }

    public static boolean hasWorkingWings(EntityLivingBase entity) {
        ItemStack wings = getWings(entity);
        if (!wings.isEmpty()) {
            return WingItem.isUsable(wings);
        }
        return false;
    }
}