package com.mpbb.ironbows.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
		public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
		
		public static final ForgeConfigSpec.ConfigValue<Double> IRON_BOW_DAMAGE_BONUS;
		public static final ForgeConfigSpec.ConfigValue<Double> GOLDEN_BOW_DAMAGE_BONUS;
		public static final ForgeConfigSpec.ConfigValue<Double> DIAMOND_BOW_DAMAGE_BONUS;
		public static final ForgeConfigSpec.ConfigValue<Double> EMERALD_BOW_DAMAGE_BONUS;
		public static final ForgeConfigSpec.ConfigValue<Double> NETHERITE_BOW_DAMAGE_BONUS;
		
		public static final ForgeConfigSpec.ConfigValue<Double> IRON_CROSSBOW_DAMAGE_BONUS;
		public static final ForgeConfigSpec.ConfigValue<Double> GOLDEN_CROSSBOW_DAMAGE_BONUS;
		public static final ForgeConfigSpec.ConfigValue<Double> DIAMOND_CROSSBOW_DAMAGE_BONUS;
		public static final ForgeConfigSpec.ConfigValue<Double> EMERALD_CROSSBOW_DAMAGE_BONUS;
		public static final ForgeConfigSpec.ConfigValue<Double> NETHERITE_CROSSBOW_DAMAGE_BONUS;

		static
		{
			IRON_BOW_DAMAGE_BONUS = BUILDER.defineInRange("Iron Bow damage bonus", 1.0f, 0.0f, Float.MAX_VALUE);
			GOLDEN_BOW_DAMAGE_BONUS = BUILDER.defineInRange("Golden Bow damage bonus", 1.5f, 0.0f, Float.MAX_VALUE);
			DIAMOND_BOW_DAMAGE_BONUS = BUILDER.defineInRange("Diamond Bow damage bonus", 2.5f, 0.0f, Float.MAX_VALUE);
			EMERALD_BOW_DAMAGE_BONUS = BUILDER.defineInRange("Emerald Bow damage bonus", 3.0f, 0.0f, Float.MAX_VALUE);
			NETHERITE_BOW_DAMAGE_BONUS = BUILDER.defineInRange("Netherite Bow damage bonus", 5.0f, 0.0f, Float.MAX_VALUE);
			
			IRON_CROSSBOW_DAMAGE_BONUS = BUILDER.defineInRange("Iron Crossbow damage bonus", 1.0f, 0.0f, Float.MAX_VALUE);
			GOLDEN_CROSSBOW_DAMAGE_BONUS = BUILDER.defineInRange("Golden Crossbow damage bonus", 1.5f, 0.0f, Float.MAX_VALUE);
			DIAMOND_CROSSBOW_DAMAGE_BONUS = BUILDER.defineInRange("Diamond Crossbow damage bonus", 2.5f, 0.0f, Float.MAX_VALUE);
			EMERALD_CROSSBOW_DAMAGE_BONUS = BUILDER.defineInRange("Emerald Crossbow damage bonus", 3.0f, 0.0f, Float.MAX_VALUE);
			NETHERITE_CROSSBOW_DAMAGE_BONUS = BUILDER.defineInRange("Netherite Crossbow damage bonus", 5.0f, 0.0f, Float.MAX_VALUE);
		}
		
		public static final ForgeConfigSpec SPEC = BUILDER.build();
}
