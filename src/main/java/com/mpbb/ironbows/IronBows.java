package com.mpbb.ironbows;

import com.mpbb.ironbows.item.Items;
import com.mpbb.ironbows.config.Config;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.MinecraftForge;

@Mod(IronBows.MODID)
public class IronBows
{
	public static final String MODID = "ironbows";
	private static final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();
	private static final IEventBus EVENT_BUS = MinecraftForge.EVENT_BUS;
	
    public IronBows()
    {
    	EVENT_BUS.register(this);
    	ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        Items.BOWS.register(MOD_EVENT_BUS);
        Items.CROSSBOWS.register(MOD_EVENT_BUS);
    }
    

}
