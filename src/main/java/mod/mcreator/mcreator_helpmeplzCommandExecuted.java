package mod.mcreator;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import java.util.HashMap;

public class mcreator_helpmeplzCommandExecuted extends cryptormod.ModElement {

	public mcreator_helpmeplzCommandExecuted(cryptormod instance) {
		super(instance);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure helpmeplzCommandExecuted!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure helpmeplzCommandExecuted!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure helpmeplzCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure helpmeplzCommandExecuted!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			Entity entityToSpawn = new mcreator_horrorCryptor.EntityhorrorCryptor(world);
			if (entityToSpawn != null) {
				entityToSpawn.setLocationAndAngles((x + 5), y, z, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(entityToSpawn);
			}
		}
	}
}
