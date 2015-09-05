package nl.raspen0.StireTweaks.Testing;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class TestRegistry { 

	
	public static Item Pickaxe0;
	public static Item Pickaxe1;
	public static Item Pickaxe2;
	public static Item Pickaxe3;
	public static Item Pickaxe4;
	public static Item Pickaxe5;
	
	public static void init(){
		
		Pickaxe0 = new Pickaxe0(Item.ToolMaterial.IRON);
		Pickaxe1 = new Pickaxe1(Item.ToolMaterial.IRON);
		Pickaxe2 = new Pickaxe2(Item.ToolMaterial.IRON);
		Pickaxe3 = new Pickaxe3(Item.ToolMaterial.IRON);
		Pickaxe4 = new Pickaxe4(Item.ToolMaterial.IRON);
		Pickaxe5 = new Pickaxe5(Item.ToolMaterial.IRON);
		
		GameRegistry.registerItem(Pickaxe0, "Pickaxe0");
		GameRegistry.registerItem(Pickaxe1, "Pickaxe1");
		GameRegistry.registerItem(Pickaxe2, "Pickaxe2");
		GameRegistry.registerItem(Pickaxe3, "Pickaxe3");
		GameRegistry.registerItem(Pickaxe4, "Pickaxe4");
		GameRegistry.registerItem(Pickaxe5, "Pickaxe5");
	}
	
    /** Converts a EnumChat color to a Decimal Color Code */
	public static int ConvertColor (String string){
		
		if(string.equalsIgnoreCase("RED")){
			return 16711680;
		}
		if(string.equalsIgnoreCase("BLUE")){
			return 255;
		}
		if(string.equalsIgnoreCase("DARK_BLUE")){
			return 139;
		}
		if(string.equalsIgnoreCase("DARK_GREEN")){
			return 78368;
		}
		if(string.equalsIgnoreCase("DARK_AQUA")){
			return 30326;
		}
		if(string.equalsIgnoreCase("DARK_RED")){
			return 9109504;
		}
		if(string.equalsIgnoreCase("DARK_PURPLE")){
			return 8388736;
		}
		if(string.equalsIgnoreCase("GOLD")){
			return 13413376;
		}
		if(string.equalsIgnoreCase("GRAY")){
			return 8421504;
		}
		if(string.equalsIgnoreCase("DARK_GRAY")){
			return 5921370;
		}
		if(string.equalsIgnoreCase("GREEN")){
			return 65280;
		}
		if(string.equalsIgnoreCase("AQUA")){
			return 65535;
		}
		if(string.equalsIgnoreCase("LIGHT_PURPLE")){
			return 11731123;
		}
		if(string.equalsIgnoreCase("YELLOW")){
			return 16776960;
		}
		if(string.equalsIgnoreCase("WHITE")){
			return 16777215;
		}
		return 0;
	}
}
