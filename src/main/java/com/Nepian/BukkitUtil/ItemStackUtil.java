package com.Nepian.BukkitUtil;

import org.bukkit.inventory.ItemStack;

public class ItemStackUtil {
	
	public static boolean hasDisplayName(ItemStack item) {
		return getDisplayName(item) != null;
	}
	
	public static String getDisplayName(ItemStack item) {
		return item.getItemMeta().getDisplayName();
	}
}
