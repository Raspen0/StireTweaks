package nl.raspen0.StireTweaks.Blocks;

import java.util.Random;





import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.material.Material;
import nl.raspen0.StireTweaks.StirecraftTweaks;

public class RedRockBlock extends Block
{
         public RedRockBlock(Material material) 
     {
             super(material);
                
                setHardness(1.0F);
                setStepSound(Block.soundTypeStone);
                setBlockName("redrock");
                setCreativeTab(StirecraftTweaks.tabSTweaks);
                setBlockTextureName("StireTweaks:redrock");
        }
         
         
         @Override
         public Item getItemDropped(int metadata, Random random, int fortune) {
             return Item.getItemFromBlock(BlockRegistry.RedCobbleBlock);
         }
         
         

        
}