package com.Nepian.Teleports.Listener;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.Nepian.Teleports.ListenerManager;
import com.Nepian.Teleports.TeleporterManagerOld;
import com.Nepian.Teleports.Data.TeleporterData;
import com.Nepian.Teleports.Data.TeleporterType;
import com.Nepian.Teleports.Event.CancellableEvent;
import com.Nepian.Teleports.Event.TeleporterRemovingEvent;

public class TeleporterRemovingListener implements Listener {

	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
	public static void onBlockBreak(BlockBreakEvent event) {
		
		if (TeleporterType.isOther(event.getBlock())) {
			return;
		}
		
		if (!TeleporterManagerOld.hasTeleporterData(event.getBlock())) {
			return;
		}
		
		Player player = event.getPlayer();
		Block block = event.getBlock();
		TeleporterData data = TeleporterManagerOld.getTeleporterData(block);
		CancellableEvent eve = new TeleporterRemovingEvent(player, block, data);
		ListenerManager.callEvent(eve);
		
		if (eve.isCancelled()) {
			event.setCancelled(true);
		}
	}
}
