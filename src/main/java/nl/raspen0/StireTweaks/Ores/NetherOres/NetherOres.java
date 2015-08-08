package nl.raspen0.StireTweaks.Ores.NetherOres;

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

public class NetherOres extends Item {

	public NetherOres() {
		this.setHasSubtypes(true);
		setCreativeTab(StirecraftTweaks.tabSTweaks);
	}

	public static final String[] names = new String[] { "nickel",
		"osmium", "coal", "diamond", "gold",
		"iron", "lapis", "sulfur", "salt", "saltpeter",
		"magnesium", "redstone", "copper", "tin", "emerald", "silver"};

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
		return super.getUnlocalizedName() + "." + names[i];
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		icons = new IIcon[16];

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
		
		return 16777215;

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		for (int x = 0; x < 16; x++) {
			par3List.add(new ItemStack(this, 1, x));
		}
	}
}