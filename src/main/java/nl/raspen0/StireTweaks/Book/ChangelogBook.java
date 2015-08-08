package nl.raspen0.StireTweaks.Book;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;
import nl.raspen0.StireTweaks.Items.ItemRegistry;
import nl.raspen0.StireTweaks.Utils.ConfigHandler;
import nl.raspen0.StireTweaks.Utils.FileLoader;
import nl.raspen0.StireTweaks.Utils.Strings;
import nl.raspen0.StireTweaks.Utils.TxtParser;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ChangelogBook extends ItemEditableBook {
	
	/**
	 * This class was copied and modified from Modpack Tweaks 
	 */

	public ChangelogBook()
	{
		super();
		setTextureName("Minecraft:book_written");
		setUnlocalizedName("ChangeBook");
	}

	@SideOnly(Side.CLIENT)
	public static void doBookGUI(EntityPlayer player, ItemStack stack, boolean par3)
	{
		Minecraft.getMinecraft().displayGuiScreen(new GuiScreenBook(player, stack, par3));
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (stack.stackTagCompound == null || !stack.getTagCompound().getString("version").equals(Strings.PackVersion))
		{
			if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
			{
				stack.setTagCompound(new NBTTagCompound());
				addTextToBook(stack);

				player.inventoryContainer.detectAndSendChanges();

				doBookGUI(player, stack, false);
				return stack;
			}
		}
		else if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
			doBookGUI(player, stack, false);
		return stack;
	}
	
	public ItemStack addTextToBook(ItemStack book)
	{
	    if (book.getTagCompound() == null)
	    {
	        book.stackTagCompound = new NBTTagCompound();
	    }
	    
		NBTTagCompound baseTag = book.getTagCompound();
		NBTTagList bookPages;

		baseTag.setString("author", "raspen0");
		
		List<String> text;

		baseTag.setString("title", "Stirecraft " + Strings.PackVersion + " Changelog");
		
		baseTag = book.getTagCompound();
		bookPages = new NBTTagList();
		
		text = ConfigHandler.changelog;
		
		if (text == null)
		{
			text = ConfigHandler.loadChangelogText(FileLoader.getChangelogText());
		}
		
		for (int i = 0; i < text.size(); i++)
		{
			bookPages.appendTag(new NBTTagString(text.get(i)));
		}

		baseTag.setTag("pages", bookPages);
		baseTag.setString("version", Strings.PackVersion);

	return book;
}
		
	public ItemStack getChangelog()
	{
		ConfigHandler.changelog = TxtParser.parseFileMain(FileLoader.getChangelogText());
		return addTextToBook(new ItemStack(ItemRegistry.book, 1, 1));
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return false;
	}
	
}
