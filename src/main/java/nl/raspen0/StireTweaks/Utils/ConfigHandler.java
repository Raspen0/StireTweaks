package nl.raspen0.StireTweaks.Utils;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigHandler {

	
	public static File cfg;
	public static List<String> changelog;
	public static List<String> bookText;
	
	public static boolean CrushedMetallurgyOres;
	public static boolean CrushedNetherOres;
	public static boolean CrushedGCOres;
	
	public static boolean redrock;
	public static boolean IridiumOre;
	
	public static boolean debug;
	public static boolean uraniumpoison;
	public static boolean RewardBag;
	public static boolean redrockbiome;
	public static boolean ChangeLog;
	public static String PackVersion;
	
	public static void init(File file)
	{
		cfg = file;
		
		Configuration config = new Configuration(file);
		config.load();
		
		
		CrushedMetallurgyOres = config.get("General", "Crushed Metallurgy Ores", true, "Enable the Crushed Metallurgy Ores").getBoolean(true);
		
		CrushedNetherOres = config.get("General", "Crushed Nether Ores", true, "Enable the Crushed Nether Ores").getBoolean(true);
		
		CrushedGCOres = config.get("General", "Crushed Galacticraft Ores", true, "Enable the Crushed Galacticraft Ores").getBoolean(true);
		
		redrock = config.get(Configuration.CATEGORY_GENERAL, "Enable Red Rock", true).getBoolean(true);
		
		IridiumOre = config.get("General", "Iridium Ore", true, "Enables Iridium Ore (Doesn't generate in the world)").getBoolean(true);
		
		RewardBag = config.get("General", "RewardBag", true, "Gives players who converted their Stirecraft 2 world a Reward").getBoolean(true);
		
		uraniumpoison = config.get("General", "Uranium Ingot Radiation", false, "Gives you a Radiation poison effect when holding a Uranium Ingot").getBoolean(true);
		
		redrockbiome = config.get("General", "RedRock Biome", true, "Registers the RedRock Biome (This biome does not generate in the world and is incomplete)").getBoolean(true);
		
		ChangeLog = config.get("General", "Changelog", true, "Give Changelog").getBoolean(true);
		
		PackVersion = config.get("General", "PackVersion", "3.0.0" , "Pack Version").getString();
		
		debug = config.get("debug", "debug", false, "When enabled shows extra messages used for testing").getBoolean(true);
	
		
		config.save();
		
	}
	
	

	
	public static List<String> loadChangelogText(InputStream file)
	{
		changelog = file == null ? new ArrayList<String>() : TxtParser.parseFileMain(file);
		return changelog;
	}
}
