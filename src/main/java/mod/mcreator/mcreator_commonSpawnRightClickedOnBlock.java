package mod.mcreator;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import java.util.HashMap;

public class mcreator_commonSpawnRightClickedOnBlock extends cryptormod.ModElement {

	public mcreator_commonSpawnRightClickedOnBlock(cryptormod instance) {
		super(instance);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure commonSpawnRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure commonSpawnRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure commonSpawnRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure commonSpawnRightClickedOnBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			Entity entityToSpawn = new mcreator_cryptorCommon.EntitycryptorCommon(world);
			if (entityToSpawn != null) {
				entityToSpawn.setLocationAndAngles(x, (y + 1), z, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(entityToSpawn);
			}
		}
	}
}
