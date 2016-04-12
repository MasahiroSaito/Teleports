package com.Nepian.Teleports.Configuration;

import org.bukkit.Material;

import com.Nepian.BukkitUtil.MaterialUtil;

public class Properties {
	public static final String NAME_FILE_CONFIG = "config.yml";
	public static final String NAME_FOLDER_TELEPORTS = "teleport_location_data";
	
	public static final String PERM_BASE = "Teleports.";
	public static final String PERM_ADMIN = PERM_BASE + "admin";
	
	public static boolean  ACTION_ITEM_USE;
	public static Material ACTION_ITEM;
	
	public static void load() {
		ACTION_ITEM_USE = getBoolean(Config.TELEPORTS__ACTION_ITEM__USE);
		ACTION_ITEM     = getMaterial(Config.TELEPORTS__ACTION_ITEM__NAME);
	}
	
	private static Material getMaterial(Config conf) {
		return MaterialUtil.getMaterial(conf.getString());
	}
	
	private static boolean getBoolean(Config conf) {
		return conf.getBoolean();
	}
}
