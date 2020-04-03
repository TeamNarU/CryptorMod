package com.cryptor.cryptormod.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import com.cryptor.cryptormod.entity.EntityCryptorX;
import com.cryptor.cryptormod.ElementsCryptorMod;

@ElementsCryptorMod.ModElement.Tag
public class ProcedureCommonCryptorEntityDies extends ElementsCryptorMod.ModElement {
	public ProcedureCommonCryptorEntityDies(ElementsCryptorMod instance) {
		super(instance, 24);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure CommonCryptorEntityDies!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure CommonCryptorEntityDies!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure CommonCryptorEntityDies!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CommonCryptorEntityDies!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			Entity entityToSpawn = new EntityCryptorX.EntityCustom(world);
			if (entityToSpawn != null) {
				entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(entityToSpawn);
			}
		}
	}
}
