package nl.raspen0.StireTweaks.WorldConversion;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import nl.raspen0.StireTweaks.Items.ItemRegistry;
import nl.raspen0.StireTweaks.Utils.ConfigHandler;
import nl.raspen0.StireTweaks.Utils.Strings;

public class RewardEvent {

	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent event) {
		giveRewardBag(event.player);
	}

	private boolean giveRewardBag(EntityPlayer player) {
		if (player.getEntityData().getCompoundTag("StireTweaks").getBoolean("Stirecraft2")
				&& !player.getEntityData().getCompoundTag("StireTweaks").getBoolean("hasRewardBag")) {
			ItemStack stack = new ItemStack(ItemRegistry.RewardBag);
			ItemRegistry.spawnItemAtPlayer(player, stack);
			player.getEntityData().getCompoundTag("StireTweaks").setBoolean("hasRewardBag", true);
			if (ConfigHandler.debug) {
				Strings.logger.info("Spawning RewardBag for " + player.getDisplayName());
			}
			return true;
		}
		if (ConfigHandler.debug) {
			Strings.logger.info("No RewardBag for " + player.getDisplayName());
		}
		return false;

	}
}
