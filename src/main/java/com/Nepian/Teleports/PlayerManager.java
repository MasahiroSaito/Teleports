package com.Nepian.Teleports;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

import com.Nepian.Teleports.Configuration.ActionType;
import com.Nepian.Teleports.Data.CommandActionData;

public class PlayerManager {
	private static Map<Player, ActionType> playerActionTypes;
	private static Map<Player, CommandActionData> commandActionDatas;
	
	static {
		playerActionTypes = new HashMap<Player, ActionType>();
		commandActionDatas = new HashMap<Player, CommandActionData>();
	}
	
	/* Method -----------------------------------------------------------------------------------*/
	
	public static void addPlayer(Player player) {
		addPlayerActionType(player, ActionType.OTHER);
		addCommandActionData(player, null);
	}
	
	public static void removePlayer(Player player) {
		removePlayerActionType(player);
		removeCommandActionData(player);
	}
	
	public static boolean resetPlayerAction(Player player) {
		return setPlayerAction(player, ActionType.OTHER);
	}
	
	/* Validator --------------------------------------------------------------------------------*/
	
	public static boolean isActionType(Player player, ActionType type) {
		return getPlayerActionType(player) == type;
	}
	
	/* Setter -----------------------------------------------------------------------------------*/
	
	public static boolean setPlayerAction(Player player, ActionType type) {
		return setPlayerAction(player, type, null);
	}
	
	public static boolean setPlayerAction(Player player, ActionType type, CommandActionData data) {
		if (!hasPlayer(player)) {
			return false;
		}
		addPlayerActionType(player, type);
		addCommandActionData(player, data);
		return true;
	}
	
	/* Getter -----------------------------------------------------------------------------------*/
	
	public static Map<Player, ActionType> getPlayerActionTypes() {
		return playerActionTypes;
	}
	
	public static Map<Player, CommandActionData> getCommandActionDatas() {
		return commandActionDatas;
	}
	
	public static ActionType getPlayerActionType(Player player) {
		return playerActionTypes.get(player);
	}
	
	public static CommandActionData getCommandActionData(Player player) {
		return commandActionDatas.get(player);
	}
	
	/* Private ----------------------------------------------------------------------------------*/
	
	private static boolean hasPlayer(Player player) {
		if (playerActionTypes.containsKey(player)) {
			if (commandActionDatas.containsKey(player)) {
				return true;
			}
		}
		return false;
	}
	
	private static void addPlayerActionType(Player player, ActionType type) {
		playerActionTypes.put(player, type);
	}
	
	private static void addCommandActionData(Player player, CommandActionData data) {
		commandActionDatas.put(player, data);
	}
	
	private static void removePlayerActionType(Player player) {
		playerActionTypes.remove(player);
	}
	
	private static void removeCommandActionData(Player player) {
		commandActionDatas.remove(player);
	}
}
