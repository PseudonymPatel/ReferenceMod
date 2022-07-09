package com.empow.tutorialmod.objects.items;

import java.util.List;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
public class SpecialItem extends SwordItem {

	
	public SpecialItem(IItemTier tier, int attack, float speed, Properties properties) {
		super(tier, attack, speed, properties);
		// Code here will only run when the item is 'created' in RegistryEvents.java
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	/**
	 * Adds text under the item's name. Also called a tooltip.
	 */
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip,
			ITooltipFlag flagIn) {
		super.appendHoverText(stack, world, tooltip, flagIn);
	}
	
	@Override
	/**
	 * What happens when a player left clicks on an entity. If a mob is using the item, this
	 * will not be called and the code here will not run. Overriding hurtEnemy generally
	 * provides better results (see next func)
	 * 
	 */
	public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
		//new EffectInstance(effect, ticks, level)
		return super.onLeftClickEntity(stack, player, entity);
	}
	
	@Override
	/**
	 * The code here is run when the item is used to damage another entity. This could mean the player
	 * is doing this or a mob has picked this up and is using it. 
	 * 
	 * 
	 * @param thisItem: the item being used, as an ItemStack (essentially an instance of an Item)
	 * @param targetedEntity: the entity being targeted by the attack (taking the damage)
	 * @param attackingEntity: the entity (usually player) that is doing the attacking.
	 */
	public boolean hurtEnemy(ItemStack thisItem, LivingEntity targetedEntity, LivingEntity attackingEntity) {
			
		//Applies Regeneration 2 to the player for 2 seconds.
		attackingEntity.addEffect(new EffectInstance(Effects.REGENERATION, 40, 2));
		
		//do regular hurtEnemy stuff.
			return super.hurtEnemy(thisItem, targetedEntity, attackingEntity);
	   }
}