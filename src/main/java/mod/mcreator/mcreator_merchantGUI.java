package mod.mcreator;

import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Keyboard;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.GuiButton;

import java.util.HashMap;

public class mcreator_merchantGUI extends cryptormod.ModElement {

	public static int GUIID = 2;
	public static HashMap guiinventory = new HashMap();
	public static IInventory Trade;

	public mcreator_merchantGUI(cryptormod instance) {
		super(instance);
	}

	public static class GuiContainerMod extends Container {

		World world;
		EntityPlayer entity;
		int x, y, z;

		public GuiContainerMod(World world, int x, int y, int z, EntityPlayer player) {
			this.world = world;
			this.entity = player;
			this.x = x;
			this.y = y;
			this.z = z;
			Trade = new InventoryBasic("Trade", true, 12);
			guiinventory.put("Trade", Trade);
			this.addSlotToContainer(new Slot(Trade, 1, 35, 17) {

				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			});
			this.addSlotToContainer(new Slot(Trade, 3, 35, 41) {

				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			});
			this.addSlotToContainer(new Slot(Trade, 5, 35, 65) {

				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			});
			this.addSlotToContainer(new Slot(Trade, 7, 151, 18) {

				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			});
			this.addSlotToContainer(new Slot(Trade, 9, 151, 41) {

				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			});
			this.addSlotToContainer(new Slot(Trade, 11, 151, 66) {

				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			});
			this.addSlotToContainer(new Slot(Trade, 2, 8, 41) {

				public boolean isItemValid(ItemStack stack) {
					return (new ItemStack(mcreator_cryptorCoin.block, (int) (1)).getItem() == stack.getItem());
				}

				public void onSlotChanged() {
					super.onSlotChanged();
					MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
					World world = server.getWorld(entity.dimension);
					if (getHasStack()) {
						{
							java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
							$_dependencies.put("guiinventory", guiinventory);
							mcreator_merchantGUIItemPlacedInSlot2.executeProcedure($_dependencies);
						}
					}
				}
			});
			this.addSlotToContainer(new Slot(Trade, 4, 8, 65) {

				public boolean isItemValid(ItemStack stack) {
					return (new ItemStack(mcreator_cryptorCoin.block, (int) (1)).getItem() == stack.getItem());
				}

				public void onSlotChanged() {
					super.onSlotChanged();
					MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
					World world = server.getWorld(entity.dimension);
					if (getHasStack()) {
						{
							java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
							$_dependencies.put("guiinventory", guiinventory);
							mcreator_merchantGUIItemPlacedInSlot4.executeProcedure($_dependencies);
						}
					}
				}
			});
			this.addSlotToContainer(new Slot(Trade, 6, 125, 18) {

				public boolean isItemValid(ItemStack stack) {
					return (new ItemStack(mcreator_cryptorCoin.block, (int) (1)).getItem() == stack.getItem());
				}

				public void onSlotChanged() {
					super.onSlotChanged();
					MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
					World world = server.getWorld(entity.dimension);
					if (getHasStack()) {
						{
							java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
							$_dependencies.put("guiinventory", guiinventory);
							mcreator_merchantGUIItemPlacedInSlot6.executeProcedure($_dependencies);
						}
					}
				}
			});
			this.addSlotToContainer(new Slot(Trade, 0, 9, 18) {

				public boolean isItemValid(ItemStack stack) {
					return (new ItemStack(mcreator_legFood.block, (int) (1)).getItem() == stack.getItem());
				}

				public void onSlotChanged() {
					super.onSlotChanged();
					MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
					World world = server.getWorld(entity.dimension);
					if (getHasStack()) {
						{
							java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
							$_dependencies.put("guiinventory", guiinventory);
							mcreator_merchantGUIItemPlacedInSlot.executeProcedure($_dependencies);
						}
					}
				}
			});
			this.addSlotToContainer(new Slot(Trade, 8, 124, 41) {

				public boolean isItemValid(ItemStack stack) {
					return (new ItemStack(mcreator_cyberBullet.block, (int) (1)).getItem() == stack.getItem());
				}

				public void onSlotChanged() {
					super.onSlotChanged();
					MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
					World world = server.getWorld(entity.dimension);
					if (getHasStack()) {
						{
							java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
							$_dependencies.put("guiinventory", guiinventory);
							mcreator_merchantGUIItemPlacedInSlot8.executeProcedure($_dependencies);
						}
					}
				}
			});
			this.addSlotToContainer(new Slot(Trade, 10, 124, 66) {

				public boolean isItemValid(ItemStack stack) {
					return (new ItemStack(mcreator_cryptorCoin.block, (int) (1)).getItem() == stack.getItem());
				}

				public void onSlotChanged() {
					super.onSlotChanged();
					MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
					World world = server.getWorld(entity.dimension);
					if (getHasStack()) {
						{
							java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
							$_dependencies.put("guiinventory", guiinventory);
							mcreator_merchantGUIItemPlacedInSlot10.executeProcedure($_dependencies);
						}
					}
				}
			});
			int si;
			int sj;
			for (si = 0; si < 3; ++si)
				for (sj = 0; sj < 9; ++sj)
					this.addSlotToContainer(new Slot(player.inventory, sj + (si + 1) * 9, 0 + 8 + sj * 18, 17 + 84 + si * 18));
			for (si = 0; si < 9; ++si)
				this.addSlotToContainer(new Slot(player.inventory, si, 0 + 8 + si * 18, 17 + 142));
		}

