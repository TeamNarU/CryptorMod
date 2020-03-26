package mod.mcreator;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;

import java.util.HashMap;

public class mcreator_merchantGUIItemPlacedInSlot10 extends cryptormod.ModElement {

	public mcreator_merchantGUIItemPlacedInSlot10(cryptormod instance) {
		super(instance);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("guiinventory") == null) {
			System.err.println("Failed to load dependency guiinventory for procedure merchantGUIItemPlacedInSlot10!");
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
		}.getAmount((int) (10))) >= 5)) {
			{
				IInventory inv = (IInventory) guiinventory.get("Trade");
				if (inv != null)
					inv.setInventorySlotContents((int) (11), new ItemStack(mcreator_radicalDimension.block, (int) (1)));
			}
			{
				IInventory inv = (IInventory) guiinventory.get("Trade");
				if (inv != null)
					inv.decrStackSize((int) (10), (int) (5));
			}
		}
	}
}
