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
import com.Nepian.Teleports.Data.CommandActionData;

public class CreateCommand extends SubCommand {
	
	public CreateCommand() {
		super("create");
		setPermission(CommandStrings.BASE_PERM + "create");
	}

	@Override
	public void execute(CommandSender sender, String label, String[] args) throws CommandException {
		
		if (!(sender instanceof Player)) {
			return;
		}
		
		Player player = (Player) sender;
		String name = args[0];
		CommandActionData data = new CommandActionData(name);
		
		PlayerManager.setPlayerAction(player, ActionType.TELEPORTER_CREATE, data);
		
		Messenger.sendLnPrefix(player, "&dRight-Click the block ( &bDIAMOND&d or &aEMERALD&d ).&r");
	}

	@Override
	public String getPossibleArguments() {
		return "<name>";
	}

	@Override
	public int getMinimumArguments() {
		return 1;
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
