
package com.cryptor.cryptormod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import com.cryptor.cryptormod.item.ItemCyberIngotB;
import com.cryptor.cryptormod.item.ItemCyberIngotA;
import com.cryptor.cryptormod.ElementsCryptorMod;

@ElementsCryptorMod.ModElement.Tag
public class RecipeCIngotCraftB extends ElementsCryptorMod.ModElement {
	public RecipeCIngotCraftB(ElementsCryptorMod instance) {
		super(instance, 68);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemCyberIngotA.block, (int) (1)), new ItemStack(ItemCyberIngotB.block, (int) (1)), 1F);
	}
}
