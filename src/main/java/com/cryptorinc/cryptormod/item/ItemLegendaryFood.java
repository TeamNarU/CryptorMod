
package com.cryptorinc.cryptormod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import com.cryptorinc.cryptormod.procedure.ProcedureLegendaryFoodFoodEaten;
import com.cryptorinc.cryptormod.creativetab.TabModTab;
import com.cryptorinc.cryptormod.ElementsCryptorMod;

@ElementsCryptorMod.ModElement.Tag
public class ItemLegendaryFood extends ElementsCryptorMod.ModElement {
	@GameRegistry.ObjectHolder("cryptormod:legendaryfood")
	public static final Item block = null;
	public ItemLegendaryFood(ElementsCryptorMod instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("cryptormod:legendaryfood", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(20, 5f, false);
			setUnlocalizedName("legendaryfood");
			setRegistryName("legendaryfood");
			setCreativeTab(TabModTab.tab);
			setMaxStackSize(64);
		}

		@Override
		@SideOnly(Side.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}

		@Override
		protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entity) {
			super.onFoodEaten(itemStack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureLegendaryFoodFoodEaten.executeProcedure($_dependencies);
			}
		}
	}
}
