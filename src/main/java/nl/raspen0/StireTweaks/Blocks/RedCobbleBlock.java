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

public class RedCobbleBlock extends Block
{
         public RedCobbleBlock(Material material) 
     {
             super(material);
                
                setHardness(1.6F);
                setStepSound(Block.soundTypeStone);
                setBlockName("redcobble");
                setCreativeTab(StirecraftTweaks.tabSTweaks);
                setBlockTextureName("StireTweaks:redcobble");
        }

        
        
        
}