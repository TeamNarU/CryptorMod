package mod.mcreator;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.model.ModelBiped;

public class mcreator_cyberCryptor extends cryptormod.ModElement {

	public static final int ENTITYID = 5;
	public static final int ENTITYID_RANGED = 6;

	public mcreator_cyberCryptor(cryptormod instance) {
		super(instance);
		instance.entities.add(() -> EntityEntryBuilder.create().entity(EntitycyberCryptor.class)
				.id(new ResourceLocation("cryptormod", "cybercryptor"), ENTITYID).name("cybercryptor").tracker(64, 1, true).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {mcreator_radicalBiome.biome,};
		EntityRegistry.addSpawn(EntitycyberCryptor.class, 20, 1, 3, EnumCreatureType.MONSTER, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntitycyberCryptor.class, renderManager -> {
			RenderBiped customRender = new RenderBiped(renderManager, new ModelBiped(), 0.5f) {

				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("cryptormod:textures/cyber cryptor.png");
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

	public static class EntitycyberCryptor extends EntityMob {

		public EntitycyberCryptor(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 10000;
			this.isImmuneToFire = true;
			setNoAI(!true);
			enablePersistence();
			this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true, true));
			this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.2, false));
			this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(4, new EntityAIBreakDoor(this));
			this.tasks.addTask(5, new EntityAIWander(this, 1));
			this.tasks.addTask(6, new EntityAILookIdle(this));
			this.tasks.addTask(7, new EntityAISwimming(this));
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mcreator_cyberGun.block, (int) (1)));
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
			return new ItemStack(mcreator_cyberBullet.block, (int) (1)).getItem();
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
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10000D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(9999D);
		}

		protected void dropRareDrop(int par1) {
			this.dropItem(new ItemStack(mcreator_cyberGun.block, (int) (1)).getItem(), 1);
		}
	}
}
