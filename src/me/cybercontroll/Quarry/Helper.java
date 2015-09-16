package me.cybercontroll.Quarry;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
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
		if(block.hasMetadata(key))
			return block.getMetadata(key).get(0).asString();
		else
			return "";
	}
	/**
	 * Gets the string value from the player's metadata
	 * @param player Player to access data from
	 * @param key MetadataKey of the value to access
	 * @return Value of the key as a string
	 */
	public static String getString(Player player, String key) {
		if(player.hasMetadata(key))
			return player.getMetadata(key).get(0).asString();
		else
			return "";
	}
	/**
	 * Gets the integer value from the block's metadata
	 * @param block Block to access data from
	 * @param key MetadataKey of the value to access
	 * @return Value of the key as an integer
	 */
	public static int getInt(Block block, String key) {
		if(block.hasMetadata(key))
			return block.getMetadata(key).get(0).asInt();
		else
			return -1;
	}
	/**
	 * Gets the integer value from the player's metadata
	 * @param player Player to access data from
	 * @param key MetadataKey of the value to access
	 * @return Value of the key as a integer
	 */
	public static int getInt(Player player, String key) {
		if(player.hasMetadata(key))
			return player.getMetadata(key).get(0).asInt();
		else
			return -1;
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
	/**
	 * Sends a message to the console as a red warning
	 * @param message Warning message to send
	 */
	public static void warn(String message) {
		Logger.getLogger("Minecraft").warning(Helper.red + message);
	}
	/**
	 * Organizes locations and gets least x,z and most x,z locations: Does not organize by sum of coords
	 * but by whether or not the coord checked is greater in both the x and the z
	 * @param locs All locations to compare
	 * @return Organized locations as {least, greatest}
	 */
	public static Location[] organizeXZ(Location ... locs) {
		Location greatest = locs[0];
		Location least = locs[0];
		for(Location loc : locs) {
			if(loc.getBlockX() > greatest.getBlockX() && loc.getBlockZ() > greatest.getBlockZ())
				greatest = loc;
			else if(loc.getBlockX() < greatest.getBlockX() && loc.getBlockZ() < greatest.getBlockZ())
				least = loc;
		}
		Location[] returnLoc = {least, greatest};
		return returnLoc;
	}
	/**
	 * Converts a given location as a whole block to a string that is easily writable and readable
	 * @param loc The location to convert
	 * @return The converted string as {world,x,y,z} 
	 */
	public static String toReadable(Location loc) {
		return String.format("{%s,%s,%s,%s}", loc.getWorld().getName(), loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
	}
}