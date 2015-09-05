package nl.raspen0.StireTweaks.Testing;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import nl.raspen0.HarvestTooltips.HarvestTooltips;

public class Pickaxe1 extends ItemPickaxe {
	
	public Pickaxe1(ToolMaterial material) {
		super(material);
		this.setHarvestLevel("pickaxe", 1);
		this.setTextureName("stone_pickaxe");
		if (Loader.isModLoaded("HarvestTooltips")) {
			this.setUnlocalizedName(EnumChatFormatting.getValueByName(HarvestTooltips.Color1) + "pickaxe1");
		}
		else if(!Loader.isModLoaded("HarvestTooltips")){
			this.setUnlocalizedName("Pickaxe1");
		}

	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemstack, int renderPass){
		if (Loader.isModLoaded("HarvestTooltips")) {
		return TestRegistry.ConvertColor(HarvestTooltips.Color1);
		}
		else {
			return 16777215;
		}

	}

}
