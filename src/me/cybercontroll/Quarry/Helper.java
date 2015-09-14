package me.cybercontroll.Quarry;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

public class Helper {
	/**
	 * Value of Color.AQUA.toString()
	 */
	public static String aqua = ChatColor.AQUA.toString();
	/**
	 * Value of Color.RED.toString()
	 */
	public static String red = ChatColor.RED.toString();
	/**
	 * Converts a string into Metadata
	 * @param value String value of Metadata to set
	 * @return Value as FixedMetadataValue
	 */
	public static FixedMetadataValue meta(String value) {
		return new FixedMetadataValue(Quarrymain.plugin, value);
	}
	/**
	 * Converts an integer into Metadata
	 * @param value Integer value of Metadata to set
	 * @return Value as FixedMetadataValue
	 */
	public static FixedMetadataValue meta(int value) {
		return new FixedMetadataValue(Quarrymain.plugin, value);
	}
	/**
	 * Converts a boolean value Metadata
	 * @param value Boolean value of the Metadata to set
	 * @return Value as FixedMetadataValue
	 */
	public static FixedMetadataValue meta(boolean value) {
		return new FixedMetadataValue(Quarrymain.plugin, value);
	}
	/**
	 * Gets the string value from the block's metadata
	 * @param block Block to access data from
	 * @param key MetadataKey of the value to access
	 * @return Value of the key as a string
	 */
	public static String getString(Block block, String key) {
		return block.getMetadata(key).get(0).asString();
	}
	/**
	 * Gets the string value from the player's metadata
	 * @param player Player to access data from
	 * @param key MetadataKey of the value to access
	 * @return Value of the key as a string
	 */
	public static String getString(Player player, String key) {
		return player.getMetadata(key).get(0).asString();
	}
	/**
	 * Gets the integer value from the block's metadata
	 * @param block Block to access data from
	 * @param key MetadataKey of the value to access
	 * @return Value of the key as an integer
	 */
	public static int getInt(Block block, String key) {
		return block.getMetadata(key).get(0).asInt();
	}
	/**
	 * Gets the integer value from the player's metadata
	 * @param player Player to access data from
	 * @param key MetadataKey of the value to access
	 * @return Value of the key as a integer
	 */
	public static int getInt(Player player, String key) {
		return player.getMetadata(key).get(0).asInt();
	}
	/**
	 * Creates a new ItemStack of a material with a displayName
	 * @param type Material of the item
	 * @param name DisplayName of the item
	 * @return ItemStack that was created
	 */
	public static ItemStack item(Material type, String name) {
		ItemStack item = new ItemStack(type);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}
	/**
	 * Sends a message to the console as info
	 * @param message Message to send
	 */
	public static void log(String message) {
		Logger.getLogger("Minecraft").info(message);
	}
}
