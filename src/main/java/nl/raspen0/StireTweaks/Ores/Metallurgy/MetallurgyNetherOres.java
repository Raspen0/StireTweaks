package nl.raspen0.StireTweaks.Ores.Metallurgy;

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

public class MetallurgyNetherOres extends Item {

	public MetallurgyNetherOres() {
		this.setHasSubtypes(true);
		setCreativeTab(StirecraftTweaks.tabSTweaks);
	}

	public static final String[] names = new String[] { "ignatius",
			"shadowiron", "lemurite", "midasium", "vyroxeres", "ceruclase",
			"alduorite", "kalendrite", "vulcanite", "sanguinite" };

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
		return super.getUnlocalizedName() + "." + names[i];
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		icons = new IIcon[10];

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
		
		return 16777215;

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		for (int x = 0; x < 10; x++) {
			par3List.add(new ItemStack(this, 1, x));
		}
	}
}