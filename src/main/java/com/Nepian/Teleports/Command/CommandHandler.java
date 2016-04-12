package com.Nepian.Teleports.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.Nepian.Teleports.Messenger;
import com.Nepian.Teleports.Command.Sub.CreateCommand;
import com.Nepian.Teleports.Command.Sub.DirectionCommand;
import com.Nepian.Teleports.Command.Sub.HelpCommand;
import com.Nepian.Teleports.Command.Sub.InfoCommand;
import com.Nepian.Teleports.Command.Sub.ListCommand;
import com.Nepian.Teleports.Command.Sub.MemberCommand;
import com.Nepian.Teleports.Command.Sub.PlayerListCommand;
import com.Nepian.Teleports.Command.Sub.RemoveCommand;

public class CommandHandler implements CommandExecutor {
	
	private List<SubCommand> subCommands;
	
	public CommandHandler() {
		subCommands = new ArrayList<SubCommand>();
		
		/* GENERIC COMMANDS */
		registerSubCommand(new CreateCommand());
		registerSubCommand(new RemoveCommand());
		registerSubCommand(new InfoCommand());
		registerSubCommand(new DirectionCommand());
		registerSubCommand(new MemberCommand());
		registerSubCommand(new ListCommand());
		registerSubCommand(new HelpCommand(this));
		
		/* HIDDEN COMMANDS */
		registerSubCommand(new PlayerListCommand());
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (args.length == 0) {
			//TODO: 引数無しの場合の処理を記述
			return true;
		}
		
		for (SubCommand subCommand : subCommands) {
			if (subCommand.isValidTrigger(args[0])) {
				if (!subCommand.hasPermission(sender)) {
					Messenger.sendLnPrefix(sender, "&cYou don't have permission!&r");
					return true;
				}
				
				if (subCommand.getMinimumArguments() <= args.length - 1) {
					try {
						subCommand.execute(sender, label, Arrays.copyOfRange(args, 1, args.length));
					} catch (CommandException e) {
						Messenger.send(sender, e.getMessage());
					}
				} else {
					StringBuilder usage = new StringBuilder("Usage: /");
					usage.append(label).append(" ");
					usage.append(subCommand.getName()).append(" ");
					usage.append(subCommand.getPossibleArguments());
					Messenger.send(sender, usage.toString());
				}
				
				return true;
			}
		}
		
		Messenger.sendLnPrefix(sender, "Unknown sub-command. Type \"/" + label + " help\" for a list of commands.");
		
		return true;
	}
	
	public List<SubCommand> getSubCommand() {
		return this.subCommands;
	}
	
	private void registerSubCommand(SubCommand command) {
		subCommands.add(command);
	}
}
	