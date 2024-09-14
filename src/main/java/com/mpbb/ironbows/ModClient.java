package com.mpbb.ironbows;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

import com.mpbb.ironbows.item.Items;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ChargedProjectiles;
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
			Items.CROSSBOWS.getEntries().forEach(crossbow -> event.accept(crossbow.get()));
		}
	}

	private static void registerBowResourceLocations(RegistryObject<Item> item) {
		ItemProperties.register(item.get(), ResourceLocation.withDefaultNamespace("pull"),
				(p_174635_, p_174636_, p_174637_, p_174638_) -> {
					if (p_174637_ == null) {
						return 0.0F;
					} else {
						return p_174637_.getUseItem() != p_174635_ ? 0.0F
								: (float) (p_174635_.getUseDuration(p_174637_) - p_174637_.getUseItemRemainingTicks()) / 20.0F;
					}
				});
		ItemProperties.register(item.get(), ResourceLocation.withDefaultNamespace("pulling"),
				(p_174630_, p_174631_, p_174632_, p_174633_) -> {
					return p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F
							: 0.0F;
				});
	}

	private static void registerCrossbowResourceLocations(RegistryObject<Item> item) {
		ItemProperties.register(
				item.get(),
                ResourceLocation.withDefaultNamespace("pull"),
                (p_340947_, p_340948_, p_340949_, p_340950_) -> {
                    if (p_340949_ == null) {
                        return 0.0F;
                    } else {
                        return CrossbowItem.isCharged(p_340947_)
                            ? 0.0F
                            : (float)(p_340947_.getUseDuration(p_340949_) - p_340949_.getUseItemRemainingTicks()) / (float)CrossbowItem.getChargeDuration(p_340947_, p_340949_);
                    }
                }
            );
		ItemProperties.register(
				item.get(),
                ResourceLocation.withDefaultNamespace("pulling"),
                (p_174605_, p_174606_, p_174607_, p_174608_) -> p_174607_ != null
                            && p_174607_.isUsingItem()
                            && p_174607_.getUseItem() == p_174605_
                            && !CrossbowItem.isCharged(p_174605_)
                        ? 1.0F
                        : 0.0F
            );
		ItemProperties.register(
				item.get(),
                ResourceLocation.withDefaultNamespace("charged"),
                (p_275891_, p_275892_, p_275893_, p_275894_) -> CrossbowItem.isCharged(p_275891_) ? 1.0F : 0.0F
            );
		ItemProperties.register(item.get(), ResourceLocation.withDefaultNamespace("firework"), (p_325563_, p_325564_, p_325565_, p_325566_) -> {
                ChargedProjectiles chargedprojectiles = p_325563_.get(DataComponents.CHARGED_PROJECTILES);
                return chargedprojectiles != null && chargedprojectiles.contains(net.minecraft.world.item.Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
            });
	}
}
