package com.Nepian.Teleports.Event;

import org.bukkit.event.player.PlayerInteractEvent;

import com.Nepian.Teleports.Data.CommandActionData;

public abstract class CommandActionEvent extends CancellableEvent {

	protected PlayerInteractEvent event;
	protected CommandActionData data;
	
	public CommandActionEvent(PlayerInteractEvent event, CommandActionData data) {
		super();
		this.event = event;
		this.data = data;
	}
	
	public abstract void execute();
	
	/* Getter -----------------------------------------------------------------------------------*/
	
	public PlayerInteractEvent getEvent() {
		return event;
	}
	
	public CommandActionData getData() {
		return data;
	}
}
