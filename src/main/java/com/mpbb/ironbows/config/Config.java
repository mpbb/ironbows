package com.mpbb.ironbows.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
		public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
		public static final ForgeConfigSpec SPEC;
		
		public static ForgeConfigSpec.ConfigValue<Double> IRON_BOW_DAMAGE_BONUS;
		public static ForgeConfigSpec.ConfigValue<Double> GOLDEN_BOW_DAMAGE_BONUS;
		public static ForgeConfigSpec.ConfigValue<Double> DIAMOND_BOW_DAMAGE_BONUS;
		public static ForgeConfigSpec.ConfigValue<Double> EMERALD_BOW_DAMAGE_BONUS;
		public static ForgeConfigSpec.ConfigValue<Double> NETHERITE_BOW_DAMAGE_BONUS;
		
		public static ForgeConfigSpec.ConfigValue<Integer> IRON_BOW_DURABILITY;
		public static ForgeConfigSpec.ConfigValue<Integer> GOLDEN_BOW_DURABILITY;
		public static ForgeConfigSpec.ConfigValue<Integer> DIAMOND_BOW_DURABILITY;
		public static ForgeConfigSpec.ConfigValue<Integer> EMERALD_BOW_DURABILITY;
		public static ForgeConfigSpec.ConfigValue<Integer> NETHERITE_BOW_DURABILITY;
		
		public static ForgeConfigSpec.ConfigValue<Double> IRON_CROSSBOW_DAMAGE_BONUS;
		public static ForgeConfigSpec.ConfigValue<Double> GOLDEN_CROSSBOW_DAMAGE_BONUS;
		public static ForgeConfigSpec.ConfigValue<Double> DIAMOND_CROSSBOW_DAMAGE_BONUS;
		public static ForgeConfigSpec.ConfigValue<Double> EMERALD_CROSSBOW_DAMAGE_BONUS;
		public static ForgeConfigSpec.ConfigValue<Double> NETHERITE_CROSSBOW_DAMAGE_BONUS;
		
		public static ForgeConfigSpec.ConfigValue<Integer> IRON_CROSSBOW_DURABILITY;
		public static ForgeConfigSpec.ConfigValue<Integer> GOLDEN_CROSSBOW_DURABILITY;
		public static ForgeConfigSpec.ConfigValue<Integer> DIAMOND_CROSSBOW_DURABILITY;
		public static ForgeConfigSpec.ConfigValue<Integer> EMERALD_CROSSBOW_DURABILITY;
		public static ForgeConfigSpec.ConfigValue<Integer> NETHERITE_CROSSBOW_DURABILITY;

		static
		{
			IRON_BOW_DAMAGE_BONUS = BUILDER.defineInRange("Iron Bow damage bonus", 1.0f, 0.0f, 100.0f);
			GOLDEN_BOW_DAMAGE_BONUS = BUILDER.defineInRange("Golden Bow damage bonus", 1.5f, 0.0f, 100.0f);
			DIAMOND_BOW_DAMAGE_BONUS = BUILDER.defineInRange("Diamond Bow damage bonus", 2.5f, 0.0f, 100.0f);
			EMERALD_BOW_DAMAGE_BONUS = BUILDER.defineInRange("Emerald Bow damage bonus", 3.0f, 0.0f, 100.0f);
			NETHERITE_BOW_DAMAGE_BONUS = BUILDER.defineInRange("Netherite Bow damage bonus", 5.0f, 0.0f, 100.0f);
			
			IRON_BOW_DURABILITY = BUILDER.define("Iron Bow durability", 768);
			GOLDEN_BOW_DURABILITY = BUILDER.define("Golden Bow durability", 576);
			DIAMOND_BOW_DURABILITY = BUILDER.define("Diamond Bow durability", 1920);
			EMERALD_BOW_DURABILITY = BUILDER.define("Emerald Bow durability", 2304);
			NETHERITE_BOW_DURABILITY = BUILDER.define("Netherite Bow durability", 3456);
			
			IRON_CROSSBOW_DAMAGE_BONUS = BUILDER.defineInRange("Iron Crossbow damage bonus", 1.0f, 0.0f, 100.0f);
			GOLDEN_CROSSBOW_DAMAGE_BONUS = BUILDER.defineInRange("Golden Crossbow damage bonus", 1.5f, 0.0f, 100.0f);
			DIAMOND_CROSSBOW_DAMAGE_BONUS = BUILDER.defineInRange("Diamond Crossbow damage bonus", 2.5f, 0.0f, 100.0f);
			EMERALD_CROSSBOW_DAMAGE_BONUS = BUILDER.defineInRange("Emerald Crossbow damage bonus", 3.0f, 0.0f, 100.0f);
			NETHERITE_CROSSBOW_DAMAGE_BONUS = BUILDER.defineInRange("Netherite Crossbow damage bonus", 5.0f, 0.0f, 100.0f);
			
			IRON_CROSSBOW_DURABILITY = BUILDER.define("Iron Crossbow durability", 768);
			GOLDEN_CROSSBOW_DURABILITY = BUILDER.define("Golden Crossbow durability", 576);
			DIAMOND_CROSSBOW_DURABILITY = BUILDER.define("Diamond Crossbow durability", 1920);
			EMERALD_CROSSBOW_DURABILITY = BUILDER.define("Emerald Crossbow durability", 2304);
			NETHERITE_CROSSBOW_DURABILITY = BUILDER.define("Netherite Crossbow durability", 3456);
			
			SPEC = BUILDER.build();
		}
}
