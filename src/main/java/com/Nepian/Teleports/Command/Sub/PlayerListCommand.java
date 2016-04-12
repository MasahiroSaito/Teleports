package com.Nepian.Teleports.Command.Sub;

import java.util.List;

import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Nepian.Teleports.PlayerManager;
import com.Nepian.Teleports.Command.CommandStrings;
import com.Nepian.Teleports.Command.SubCommand;
import com.Nepian.Teleports.Configuration.ActionType;

public class PlayerListCommand extends SubCommand {
	
	public PlayerListCommand() {
		super("playerlist");
		setPermission(CommandStrings.BASE_PERM + "playerlist");
	}

	@Override
	public void execute(CommandSender sender, String label, String[] args) throws CommandException {
		sender.sendMessage("");
		sender.sendMessage("Teleports Player List");
		
		for (Player player : PlayerManager.getPlayerActionTypes().keySet()) {
			ActionType type = PlayerManager.getPlayerActionType(player);
			sender.sendMessage(" # " + player.getName() + " : " + type.toString());
		}
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
		return SubCommandType.HIDDEN;
	}

}
