package com.mpbb.ironbows.item;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

public class TieredBowItem extends BowItem {
	private final BowTier tier;

	public TieredBowItem(BowTier tier, Properties properties) {
		super(properties.durability(tier.getUses()));
		this.tier = tier;
	}
	
	public BowTier getTier() {
		return this.tier;
	}

	@Override
	public AbstractArrow customArrow(AbstractArrow arrow) {
		arrow.setBaseDamage(arrow.getBaseDamage() + this.tier.getAttackDamageBonus());
		return arrow;
	}
	
	@Override
	public int getEnchantmentValue() {
		return this.tier.getEnchantmentValue();
	}
	
	@Override
	public boolean isValidRepairItem(ItemStack p_41402_, ItemStack p_41403_) {
		return this.tier.getRepairIngredient().test(p_41403_);
	}
	
	@Override
	public void appendHoverText(ItemStack p_41421_, TooltipContext p_333372_, List<Component> p_41423_, TooltipFlag p_41424_) {
		p_41423_.add(Component.literal("+" + Float.toString(this.tier.getAttackDamageBonus()) + " ")
				.append(Component.translatable("item.ironbows.damage_tooltip"))
				.withStyle(ChatFormatting.DARK_GREEN));
		super.appendHoverText(p_41421_, p_333372_, p_41423_, p_41424_);
	}
}
