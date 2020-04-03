
package com.cryptor.cryptormod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import com.cryptor.cryptormod.item.ItemHorrorIngot;
import com.cryptor.cryptormod.block.BlockExeblock;
import com.cryptor.cryptormod.ElementsCryptorMod;

@ElementsCryptorMod.ModElement.Tag
public class RecipeHorIngotSmelting extends ElementsCryptorMod.ModElement {
	public RecipeHorIngotSmelting(ElementsCryptorMod instance) {
		super(instance, 43);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockExeblock.block, (int) (1)), new ItemStack(ItemHorrorIngot.block, (int) (1)), 1F);
	}
}
