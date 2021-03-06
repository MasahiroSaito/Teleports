package com.Nepian.Teleports.Command.Sub;

import java.util.List;

import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Nepian.Teleports.Messenger;
import com.Nepian.Teleports.PlayerManager;
import com.Nepian.Teleports.Command.CommandStrings;
import com.Nepian.Teleports.Command.SubCommand;
import com.Nepian.Teleports.Configuration.ActionType;

public class InfoCommand extends SubCommand {
	
	public InfoCommand() {
		super("info");
		setPermission(CommandStrings.BASE_PERM + "info");
	}

	@Override
	public void execute(CommandSender sender, String label, String[] args) throws CommandException {
		
		if (!(sender instanceof Player)) {
			return;
		}
		
		Player player = (Player) sender;
		
		PlayerManager.setPlayerAction(player, ActionType.TELEPORTER_INFO);
		
		Messenger.sendLnPrefix(player, "&dPlease Right-Click the Teleporter.&r");
	}

	@Override
	public String getPossibleArguments() {
		return "";
	}

	@Override
	public int getMinimumArguments() {
		return 0;
	}

	@Override
	public List<String> getTutorial() {
		return null;
	}

	@Override
	public SubCommandType getType() {
		return SubCommandType.GENERIC;
	}

}
