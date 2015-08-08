package nl.raspen0.StireTweaks.WorldConversion;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import nl.raspen0.StireTweaks.Items.ItemRegistry;
import nl.raspen0.StireTweaks.Utils.ConfigHandler;
import nl.raspen0.StireTweaks.Utils.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RewardBag extends Item{

	public RewardBag()
	{
		super();
		setUnlocalizedName("RewardBag");
	}
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemstack)
    {
            return true; 	
        }
	
    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack){
    	return EnumRarity.epic;
    }
    
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
    list.add("Gift for converting your world");
    list.add("from Stirecraft 2");
    }
    
    
    
    public boolean RewardBag;
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
 {
		if (!player.worldObj.isRemote) {
			if (ConfigHandler.RewardBag){
			if (!player.getEntityData().getCompoundTag(player.PERSISTED_NBT_TAG).getBoolean("RewardBag")) {

				world.playSoundAtEntity(player, "random.levelup", 1, 1);
				player.inventory.setInventorySlotContents(
						player.inventory.currentItem, null);
				ItemRegistry.spawnItemAtPlayer(player, new ItemStack(
						Items.nether_star, 5));
				ItemRegistry.spawnItemAtPlayer(player,
						new ItemStack(Items.apple, 5));

				NBTTagCompound persist = player.getEntityData().getCompoundTag(
						EntityPlayer.PERSISTED_NBT_TAG);
				persist.setBoolean("RewardBag", true);

				player.inventoryContainer.detectAndSendChanges();
				Strings.logger.info("RightClick");
				return stack;
			}
			else if (player.getEntityData().getCompoundTag(player.PERSISTED_NBT_TAG).getBoolean("RewardBag")){
				player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "You already opened a RewardBag!"));
			}
    	}
		}
		return stack;
    }
    
   
    
}
