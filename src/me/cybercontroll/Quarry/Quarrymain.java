package me.cybercontroll.Quarry;

import java.util.logging.Logger;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Quarrymain extends JavaPlugin {
public final Logger logger = Logger.getLogger("Minecraft");


	public void onEnable() {
	
	addRecipes();
	Logger.getLogger("Minecraft").info("Quarry has been enabled");
	}

	public void onDisable() {
		Logger.getLogger("Minecraft").info("Quarry has been disabled");
	}
	/**
	 * Adds all the recipes from the Quarry plugin
	 */
	public void addRecipes() {
		//Quarry
		
		ItemStack quarryBlock = new ItemStack(Material.BEDROCK, 1);
		quarryBlock.getItemMeta().setDisplayName(ChatColor.RED.toString() + "Quarry");
		ShapedRecipe Quarry = new ShapedRecipe(quarryBlock);
		
		Quarry.shape("DOD",
					 "SFT",
					 "DCD");
		 
		Quarry.setIngredient('D', Material.DIAMOND);
		Quarry.setIngredient('O', Material.OBSIDIAN );
		Quarry.setIngredient('F', Material.FURNACE);
		//CHANGE TO DRILL BIT
		Quarry.setIngredient('S', Material.PRISMARINE_SHARD);
		Quarry.setIngredient('T', Material.REDSTONE_TORCH_ON);
		Quarry.setIngredient('C', Material.CHEST);
		 
		//Path marker
		ItemStack marker = new ItemStack(Material.REDSTONE_TORCH_ON,1);
		marker.getItemMeta().setDisplayName(ChatColor.RED.toString() + "Path Marker");
		
		ShapedRecipe Marker = new ShapedRecipe(marker);
		Marker.shape("L",
					 "T");
		Marker.setIngredient('L', Material.LAPIS_BLOCK);
		Marker.setIngredient('T', Material.REDSTONE_TORCH_ON);
		
		getServer().addRecipe(Quarry);
		getServer().addRecipe(Marker);
	}

}
