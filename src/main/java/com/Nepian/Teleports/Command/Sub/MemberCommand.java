package com.Nepian.Teleports.Command.Sub;

import java.util.List;

import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Nepian.Teleports.Command.CommandStrings;
import com.Nepian.Teleports.Command.SubCommand;

public class MemberCommand extends SubCommand {
	
	public MemberCommand() {
		super("member");
		setPermission(CommandStrings.BASE_PERM + "member");
	}

	@Override
	public void execute(CommandSender sender, String label, String[] args) throws CommandException {
		
		if (!(sender instanceof Player)) {
			return;
		}
		
//		Player player = (Player) sender;
//		Pattern pat = Pattern.compile("add|remove", Pattern.CASE_INSENSITIVE);
//		String subCommand = args[0];
//		
//		if (!pat.matcher(subCommand).matches()) {
//			player.sendMessage("Invalid args");
//			return;
//		}
//		
//		Pattern add = Pattern.compile("add", Pattern.CASE_INSENSITIVE);
//		Pattern remove = Pattern.compile("remove", Pattern.CASE_INSENSITIVE);
//		
//		if (add.matcher(subCommand).matches()) {
//			String name = args[1];
//			OfflinePlayer data = PlayerUtil.getOfflinePlayer(name);
//			
//			if (data == null) {
//				sender.sendMessage("Not found the player of such a name.");
//				return;
//			}
//			
//			ActionType type = ActionType.COMMAND_MEMBER_ADD;
//			PlayerManager.setPlayerAction(player, type, data);
//			
//		} else if (remove.matcher(subCommand).matches()) {
//			String name = args[1];
//			OfflinePlayer data = PlayerUtil.getOfflinePlayer(name);
//			
//			if (data == null) {
//				sender.sendMessage("Not found the player of such a name.");
//				return;
//			}
//			
//			ActionType type = ActionType.COMMAND_MEMBER_REMOVE;
//			PlayerManager.setPlayerAction(player, type, data);
//			
//		}

		sender.sendMessage("Please Right-Click the block you want to add member.");
	}

	@Override
	public String getPossibleArguments() {
		return "<add/remove> <player>";
	}

	@Override
	public int getMinimumArguments() {
		return 2;
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
