package nl.raspen0.StireTweaks.Blocks;

import java.util.Random;




import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.block.material.Material;
import nl.raspen0.StireTweaks.StirecraftTweaks;

public class IridiumOre extends Block
{
         public IridiumOre(Material material) 
     {
             super(material);
                
                setHardness(25F);
                setHarvestLevel("pickaxe", 9);
                setResistance(5.0F);
                setStepSound(Block.soundTypeStone);
                setBlockName("iridiumOre");
                setCreativeTab(StirecraftTweaks.tabSTweaks);
                setBlockTextureName("StireTweaks:iridiumOre");
        }

        
        
        
}