
package com.cryptor.cryptormod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import com.cryptor.cryptormod.item.ItemCyberIngotA;
import com.cryptor.cryptormod.block.BlockCyberBlock;
import com.cryptor.cryptormod.ElementsCryptorMod;

@ElementsCryptorMod.ModElement.Tag
public class RecipeCIngotSmeltA extends ElementsCryptorMod.ModElement {
	public RecipeCIngotSmeltA(ElementsCryptorMod instance) {
		super(instance, 67);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockCyberBlock.block, (int) (1)), new ItemStack(ItemCyberIngotA.block, (int) (1)), 1F);
	}
}
