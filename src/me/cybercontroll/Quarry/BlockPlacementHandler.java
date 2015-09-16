package me.cybercontroll.Quarry;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class BlockPlacementHandler implements Listener {

	@EventHandler
	public void placeTorch(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		ItemStack marker = Helper.item(Material.REDSTONE_TORCH_ON, Helper.red + "Path Marker");
		ItemStack hand = player.getItemInHand();
		if(hand.hasItemMeta() && hand.getItemMeta().equals(marker.getItemMeta())) {
			Block block = event.getBlock();
			block.setType(Material.REDSTONE_TORCH_OFF);
			block.setMetadata("QuarryBlockType", Helper.meta("marker"));
			if(player.getGameMode().equals(GameMode.SURVIVAL)) {
				hand.setAmount(hand.getAmount()-1);
				player.getInventory().setItemInHand(hand);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void placeQuarry(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		ItemStack quarry = Helper.item(Material.BEDROCK, Helper.red + "Quarry");
		ItemStack hand = player.getItemInHand();
		if(hand.hasItemMeta() && hand.getItemMeta().equals(quarry.getItemMeta()) /*&& isValidQuarrySpot*/) {
			Block block = event.getBlock();
			block.setType(Material.DROPPER);
			block.setData((byte) 0);
			block.setMetadata("QuarryBlockType", Helper.meta("quarry"));
			block.setMetadata("QuarryBlockOwner", Helper.meta(player.getUniqueId().toString()));
			Bukkit.getScheduler().cancelTask(TorchTask.instance);
			if(player.getGameMode().equals(GameMode.SURVIVAL)) {
				hand.setAmount(hand.getAmount()-1);
				player.getInventory().setItemInHand(hand);
			}
		}
	}
}
