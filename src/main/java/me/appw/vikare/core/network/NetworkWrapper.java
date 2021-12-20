package me.appw.vikare.core.network;

import me.appw.vikare.core.network.client.CPlayerFlappingPacket;
import me.appw.vikare.core.network.client.CPlayerFlappingPacket.CPlayerFlappingPacketHandler;
import me.appw.vikare.core.network.server.SPlayerFlappingPacket;
import me.appw.vikare.core.network.server.SPlayerFlappingPacket.SPlayerFlappingPacketHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkWrapper {

    public static SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("vikare:main");

    public static void register() {
        INSTANCE.registerMessage(CPlayerFlappingPacketHandler.class, CPlayerFlappingPacket.class, 0, Side.SERVER);
        INSTANCE.registerMessage(SPlayerFlappingPacketHandler.class, SPlayerFlappingPacket.class, 1, Side.CLIENT);
    }
}
