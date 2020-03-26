package mod.mcreator;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import java.util.HashMap;

public class mcreator_cyberSwordMobIsHitWithItem extends cryptormod.ModElement {

	public mcreator_cyberSwordMobIsHitWithItem(cryptormod instance) {
		super(instance);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure cyberSwordMobIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.WITHER, (int) 60, (int) 228, (true), (false)));
		if ((entity instanceof mcreator_cryptorCommon.EntitycryptorCommon)) {
			if (entity instanceof EntityPlayerMP)
				mcreator_powerOfCyber.trigger.triggerAdvancement((EntityPlayerMP) entity);
		}
	}
}
