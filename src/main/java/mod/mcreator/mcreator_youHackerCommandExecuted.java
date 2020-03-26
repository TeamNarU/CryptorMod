package mod.mcreator;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.Entity;

import java.util.HashMap;

public class mcreator_youHackerCommandExecuted extends cryptormod.ModElement {

	public mcreator_youHackerCommandExecuted(cryptormod instance) {
		super(instance);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure youHackerCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayerMP)
			mcreator_easterEgg.trigger.triggerAdvancement((EntityPlayerMP) entity);
		if (entity instanceof EntityPlayerMP) {
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getCommandManager().executeCommand((EntityPlayerMP) entity, "advancement grant @s cryptormod:easteregg");
		}
	}
}
