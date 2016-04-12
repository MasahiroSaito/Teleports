package com.Nepian.Teleports.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.Nepian.Teleports.Event.CommandActionEvent;

public class CommandActionExecutor implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public static void onCommandAction(CommandActionEvent event) {
		
		if (event.isCancelled()) {
			return;
		}
		
		event.execute();
	}
}
