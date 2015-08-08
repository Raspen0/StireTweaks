package nl.raspen0.StireTweaks.Items;


import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import nl.raspen0.StireTweaks.StirecraftTweaks;
import nl.raspen0.StireTweaks.Potion.PotionRegistry;
import nl.raspen0.StireTweaks.Utils.ConfigHandler;

public class Ingots extends Item{

	public Ingots()
	{
		super();
		setTextureName("StireTweaks:UraniumIngot");
		setUnlocalizedName("uraniumingot");
		setCreativeTab(StirecraftTweaks.tabSTweaks);
	}
	
    
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity,
			int par4, boolean par5) {
		if (ConfigHandler.uraniumpoison) {
			if (!world.isRemote) {
				if (entity instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer) entity;
					// if (player.inventory.armorItemInSlot(2) ==
					// Ic2Items.hazmatChestplate) {
					player.addPotionEffect(new PotionEffect(
							PotionRegistry.customPotion.id, 300, 5, false));
					entity.attackEntityFrom(PotionRegistry.Radiation, 1);
				}
			}
		}
	}
}
