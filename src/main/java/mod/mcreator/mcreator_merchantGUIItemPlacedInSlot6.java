package mod.mcreator;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;

import java.util.HashMap;

public class mcreator_merchantGUIItemPlacedInSlot6 extends cryptormod.ModElement {

	public mcreator_merchantGUIItemPlacedInSlot6(cryptormod instance) {
		super(instance);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("guiinventory") == null) {
			System.err.println("Failed to load dependency guiinventory for procedure merchantGUIItemPlacedInSlot6!");
			return;
		}
		HashMap guiinventory = (HashMap) dependencies.get("guiinventory");
		if (((new Object() {

			public int getAmount(int sltid) {
				IInventory inv = (IInventory) guiinventory.get("Trade");
				if (inv != null) {
					ItemStack stack = inv.getStackInSlot(sltid);
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount((int) (6))) >= 1)) {
			{
				IInventory inv = (IInventory) guiinventory.get("Trade");
				if (inv != null)
					inv.setInventorySlotContents((int) (7), new ItemStack(mcreator_radicalWorldBlock.block, (int) (2)));
			}
			{
				IInventory inv = (IInventory) guiinventory.get("Trade");
				if (inv != null)
					inv.decrStackSize((int) (6), (int) (1));
			}
		}
	}
}
