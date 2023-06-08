package com.mpbb.ironbows.item;

import com.mpbb.ironbows.config.Config;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public enum BowTiers implements BowTier {

	IRON(Config.IRON_BOW_DURABILITY, Config.IRON_BOW_DAMAGE_BONUS, 1, Ingredient.of(Items.IRON_INGOT)),
	GOLD(Config.GOLDEN_BOW_DURABILITY, Config.GOLDEN_BOW_DAMAGE_BONUS, 2, Ingredient.of(Items.GOLD_INGOT)),
	DIAMOND(Config.DIAMOND_BOW_DURABILITY, Config.DIAMOND_BOW_DAMAGE_BONUS, 2, Ingredient.of(Items.DIAMOND)),
	EMERALD(Config.EMERALD_BOW_DURABILITY, Config.EMERALD_BOW_DAMAGE_BONUS, 2, Ingredient.of(Items.EMERALD)),
	NETHERITE(Config.NETHERITE_BOW_DURABILITY, Config.NETHERITE_BOW_DAMAGE_BONUS, 2,
			Ingredient.of(Items.NETHERITE_INGOT));

	private final ConfigValue<Integer> uses;
	private final ConfigValue<Float> damageBonus;
	private final int enchantmentValue;
	private final Ingredient repairIngredient;

	private BowTiers(ConfigValue<Integer> durability, ConfigValue<Float> damageBonus, int enchantmentValue,
			Ingredient repairIngredient) {
		this.uses = durability;
		this.damageBonus = damageBonus;
		this.enchantmentValue = enchantmentValue;
		this.repairIngredient = repairIngredient;
	}

	public int getUses() {
		try {
			return this.uses.get();
		} catch (Exception e) {
			return this.uses.getDefault();
		}
	}

	public float getAttackDamageBonus() {
		try {
			return this.damageBonus.get();
		} catch (Exception e) {
			return this.damageBonus.getDefault();
		}
	}

	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	public Ingredient getRepairIngredient() {
		return this.repairIngredient;
	}
}
