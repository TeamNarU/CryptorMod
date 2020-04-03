
package com.cryptor.cryptormod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import com.cryptor.cryptormod.item.ItemXIngot;
import com.cryptor.cryptormod.block.BlockDefBlock;
import com.cryptor.cryptormod.ElementsCryptorMod;

@ElementsCryptorMod.ModElement.Tag
public class RecipeXIngotFurnace extends ElementsCryptorMod.ModElement {
	public RecipeXIngotFurnace(ElementsCryptorMod instance) {
		super(instance, 42);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockDefBlock.block, (int) (1)), new ItemStack(ItemXIngot.block, (int) (1)), 1F);
	}
}
