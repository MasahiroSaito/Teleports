package com.Nepian.Teleports.Configuration;

import java.lang.reflect.Constructor;

import org.bukkit.event.player.PlayerInteractEvent;

import com.Nepian.Teleports.Data.CommandActionData;
import com.Nepian.Teleports.Event.CommandActionEvent;
import com.Nepian.Teleports.Event.CommandAction.TeleporterCreatingEvent;
import com.Nepian.Teleports.Event.CommandAction.TeleporterDirectionEvent;
import com.Nepian.Teleports.Event.CommandAction.TeleporterInformationEvent;
import com.Nepian.Teleports.Event.CommandAction.TeleporterRemovingEvent;

public enum ActionType {

	TELEPORTER_CREATE(TeleporterCreatingEvent.class),
	TELEPORTER_REMOVE(TeleporterRemovingEvent.class),
	TELEPORTER_INFO(TeleporterInformationEvent.class),
	TELEPORTER_DIRECTION(TeleporterDirectionEvent.class),
	
	OTHER(null);
	
	private Class<? extends CommandActionEvent> eventClass;
	
	ActionType(Class<? extends CommandActionEvent> eventClass) {
		this.eventClass = eventClass;
	}
	
	public CommandActionEvent getEvent(PlayerInteractEvent event, CommandActionData data) {
		CommandActionEvent eve = null;
		
		for (Constructor<?> cons : eventClass.getConstructors()) {
			try {
				return eve = (CommandActionEvent) cons.newInstance(event, data);
			} catch (Exception e) {
				continue;
			}
		}
		
		return eve;
	}
}