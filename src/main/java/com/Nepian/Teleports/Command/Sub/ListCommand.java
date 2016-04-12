package com.Nepian.Teleports.Command.Sub;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;

import com.Nepian.Teleports.Messenger;
import com.Nepian.Teleports.TeleporterManagerOld;
import com.Nepian.Teleports.Command.CommandStrings;
import com.Nepian.Teleports.Command.SubCommand;
import com.Nepian.Teleports.Data.LocationStringable;
import com.Nepian.Teleports.Data.TeleporterData;
import com.Nepian.Teleports.Data.TeleporterType;

public class ListCommand extends SubCommand {
	
	public ListCommand() {
		super("list");
		setPermission(CommandStrings.BASE_PERM + "list");
	}

	@Override
	public void execute(CommandSender sender, String label, String[] args) throws CommandException {
		
		if (args.length == 0) {
			
			Messenger.sendLnPrefix(sender, "&eTeleports End Location List&r");
			
			StringBuffer message = new StringBuffer("");
			
			for (TeleporterData data : TeleporterManagerOld.getEndLocationDatas()) {
				String location = LocationStringable.toString(data.getBlockLocation());
				
				message.append(" # ");
				message.append("Name: ").append("&9").append(data.getName()).append("&r").append(", ");
				message.append("Location: ").append("&9").append(location).append("&r").append("\n");
			}
			
			Messenger.send(sender, message.toString());
			
			return;
		}
		
		if (args.length == 1) {
			
			if (!TeleporterManagerOld.hasName(args[0])) {
				Messenger.sendLnPrefix(sender, "&cTeleporter doesn't exists!&r");
				return;
			}
			
			String name = TeleporterManagerOld.getEndLocationData(args[0]).getName();
			
			Messenger.sendLnPrefix(sender, "&eTeleports Start Teleporter List of &d[" + name + "]&r");
			
			StringBuilder message = new StringBuilder("");
			
			for (TeleporterData data :TeleporterManagerOld.getTeleportLocationDatas()) {
			
				if (data.getType() != TeleporterType.START) {
					continue;
				}
				
				if (!data.getName().equalsIgnoreCase(name)) {
					continue;
				}
				
				String owner = data.getOwner().getName();
				String location = LocationStringable.toString(data.getBlockLocation());
				
				message.append(" # ");
				message.append("Owner: ").append("&9").append(owner).append("&r").append(", ");
				message.append("Location: ").append("&9").append(location).append("&r").append("\n");
			}
			
			Messenger.send(sender, message.toString());
			
			return;
		}
	}

	@Override
	public String getPossibleArguments() {
		return "<End Location Name>";
	}

	@Override
	public int getMinimumArguments() {
		return 0;
	}

	@Override
	public List<String> getTutorial() {
		return Arrays.asList("Show the list of teleports.");
	}

	@Override
	public SubCommandType getType() {
		return SubCommandType.GENERIC;
	}

}
