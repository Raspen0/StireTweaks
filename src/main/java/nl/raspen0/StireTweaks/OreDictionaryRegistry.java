package nl.raspen0.StireTweaks;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import nl.raspen0.StireTweaks.Items.ItemRegistry;
import nl.raspen0.StireTweaks.Utils.ConfigHandler;

public class OreDictionaryRegistry {
	
    public static void mainRegistry(){
    	MetallurgyOres();
    	Misc();
    }
    
    
	public static void MetallurgyOres() {
	    ItemStack Ignatius = new ItemStack(ItemRegistry.CrushedMNetherOre);
	    ItemStack ShadowIron = new ItemStack(ItemRegistry.CrushedMNetherOre);
	    ItemStack Lemurite = new ItemStack(ItemRegistry.CrushedMNetherOre);
	    ItemStack Midasium = new ItemStack(ItemRegistry.CrushedMNetherOre);
	    ItemStack Vyroxeres = new ItemStack(ItemRegistry.CrushedMNetherOre);
	    ItemStack Ceruclase = new ItemStack(ItemRegistry.CrushedMNetherOre);
	    ItemStack Alduorite = new ItemStack(ItemRegistry.CrushedMNetherOre);
	    ItemStack Kalendrite = new ItemStack(ItemRegistry.CrushedMNetherOre);
	    ItemStack Vulcanite = new ItemStack(ItemRegistry.CrushedMNetherOre);
	    ItemStack Sanguinite = new ItemStack(ItemRegistry.CrushedMNetherOre);
	    
	    ShadowIron.setItemDamage(1);
	    Lemurite.setItemDamage(2);
	    Midasium.setItemDamage(3);
	    Vyroxeres.setItemDamage(4);
	    Ceruclase.setItemDamage(5);
	    Alduorite.setItemDamage(6);
	    Kalendrite.setItemDamage(7);
	    Vulcanite.setItemDamage(8);
	    Sanguinite.setItemDamage(9);
	    
		OreDictionary.registerOre("crushedIgnatius", Ignatius);
		OreDictionary.registerOre("crushedShadowIron", ShadowIron);
		OreDictionary.registerOre("crushedLemurite", Lemurite);
		OreDictionary.registerOre("crushedMidasium", Midasium);
		OreDictionary.registerOre("crushedVyroxeres", Vyroxeres);
		OreDictionary.registerOre("crushedCeruclase", Ceruclase);
		OreDictionary.registerOre("crushedAlduorite", Alduorite);
		OreDictionary.registerOre("crushedKalendrite", Kalendrite);
		OreDictionary.registerOre("crushedVulcanite", Vulcanite);
		OreDictionary.registerOre("crushedSanguinite", Sanguinite);
	}
	
	public static void Misc() {
	    ItemStack GearPurple = new ItemStack(ItemRegistry.GearPurple);
		OreDictionary.registerOre("gearManyullyn", GearPurple);
		
		ItemStack MyRaniumIngot = new ItemStack(ItemRegistry.MyRaniumIngot);
		OreDictionary.registerOre("ingotUranium", MyRaniumIngot);
	}
}
