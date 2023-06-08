package com.mpbb.ironbows.mixin;


import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.mpbb.ironbows.item.TieredCrossbowItem;

import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

@Mixin(CrossbowItem.class)
public class CrossbowPower {
	@Inject(method = "getShootingPower", at = @At(value = "RETURN"), cancellable = true)
	private static float getShootingPower(ItemStack crossbowItemStack, CallbackInfoReturnable<Float> cir) {
		Item crossbowItem = crossbowItemStack.getItem();
		float power = cir.getReturnValue();
		if (crossbowItem instanceof TieredCrossbowItem tieredCrossbowItem)
		{
			power += tieredCrossbowItem.getTier().getAttackDamageBonus();
		}
		cir.setReturnValue(power);
		return power;
	}
}