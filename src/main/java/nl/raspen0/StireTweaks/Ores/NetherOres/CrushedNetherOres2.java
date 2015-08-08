package nl.raspen0.StireTweaks.Ores.NetherOres;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CrushedNetherOres2 extends NetherOres2 {

    private IIcon theIcon;

    
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemstack, int renderPass)
    {
        if (renderPass == 1){ 
    		if (itemstack.getItemDamage() == 0) {
    			return 5660797;
    		}
    		if (itemstack.getItemDamage() == 1) {
    			return 8700228;
    		}
    		if (itemstack.getItemDamage() == 2) {
    			return 13402497;
    		}
    		if (itemstack.getItemDamage() == 3) {
    			return 6400587;
    		}
    		if (itemstack.getItemDamage() == 4) {
    			return 3422883;
    		}
        }
		return 10901849;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(int i, int j)
    {
        return j > 0 ? this.theIcon : super.getIconFromDamageForRenderPass(i, j);
    }
    
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
		return super.getUnlocalizedName() + "." + "nether" + "." + names[i];
	}
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister icon)
    {
        super.registerIcons(icon);
        this.theIcon = icon.registerIcon("StireTweaks:CrushedOre_overlay");
    }
    

    
}
