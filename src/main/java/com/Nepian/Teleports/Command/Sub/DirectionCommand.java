package com.Nepian.Teleports.Command.Sub;

import java.util.List;
import java.util.regex.Pattern;

import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Nepian.Teleports.Messenger;
import com.Nepian.Teleports.PlayerManager;
import com.Nepian.Teleports.Command.CommandStrings;
import com.Nepian.Teleports.Command.SubCommand;
import com.Nepian.Teleports.Configuration.ActionType;
import com.Nepian.Teleports.Data.CommandActionData;

public class DirectionCommand extends SubCommand {
	
	private final Pattern pat;
	
	public DirectionCommand() {
		super("direction");
		setPermission(CommandStrings.BASE_PERM + "direction");
		pat = Pattern.compile("NORTH|SOUTH|EAST|WEST", Pattern.CASE_INSENSITIVE);
	}

	@Override
	public void execute(CommandSender sender, String label, String[] args) throws CommandException {
		
		if (!(sender instanceof Player)) {
			return;
		}
		
		Player player = (Player) sender;
		
		if (!pat.matcher(args[0]).matches()) {
			Messenger.sendLnPrefix(player, "&cThis args &e" + args[0] + " &cis invalid!&r");
			return;
		}
		
		CommandActionData data = new CommandActionData(args[0]);
		
		PlayerManager.setPlayerAction(player, ActionType.TELEPORTER_DIRECTION, data);
		
		Messenger.sendLnPrefix(player, "&dPlease Right-Click the End Teleporter.&r");
	}

	@Override
	public String getPossibleArguments() {
		return "<NORTH/SOUTH/EAST/WEST>";
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
