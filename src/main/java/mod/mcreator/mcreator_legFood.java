package mod.mcreator;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.potion.PotionEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.init.MobEffects;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class mcreator_legFood extends cryptormod.ModElement {

	@GameRegistry.ObjectHolder("cryptormod:legfood")
	public static final Item block = null;

	public mcreator_legFood(cryptormod instance) {
		super(instance);
		instance.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("cryptormod:legfood", "inventory"));
	}

	public static class ItemFoodCustom extends ItemFood {

		public ItemFoodCustom() {
			super(20, 0.3F, false);
			setUnlocalizedName("legfood");
			setRegistryName("legfood");
			setPotionEffect(new PotionEffect(MobEffects.REGENERATION, 600, 0), 1.0F);
			setCreativeTab(mcreator_cryptorModTab.tab);
			setMaxStackSize(64);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}
	}
}
