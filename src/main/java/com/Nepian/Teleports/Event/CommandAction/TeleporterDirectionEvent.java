package com.Nepian.Teleports.Event.CommandAction;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.Nepian.BukkitUtil.LocationUtil;
import com.Nepian.Teleports.Messenger;
import com.Nepian.Teleports.TeleporterManagerOld;
import com.Nepian.Teleports.Configuration.Properties;
import com.Nepian.Teleports.Data.CommandActionData;
import com.Nepian.Teleports.Data.TeleporterData;
import com.Nepian.Teleports.Data.TeleporterType;
import com.Nepian.Teleports.Event.CommandActionEvent;

public class TeleporterDirectionEvent extends CommandActionEvent {
	
	public TeleporterDirectionEvent(PlayerInteractEvent event, CommandActionData data) {
		super(event, data);
	}

	@Override
	public void execute() {
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		
		if (!TeleporterType.isEnd(block)) {
			Messenger.sendLnPrefix(player, "&cThis block is not End Teleporter!&r");
			return;
		}
		
		if (!TeleporterManagerOld.hasTeleporterData(block)) {
			Messenger.sendLnPrefix(player, "&cThis block is not Teleporter!&r");
			return;
		}
		
		TeleporterData teleporter = TeleporterManagerOld.getTeleporterData(block);
		
		if (!player.hasPermission(Properties.PERM_ADMIN)) {
			if (!teleporter.isMember(player)) {
				Messenger.sendLnPrefix(player, "&cYou are not member of this teleporter!&r");
				return;
			}
		}
		
		Location location = teleporter.getTeleportLocation();
		location.setYaw(LocationUtil.getYaw(data.asString()));
		teleporter.setTeleportLocation(location);
		
		Messenger.sendLnPrefix(player, "&aDirection was changed to &e" + data.asString() + "&a !&r");
	}
}
