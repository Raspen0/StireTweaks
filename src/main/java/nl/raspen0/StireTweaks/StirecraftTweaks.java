package nl.raspen0.StireTweaks;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.MinecraftForge;
import nl.raspen0.StireTweaks.Biomes.RedRockBiome;
import nl.raspen0.StireTweaks.Blocks.BlockRegistry;
import nl.raspen0.StireTweaks.Blocks.RedCobbleBlock;
import nl.raspen0.StireTweaks.Blocks.RedRockBlock;
import nl.raspen0.StireTweaks.Blocks.RedRockBrick;
import nl.raspen0.StireTweaks.Book.BookEvent;
import nl.raspen0.StireTweaks.WorldConversion.RewardEvent;
import nl.raspen0.StireTweaks.Items.ItemRegistry;
import nl.raspen0.StireTweaks.Potion.PotionEvent;
import nl.raspen0.StireTweaks.Potion.RadiationPotion;
import nl.raspen0.StireTweaks.Utils.ConfigHandler;
import nl.raspen0.StireTweaks.Utils.FileLoader;
import nl.raspen0.StireTweaks.Utils.Strings;
import nl.raspen0.StireTweaks.WorldConversion.RewardCommand;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Strings.MODID, version = Strings.VERSION)
public class StirecraftTweaks {

	public static BookEvent BookEvent;
	public static RewardEvent RewardEvent;
    public static BiomeGenBase biomeStireTweaks;

	public static CreativeTabs tabSTweaks = new CreativeTabs("StireTweaks") {
		public Item getTabIconItem() {
			return ItemRegistry.book;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Config Generation
		ConfigHandler.init(
				new File(event.getModConfigurationDirectory().getAbsolutePath() + "/StireTweaks/StireTweaks.cfg"));

		try {
			FileLoader.init(ConfigHandler.cfg, 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ConfigHandler.loadChangelogText(FileLoader.getChangelogText());

		// Changelogbook Event
		if (ConfigHandler.ChangeLog) {
			BookEvent = new BookEvent();
			FMLCommonHandler.instance().bus().register(BookEvent);
		}
		RewardEvent = new RewardEvent();
	    FMLCommonHandler.instance().bus().register(RewardEvent);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		ItemRegistry.TweakRegistry();

		if (ConfigHandler.redrock) {
			BlockRegistry.RedRock();
		}

		if (ConfigHandler.redrock) {
			BlockRegistry.Iridium();
		}

		if (ConfigHandler.CrushedNetherOres) {
			ItemRegistry.NetherOreRegistry();
		}

		if (ConfigHandler.CrushedMetallurgyOres) {
			ItemRegistry.MetallurgyRegistry();
		}

		if (ConfigHandler.CrushedGCOres) {
			ItemRegistry.GCOresRegistry();
		}

		// Register Biome (Doesn't generate, only for world conversion from 1.6)
		if (ConfigHandler.redrockbiome) {
			biomeStireTweaks = new RedRockBiome(180);

			BiomeDictionary.registerBiomeType(biomeStireTweaks, Type.MESA);
			// BiomeManager.addSpawnBiome(biomeStireTweaks);
		}

	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		event.registerServerCommand(new RewardCommand());
	}

}