package com.mpbb.ironbows.item;

import com.mpbb.ironbows.IronBows;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
	public static final DeferredRegister<Item> BOWS = DeferredRegister.create(ForgeRegistries.ITEMS, IronBows.MODID);

	public static final RegistryObject<Item> IRON_BOW = BOWS.register("iron_bow", () -> new TieredBowItem(BowTiers.IRON, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> GOLDEN_BOW = BOWS.register("golden_bow", () -> new TieredBowItem(BowTiers.GOLD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> DIAMOND_BOW = BOWS.register("diamond_bow", () -> new TieredBowItem(BowTiers.DIAMOND, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> EMERALD_BOW = BOWS.register("emerald_bow", () -> new TieredBowItem(BowTiers.EMERALD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> NETHERITE_BOW = BOWS.register("netherite_bow", () -> new TieredBowItem(BowTiers.NETHERITE, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	
	
	
	public static final DeferredRegister<Item> CROSSBOWS = DeferredRegister.create(ForgeRegistries.ITEMS, IronBows.MODID);
	
	public static final RegistryObject<Item> IRON_CROSSBOW = CROSSBOWS.register("iron_crossbow", () -> new TieredCrossbowItem(CrossbowTiers.IRON, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> GOLDEN_CROSSBOW = CROSSBOWS.register("golden_crossbow", () -> new TieredCrossbowItem(CrossbowTiers.GOLD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> DIAMOND_CROSSBOW = CROSSBOWS.register("diamond_crossbow", () -> new TieredCrossbowItem(CrossbowTiers.DIAMOND, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> EMERALD_CROSSBOW = CROSSBOWS.register("emerald_crossbow", () -> new TieredCrossbowItem(CrossbowTiers.EMERALD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> NETHERITE_CROSSBOW = CROSSBOWS.register("netherite_crossbow", () -> new TieredCrossbowItem(CrossbowTiers.NETHERITE, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
}
