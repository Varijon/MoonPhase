package com.varijon.tinies.DisableEssence;


import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;

public class DisableEssenceHandler 
{
	public DisableEssenceHandler()
	{	
	}

	@SubscribeEvent
	public void onChatReceive (ClientChatReceivedEvent event)
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
			if(event.getMessage().getFormattedText().contains(" essence was added to your inventory!"))
			{
				event.setCanceled(true);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
