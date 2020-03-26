package mod.mcreator;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.Entity;

import java.util.HashMap;

public class mcreator_cryptorXMobDies extends cryptormod.ModElement {

	public mcreator_cryptorXMobDies(cryptormod instance) {
		super(instance);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure cryptorXMobDies!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure cryptorXMobDies!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure cryptorXMobDies!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure cryptorXMobDies!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure cryptorXMobDies!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayerMP)
			mcreator_cryptorXDefeated.trigger.triggerAdvancement((EntityPlayerMP) entity);
		if (entity instanceof EntityPlayerMP) {
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getCommandManager().executeCommand((EntityPlayerMP) entity, "title @a title No.. No..");
		}
		if (entity instanceof EntityPlayerMP) {
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getCommandManager().executeCommand((EntityPlayerMP) entity, "title @a title It cant be happened.");
		}
		if (entity instanceof EntityPlayerMP) {
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getCommandManager().executeCommand((EntityPlayerMP) entity, "title @a title You.. You..");
		}
		if (entity instanceof EntityPlayerMP) {
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getCommandManager().executeCommand((EntityPlayerMP) entity, "title @a title You IDIOT! ");
		}
		world.createExplosion(null, (int) x, (int) y, (int) z,
				(float) (world.isBlockIndirectlyGettingPowered(new BlockPos((int) x, (int) y, (int) z))), true);
	}
}
