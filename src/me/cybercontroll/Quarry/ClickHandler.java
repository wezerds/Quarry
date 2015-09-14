package me.cybercontroll.Quarry;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ClickHandler implements Listener {
	
	@EventHandler
	public void clickBlock(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		World world = player.getWorld();
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			Block block = event.getClickedBlock();
			if(block.hasMetadata("QuarryBlockType")) {
				if(block.getType().equals(Material.REDSTONE_TORCH_ON)) {
					Location torch1 = block.getLocation();
					int yLevel = torch1.getBlockY();
					int maxSize = Quarrymain.plugin.getConfig().getInt("Max quarry size");
					Location start = new Location(world, torch1.getBlockX()-(maxSize-1), yLevel, torch1.getBlockZ()-(maxSize-1));
					Location goTo = new Location(world, torch1.getBlockX()+(maxSize-1), yLevel, torch1.getBlockZ()+(maxSize-1));
					Location torch2 = start;
					event.setCancelled(true);
					boolean foundCorners = false;
					for(int x = start.getBlockX(); x <= goTo.getBlockX(); x++) {
						for(int z = start.getBlockZ(); z <= goTo.getBlockZ(); z++) {
							if(Math.abs(x-torch1.getBlockX()) > 1 && Math.abs(z-torch1.getBlockZ()) > 1) {
								torch2 = new Location(world, x, yLevel, z);
								if(checkBlock(torch2)) {
									foundCorners = true;
									break;
								}
							}
						}
						if(foundCorners)
							break;
					}
					if(foundCorners) {
						Location[] corners = {torch1, new Location(world, torch1.getBlockX(), yLevel, torch2.getBlockZ()) , torch2, new Location(world, torch2.getBlockX(), yLevel, torch1.getBlockZ())};
						player.setMetadata("QuarryCorner0", Helper.meta(corners[0].toString()));
						player.setMetadata("QuarryCorner1", Helper.meta(corners[1].toString()));
						player.setMetadata("QuarryCorner2", Helper.meta(corners[2].toString()));
						player.setMetadata("QuarryCorner3", Helper.meta(corners[3].toString()));
						TorchTask task = new TorchTask(corners);
						task.getCorners();
					}
					else {
						event.setCancelled(false);
						player.sendMessage(Helper.red + "[Quarry]: Could not find a second marker in cubic radius of " + maxSize);
					}
				}
				
				if(block.getType().equals(Material.DROPPER) && player.isSneaking()) {
					if(player.getUniqueId().toString().equals(Helper.getString(block, "QuarryBlockOwner"))) {
						String name = player.getDisplayName();
						Inventory options = Bukkit.createInventory(player, 9, name + (name.endsWith("s")? "\'" : "\'s") + " Quarry Options");
						ItemStack air = new ItemStack(Material.AIR);
						ItemStack enchants = Helper.item(Material.ENCHANTMENT_TABLE, Helper.aqua + "Enchantments");
						ItemStack[] contents = {air,air,air,air,air,air,air,enchants,air};
						options.setContents(contents);
						player.openInventory(options);
					}
				}
			}
		}
	}
	
	public boolean checkBlock(Location loc) {
		Block block = loc.getBlock();
		if(block.hasMetadata("QuarryBlockType") && block.getType().equals(Material.REDSTONE_TORCH_ON)) {
			return true;
		}
		return false;
	}
}
