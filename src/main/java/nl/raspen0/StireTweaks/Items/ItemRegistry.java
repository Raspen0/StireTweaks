package nl.raspen0.StireTweaks.Items;

import java.lang.reflect.Method;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import nl.raspen0.StireTweaks.OreDictionaryRegistry;
import nl.raspen0.StireTweaks.Blocks.IridiumOre;
import nl.raspen0.StireTweaks.Book.ChangelogBook;
import nl.raspen0.StireTweaks.GCOres.AsteroidOres;
import nl.raspen0.StireTweaks.GCOres.CrushedAsteroidOres;
import nl.raspen0.StireTweaks.GCOres.CrushedMarsOres;
import nl.raspen0.StireTweaks.GCOres.MarsOres;
import nl.raspen0.StireTweaks.Ores.Metallurgy.CrushedMetallurgyEndOres;
import nl.raspen0.StireTweaks.Ores.Metallurgy.CrushedMetallurgyNetherOres;
import nl.raspen0.StireTweaks.Ores.Metallurgy.MetallurgyEndOres;
import nl.raspen0.StireTweaks.Ores.Metallurgy.MetallurgyNetherOres;
import nl.raspen0.StireTweaks.Ores.NetherOres.CrushedNetherOres;
import nl.raspen0.StireTweaks.Ores.NetherOres.CrushedNetherOres2;
import nl.raspen0.StireTweaks.Utils.ConfigHandler;
import nl.raspen0.StireTweaks.Utils.Strings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import codechicken.nei.api.API;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRegistry {

	public static ChangelogBook book;
	public static Item CrushedMNetherOre;
	public static Item CrushedMEndOre;
	public static Item PurifiedMNetherOre;
	public static Item PurifiedMEndOre;

	public static Item CrushedTFOre;

	public static Item CrushedMekanismOre;

	public static Item CrushedNetherOre;
	public static Item CrushedNetherOre2;

	public static Item CrushedGCMarsOre;
	public static Item CrushedGCAsteroidOre;
	public static Item PurifiedGCMarsOre;
	public static Item PurifiedGCAsteroidOre;

	public static Item RewardBag;

	public static Item GearPurple;
	public static Item DrillPurple;
	public static Item MyRaniumIngot;

	public static void init() {
		MetallurgyRegistry();
		NetherOreRegistry();
		GCOresRegistry();
		TweakRegistry();
	}

	public static void TweakRegistry() {
		GearPurple = new Gears();
		GameRegistry.registerItem(GearPurple, "GearPurple");
		
        GameRegistry.addRecipe(new ShapedOreRecipe(GearPurple, true, new Object[]{
                " F ", "FGF", " F ", Character.valueOf('F'), "ingotManyullyn", Character.valueOf('G'), "gearDiamond"}));
		
		
		DrillPurple = new Drill();
		GameRegistry.registerItem(DrillPurple, "DrillPurple");
		
        GameRegistry.addRecipe(new ShapedOreRecipe(DrillPurple, true, new Object[]{
                "FF ", " FF", "FF ", Character.valueOf('F'), "ingotManyullyn"}));
		
		MyRaniumIngot = new Ingots();
		GameRegistry.registerItem(MyRaniumIngot, "UraniumIngot");
		
		
		
		
		book = new ChangelogBook();
		GameRegistry.registerItem(book, "ChangelogBook");
		API.hideItem(new ItemStack(book));

		RewardBag = new nl.raspen0.StireTweaks.WorldConversion.RewardBag().setUnlocalizedName("RewardBag");
		GameRegistry.registerItem(RewardBag, "RewardBag");
		API.hideItem(new ItemStack(RewardBag));
	}

	public static void GCOresRegistry() {
		CrushedGCMarsOre = new CrushedMarsOres().setUnlocalizedName("CrushedOreColor");
		CrushedGCAsteroidOre = new CrushedAsteroidOres().setUnlocalizedName("CrushedOreColor");

		GameRegistry.registerItem(CrushedGCMarsOre, "CrushedGCMarsOre");
		GameRegistry.registerItem(CrushedGCAsteroidOre, "CrushedGCAsteroidOre");
	}


	public static void NetherOreRegistry() {

		CrushedNetherOre = new CrushedNetherOres().setUnlocalizedName("CrushedOre");
		CrushedNetherOre2 = new CrushedNetherOres2().setUnlocalizedName("CrushedOre");

		GameRegistry.registerItem(CrushedNetherOre, "CrushedNetherOre");
		GameRegistry.registerItem(CrushedNetherOre2, "CrushedNetherOre2");
	}

	public static void MetallurgyRegistry() {
		CrushedMNetherOre = new CrushedMetallurgyNetherOres().setUnlocalizedName("CrushedOre");
		CrushedMEndOre = new CrushedMetallurgyEndOres().setUnlocalizedName("CrushedOreColor");

		PurifiedMNetherOre = new MetallurgyNetherOres().setUnlocalizedName("PurifiedOre");
		PurifiedMEndOre = new MetallurgyEndOres().setUnlocalizedName("PurifiedOre");

		GameRegistry.registerItem(CrushedMNetherOre, "CrushedMNetherOre");
		GameRegistry.registerItem(CrushedMEndOre, "CrushedMEndOre");

		GameRegistry.registerItem(PurifiedMNetherOre, "PurifiedMNetherOre");
		GameRegistry.registerItem(PurifiedMEndOre, "PurifiedMEndOre");
		
		//Register Crushed Metallurgy Ores in the OreDictionary
		OreDictionaryRegistry.MetallurgyOres();
	}


	public static void spawnItemAtPlayer(EntityPlayer player, ItemStack stack) {
		if (!player.worldObj.isRemote) {
			EntityItem entityitem = new EntityItem(player.worldObj, player.posX + 0.5D, player.posY + 0.5D,
					player.posZ + 0.5D, stack);
			player.worldObj.spawnEntityInWorld(entityitem);
			if (!(player instanceof FakePlayer))
				entityitem.onCollideWithPlayer(player);
		}
	}

}
