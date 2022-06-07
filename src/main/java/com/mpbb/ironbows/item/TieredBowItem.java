package com.mpbb.ironbows.item;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;

public class TieredBowItem extends BowItem {
	private final BowTier tier;

	public TieredBowItem(BowTier tier, Properties properties) {
		super(properties.durability(tier.getUses()));
		this.tier = tier;
	}

	@Override
	public AbstractArrow customArrow(AbstractArrow arrow) {
		arrow.setBaseDamage(arrow.getBaseDamage() + this.tier.getAttackDamageBonus());
		return arrow;
	}
	
	@Override
	public int getEnchantmentValue() {
		return super.getEnchantmentValue();
	}
	
	@Override
	public boolean isValidRepairItem(ItemStack p_41402_, ItemStack p_41403_) {
		return this.tier.getRepairIngredient().test(p_41403_);
	}
}
