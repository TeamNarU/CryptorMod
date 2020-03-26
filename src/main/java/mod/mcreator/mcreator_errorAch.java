package mod.mcreator;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.Mod.Instance;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.advancements.critereon.AbstractCriterionInstance;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.advancements.CriteriaTriggers;

import java.util.Set;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonDeserializationContext;
import com.google.common.collect.Sets;
import com.google.common.collect.Maps;

public class mcreator_errorAch extends cryptormod.ModElement {

	public static final CustomAdvancementTrigger trigger = new CustomAdvancementTrigger();

	public mcreator_errorAch(cryptormod instance) {
		super(instance);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		CriteriaTriggers.register(trigger);
	}

	public static class CustomAdvancementTrigger implements ICriterionTrigger {

		private final Map<PlayerAdvancements, CustomAdvancementTrigger.Listeners> listeners = Maps.newHashMap();

		@Override
		public void addListener(PlayerAdvancements playerAdvancementsIn, ICriterionTrigger.Listener listener) {
			CustomAdvancementTrigger.Listeners listeners = this.listeners.get(playerAdvancementsIn);
			if (listeners == null) {
				listeners = new CustomAdvancementTrigger.Listeners(playerAdvancementsIn);
				this.listeners.put(playerAdvancementsIn, listeners);
			}
			listeners.add(listener);
		}

		@Override
		public void removeListener(PlayerAdvancements playerAdvancementsIn, ICriterionTrigger.Listener listener) {
			CustomAdvancementTrigger.Listeners listeners = this.listeners.get(playerAdvancementsIn);
			if (listeners != null) {
				listeners.remove(listener);
				if (listeners.listeners.isEmpty())
					this.listeners.remove(playerAdvancementsIn);
			}
		}

		@Override
		public void removeAllListeners(PlayerAdvancements playerAdvancementsIn) {
			this.listeners.remove(playerAdvancementsIn);
		}

		@Override
		public ResourceLocation getId() {
			return new ResourceLocation("errorach");
		}

		@Override
		public CustomAdvancementTrigger.Instance deserializeInstance(JsonObject json, JsonDeserializationContext context) {
			return new CustomAdvancementTrigger.Instance(this.getId());
		}

		public void triggerAdvancement(EntityPlayerMP parPlayer) {
			CustomAdvancementTrigger.Listeners listeners = this.listeners.get(parPlayer.getAdvancements());
			if (listeners != null)
				listeners.triggerAdvancement(parPlayer);
		}

		public static class Instance extends AbstractCriterionInstance {

			public Instance(ResourceLocation triggerID) {
				super(triggerID);
			}
		}

		static class Listeners {

			PlayerAdvancements playerAdvancements;
			Set<ICriterionTrigger.Listener> listeners = Sets.newHashSet();

			public Listeners(PlayerAdvancements playerAdvancementsIn) {
				this.playerAdvancements = playerAdvancementsIn;
			}

			public void triggerAdvancement(EntityPlayerMP player) {
				for (ICriterionTrigger.Listener listener1 : listeners)
					listener1.grantCriterion(playerAdvancements);
			}

			public void add(ICriterionTrigger.Listener listener) {
				this.listeners.add(listener);
			}

			public void remove(ICriterionTrigger.Listener listener) {
				this.listeners.remove(listener);
			}
		}
	}
}
