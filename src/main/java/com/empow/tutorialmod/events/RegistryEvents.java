package com.empow.tutorialmod.events;

import org.apache.logging.log4j.Logger;

import com.empow.tutorialmod.Main;
import com.empow.tutorialmod.lists.ArmorList;
import com.empow.tutorialmod.lists.BlockList;
import com.empow.tutorialmod.lists.FoodList;
import com.empow.tutorialmod.lists.ItemList;
import com.empow.tutorialmod.lists.ToolList;
import com.empow.tutorialmod.objects.blocks.CustomOreBlock;
import com.empow.tutorialmod.objects.items.SpecialArmor;
import com.empow.tutorialmod.objects.items.SpecialItem;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {
	public static final Logger LOGGER = Main.LOGGER;
	public static final String MOD_ID = Main.MOD_ID;

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				
				//The most basic item. Does nothing but exist. Can be copy-pasted and built off of.
				ItemList.tutorial_item = new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)).setRegistryName(location("tutorial_item")),
				
				//A food item like this one is defined all the same as a regular item, but add this: vvv  `.food(...)` to make it edible.
				ItemList.powerful_food = new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(FoodList.SUPER_FOOD)).setRegistryName(location("powerful_food")),
				
				//This armor is the specialArmor class, which is used to give the player a potion effect when worn (see OtherEvents.java)
				ItemList.tutorial_armor_chestplate = new SpecialArmor(ArmorList.EXAMPLE_ARMOR, EquipmentSlotType.CHEST,
						new Item.Properties().tab(ItemGroup.TAB_COMBAT))
								.setRegistryName(location("tutorial_armor_chestplate")),
								
				// The first number (2nd param) adds to the attack damage value in ToolList, and the next number adds (negative = quicker attacks) to the speed of the sword.
				ItemList.custom_sword = new SpecialItem(ToolList.EXAMPLE_SWORD, 0, 0, new Item.Properties().tab(ItemGroup.TAB_COMBAT)).setRegistryName(location("custom_sword"))

		);
	}

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				/*
				 * Reference of Block created in BlockList.java To add more items to registry,
				 * copy the code:
				 * 
				 */

		);
	}
	
	
	@SubscribeEvent
	public static void registerFluids(final RegistryEvent.Register<Fluid> event) {
		event.getRegistry().registerAll(
				/*
				 * Reference of Fluid created in FluidList.java To add more items to registry,
				 * copy the code:
				 * 
				 */

		);
	}
	
	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
		//registers entities liked primed TNT, mobs, blocks with storages, etc.
	}

	public static ResourceLocation location(String name) {
		return new ResourceLocation(MOD_ID, name);
	}
}
