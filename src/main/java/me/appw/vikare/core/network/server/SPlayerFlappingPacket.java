package me.appw.vikare.core.network.server;


public class SPlayerFlappingPacket {
//    private int entityId;
//    private boolean isFlapping;
//
//    public SPlayerFlappingPacket(int entityId, boolean isFlapping) {
//        this.entityId = entityId;
//        this.isFlapping = isFlapping;
//    }
//
//    public static void encode(SPlayerFlappingPacket packet, PacketBuffer buffer) {
//        buffer.writeInt(packet.entityId);
//        buffer.writeBoolean(packet.isFlapping);
//    }
//
//    public static SPlayerFlappingPacket decode(PacketBuffer buffer) {
//        return new SPlayerFlappingPacket(buffer.readInt(), buffer.readBoolean());
//    }
//
//    public static void send(ServerPlayerEntity player, FlappingState startedFlying) {
//        NetworkHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY.with(() -> player), new SPlayerFlappingPacket(player.getEntityId(), startedFlying == FlappingState.STARTED));
//    }
//
//    public static void handle(SPlayerFlappingPacket message, Supplier<NetworkEvent.Context> ctx) {
//        ctx.get().enqueueWork(() -> {
//            ClientWorld world = Minecraft.getInstance().world;
//
//            if (world != null) {
//                Entity entity = world.getEntityByID(message.entityId);
//                if (entity instanceof PlayerEntity && entity != Minecraft.getInstance().player) {
//                    PlayerEntity player = (PlayerEntity) entity;
//                    Optional<ImmutableTriple<String, Integer, ItemStack>> equippedCurio = CuriosApi.getCuriosHelper().findEquippedCurio(stack -> stack.getItem() instanceof WingItem, player);
//                    if (equippedCurio.isPresent()) {
//                        WingItemCapability wingCap = (WingItemCapability) equippedCurio.get().right.getCapability(CuriosCapability.ITEM).resolve().get();
//                        wingCap.setForcedFlap(message.isFlapping);
//                    }
//                }
//            }
//        });
//        ctx.get().setPacketHandled(true);
//    }
}
