package mod.mcreator;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.Entity;

import java.util.HashMap;

public class mcreator_eRRORCommandExecuted extends cryptormod.ModElement {

	public mcreator_eRRORCommandExecuted(cryptormod instance) {
		super(instance);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure eRRORCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayerMP)
			mcreator_errorAch.trigger.triggerAdvancement((EntityPlayerMP) entity);
	}
}
