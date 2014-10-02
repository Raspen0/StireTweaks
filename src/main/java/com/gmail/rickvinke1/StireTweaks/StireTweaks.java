package com.gmail.rickvinke1.StireTweaks;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;


import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = StireTweaks.MODID, version = StireTweaks.VERSION)
@NetworkMod(clientSideRequired=true)
public class StireTweaks
{
	
	
    public static final String MODID = Strings.MODID;
    public static final String VERSION = Strings.version;
    
    @EventHandler
    public void PreLoad(FMLPreInitializationEvent Event)
    {    	
    	playerTracker = new StireTweaksPlayerHandler();
        GameRegistry.registerPlayerTracker(playerTracker);
        MinecraftForge.EVENT_BUS.register(playerTracker);	
    }
    
    public static StireTweaksPlayerHandler playerTracker;
}
