package nl.raspen0.StireTweaks.Book;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.FakePlayer;
import nl.raspen0.StireTweaks.Items.ItemRegistry;
import nl.raspen0.StireTweaks.Utils.ConfigHandler;
import nl.raspen0.StireTweaks.Utils.Strings;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class BookEvent {
	
	/**
	 * This class was copied and modified from Modpack Tweaks 
	 */

	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent event)
	{
		addBook(event.player);
	}
	
	private boolean addBook(EntityPlayer player)
	{
		if (player != null  && !player.worldObj.isRemote)
		{
			if (!player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getString("LastVersion").equals(Strings.PackVersion)){
				if (ConfigHandler.debug){
				Strings.logger.info("Giving Changelog to " + player.getDisplayName());
				}
				NBTTagCompound persist = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
				persist.setString("LastVersion", Strings.PackVersion);
				player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persist);
				
				ItemStack stack = ItemRegistry.book.getChangelog();
				ItemRegistry.spawnItemAtPlayer(player, stack);
				//player.inventory.addItemStackToInventory(stack);
				return true;
			}
			if (player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getString("LastVersion").equals(Strings.PackVersion)){
				if (ConfigHandler.debug){
				Strings.logger.info("Player " + player.getDisplayName() + " has newest changelog");
				}
				return true;
			}
		}
		else
		Strings.logger.error("Error with changelog of " + player.getDisplayName());
		return false;
	}
	


}
