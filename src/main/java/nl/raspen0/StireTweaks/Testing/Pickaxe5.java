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

public class Pickaxe5 extends ItemPickaxe {
	
	public Pickaxe5 (ToolMaterial material)
	{
		super(material);
		this.setHarvestLevel("pickaxe", 5);
		this.setTextureName("stone_pickaxe");
		if (Loader.isModLoaded("HarvestTooltips")) {
			this.setUnlocalizedName(EnumChatFormatting.getValueByName(HarvestTooltips.Color5) + "pickaxe5");
		}
		else if(!Loader.isModLoaded("HarvestTooltips")){
			this.setUnlocalizedName("Pickaxe5");
		}

	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemstack, int renderPass){
		if (Loader.isModLoaded("HarvestTooltips")) {
		return TestRegistry.ConvertColor(HarvestTooltips.Color5);
		}
		else {
			return 0;
		}
	}

}