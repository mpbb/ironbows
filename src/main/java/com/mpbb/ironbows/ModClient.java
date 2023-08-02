package com.mpbb.ironbows;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

import com.mpbb.ironbows.item.Items;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = IronBows.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClient {

	@SubscribeEvent
	public static void setup(final FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			Items.BOWS.getEntries().forEach(item -> registerBowResourceLocations(item));
			Items.CROSSBOWS.getEntries().forEach(item -> registerCrossbowResourceLocations(item));
		});
	}
	
	@SubscribeEvent
	public static void buildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
		if(event.getTabKey() == CreativeModeTabs.COMBAT) {
			Items.BOWS.getEntries().forEach(bow -> event.accept(bow.get()));
			Items.CROSSBOWS.getEntries().forEach(bow -> event.accept(bow.get()));
		}
	}

	private static void registerBowResourceLocations(RegistryObject<Item> item) {
		ItemProperties.register(item.get(), new ResourceLocation("pull"),
				(p_174635_, p_174636_, p_174637_, p_174638_) -> {
					if (p_174637_ == null) {
						return 0.0F;
					} else {
						return p_174637_.getUseItem() != p_174635_ ? 0.0F
								: (float) (p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 20.0F;
					}
				});
		ItemProperties.register(item.get(), new ResourceLocation("pulling"),
				(p_174630_, p_174631_, p_174632_, p_174633_) -> {
					return p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F
							: 0.0F;
				});
	}

	private static void registerCrossbowResourceLocations(RegistryObject<Item> item) {
		ItemProperties.register(item.get(), new ResourceLocation("pull"),
				(p_174635_, p_174636_, p_174637_, p_174638_) -> {
					if (p_174637_ == null) {
						return 0.0F;
					} else {
						return p_174637_.getUseItem() != p_174635_ ? 0.0F
								: (float) (p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 20.0F;
					}
				});
		ItemProperties.register(item.get(), new ResourceLocation("pulling"),
				(p_174630_, p_174631_, p_174632_, p_174633_) -> {
					return p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F
							: 0.0F;
				});
		ItemProperties.register(item.get(), new ResourceLocation("charged"),
				(p_174635_, p_174636_, p_174637_, p_174638_) -> {
					return p_174637_ != null && CrossbowItem.isCharged(p_174635_) ? 1.0F : 0.0F;
				});
		ItemProperties.register(item.get(), new ResourceLocation("firework"),
				(p_174635_, p_174636_, p_174637_, p_174638_) -> {
					return p_174637_ != null && CrossbowItem.containsChargedProjectile(p_174635_,
							net.minecraft.world.item.Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
				});
	}
}
