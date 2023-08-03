package com.mpbb.ironbows.item;

import java.util.function.Supplier;

import com.mpbb.ironbows.config.Config;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public enum BowTiers implements BowTier {

	IRON(384 * 2, Config.IRON_BOW_DAMAGE_BONUS, 1, Ingredient.of(Items.IRON_INGOT)),
	GOLD(384 / 6, Config.GOLDEN_BOW_DAMAGE_BONUS, 2, Ingredient.of(Items.GOLD_INGOT)),
	DIAMOND(384 * 8, Config.DIAMOND_BOW_DAMAGE_BONUS, 2, Ingredient.of(Items.DIAMOND)),
	EMERALD(384 * 9, Config.EMERALD_BOW_DAMAGE_BONUS, 2, Ingredient.of(Items.EMERALD)),
	NETHERITE(384 * 12, Config.NETHERITE_BOW_DAMAGE_BONUS, 2,
			Ingredient.of(Items.NETHERITE_INGOT));

	private final int uses;
	private Supplier<Double> damageBonus;
	private final int enchantmentValue;
	private final Ingredient repairIngredient;

	private BowTiers(int durability, Supplier<Double> damageBonus, int enchantmentValue,
			Ingredient repairIngredient) {
		this.uses = durability;
		this.damageBonus = damageBonus;
		this.enchantmentValue = enchantmentValue;
		this.repairIngredient = repairIngredient;
	}

	public int getUses() {
		return this.uses;
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
