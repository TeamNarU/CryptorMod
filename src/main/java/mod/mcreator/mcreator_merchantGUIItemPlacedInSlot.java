package mod.mcreator;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;

import java.util.HashMap;

public class mcreator_merchantGUIItemPlacedInSlot extends cryptormod.ModElement {

	public mcreator_merchantGUIItemPlacedInSlot(cryptormod instance) {
		super(instance);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("guiinventory") == null) {
			System.err.println("Failed to load dependency guiinventory for procedure merchantGUIItemPlacedInSlot!");
			return;
		}
		HashMap guiinventory = (HashMap) dependencies.get("guiinventory");
		if (((new Object() {

			public ItemStack getItemStack(int sltid) {
				IInventory inv = (IInventory) guiinventory.get("Trade");
				if (inv != null)
					return inv.getStackInSlot(sltid);
				return null;
			}
		}.getItemStack((int) (0))).getItem() == new ItemStack(mcreator_legFood.block, (int) (1)).getItem())) {
			{
				IInventory inv = (IInventory) guiinventory.get("Trade");
				if (inv != null)
					inv.setInventorySlotContents((int) (1), new ItemStack(mcreator_cryptorCoin.block, (int) (10)));
			}
			{
				IInventory inv = (IInventory) guiinventory.get("Trade");
				if (inv != null)
					inv.decrStackSize((int) (0), (int) (1));
			}
		}
	}
}
