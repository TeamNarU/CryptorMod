package mod.mcreator;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.Block;

import java.util.function.Supplier;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

@Mod(modid = cryptormod.MODID, version = cryptormod.VERSION, dependencies = "required-after:forge@[14.23.5.2768]")
public class cryptormod implements IFuelHandler, IWorldGenerator {

	public static final String MODID = "cryptormod";
	public static final String VERSION = "3.0.0";
	@SidedProxy(clientSide = "mod.mcreator.ClientProxycryptormod", serverSide = "mod.mcreator.CommonProxycryptormod")
	public static CommonProxycryptormod proxy;
	@Instance(MODID)
	public static cryptormod instance;
	public final List<ModElement> elements = new ArrayList<>();
	public final List<Supplier<Block>> blocks = new ArrayList<>();
	public final List<Supplier<Item>> items = new ArrayList<>();
	public final List<Supplier<Biome>> biomes = new ArrayList<>();
	public final List<Supplier<EntityEntry>> entities = new ArrayList<>();

	public cryptormod() {
		FluidRegistry.enableUniversalBucket();
		elements.add(new mcreator_cryptorFightBiome(this));
		elements.add(new mcreator_hurtGM(this));
		elements.add(new mcreator_lightGM(this));
		elements.add(new mcreator_rightGM(this));
		elements.add(new mcreator_fallGM(this));
		elements.add(new mcreator_cryptorXMobDies(this));
		elements.add(new mcreator_cryptorX(this));
		elements.add(new mcreator_cryptorCommonMobDies(this));
		elements.add(new mcreator_cryptorCommon(this));
		elements.add(new mcreator_cryptorModTab(this));
		elements.add(new mcreator_cryptorXArmor(this));
		elements.add(new mcreator_legFood(this));
		elements.add(new mcreator_cryptorXDefeated(this));
		elements.add(new mcreator_cryptorXSpawnRightClickedOnBlock(this));
		elements.add(new mcreator_cryptorXSpawn(this));
		elements.add(new mcreator_commonSpawnRightClickedOnBlock(this));
		elements.add(new mcreator_commonSpawn(this));
		elements.add(new mcreator_cryptorXSword(this));
		elements.add(new mcreator_cryptorBlock(this));
		elements.add(new mcreator_superTool(this));
		elements.add(new mcreator_youHackerCommandExecuted(this));
		elements.add(new mcreator_youHacker(this));
		elements.add(new mcreator_easterEgg(this));
		elements.add(new mcreator_cryptorCoin(this));
		elements.add(new mcreator_radicalDimension(this));
		elements.add(new mcreator_radicalWorldBlock(this));
		elements.add(new mcreator_radicalBiome(this));
		elements.add(new mcreator_cyberCryptor(this));
		elements.add(new mcreator_cyberSwordMobIsHitWithItem(this));
		elements.add(new mcreator_powerOfCyber(this));
		elements.add(new mcreator_cryptorMod(this));
		elements.add(new mcreator_cyberSword(this));
		elements.add(new mcreator_cyberGunBulletHitsPlayer(this));
		elements.add(new mcreator_cyberGunBulletHitsLivingEntity(this));
		elements.add(new mcreator_cyberGun(this));
		elements.add(new mcreator_cyberBullet(this));
		elements.add(new mcreator_bulletShooted(this));
		elements.add(new mcreator_cyberSpawnRightClickedOnBlock(this));
		elements.add(new mcreator_cyberSpawn(this));
		elements.add(new mcreator_xSwordCraft(this));
		elements.add(new mcreator_cyberSwordCraft(this));
		elements.add(new mcreator_cyberGunCraft(this));
		elements.add(new mcreator_multitoolCraft(this));
		elements.add(new mcreator_xHelmetCraft(this));
		elements.add(new mcreator_chestCraft(this));
		elements.add(new mcreator_legCraft(this));
		elements.add(new mcreator_bootsCraft(this));
		elements.add(new mcreator_merchantGUIItemPlacedInSlot(this));
		elements.add(new mcreator_merchantGUIItemPlacedInSlot2(this));
		elements.add(new mcreator_merchantGUIItemPlacedInSlot4(this));
		elements.add(new mcreator_merchantGUIItemPlacedInSlot6(this));
		elements.add(new mcreator_merchantGUIItemPlacedInSlot8(this));
		elements.add(new mcreator_merchantGUIItemPlacedInSlot10(this));
		elements.add(new mcreator_merchantGUIOnButtonClicked1(this));
		elements.add(new mcreator_merchantRightClickedOnMob(this));
		elements.add(new mcreator_merchant(this));
		elements.add(new mcreator_merchantSpawnEggRightClickedOnBlock(this));
		elements.add(new mcreator_merchantSpawnEgg(this));
		elements.add(new mcreator_explodeChickenMobIsHurt(this));
		elements.add(new mcreator_explodeChickenMobDies(this));
		elements.add(new mcreator_explodeChicken(this));
		elements.add(new mcreator_chickenDetonatorRightClickedInAir(this));
		elements.add(new mcreator_chickenDetonatorRightClickedOnBlock(this));
		elements.add(new mcreator_chickenDetonator(this));
		elements.add(new mcreator_chickenSpawnEggRightClickedOnBlock(this));
		elements.add(new mcreator_chickenSpawnEgg(this));
		elements.add(new mcreator_eRROR(this));
		elements.add(new mcreator_errorAch(this));
		elements.add(new mcreator_eRRORCommandExecuted(this));
		elements.add(new mcreator_merchantGUIItemPlacedInSlot0(this));
		elements.add(new mcreator_hiddenAch(this));
		elements.add(new mcreator_detonCraft(this));
		elements.add(new mcreator_coinCraft(this));
		elements.add(new mcreator_horrorCryptor(this));
		elements.add(new mcreator_helpmeplzCommandExecuted(this));
		elements.add(new mcreator_helpmeplz(this));
		elements.add(new mcreator_exeBlock(this));
		elements.add(new mcreator_exeDimension(this));
		elements.add(new mcreator_exeBiome(this));
		elements.add(new mcreator_scareAch(this));
		elements.add(new mcreator_cheatWeapon(this));
		elements.add(new mcreator_cheaterach(this));
		elements.add(new mcreator_bacterianMobDies(this));
		elements.add(new mcreator_bacterian(this));
		elements.add(new mcreator_horSwordMobIsHitWithItem(this));
		elements.add(new mcreator_horSword(this));
		elements.add(new mcreator_horSwordCraft(this));
	}

