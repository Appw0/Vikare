package me.appw.vikare.core.network;

import me.appw.vikare.Vikare;
import me.appw.vikare.core.network.client.CPlayerFlappingPacket;
import me.appw.vikare.core.network.server.SPlayerFlappingPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworkHandler {

    private static final String PROTOCOL_VERSION = "1";
//    private static int id = 0;
    public static SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(Vikare.MODID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void register() {
        INSTANCE.registerMessage(0, CPlayerFlappingPacket.class, CPlayerFlappingPacket::encode, CPlayerFlappingPacket::decode, CPlayerFlappingPacket::handle);
        INSTANCE.registerMessage(1, SPlayerFlappingPacket.class, SPlayerFlappingPacket::encode, SPlayerFlappingPacket::decode, SPlayerFlappingPacket::handle);
    }
}
