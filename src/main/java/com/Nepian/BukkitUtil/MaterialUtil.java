package com.Nepian.BukkitUtil;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MaterialUtil {

	/**
	 * 名前からMaterialを取得する
	 * @param materialName
	 * @return 存在しない場合は null
	 */
	public static Material getMaterialFromString(String materialName) {
		return Material.getMaterial(materialName);
	}
	
	/**
	 * IDからMaterialを取得する
	 * @param id
	 * @return 存在しない場合は null
	 */
	@SuppressWarnings("deprecation")
	public static Material getMaterialFromID(int id) {
		return Material.getMaterial(id);
	}
	
	/**
	 * 名前かIDからMaterialを取得する
	 * @param nameOrID 名前かIDの文字列
	 * @return 存在しない場合は null
	 */
	public static Material getMaterial(String nameOrID) {
		Material material = getMaterialFromString(nameOrID);
		
		if (material == null) {
			int id;
			
			try {
				id = Integer.valueOf(nameOrID);
			} catch (NumberFormatException e) {
				id = -1;
			}
			
			if (id != -1) {
				material = getMaterialFromID(id);
			}
		}
		
		return material;
	}
	
	/**
	 * アイテムスタックのマテリアルを取得する
	 * @param item
	 * @return
	 */
	public static Material getMaterial(ItemStack item) {
		return item.getType();
	}
	
	/**
	 * アイテムスタックが指定したマテリアルなのかを判定する
	 * @param item
	 * @param material
	 * @return
	 */
	public static boolean isMaterial(ItemStack item, Material material) {
		return getMaterial(item) == material;
	}
}
