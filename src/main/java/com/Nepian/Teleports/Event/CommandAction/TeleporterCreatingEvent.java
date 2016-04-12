package com.Nepian.Teleports.Event.CommandAction;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.Nepian.Teleports.Messenger;
import com.Nepian.Teleports.TeleporterManagerOld;
import com.Nepian.Teleports.Data.CommandActionData;
import com.Nepian.Teleports.Data.TeleporterType;
import com.Nepian.Teleports.Event.CommandActionEvent;
import com.Nepian.Teleports.Util.TeleporterDataCreator;

public class TeleporterCreatingEvent extends CommandActionEvent {
	
	public TeleporterCreatingEvent(PlayerInteractEvent event, CommandActionData data) {
		super(event, data);
	}

	@Override
	public void execute() {
		
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		String name = data.asString();
		
		if (TeleporterType.isOther(block)) {
			Messenger.sendLnPrefix(player, "&cThis block is not teleportable!&r");
			return;
		}
		
		if (TeleporterManagerOld.hasTeleporterData(block)) {
			Messenger.sendLnPrefix(player, "&cThis location already exists!&r");
			return;
		}
		
		if (TeleporterType.isEnd(block)) {
			if (TeleporterManagerOld.hasName(name)) {
				Messenger.sendLnPrefix(player, "&cThis name already exists!&r");
				return;
			}
		}
		
		TeleporterManagerOld.put(TeleporterDataCreator.newInstance(this));
		Messenger.sendLnPrefix(player, "&aCreated the new teleporter! &d( " + name + " )&r");
	}
}
