package nl.raspen0.StireTweaks.Ores.NetherOres;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CrushedNetherOres extends NetherOres {

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
    			return 14208147;
    		}
    		if (itemstack.getItemDamage() == 1) {
    			return 4416394;
    		}
    		if (itemstack.getItemDamage() == 2) {
    			return 3355443;
    		}
    		if (itemstack.getItemDamage() == 3) {
    			return 4910545;
    		}
    		if (itemstack.getItemDamage() == 4) {
    			return 14605824;
    		}
    		if (itemstack.getItemDamage() == 5) {
    			return 12360064;
    		}
    		if (itemstack.getItemDamage() == 6) {
    			return 2247599;
    		}
    		if (itemstack.getItemDamage() == 7) {
    			return 16176466;
    		}
    		if (itemstack.getItemDamage() == 8) {
    			return 13619151;
    		}
    		if (itemstack.getItemDamage() == 9) {
    			return 14671289;
    		}
    		if (itemstack.getItemDamage() == 10) {
    			return 9665644;
    		}
    		if (itemstack.getItemDamage() == 11) {
    			return 7471104;
    		}
    		if (itemstack.getItemDamage() == 12) {
    			return 11953712;
    		}
    		if (itemstack.getItemDamage() == 13) {
    			return 14737632;
    		}
    		if (itemstack.getItemDamage() == 14) {
    			return 45112;
    		}
    		if (itemstack.getItemDamage() == 15) {
    			return 10272970;
    		}
    		if (itemstack.getItemDamage() == 16) {
    			return 9999204;
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
