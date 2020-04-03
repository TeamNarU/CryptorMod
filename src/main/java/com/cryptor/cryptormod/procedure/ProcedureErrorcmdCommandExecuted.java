package com.cryptor.cryptormod.procedure;

import net.minecraft.world.WorldServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.Iterator;

import com.cryptor.cryptormod.ElementsCryptorMod;

@ElementsCryptorMod.ModElement.Tag
public class ProcedureErrorcmdCommandExecuted extends ElementsCryptorMod.ModElement {
	public ProcedureErrorcmdCommandExecuted(ElementsCryptorMod instance) {
		super(instance, 74);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ErrorcmdCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
				? ((EntityPlayerMP) entity).getAdvancements()
						.getProgress(((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("cryptormod:erroradv")))
						.isDone()
				: false)) {
			if (entity instanceof EntityPlayerMP) {
				Advancement _adv = ((MinecraftServer) ((EntityPlayerMP) entity).mcServer).getAdvancementManager()
						.getAdvancement(new ResourceLocation("cryptormod:erroradv"));
				AdvancementProgress _ap = ((EntityPlayerMP) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((EntityPlayerMP) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clear();
		} else {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clear();
			if (entity instanceof EntityPlayer) {
				((EntityPlayer) entity).capabilities.allowEdit = (true);
				((EntityPlayer) entity).sendPlayerAbilities();
			}
		}
	}
}
