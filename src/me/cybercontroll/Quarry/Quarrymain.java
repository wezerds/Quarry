package me.cybercontroll.Quarry;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Quarrymain extends JavaPlugin {

	static FileConfiguration config;
	final static Plugin plugin = Bukkit.getPluginManager().getPlugin("Quarry");
	
	public void onEnable() {
		config = new YamlConfiguration();
		registerAllEvents(this, new BlockPlacementHandler());
		loadConfig();
		addRecipes();
	}

	public void onDisable() {
		getServer().clearRecipes();
	}
	/**
	 * Adds all the recipes from the Quarry plugin
	 */
	@SuppressWarnings("deprecation")
	public void addRecipes() {
		//Quarry
		ItemStack QuarryBlock = new ItemStack(Material.BEDROCK);
		ItemMeta quarryim = QuarryBlock.getItemMeta();
		quarryim.setDisplayName(ChatColor.RED.toString() + "Quarry");
		QuarryBlock.setItemMeta(quarryim);
		ShapedRecipe Quarry = new ShapedRecipe(QuarryBlock);
		
		Quarry.shape("DOD",
					 "SFT",
					 "DCD");
		 
		Quarry.setIngredient('D', Material.DIAMOND);
		Quarry.setIngredient('O', Material.OBSIDIAN );
		Quarry.setIngredient('F', Material.FURNACE);
		//DRILL BIT
		Quarry.setIngredient('S', Material.PRISMARINE_SHARD);
		Quarry.setIngredient('T', Material.REDSTONE_TORCH_ON);
		Quarry.setIngredient('C', Material.CHEST);
		 
		//Path Marker
		ItemStack marker = new ItemStack(Material.REDSTONE_TORCH_ON);
		ItemMeta markerim = marker.getItemMeta();
		markerim.setDisplayName(ChatColor.RED.toString() + "Path Marker");
		marker.setItemMeta(markerim);
		ShapedRecipe Marker = new ShapedRecipe(marker);
		
		Marker.shape("L",
					 "T");
		
		Marker.setIngredient('L', Material.INK_SACK, 4);
		Marker.setIngredient('T', Material.REDSTONE_TORCH_ON);
		
		//Drill Bit
		ItemStack drill = new ItemStack(Material.PRISMARINE_SHARD);
		ItemMeta drillim = drill.getItemMeta();
		drillim.setDisplayName(ChatColor.RED.toString() + "Drill Bit");
		drill.setItemMeta(drillim);
		ShapelessRecipe DrillBit = new ShapelessRecipe(drill);
		
		DrillBit.addIngredient(Material.WOOD_PICKAXE)
				.addIngredient(Material.STONE_PICKAXE)
				.addIngredient(Material.IRON_PICKAXE)
				.addIngredient(Material.GOLD_PICKAXE)
				.addIngredient(Material.DIAMOND_PICKAXE);
		
		getServer().addRecipe(DrillBit);
		getServer().addRecipe(Quarry);
		getServer().addRecipe(Marker);
	}

	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public void registerAllEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
			}
		}
}
