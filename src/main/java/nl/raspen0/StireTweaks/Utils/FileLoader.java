package nl.raspen0.StireTweaks.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * This class was copied and modified from Modpack Tweaks 
 */

public class FileLoader
{
	private static InputStream changelogText;

	public static void init(File file, int attempt) throws IOException
	{
		File dir = new File(file.getParent() + "");
		if (!dir.exists())
			dir.mkdir();
	}

	public static InputStream getChangelogText()
	{
		changelogText = loadFile(new File(ConfigHandler.cfg.getParent() + "/changelog.txt"));
		return changelogText;
	}
	
	private static InputStream loadFile(File file)
	{
		if (!file.exists())
		{
			FileWriter fw;
			try
			{
				file.createNewFile();
				fw = new FileWriter(file);
				fw.write("Default file, please make sure the correct file, " + file.getName() + ", exists in the StireTweaks config directory before launching next time!");
				fw.flush();
				fw.close();
			} catch (IOException e1) {
				Strings.logger.error("Could not create default file" + file.getName() + "!");
				e1.printStackTrace();
			}
		}

		try
		{
			return new FileInputStream(file);
		}
		catch (FileNotFoundException e)
		{
			IOErr(file.getName(), e);
			return null;
		}
	}
	
	private static void IOErr(String filename, IOException e)
	{
		Strings.logger.fatal("IO error while loading StirecraftTweaks, make sure nothing in the config folder is actively open and Minecraft has permission to read those files!");
		e.printStackTrace();
		throw new RuntimeException("IO Error in StireTweaks file loading, file: " + filename);
	}
}