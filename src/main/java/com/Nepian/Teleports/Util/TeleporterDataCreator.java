package com.Nepian.Teleports.Util;

import org.bukkit.event.player.PlayerInteractEvent;

import com.Nepian.Teleports.Data.CommandActionData;
import com.Nepian.Teleports.Data.TeleporterData;
import com.Nepian.Teleports.Event.CommandAction.TeleporterCreatingEvent;

public class TeleporterDataCreator {

	public static TeleporterData newInstance(TeleporterCreatingEvent event) {
		PlayerInteractEvent eve = event.getEvent();
		CommandActionData data = event.getData();
		return new TeleporterData(eve.getPlayer(), eve.getClickedBlock(), data.asString());
	}
}
