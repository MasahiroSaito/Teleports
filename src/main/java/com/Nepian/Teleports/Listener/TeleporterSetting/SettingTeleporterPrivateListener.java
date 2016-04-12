package com.Nepian.Teleports.Listener.TeleporterSetting;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.Nepian.BukkitUtil.ActionUtil;
import com.Nepian.Teleports.TeleporterManagerOld;
import com.Nepian.Teleports.Configuration.Properties;
import com.Nepian.Teleports.Data.TeleporterData;
import com.Nepian.Teleports.Data.TeleporterType;

public class SettingTeleporterPrivateListener implements Listener {

	@EventHandler
	public static void onChangePrivate(PlayerInteractEvent event) {
		
		if (!ActionUtil.isClickedBlock(event.getAction())) {
			return;
		}
		
		Block block = event.getClickedBlock();
		
		if (TeleporterType.isOther(block)) {
			return;
		}
		
		Player player = event.getPlayer();
		
//		if (!TeleportsMaterials.isTeleporterSettingPrivateMaterial(player.getItemInHand())) {
//			return;
//		}
		
		if (!TeleporterManagerOld.hasTeleporterData(block)) {
			player.sendMessage("This block is NOT Teleport block!");
			return;
		}
				
		TeleporterData data = TeleporterManagerOld.getTeleporterData(block);
		
		if (!player.hasPermission(Properties.PERM_ADMIN)) {
			if (!data.isOwner(player)) {
				player.sendMessage("You are not owner!");
				return;
			}
		}
		
		Boolean isPrivate;
		
		if (data.isPrivate()) {
			isPrivate = false;
		} else {
			isPrivate = true;
		}
		
		data.setPrivate(isPrivate);
		player.sendMessage("Success changing private -> " + isPrivate);
	}
}
