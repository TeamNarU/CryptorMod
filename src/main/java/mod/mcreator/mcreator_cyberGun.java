package mod.mcreator;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.init.Enchantments;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.Minecraft;

import java.util.Random;
import java.util.HashMap;

public class mcreator_cyberGun extends cryptormod.ModElement {

	@GameRegistry.ObjectHolder("cryptormod:cybergun")
	public static final Item block = null;
	public static final int ENTITYID = 7;

	public mcreator_cyberGun(cryptormod instance) {
		super(instance);
		instance.items.add(() -> new RangedItem());
		instance.entities.add(() -> EntityEntryBuilder.create().entity(EntityArrowCustom.class)
				.id(new ResourceLocation("cryptormod", "entitybulletcybergun"), ENTITYID).name("entitybulletcybergun").tracker(64, 1, true).build());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("cryptormod:cybergun", "inventory"));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityArrowCustom.class, renderManager -> {
			return new RenderSnowball(renderManager, new ItemStack(mcreator_bulletShooted.block, (int) (1)).getItem(), Minecraft.getMinecraft()
					.getRenderItem());
		});
	}

	public static class RangedItem extends Item {

		public RangedItem() {
			super();
			setMaxDamage(100000);
			maxStackSize = 1;
			setFull3D();
			setUnlocalizedName("cybergun");
			setRegistryName("cybergun");
			setCreativeTab(mcreator_cryptorModTab.tab);
		}

		@Override
		public void onUsingTick(ItemStack itemstack, EntityLivingBase entityLivingBase, int count) {
			World world = entityLivingBase.world;
			if (!world.isRemote && entityLivingBase instanceof EntityPlayerMP) {
				EntityPlayerMP entity = (EntityPlayerMP) entityLivingBase;
				boolean flag = entity.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, itemstack) > 0;
				int slotID = entity.inventory.getSlotFor(new ItemStack(mcreator_cyberBullet.block, (int) (1)));
				if (flag || slotID != -1) {
					float f = 50F;
					EntityArrowCustom entityarrow = new EntityArrowCustom(world, entity);
					entityarrow.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, f * 2.0F, 0);
					entityarrow.setIsCritical(false);
					entityarrow.setDamage(1000);
					entityarrow.setKnockbackStrength(5);
					itemstack.damageItem(1, entity);
					int x = (int) entity.posX;
					int y = (int) entity.posY;
					int z = (int) entity.posZ;
					world.playSound((EntityPlayer) null, (double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D,
							(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
									("entity.arrow.shoot"))), SoundCategory.NEUTRAL, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
					if (flag) {
						entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
					} else {
						if (new ItemStack(mcreator_cyberBullet.block, (int) (1)).isItemStackDamageable()) {
							ItemStack stack = entity.inventory.getStackInSlot(slotID);
							if (stack.attemptDamageItem(1, new Random(), entity)) {
								stack.shrink(1);
								stack.setItemDamage(0);
							}
						} else {
							entity.inventory.clearMatchingItems(new ItemStack(mcreator_cyberBullet.block, (int) (1)).getItem(), -1, 1, null);
						}
					}
					if (!world.isRemote)
						world.spawnEntity(entityarrow);
				}
				entity.stopActiveHand();
			}
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
			entity.setActiveHand(hand);
			return new ActionResult(EnumActionResult.SUCCESS, entity.getHeldItem(hand));
		}

		@Override
		public EnumAction getItemUseAction(ItemStack itemstack) {
			return EnumAction.BOW;
		}

		@Override
		public int getMaxItemUseDuration(ItemStack itemstack) {
			return 72000;
		}
	}

	public static class EntityArrowCustom extends EntityTippedArrow {

		public EntityArrowCustom(World a) {
			super(a);
		}

		public EntityArrowCustom(World worldIn, double x, double y, double z) {
			super(worldIn, x, y, z);
		}

		public EntityArrowCustom(World worldIn, EntityLivingBase shooter) {
			super(worldIn, shooter);
		}

		@Override
		protected void arrowHit(EntityLivingBase entity) {
			super.arrowHit(entity);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			World world = this.world;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				mcreator_cyberGunBulletHitsLivingEntity.executeProcedure($_dependencies);
			}
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			World world = this.world;
			Entity entity = (Entity) shootingEntity;
			if (this.inGround) {
				this.world.removeEntity(this);
			}
		}
	}
}
