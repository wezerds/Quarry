package me.cybercontroll.Quarry;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;

public class DestroyEventHandler implements Listener {
	
	@EventHandler
	public void destroyEvent(BlockDispenseEvent event) {
		Block block = event.getBlock();
		if(Helper.getString(block, "QuarryBlockType").equals("marker") && block.getType().equals(Material.REDSTONE_TORCH_ON)) {
			ItemStack marker = Helper.item(Material.REDSTONE_TORCH_ON, Helper.red + "Path Marker");
			event.setItem(marker);
		}
	}
}
