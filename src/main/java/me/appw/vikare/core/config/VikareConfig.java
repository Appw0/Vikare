package me.appw.vikare.core.config;


import me.appw.vikare.Vikare;
import me.appw.vikare.core.registry.Items;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

// TODO: Split this awful config into server/client sides for proper synchronization
public class VikareConfig {
    public static class Server {
        public final ForgeConfigSpec.ConfigValue<Boolean> armorSlows;
        public final ForgeConfigSpec.ConfigValue<Double> maxSlowedMultiplier;
        public final ForgeConfigSpec.ConfigValue<Double> wingsSpeed;
        public final ForgeConfigSpec.ConfigValue<Integer> wingsDurability;
        public final ForgeConfigSpec.ConfigValue<Double> wingsAcceleration;
        public final ForgeConfigSpec.ConfigValue<Double> exhaustionAmount;
        public final ForgeConfigSpec.ConfigValue<Boolean> allowLoop;

        public Server(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            // TODO: Backport this fix, as configs no longer endlessly duplicate!
            this.armorSlows = builder.define("armorSlows", true);
            this.maxSlowedMultiplier = builder.defineInRange("maxSlowedMultiplier", 3, 0, Double.MAX_VALUE);
            this.wingsSpeed = builder.defineInRange("wingsSpeed", 0.05, 0, Double.MAX_VALUE);
            this.wingsDurability = builder.defineInRange("wingsDurability", 431, 0, Integer.MAX_VALUE);
            this.wingsAcceleration = builder.defineInRange("wingsAcceleration", 0.05, 0, Double.MAX_VALUE);
            this.exhaustionAmount = builder.defineInRange("exhaustionAmount", 0.05, 0, Double.MAX_VALUE);
            this.allowLoop = builder.define("allowLoop", true);
            builder.pop();
        }

        public static void apply() {
            // This is cringe
            // TODO: Find a better solution to this
            Items.WINGS.getEntries().forEach(wings -> wings.get().maxDamage = VikareConfig.SERVER.wingsDurability.get());
        }
    }

    public static class Client {
        public final ForgeConfigSpec.ConfigValue<Double> rollAmount;

        public Client(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            this.rollAmount = builder.defineInRange("rollAmount", 1.0, 0, Double.MAX_VALUE);
            builder.pop();
        }
    }

    public static final Server SERVER;
    public static final ForgeConfigSpec SERVER_SPEC;

    public static final Client CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;

    static {
        Pair<Server, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Server::new);
        SERVER = commonSpecPair.getLeft();
        SERVER_SPEC = commonSpecPair.getRight();

        Pair<Client, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(Client::new);
        CLIENT = clientSpecPair.getLeft();
        CLIENT_SPEC = clientSpecPair.getRight();
    }

    public static void onConfigUpdate(ModConfigEvent event) {
        if (!(event instanceof ModConfigEvent.Loading) && !(event instanceof ModConfigEvent.Reloading)) return;

        if (event.getConfig().getModId().equals(Vikare.MODID) && event.getConfig().getType().equals(ModConfig.Type.SERVER)) {
            Server.apply();
        }
    }
}
