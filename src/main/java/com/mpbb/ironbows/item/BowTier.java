package com.mpbb.ironbows.item;

import net.minecraft.world.item.crafting.Ingredient;

public interface BowTier {
	   int getUses();

	   float getAttackDamageBonus();

	   int getEnchantmentValue();

	   Ingredient getRepairIngredient();
}
