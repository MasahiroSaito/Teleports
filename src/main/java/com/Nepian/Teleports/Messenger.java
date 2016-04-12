package com.Nepian.Teleports;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Messenger {

	public static final String prefix = "&7[Teleports]&r ";
	
	public static void sendPrefix(CommandSender sender, String message) {
		send(sender, prefix + message);
	}
	
	public static void sendLnPrefix(CommandSender sender, String message) {
		send(sender, "\n" + prefix + message);
	}
	
	public static void send(CommandSender sender, String message) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
	}
}
