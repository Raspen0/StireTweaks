package nl.raspen0.StireTweaks.Blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import nl.raspen0.StireTweaks.Utils.ConfigHandler;

public class BlockRegistry {

	public final static Block RedRockBlock = new RedRockBlock(Material.rock);
	public final static Block RedCobbleBlock = new RedCobbleBlock(Material.rock);
	public final static Block RedRockBrick = new RedRockBrick(Material.rock);

	public final static Block IridiumOre = new IridiumOre(Material.rock);

	public static void init() {
		RedRock();
		Iridium();
	}

	public static void RedRock() {

		ItemStack RedRock = new ItemStack(RedRockBlock);
		ItemStack RedCobble = new ItemStack(RedCobbleBlock);
		ItemStack RedBricks = new ItemStack(RedRockBrick);
		
		GameRegistry.registerBlock(RedRockBlock, "RedRock");
		GameRegistry.registerBlock(RedCobbleBlock, "RedCobble");
		GameRegistry.registerBlock(RedRockBrick, "RedRockBrick");

		GameRegistry.addSmelting(RedCobble, RedRock, 0.1f);

		GameRegistry.addShapelessRecipe(new ItemStack(RedRockBrick, 4), RedRock, RedRock, RedRock, RedRock);
		
	}

	public static void Iridium() {
		GameRegistry.registerBlock(IridiumOre, "IridiumOre");
	}
}
