
package com.cryptorinc.cryptormod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import com.cryptorinc.cryptormod.creativetab.TabModTab;
import com.cryptorinc.cryptormod.ElementsCryptorMod;

@ElementsCryptorMod.ModElement.Tag
public class ItemCryptorXArmor extends ElementsCryptorMod.ModElement {
	@GameRegistry.ObjectHolder("cryptormod:cryptorxarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("cryptormod:cryptorxarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("cryptormod:cryptorxarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("cryptormod:cryptorxarmorboots")
	public static final Item boots = null;
	public ItemCryptorXArmor(ElementsCryptorMod instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("CRYPTORXARMOR", "cryptormod:cryptorxarmor", 999, new int[]{25, 35, 40, 30}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 5f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("cryptorxarmorhelmet")
				.setRegistryName("cryptorxarmorhelmet").setCreativeTab(TabModTab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("cryptorxarmorbody")
				.setRegistryName("cryptorxarmorbody").setCreativeTab(TabModTab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("cryptorxarmorlegs")
				.setRegistryName("cryptorxarmorlegs").setCreativeTab(TabModTab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("cryptorxarmorboots")
				.setRegistryName("cryptorxarmorboots").setCreativeTab(TabModTab.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("cryptormod:cryptorxarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("cryptormod:cryptorxarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("cryptormod:cryptorxarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("cryptormod:cryptorxarmorboots", "inventory"));
	}
}
