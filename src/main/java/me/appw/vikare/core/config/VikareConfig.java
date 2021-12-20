package me.appw.vikare.core.config;


import me.appw.vikare.Vikare;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.*;

@Config(modid = Vikare.MODID)
public class VikareConfig {

    @Comment("Whether armor slows flight")
    public static boolean armorSlows = true;

    @Comment({"The max value to slow based on the armor bar",
    "Actual slowdown will range based on the player's armor value and cap at this maximum when 10 armor is reached"})
    @RangeDouble(min = 0.0D)
    public static double maxSlowedMultiplier = 3.0D;

    @Comment("The top speed of flight")
    @RangeDouble(min = 0.0D)
    public static double wingsSpeed = 0.05D;

    @Comment("The durability of wings, zero disables damage entirely")
    @RangeInt(min = 0)
    public static int wingsDurability = 431;

    @Comment("The acceleration the player will undergo to reach top speed")
    @RangeDouble(min = 0.0D)
    public static double wingsAcceleration = 0.05D;

    @Comment("The amount of exhaustion the player receives when flapping")
    @RangeDouble(min = 0.0D)
    public static double exhaustionAmount = 0.05D;

    @Comment({"The multiplier for camera roll",
    "Setting this to a large value will almost certainly give you motion sickness"})
    @RangeDouble(min = 0.0D)
    public static double rollAmount = 1.0D;

    @Comment("free!")
    public static String[] freeFlight = {"flandres", "discords", "zanzas"};

    @Comment("melts")
    public static String[] melts = {"feathered", "dragon", "light", "mechanical_feathered", "mechanical_leather"};
}
