package com.empow.tutorialmod.lists;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

/**
 * This class will list the properties of different custom food items in the game. I usually have students put 
 * these in ItemList.java for ease, but to follow the code style they should get their own file. These Food 
 * variables will be used as a modifier to an Item and are not actually an Item themselves.
 * 
 * To assign an item the properties of a defined food, use the `.food(...)` method after setting the creative tab in RegistryEvents.java
 * 
 * TIP: I have students look at Minecraft's Foods.java class (net.minecraft.items.Foods) 
 * and copy/modify a similar food (usually golden apple).
 * 
 * @author Sheen
 *
 */
public class FoodList {
	//define a super good food that's suspiciously similar to a enchanted golden apple. 
	//nutrition: the hunger bar,  saturation: hidden other stat that affects regen, higher=better, player only regenerates health
	//	when saturation greater than 0. Saturation max of 20 just like health and hunger.
	public static final Food SUPER_FOOD = (new Food.Builder()).nutrition(10).saturationMod(3F).effect(new EffectInstance(Effects.REGENERATION, 400, 1), 1.0F).effect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 6000, 0), 1.0F).effect(new EffectInstance(Effects.FIRE_RESISTANCE, 6000, 0), 1.0F).effect(new EffectInstance(Effects.DIG_SPEED, 2400, 3), 1.0F).alwaysEat().build();
}
