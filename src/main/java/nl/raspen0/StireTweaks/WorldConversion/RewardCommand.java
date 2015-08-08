package nl.raspen0.StireTweaks.WorldConversion;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import nl.raspen0.StireTweaks.Items.ItemRegistry;

public class RewardCommand extends CommandBase{

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "st_rewardbag";
	}
	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/st_rewardbag";
	}

	@Override
	public List getCommandAliases() {
		return null;
	}
	
    public int getRequiredPermissionLevel()
    {
        return 2;
    }

	@Override
	public void processCommand(ICommandSender sender, String[] astring) {
		EntityPlayer player = (EntityPlayer)sender;
	    	ItemRegistry.spawnItemAtPlayer(player, (new ItemStack(ItemRegistry.RewardBag)));
	}

	@Override
    public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return sender.canCommandSenderUseCommand(this.getRequiredPermissionLevel(), this.getCommandName());
    }

	@Override
	public List addTabCompletionOptions(ICommandSender sender,
			String[] astring) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i) {
		return false;
	}

}
