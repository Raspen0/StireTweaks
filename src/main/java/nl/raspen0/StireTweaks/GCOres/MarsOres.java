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

public class MarsOres extends Item {

	public MarsOres() {
		this.setHasSubtypes(true);
		setCreativeTab(StirecraftTweaks.tabSTweaks);
	}

	public static final String[] names = new String[] { "copper", "tin", "iron"};

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
		return super.getUnlocalizedName() + "." + "mars" + "." + names[i];
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		icons = new IIcon[3];

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
			return 11953712;
		}
		if (itemstack.getItemDamage() == 1) {
			return 14737632;
		}
		if (itemstack.getItemDamage() == 2) {
			return 12360064;
		}
		
		return 16777215;

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		for (int x = 0; x < 3; x++) {
			par3List.add(new ItemStack(this, 1, x));
		}
	}
}