		@Override
		public boolean canInteractWith(EntityPlayer player) {
			return true;
		}

		@Override
		public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
			ItemStack itemstack = null;
			Slot slot = (Slot) this.inventorySlots.get(index);
			if (slot != null && slot.getHasStack()) {
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();
				if (index < 9) {
					if (!this.mergeItemStack(itemstack1, 9, (45 - 9), true))
						return ItemStack.EMPTY;
				} else if (!this.mergeItemStack(itemstack1, 0, 9, false)) {
					return ItemStack.EMPTY;
				}
				if (itemstack1.getCount() == 0) {
					slot.putStack(ItemStack.EMPTY);
				} else {
					slot.onSlotChanged();
				}
				if (itemstack1.getCount() == itemstack.getCount()) {
					return ItemStack.EMPTY;
				}
				slot.onTake(playerIn, itemstack1);
			}
			return itemstack;
		}

		public void onContainerClosed(EntityPlayer playerIn) {
			super.onContainerClosed(playerIn);
			InventoryHelper.dropInventoryItems(world, new BlockPos(x, y, z), Trade);
		}
	}

	public static class GuiWindow extends GuiContainer {

		int x, y, z;
		EntityPlayer entity;

		public GuiWindow(World world, int x, int y, int z, EntityPlayer entity) {
			super(new GuiContainerMod(world, x, y, z, entity));
			this.x = x;
			this.y = y;
			this.z = z;
			this.entity = entity;
			this.xSize = 176;
			this.ySize = 200;
		}

		private static final ResourceLocation texture = new ResourceLocation("cryptormod:textures/merchantgui.png");

		@Override
		public void drawScreen(int mouseX, int mouseY, float partialTicks) {
			this.drawDefaultBackground();
			super.drawScreen(mouseX, mouseY, partialTicks);
			this.renderHoveredToolTip(mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.mc.renderEngine.bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
			zLevel = 100.0F;
		}

		@Override
		protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
			try {
				super.mouseClicked(mouseX, mouseY, mouseButton);
			} catch (Exception ignored) {
			}
		}

		@Override
		public void updateScreen() {
			super.updateScreen();
		}

		@Override
		protected void keyTyped(char typedChar, int keyCode) {
			try {
				super.keyTyped(typedChar, keyCode);
			} catch (Exception ignored) {
			}
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int par1, int par2) {
			this.fontRenderer.drawString("Merchant", 62, 5, -16777216);
			this.fontRenderer.drawString("1", 2, 20, -16777216);
			this.fontRenderer.drawString("2", 2, 43, -16777216);
			this.fontRenderer.drawString("3", 1, 67, -16777216);
			this.fontRenderer.drawString("4", 118, 19, -16777216);
			this.fontRenderer.drawString("5", 116, 43, -16777216);
			this.fontRenderer.drawString("6", 116, 65, -16777216);
		}

		@Override
		public void onGuiClosed() {
			super.onGuiClosed();
			Keyboard.enableRepeatEvents(false);
		}

		@Override
		public void initGui() {
			super.initGui();
			this.guiLeft = (this.width - 176) / 2;
			this.guiTop = (this.height - 200) / 2;
			Keyboard.enableRepeatEvents(true);
			this.buttonList.clear();
			this.buttonList.add(new GuiButton(0, this.guiLeft + 62, this.guiTop + 39, 42, 20, "Help"));
		}

		@Override
		protected void actionPerformed(GuiButton button) {
			MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
			World world = server.getWorld(entity.dimension);
			if (button.id == 0) {
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					mcreator_merchantGUIOnButtonClicked1.executeProcedure($_dependencies);
				}
			}
		}

		@Override
		public boolean doesGuiPauseGame() {
			return false;
		}
	}
}
