package com.Nepian.Teleports;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;

import com.Nepian.Teleports.Listener.CommandActionExecutor;
import com.Nepian.Teleports.Listener.CommandActionHandler;
import com.Nepian.Teleports.Listener.TeleporterRemovingListener;
import com.Nepian.Teleports.Listener.Player.PlayerJoinListener;
import com.Nepian.Teleports.Listener.Player.PlayerQuitListener;
import com.Nepian.Teleports.Listener.PlayerTeleport.PlayerTeleportEndPrivateChecker;
import com.Nepian.Teleports.Listener.PlayerTeleport.PlayerTeleportExecutor;
import com.Nepian.Teleports.Listener.PlayerTeleport.PlayerTeleportLocationChecker;
import com.Nepian.Teleports.Listener.PlayerTeleport.PlayerTeleportSounder;
import com.Nepian.Teleports.Listener.PlayerTeleport.PlayerTeleportStartPrivateChecker;
import com.Nepian.Teleports.Listener.TeleporterUsing.UsingButtonTeleporterListener;
import com.Nepian.Teleports.Listener.TeleporterUsing.UsingPlateTeleporterListener;
import com.Nepian.Teleports.Listener.TeleporterUsing.UsingSignTeleporterListener;

public class ListenerManager {
	private static final Main plugin;

	static {
		plugin = Main.getPlugin();
	}
	
	public static void load() {
		registerListener(new CommandActionHandler());
		registerListener(new CommandActionExecutor());
		registerListener(new TeleporterRemovingListener());
		
		registerTeleporterPlayerListener();
		
		registerTeleporterUsingListener();
		registerTeleporterSettingListener();
		
		registerPlayerTeleportListener();
	}

	public static void callEvent(Event event) {
		Bukkit.getPluginManager().callEvent(event);
	}

	public static void registerListener(Listener listener) {
		plugin.getServer().getPluginManager().registerEvents(listener, plugin);
	}
	
	/* Private Methods --------------------------------------------------------------------------*/
	
	private static void registerTeleporterPlayerListener() {
		registerListener(new PlayerJoinListener());
		registerListener(new PlayerQuitListener());
	}
	
	private static void registerTeleporterUsingListener() {
		registerListener(new UsingPlateTeleporterListener());
		registerListener(new UsingButtonTeleporterListener());
		registerListener(new UsingSignTeleporterListener());
	}
	
	private static void registerTeleporterSettingListener() {
//		registerListener(new SettingTeleporterMemberListener());
//		registerListener(new SettingTeleporterPrivateListener());
	}
	
	private static void registerPlayerTeleportListener() {
		registerListener(new PlayerTeleportLocationChecker());
		registerListener(new PlayerTeleportStartPrivateChecker());
		registerListener(new PlayerTeleportEndPrivateChecker());
		registerListener(new PlayerTeleportExecutor());
		registerListener(new PlayerTeleportSounder());
	}
}
