package nl.raspen0.StireTweaks;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import nl.raspen0.StireTweaks.Items.ItemRegistry;
import nl.raspen0.StireTweaks.Utils.ConfigHandler;
import nl.raspen0.StireTweaks.Utils.Strings;

public class HasPlayedEvent {

	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent event) {
		hasPlayed(event.player);
	}

	
	private boolean hasPlayed(EntityPlayer player) {
			player.getEntityData().getCompoundTag("StireTweaks").setBoolean("Stirecraft3", true);
			if (ConfigHandler.debug) {
				Strings.logger.info("Logging" + player.getDisplayName());
			}
			return true;
	}
}
