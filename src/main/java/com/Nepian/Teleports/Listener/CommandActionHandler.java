package com.Nepian.Teleports.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.Nepian.BukkitUtil.ActionUtil;
import com.Nepian.BukkitUtil.MaterialUtil;
import com.Nepian.Teleports.ListenerManager;
import com.Nepian.Teleports.Messenger;
import com.Nepian.Teleports.PlayerManager;
import com.Nepian.Teleports.Configuration.ActionType;
import com.Nepian.Teleports.Configuration.Properties;

public class CommandActionHandler implements Listener {

	@EventHandler
	public static void onPlayerInteract(PlayerInteractEvent event) {
		
		if (!ActionUtil.isRightClickedBlock(event.getAction())) {
			return;
		}
		
		Player player = event.getPlayer();
		
		if (PlayerManager.isActionType(player, ActionType.OTHER)) {
			return;
		}
		
		if (Properties.ACTION_ITEM_USE) {
			if (!MaterialUtil.isMaterial(player.getItemInHand(), Properties.ACTION_ITEM)) {
				String itemname = Properties.ACTION_ITEM.toString();
				Messenger.sendLnPrefix(player, "&cYou don't have teleports action item!&r (" + itemname + ")");
				PlayerManager.resetPlayerAction(player);
				return;
			}
		}
		
		Event eve = null;
		
		ActionType type = PlayerManager.getPlayerActionType(player);
		for (ActionType pat : ActionType.values()) {
			if (pat == type) {
				eve = pat.getEvent(event, PlayerManager.getCommandActionData(player));
			}
		}
		
		ListenerManager.callEvent(eve);
		PlayerManager.resetPlayerAction(player);
	}
}
