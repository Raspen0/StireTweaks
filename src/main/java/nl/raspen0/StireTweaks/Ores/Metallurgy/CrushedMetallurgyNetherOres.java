package nl.raspen0.StireTweaks.Ores.Metallurgy;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CrushedMetallurgyNetherOres extends  MetallurgyNetherOres {

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
    			return 16744448;
    		}
    		if (itemstack.getItemDamage() == 1) {
    			return 5389873;
    		}
    		if (itemstack.getItemDamage() == 2) {
    			return 13224393;
    		}
    		if (itemstack.getItemDamage() == 3) {
    			return 15897088;
    		}
    		if (itemstack.getItemDamage() == 4) {
    			return 4634625;
    		}
    		if (itemstack.getItemDamage() == 5) {
    			return 3567749;
    		}
    		if (itemstack.getItemDamage() == 6) {
    			return 5751233;
    		}
    		if (itemstack.getItemDamage() == 7) {
    			return 7681669;
    		}
    		if (itemstack.getItemDamage() == 8) {
    			return 15879936;
    		}
    		if (itemstack.getItemDamage() == 9) {
    			return 10420224;
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
		return super.getUnlocalizedName() + "." + names[i];
	}
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister icon)
    {
        super.registerIcons(icon);
        this.theIcon = icon.registerIcon("StireTweaks:CrushedOre_overlay");
    }
    

    
}
