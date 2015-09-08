package me.cybercontroll.Quarry;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Quarrymain extends JavaPlugin {
public final Logger logger = Logger.getLogger("Minecraft");


public void onEnable(){
	//Quarry
	ItemStack bedrock = new ItemStack(Material.CHEST, 1);
	
	ShapedRecipe Quarry = new ShapedRecipe(bedrock);
	
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
	 
	getServer().addRecipe(Quarry);
	//Path marker
	ItemStack Path_marker = new ItemStack(Material.DIRT, 2);
	
	ShapedRecipe Marker = new ShapedRecipe(Path_marker);
	
	Marker.shape("RRR",
			 	 "SLS",
			 	 "TRT");
	Marker.setIngredient('T', Material.REDSTONE_TORCH_ON);
	Marker.setIngredient('L', Material.LAPIS_BLOCK);
	Marker.setIngredient('R', Material.REDSTONE);
	Marker.setIngredient('S', Material.STONE);
	
	getServer().addRecipe(Marker);
PluginDescriptionFile pdffile = this.getDescription();
this.logger.info(pdffile.getName() + " has been enabled");
}
public void onDisable(){
	PluginDescriptionFile pdffile = this.getDescription();
	this.logger.info(pdffile.getName() + " has been disabled");	
}

}
