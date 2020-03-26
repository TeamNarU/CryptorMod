package mod.mcreator;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class mcreator_cryptorXArmor extends cryptormod.ModElement {

	@GameRegistry.ObjectHolder("cryptormod:cryptorxarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("cryptormod:cryptorxarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("cryptormod:cryptorxarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("cryptormod:cryptorxarmorboots")
	public static final Item boots = null;

	public mcreator_cryptorXArmor(cryptormod instance) {
		super(instance);
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("CRYPTORXARMOR", "cryptormod:cryptorxarmor", 1000, new int[]{99, 99, 99, 99}, 9,
				null, 5f);
		instance.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("cryptorxarmorhelmet")
				.setRegistryName("cryptorxarmorhelmet").setCreativeTab(mcreator_cryptorModTab.tab));
		instance.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("cryptorxarmorbody")
				.setRegistryName("cryptorxarmorbody").setCreativeTab(mcreator_cryptorModTab.tab));
		instance.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("cryptorxarmorlegs")
				.setRegistryName("cryptorxarmorlegs").setCreativeTab(mcreator_cryptorModTab.tab));
		instance.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("cryptorxarmorboots")
				.setRegistryName("cryptorxarmorboots").setCreativeTab(mcreator_cryptorModTab.tab));
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
