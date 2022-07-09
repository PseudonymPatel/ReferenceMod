package com.empow.tutorialmod.objects.blocks;

import java.util.Random;

import com.empow.tutorialmod.lists.BlockList;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

public class CustomOreBlock extends OreBlock{

	public CustomOreBlock(Properties properties) {
		super(properties);
		
	}
	@Override
	protected int xpOnDrop(Random random) {
		return 0;
	}

}
