package me.appw.vikare.core.config;


import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

// TODO: Split this awful config into server/client sides for proper synchronization
public class VikareConfig {
    public static class Common {
        public final ForgeConfigSpec.ConfigValue<Boolean> armorSlows;
        public final ForgeConfigSpec.ConfigValue<Double> maxSlowedMultiplier;
        public final ForgeConfigSpec.ConfigValue<Double> wingsSpeed;
        public final ForgeConfigSpec.ConfigValue<Integer> wingsDurability;
        public final ForgeConfigSpec.ConfigValue<Double> wingsAcceleration;
        public final ForgeConfigSpec.ConfigValue<Double> exhaustionAmount;
        public final ForgeConfigSpec.ConfigValue<Double> rollAmount;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            // TODO: Backport this fix, as configs no longer endlessly duplicate!
            this.armorSlows = builder.define("armorSlows", true);
            this.maxSlowedMultiplier = builder.defineInRange("maxSlowedMultiplier", 3, 0, Double.MAX_VALUE);
            this.wingsSpeed = builder.defineInRange("wingsSpeed", 0.05, 0, Double.MAX_VALUE);
            this.wingsDurability = builder.defineInRange("wingsDurability", 431, 0, Integer.MAX_VALUE);
            this.wingsAcceleration = builder.defineInRange("wingsAcceleration", 0.05, 0, Double.MAX_VALUE);
            this.exhaustionAmount = builder.defineInRange("exhaustionAmount", 0.05, 0, Double.MAX_VALUE);
            this.rollAmount = builder.defineInRange("rollAmount", 1.0, 0, Double.MAX_VALUE);
            builder.pop();
        }
    }

    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static {
        Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON = commonSpecPair.getLeft();
        COMMON_SPEC = commonSpecPair.getRight();
    }
}
