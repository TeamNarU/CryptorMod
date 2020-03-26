package mod.mcreator;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import java.util.Set;
import java.util.HashMap;

public class mcreator_cryptorXSword extends cryptormod.ModElement {

	@GameRegistry.ObjectHolder("cryptormod:cryptorxsword")
	public static final Item block = null;

	public mcreator_cryptorXSword(cryptormod instance) {
		super(instance);
		instance.items.add(() -> new ItemSword(EnumHelper.addToolMaterial("CRYPTORXSWORD", 0, 4000, 4, 100, 2)) {

			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("sword", 0);
				return ret.keySet();
			}
		}.setUnlocalizedName("cryptorxsword").setRegistryName("cryptorxsword").setCreativeTab(mcreator_cryptorModTab.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("cryptormod:cryptorxsword", "inventory"));
	}
}
