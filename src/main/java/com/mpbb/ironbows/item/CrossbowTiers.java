package com.mpbb.ironbows.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public enum CrossbowTiers implements BowTier {

	   IRON(768, 1.0f, 1, Ingredient.of(Items.IRON_INGOT)),
	   GOLD(576, 1.5f, 2, Ingredient.of(Items.GOLD_INGOT)),
	   DIAMOND(1920, 2.5f, 2, Ingredient.of(Items.DIAMOND)),
	   EMERALD(2304, 3.0f, 2, Ingredient.of(Items.EMERALD)),
	   NETHERITE(3456, 5.0f, 2, Ingredient.of(Items.NETHERITE_INGOT));

	   private final int uses;
	   private final float damage;
	   private final int enchantmentValue;
	   private final Ingredient repairIngredient;

	   private CrossbowTiers(int uses, float damage, int enchantmentValue, Ingredient repairIngredient) {
	      this.uses = uses;
	      this.damage = damage;
	      this.enchantmentValue = enchantmentValue;
	      this.repairIngredient = repairIngredient;
	   }

	   public int getUses() {
	      return this.uses;
	   }

	   public float getAttackDamageBonus() {
	      return this.damage;
	   }

	   public int getEnchantmentValue() {
	      return this.enchantmentValue;
	   }

	   public Ingredient getRepairIngredient() {
	      return this.repairIngredient;
	   }
}
