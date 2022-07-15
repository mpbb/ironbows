package com.mpbb.ironbows;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import com.mpbb.ironbows.item.Items;
import com.mpbb.ironbows.item.TieredBowItem;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod("ironbows")
public class IronBows
{
	public static final String MODID = "ironbows";
	private static final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();
	private static final IEventBus EVENT_BUS = MinecraftForge.EVENT_BUS;

    public IronBows()
    {
    	MOD_EVENT_BUS.addListener(this::setup);
        Items.BOWS.register(MOD_EVENT_BUS);
        
        EVENT_BUS.register(this);
    }
    
    private void setup(final FMLClientSetupEvent event)
    {
        event.enqueueWork(() -> {
    	Items.BOWS.getEntries().forEach(item -> {
    		ItemProperties.register(item.get(), new ResourceLocation("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                if (p_174637_ == null) {
                    return 0.0F;
                 } else {
                    return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 20.0F;
                 }
              });
            ItemProperties.register(item.get(), new ResourceLocation("pulling"), (p_174630_, p_174631_, p_174632_, p_174633_) -> {
                return p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F;
             });
    	});
      });
    }
    
    @SubscribeEvent
    public void onFOVUpdate(ComputeFovModifierEvent event)
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
