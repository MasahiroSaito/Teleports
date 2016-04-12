package com.Nepian.Teleports.Event.CommandAction;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.Nepian.Teleports.Messenger;
import com.Nepian.Teleports.TeleporterManagerOld;
import com.Nepian.Teleports.Data.CommandActionData;
import com.Nepian.Teleports.Data.TeleporterData;
import com.Nepian.Teleports.Event.CommandActionEvent;

public class TeleporterInformationEvent extends CommandActionEvent {

	public TeleporterInformationEvent(PlayerInteractEvent event, CommandActionData data) {
		super(event, data);
	}
	
	@Override
	public void execute() {

		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		
		if (!TeleporterManagerOld.hasTeleporterData(block)) {
			Messenger.sendLnPrefix(player, "&cThis block is not Teleporter!&r");
			return;
		}
		
		TeleporterData data = TeleporterManagerOld.getTeleporterData(block);
		
		Messenger.sendLnPrefix(player, "&eTeleporter Information&r");
		player.sendMessage(data.toString());
	}

}
