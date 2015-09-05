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

public class Pickaxe2 extends ItemPickaxe {
	
	public Pickaxe2 (ToolMaterial material)
	{
		super(material);
		this.setHarvestLevel("pickaxe", 2);
		this.setTextureName("stone_pickaxe");
		if (Loader.isModLoaded("HarvestTooltips")) {
			this.setUnlocalizedName(EnumChatFormatting.getValueByName(HarvestTooltips.Color2) + "pickaxe2");
		}
		else if(!Loader.isModLoaded("HarvestTooltips")){
			this.setUnlocalizedName("Pickaxe2");
		}

	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemstack, int renderPass){
		if (Loader.isModLoaded("HarvestTooltips")) {
		return TestRegistry.ConvertColor(HarvestTooltips.Color2);
		}
		else {
			return 0;
		}
	}

}