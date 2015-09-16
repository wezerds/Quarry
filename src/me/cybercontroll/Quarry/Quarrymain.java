package me.cybercontroll.Quarry;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Quarrymain extends JavaPlugin {

	static Plugin plugin = Bukkit.getPluginManager().getPlugin("Quarry");
	static FileConfiguration config;
	
	public void onEnable() {
		plugin = Bukkit.getPluginManager().getPlugin("Quarry");
		config = new YamlConfiguration();
		int max = plugin.getConfig().getInt("Max quarry size");
		if(max < 5 || max > 60)
			Helper.warn("Max quarry size of " + max + " is not valid: must be 5-60");
		else
			Helper.log("Max quarry size of " + max + " successfully loaded");
		//Add EventHandlers here to register them
		registerAllEvents(this, new BlockPlacementHandler(), new ClickHandler(), new DestroyEventHandler());
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
		ItemStack QuarryBlock = Helper.item(Material.BEDROCK, Helper.red + "Quarry");
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
		ItemStack marker = Helper.item(Material.REDSTONE_TORCH_ON, Helper.red + "Path Marker");
		ShapedRecipe Marker = new ShapedRecipe(marker);
		
		Marker.shape("L",
					 "T");
		
		Marker.setIngredient('L', Material.INK_SACK, 4);
		Marker.setIngredient('T', Material.REDSTONE_TORCH_ON);
		
		//Drill Bit
		ItemStack drill = Helper.item(Material.PRISMARINE_SHARD, Helper.red + "Drill Bit");
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
		saveDefaultConfig();
	}
	
	public void registerAllEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
			}
		}
}
