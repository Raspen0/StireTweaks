package nl.raspen0.StireTweaks.Biomes;

import java.awt.Color;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import nl.raspen0.StireTweaks.StirecraftTweaks;
import nl.raspen0.StireTweaks.Blocks.BlockRegistry;

public class RedRockBiome extends BiomeGenBase {
	
	public RedRockBiome(int biomeId) {
		super(biomeId);
		this.setBiomeName("Red Mesa");
		this.setHeight(height_HighPlateaus);
		this.setDisableRain();
		this.setColor(15898486);
		this.topBlock = BlockRegistry.RedRockBlock;
	}
	
	@Override
	public int getSkyColorByTemp(float par1)
	{
		return 15898486;
	}
	
	
}
