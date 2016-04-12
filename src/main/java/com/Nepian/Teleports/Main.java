package com.Nepian.Teleports;

import org.bukkit.plugin.java.JavaPlugin;

import com.Nepian.Teleports.Configuration.Config;
import com.Nepian.Teleports.Configuration.Properties;

public class Main extends JavaPlugin {
	private static Main plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		
		Config.load();
		Properties.load();
		ListenerManager.load();
		CommandManager.load();
		TeleporterManagerOld.load();
		
	}
	
	@Override
	public void onDisable() {
		TeleporterManagerOld.save();
		Config.save();
	}
	
	public static Main getPlugin() {
		return plugin;
	}
}
