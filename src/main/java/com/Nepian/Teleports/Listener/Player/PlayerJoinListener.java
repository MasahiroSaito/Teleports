package com.Nepian.Teleports.Listener.Player;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.Nepian.Teleports.Main;
import com.Nepian.Teleports.PlayerManager;

public class PlayerJoinListener implements Listener {

	@EventHandler(priority = EventPriority.MONITOR)
	public static void onPlayerJoin(final PlayerJoinEvent event) {
		Bukkit.getScheduler().runTaskAsynchronously(Main.getPlugin(), new Runnable() {
			@Override
			public void run() {
				PlayerManager.addPlayer(event.getPlayer());
			}
		});
	}
}
