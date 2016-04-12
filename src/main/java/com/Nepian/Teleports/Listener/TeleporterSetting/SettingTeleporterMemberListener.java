package com.Nepian.Teleports.Listener.TeleporterSetting;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.Nepian.BukkitUtil.ActionUtil;

public class SettingTeleporterMemberListener implements Listener {

	@EventHandler
	public static void onAddMember(PlayerInteractEvent event) {
		
		if (!ActionUtil.isRightClickedBlock(event.getAction())) {
			return;
		}
		
//		Player player = event.getPlayer();
//		ActionType type = ActionType.COMMAND_MEMBER_ADD;
//		
//		if (!PlayerManager.isActionType(player, type)) {
//			return;
//		}
//		
//		Block block = event.getClickedBlock();
//		
//		if (TeleporterType.isOther(event.getClickedBlock())) {
//			return;
//		}
//		
//		if (!TeleporterManager.hasTeleporterData(block)) {
//			player.sendMessage("This block is NOT Teleport block!");
//			return;
//		}
//		
//		TeleporterData data = TeleporterManager.getTeleporterData(block);
//		
//		if (!player.hasPermission(Properties.PERM_ADMIN)) {
//			if (!data.isOwner(player)) {
//				player.sendMessage("You are not owner!");
//				return;
//			}
//		}
//		
//		for (MetadataValue metadataValue : player.getMetadata(MetadataKeys.ADD_MEMBER)) {
//			OfflinePlayer member = (OfflinePlayer) metadataValue.value();
//
//			data.addMemebr(member);
//			removeMetadata(player);
//			
//			player.sendMessage("Success adding a member " + member.getName());
//		}
	}
	
	/* Private Method ---------------------------------------------------------------------------*/
	
}
