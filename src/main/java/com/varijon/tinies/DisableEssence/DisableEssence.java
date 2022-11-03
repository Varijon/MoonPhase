package com.varijon.tinies.DisableEssence;


import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid="disableessence", version="1.0.1", acceptableRemoteVersions="*")
public class DisableEssence
{
	public static String MODID = "modid";
	public static String VERSION = "version";

		
	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{

	}
	
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		MinecraftForge.EVENT_BUS.register(new DisableEssenceHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
	}

}