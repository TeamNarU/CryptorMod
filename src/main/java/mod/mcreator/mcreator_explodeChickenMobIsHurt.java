package mod.mcreator;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.Entity;

import java.util.HashMap;

public class mcreator_explodeChickenMobIsHurt extends cryptormod.ModElement {

	public mcreator_explodeChickenMobIsHurt(cryptormod instance) {
		super(instance);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure explodeChickenMobIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayerMP) {
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getCommandManager().executeCommand((EntityPlayerMP) entity, "execute @e[type=cryptormod:explodechicken,r=1] ~ ~ ~ summon tnt");
		}
	}
}
