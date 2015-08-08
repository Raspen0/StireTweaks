package nl.raspen0.StireTweaks.Ores.Metallurgy;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CrushedMetallurgyEndOres extends  MetallurgyEndOres {

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
    			return 6637946;
    		}
    		if (itemstack.getItemDamage() == 1) {
    			return 4603214;
    		}
        }
		return 14278302;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(int i, int j)
    {
        return j > 0 ? this.theIcon : super.getIconFromDamageForRenderPass(i, j);
    }
    
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
		return super.getUnlocalizedName() + "." + names[i];
	}
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister icon)
    {
        super.registerIcons(icon);
        this.theIcon = icon.registerIcon("StireTweaks:CrushedOre_overlay");
    }
    

    
}
