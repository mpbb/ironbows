package com.mpbb.ironbows.item;

import java.util.function.Supplier;

import com.mpbb.ironbows.config.Config;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public enum CrossbowTiers implements BowTier {

	IRON(465 * 2, Config.IRON_CROSSBOW_DAMAGE_BONUS, 1, Ingredient.of(Items.IRON_INGOT)),
	GOLD(465 / 6, Config.GOLDEN_CROSSBOW_DAMAGE_BONUS, 2, Ingredient.of(Items.GOLD_INGOT)),
	DIAMOND(465 * 8, Config.DIAMOND_CROSSBOW_DAMAGE_BONUS, 2, Ingredient.of(Items.DIAMOND)),
	EMERALD(465 * 9, Config.EMERALD_CROSSBOW_DAMAGE_BONUS, 2, Ingredient.of(Items.EMERALD)),
	NETHERITE(465 * 12, Config.NETHERITE_CROSSBOW_DAMAGE_BONUS, 2, Ingredient.of(Items.NETHERITE_INGOT));

	private final int uses;
	Supplier<Float> damageBonus;
	private final int enchantmentValue;
	private final Ingredient repairIngredient;

	private CrossbowTiers(int durability, Supplier<Float> damageBonus, int enchantmentValue,
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
