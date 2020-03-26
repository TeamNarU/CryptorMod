package mod.mcreator;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.BossInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumHand;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.model.ModelBiped;

import java.util.Random;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;

public class mcreator_cryptorX extends cryptormod.ModElement {

	public static final int ENTITYID = 1;
	public static final int ENTITYID_RANGED = 2;

	public mcreator_cryptorX(cryptormod instance) {
		super(instance);
		instance.entities.add(() -> EntityEntryBuilder.create().entity(EntitycryptorX.class)
				.id(new ResourceLocation("cryptormod", "cryptorx"), ENTITYID).name("cryptorx").tracker(64, 1, true).build());
	}

	private Biome[] allbiomes(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext())
			ls.add(itr.next());
		return ls.toArray(new Biome[ls.size()]);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntitycryptorX.class, renderManager -> {
			RenderBiped customRender = new RenderBiped(renderManager, new ModelBiped(), 2f) {

				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("cryptormod:textures/wannacryptor.png");
				}
			};
			customRender.addLayer(new net.minecraft.client.renderer.entity.layers.LayerHeldItem(customRender));
			customRender.addLayer(new net.minecraft.client.renderer.entity.layers.LayerBipedArmor(customRender) {

				protected void initArmor() {
					this.modelLeggings = new ModelBiped();
					this.modelArmor = new ModelBiped();
				}
			});
			return customRender;
		});
	}

	public static class EntitycryptorX extends EntityMob {

		public EntitycryptorX(World world) {
			super(world);
			setSize(1f, 2f);
			experienceValue = 9999;
			this.isImmuneToFire = false;
			setNoAI(!true);
			enablePersistence();
			this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true, true));
			this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.2, false));
			this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(4, new EntityAIBreakDoor(this));
			this.tasks.addTask(5, new EntityAIWander(this, 1));
			this.targetTasks.addTask(6, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(7, new EntityAILookIdle(this));
			this.tasks.addTask(8, new EntityAISwimming(this));
			this.targetTasks.addTask(9, new EntityAIHurtByTarget(this, false));
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mcreator_cryptorXSword.block, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(mcreator_cryptorXArmor.helmet, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mcreator_cryptorXArmor.body, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(mcreator_cryptorXArmor.legs, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(mcreator_cryptorXArmor.boots, (int) (1)));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected boolean canDespawn() {
			return false;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(mcreator_legFood.block, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
			super.onStruckByLightning(entityLightningBolt);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				mcreator_lightGM.executeProcedure($_dependencies);
			}
		}

		@Override
		public void fall(float l, float d) {
			super.fall(l, d);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				mcreator_fallGM.executeProcedure($_dependencies);
			}
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			boolean retval = super.attackEntityFrom(source, amount);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				mcreator_hurtGM.executeProcedure($_dependencies);
			}
			return retval;
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				mcreator_cryptorXMobDies.executeProcedure($_dependencies);
			}
		}

		@Override
		public boolean processInteract(EntityPlayer entity, EnumHand hand) {
			boolean retval = super.processInteract(entity, hand);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			ItemStack itemstack = entity.getHeldItem(hand);
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				mcreator_rightGM.executeProcedure($_dependencies);
			}
			return retval;
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10000D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(9999D);
		}

		protected void dropRareDrop(int par1) {
			this.dropItem(new ItemStack(mcreator_cryptorXSword.block, (int) (1)).getItem(), 1);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}

		private final BossInfoServer bossInfo = (BossInfoServer) (new BossInfoServer(this.getDisplayName(), BossInfo.Color.RED,
				BossInfo.Overlay.PROGRESS));

		@Override
		public void addTrackingPlayer(EntityPlayerMP player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(EntityPlayerMP player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}

		public void onLivingUpdate() {
			super.onLivingUpdate();
			int i = (int) this.posX;
			int j = (int) this.posY;
			int k = (int) this.posZ;
			Random random = this.rand;
			if (true)
				for (int l = 0; l < 10; ++l) {
					double d0 = (double) ((float) i + random.nextFloat());
					double d1 = (double) ((float) j + random.nextFloat());
					double d2 = (double) ((float) k + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = ((double) random.nextFloat() - 0.5D) * 1D;
					double d4 = ((double) random.nextFloat() - 0.5D) * 1D;
					double d5 = ((double) random.nextFloat() - 0.5D) * 1D;
					world.spawnParticle(EnumParticleTypes.DRIP_LAVA, d0, d1, d2, d3, d4, d5);
				}
		}
	}
}
