package me.cybercontroll.Quarry;

import java.util.ArrayList;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BlockPlacementHandler implements Listener {
	
	public static ArrayList<Location> markerLocs = new ArrayList<Location>();
	
	@EventHandler
	public void placeTorch(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		ItemStack marker = new ItemStack(Material.REDSTONE_TORCH_ON);
		ItemMeta markerim = marker.getItemMeta();
		markerim.setDisplayName(ChatColor.RED.toString() + "Path Marker");
		marker.setItemMeta(markerim);
		ItemStack hand = player.getItemInHand();
		if(hand.hasItemMeta() && hand.getItemMeta().equals(markerim)) {
			Block block = event.getBlock();
			Location loc = block.getLocation();
			block.setType(Material.REDSTONE_TORCH_OFF);
			block.setMetadata("QuarryBlockType", Helper.meta("marker"));
			markerLocs.add(loc);
			if(player.getGameMode().equals(GameMode.SURVIVAL)) {
				hand.setAmount(hand.getAmount()-1);
				player.getInventory().setItemInHand(hand);
			}
		}
	}
	
	@EventHandler
	public void placeQuarry(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		ItemStack quarry = new ItemStack(Material.BEDROCK);
		ItemMeta quarryim = quarry.getItemMeta();
		quarryim.setDisplayName(ChatColor.RED.toString() + "Quarry");
		quarry.setItemMeta(quarryim);
		ItemStack hand = player.getItemInHand();
		if(hand.hasItemMeta() && hand.getItemMeta().equals(quarryim)) {
			Block block = event.getBlock();
			block.setType(Material.DROPPER);
			block.setMetadata("QuarryBlockType", Helper.meta("quarry"));
			if(player.getGameMode().equals(GameMode.SURVIVAL)) {
				hand.setAmount(hand.getAmount()-1);
				player.getInventory().setItemInHand(hand);
			}
		}
	}
}
