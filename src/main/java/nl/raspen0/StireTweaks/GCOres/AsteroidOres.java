package nl.raspen0.StireTweaks.GCOres;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import nl.raspen0.StireTweaks.StirecraftTweaks;
import nl.raspen0.StireTweaks.Utils.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AsteroidOres extends Item {

	public AsteroidOres() {
		this.setHasSubtypes(true);
		setCreativeTab(StirecraftTweaks.tabSTweaks);
	}

	public static final String[] names = new String[] { "iron", "aluminum"};

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
		return super.getUnlocalizedName() + "." + "asteroid" + "." + names[i];
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		icons = new IIcon[2];

		for (int i = 0; i < icons.length; i++) {
			icons[i] = par1IconRegister.registerIcon(Strings.MODID + ":"
					+ (this.getUnlocalizedName().substring(5)));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
		return icons[par1];
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemstack, int i) {

		if (itemstack.getItemDamage() == 0) {
			return 12360064;
		}
		if (itemstack.getItemDamage() == 1) {
			return 12371414;
		}
		
		return 16777215;

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		for (int x = 0; x < 2; x++) {
			par3List.add(new ItemStack(this, 1, x));
		}
	}
}