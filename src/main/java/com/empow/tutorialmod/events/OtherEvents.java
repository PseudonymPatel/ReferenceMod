package com.empow.tutorialmod.events;

import java.util.ArrayList;

import com.empow.tutorialmod.objects.items.SpecialArmor;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
/**
 * This class houses different Forge Mod Bus events, like the LivingEquipmentChangeEvent. They are put here because they
 * do not belong in any single class as the code may be called at a random time. This class is instanced by Forge at startup. 
 * To make it work, we NEED the `@EventBusSubcriber` tag at the top, above the `public class ClassName`. You can find that above
 * this comment here. Then, for each function, we need a `@SubscribeEvent` above each method header. See the onPlayerEquipmentChange
 * function for an example of this. The only parameter for these functions should be the name of the event (correctly capitalized). 
 *
 * @author Sheen
 */
public class OtherEvents {

	
	/**
	 * This specfic function is called when the player changes their equipment (armor). Includes changes in the player's hand.
	 * This is an example of a Forge Mod Bus event. These are called when specific world events happen. The documentation
	 * for many of these is often poor, so it may take time to find the right event. 
	 * 
	 * @param event This parameter dictates what event is actually being called.
	 */
	@SubscribeEvent
	public static void onPlayerEquipmentChange(LivingEquipmentChangeEvent event)  {
		Iterable<ItemStack> armors = event.getEntityLiving().getArmorSlots(); //get player's armor slots
		for (ItemStack armor : armors) { // loop through the armor being worn
			System.out.println(armor.getDisplayName());
			if (armor.getItem() instanceof SpecialArmor) { //if one of the slots of armor is our SpecialArmor.java item, do this:
				event.getEntityLiving().addEffect(new EffectInstance(Effects.ABSORPTION, 999, 999)); //give them super high absorption
			}
		}
	}
	
	/**
	 * Small function that stops the player from taking fall damage. Some events are cancellable, check the documentation to see if 
	 * this is the case for your event by Control + left clicking on the event and reading the comments above the class. 
	 * 
	 * @param event
	 */
	@SubscribeEvent
	public static void iFellOnTheGround(LivingFallEvent event) {
		//check if it's the player
		if (event.getEntityLiving() instanceof PlayerEntity) {
			event.setCanceled(true); //stop the player from taking fall damage by cancelling the event. Not all events are cancellable.
		}
	}
}
 