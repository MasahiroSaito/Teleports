package com.Nepian.Teleports.Event.CommandAction;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.Nepian.Teleports.Messenger;
import com.Nepian.Teleports.TeleporterManagerOld;
import com.Nepian.Teleports.Configuration.Properties;
import com.Nepian.Teleports.Data.CommandActionData;
import com.Nepian.Teleports.Data.TeleporterData;
import com.Nepian.Teleports.Data.TeleporterType;
import com.Nepian.Teleports.Event.CommandActionEvent;

public class TeleporterRemovingEvent extends CommandActionEvent {
	
	public TeleporterRemovingEvent(PlayerInteractEvent event, CommandActionData data) {
		super(event, data);
	}

	@Override
	public void execute() {
		
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		
		if (TeleporterType.isOther(block)) {
			Messenger.sendLnPrefix(player, "&cThis block is NOT Teleporter!&r");
			return;
		}
		
		if (!TeleporterManagerOld.hasTeleporterData(block)) {
			Messenger.sendLnPrefix(player, "&cThis block is NOT Teleporter!&r");
			return;
		}
		
		TeleporterData teleporter = TeleporterManagerOld.getTeleporterData(block);
		
		if (!player.hasPermission(Properties.PERM_ADMIN)) {
			if (!teleporter.isOwner(player)) {
				Messenger.sendLnPrefix(player, "&cYou are NOT OWNER of this Teleporter!&r");
				return;
			}
		}
		
		TeleporterManagerOld.remove(block.getLocation());
		
		Messenger.sendLnPrefix(player, "&aRemoved the Teleporter!&r");
	}
}
