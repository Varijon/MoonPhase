package com.varijon.tinies.MoonPhase;


import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;

public class MoonPhaseHandler 
{
	int oldPhase = -1;
	public MoonPhaseHandler()
	{	
	}

	@SubscribeEvent
	public void onWorldTick (ClientTickEvent event)
	{
		try
		{
			if(Minecraft.getMinecraft().player == null)
			{
				return;
			}
			if(Minecraft.getMinecraft().player.getEntityWorld() == null)
			{
				return;
			}
			if(Minecraft.getMinecraft().player.getEntityWorld().getMoonPhase() != oldPhase)
			{
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString(TextFormatting.GREEN + "Current Moon Phase is " + TextFormatting.GOLD + convertMoonPhase(Minecraft.getMinecraft().player.getEntityWorld().getMoonPhase())));
				oldPhase = Minecraft.getMinecraft().player.getEntityWorld().getMoonPhase();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public String convertMoonPhase(int phase)
	{
		switch(phase)
		{
			case 0:
				return "8: Full moon";
			case 2:
				return "2: Third quarter";
			case 3:
				return "3: Waning crescent";
			case 4:
				return "4: New moon";
			case 5:
				return "5: Waxing crescent";
			case 6:
				return "6: First quarter";
			case 1:
				return "1: Waning gibbous";
			case 7:
				return "7: Waxing gibbous";
		}
		return "nothing";
	}
}
