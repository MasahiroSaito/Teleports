package com.Nepian.BukkitUtil;

import org.bukkit.event.block.Action;

public class ActionUtil {
	
	/**
	 * 空気を右クリックしたアクションなのかを判定する
	 * @param action
	 * @return
	 */
	public static boolean isRightClickedAir(Action action) {
		return action == Action.RIGHT_CLICK_AIR;
	}
	
	/**
	 * ブロックを右クリックしたアクションなのかを判定する
	 * @param action
	 * @return
	 */
	public static boolean isRightClickedBlock(Action action) {
		return action == Action.RIGHT_CLICK_BLOCK;
	}
	
	/**
	 * 空気を左クリックしたアクションなのかを判定する
	 * @param action
	 * @return
	 */
	public static boolean isLeftClickedAir(Action action) {
		return action == Action.LEFT_CLICK_AIR;
	}
	
	/**
	 * ブロックを左クリックしたアクションなのかを判定する
	 * @param action
	 * @return
	 */
	public static boolean isLeftClickedBlock(Action action) {
		return action == Action.LEFT_CLICK_BLOCK;
	}
	
	/**
	 * ブロックをクリックしたアクションなのかを判定する
	 * @param action
	 * @return
	 */
	public static boolean isClickedBlock(Action action) {
		return isRightClickedBlock(action) || isLeftClickedBlock(action);
	}
	
	/**
	 * 空気をクリックしたアクションなのかを判定する
	 * @param action
	 * @return
	 */
	public static boolean isClickedAir(Action action) {
		return isRightClickedAir(action) || isLeftClickedAir(action);
	}
	
	/**
	 * 右クリックのアクションなのかを判定する
	 * @param action
	 * @return
	 */
	public static boolean isRightClick(Action action) {
		return isRightClickedAir(action) || isRightClickedBlock(action);
	}
	
	/**
	 * 左クリックのアクションなのかを判定する
	 * @param action
	 * @return
	 */
	public static boolean isLeftClick(Action action) {
		return isLeftClickedAir(action) || isLeftClickedBlock(action);
	}
}
