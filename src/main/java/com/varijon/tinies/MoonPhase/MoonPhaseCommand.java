package com.varijon.tinies.MoonPhase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.IClientCommand;

public class MoonPhaseCommand extends CommandBase implements IClientCommand  {

	private List aliases;
	
	public MoonPhaseCommand()
	{
	   this.aliases = new ArrayList();
	   this.aliases.add("moon");
	}
	
	@Override
	public int compareTo(ICommand arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "moonphase";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "moonphase";
	}

	@Override
	public List<String> getAliases() {
		// TODO Auto-generated method stub
		return this.aliases;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException 
	{
		EntityPlayer player = (EntityPlayer) sender;
		sender.sendMessage(new TextComponentString(TextFormatting.GREEN + "Current Moon Phase is " + TextFormatting.GOLD + convertMoonPhase(player.getEntityWorld().getMoonPhase())));
		//		if(args.length == 2)
//		{
//			if(args[0].equals(""))
//			{
//				
//			}
//		}
//		if(args.length == 4)
//		{
//			if(args[0].equals("addevent"))
//			{
//				ConfigManager.getEventConfigList().add(new EventConfig(args[1], args[2], args[3], new ArrayList<EventPokemon>()));
//				ConfigManager
//				ConfigManager.loadConfig();
//			}
//		}
	    return;
	}
	
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) 
	{
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowUsageWithoutPrefix(ICommandSender sender, String message) {
		// TODO Auto-generated method stub
		return false;
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
