package com.mpbb.ironbows;

import com.mpbb.ironbows.item.TieredBowItem;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(modid = IronBows.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeClient {
	@SubscribeEvent
    public static void onFOVUpdate(ComputeFovModifierEvent event)
    {
    	LivingEntity player = event.getPlayer();
    	Item item = player.getUseItem().getItem();
        if(item instanceof TieredBowItem) {
        	float FOVModifier = player.getTicksUsingItem() / (float)TieredBowItem.MAX_DRAW_DURATION;
        	if (FOVModifier > 1.0f) {
        		FOVModifier = 1.0f;
        	}
        	else {
        		FOVModifier *= FOVModifier;
        	}
        	event.setNewFovModifier(event.getNewFovModifier() * (1.0f - FOVModifier * 0.15f));
        }
    }
}