	@Override
	public int getBurnTime(ItemStack fuel) {
		for (ModElement element : elements) {
			int ret = element.addFuel(fuel);
			if (ret != 0)
				return ret;
		}
		return 0;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator cg, IChunkProvider cp) {
		elements.forEach(element -> element.generateWorld(random, chunkX * 16, chunkZ * 16, world, world.provider.getDimension(), cg, cp));
	}

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(blocks.stream().map(Supplier::get).toArray(Block[]::new));
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(items.stream().map(Supplier::get).toArray(Item[]::new));
	}

	@SubscribeEvent
	public void registerBiomes(RegistryEvent.Register<Biome> event) {
		event.getRegistry().registerAll(biomes.stream().map(Supplier::get).toArray(Biome[]::new));
	}

	@SubscribeEvent
	public void registerEntities(RegistryEvent.Register<EntityEntry> event) {
		event.getRegistry().registerAll(entities.stream().map(Supplier::get).toArray(EntityEntry[]::new));
	}

	@SubscribeEvent
	public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		elements.forEach(element -> element.registerModels(event));
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		GameRegistry.registerFuelHandler(this);
		GameRegistry.registerWorldGenerator(this, 5);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		elements.forEach(element -> element.preInit(event));
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		elements.forEach(element -> element.init(event));
		proxy.init(event);
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		elements.forEach(element -> element.serverLoad(event));
	}

	public static class GuiHandler implements IGuiHandler {

		@Override
		public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			return null;
		}

		@Override
		public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			return null;
		}
	}

	public static class ModElement {

		public static cryptormod instance;

		public ModElement(cryptormod instance) {
			this.instance = instance;
		}

		public void init(FMLInitializationEvent event) {
		}

		public void preInit(FMLPreInitializationEvent event) {
		}

		public void generateWorld(Random random, int posX, int posZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		}

		public void serverLoad(FMLServerStartingEvent event) {
		}

		public void registerModels(ModelRegistryEvent event) {
		}

		public int addFuel(ItemStack fuel) {
			return 0;
		}
	}
}
