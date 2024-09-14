package com.mpbb.ironbows.item;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

public class TieredCrossbowItem extends CrossbowItem {
	private final BowTier tier;

	public TieredCrossbowItem(BowTier tier, Properties properties) {
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
	public void appendHoverText(ItemStack p_40880_, TooltipContext p_333751_, List<Component> p_40882_, TooltipFlag p_40883_) {
		p_40882_.add(Component.literal("+" + Float.toString(this.tier.getAttackDamageBonus()) + " ")
				.append(Component.translatable("item.ironbows.damage_tooltip"))
				.withStyle(ChatFormatting.DARK_GREEN));
		super.appendHoverText(p_40880_, p_333751_, p_40882_, p_40883_);
	}
}
