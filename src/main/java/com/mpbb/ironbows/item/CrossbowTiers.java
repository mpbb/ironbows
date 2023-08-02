package com.mpbb.ironbows.item;

import java.util.function.Supplier;

import com.mpbb.ironbows.config.Config;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public enum CrossbowTiers implements BowTier {

	IRON(Config.IRON_CROSSBOW_DURABILITY, Config.IRON_CROSSBOW_DAMAGE_BONUS, 1, Ingredient.of(Items.IRON_INGOT)),
	GOLD(Config.GOLDEN_CROSSBOW_DURABILITY, Config.GOLDEN_CROSSBOW_DAMAGE_BONUS, 2, Ingredient.of(Items.GOLD_INGOT)),
	DIAMOND(Config.DIAMOND_CROSSBOW_DURABILITY, Config.DIAMOND_CROSSBOW_DAMAGE_BONUS, 2, Ingredient.of(Items.DIAMOND)),
	EMERALD(Config.EMERALD_CROSSBOW_DURABILITY, Config.EMERALD_CROSSBOW_DAMAGE_BONUS, 2, Ingredient.of(Items.EMERALD)),
	NETHERITE(Config.NETHERITE_CROSSBOW_DURABILITY, Config.NETHERITE_CROSSBOW_DAMAGE_BONUS, 2, Ingredient.of(Items.NETHERITE_INGOT));

	Supplier<Integer> uses;
	Supplier<Double> damageBonus;
	private final int enchantmentValue;
	private final Ingredient repairIngredient;

	private CrossbowTiers(Supplier<Integer> durability, Supplier<Double> damageBonus, int enchantmentValue,
			Ingredient repairIngredient) {
		this.uses = durability;
		this.damageBonus = damageBonus;
		this.enchantmentValue = enchantmentValue;
		this.repairIngredient = repairIngredient;
	}

	public int getUses() {
		return this.uses.get().intValue();
	}

	public float getAttackDamageBonus() {
		return this.damageBonus.get().floatValue();
	}

	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	public Ingredient getRepairIngredient() {
		return this.repairIngredient;
	}
}
