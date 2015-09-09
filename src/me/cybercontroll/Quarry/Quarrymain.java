package me.cybercontroll.Quarry;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Quarrymain extends JavaPlugin {
public final Logger logger = Logger.getLogger("Minecraft");


public void onEnable() {
	
	addRecipes();
	PluginDescriptionFile pdfFile = this.getDescription();
	this.logger.info(pdfFile.getName() + "has been enabled");
	Logger.getLogger("Minecraft").info("Quarry has been enabled");
	}

	public void onDisable() {
		PluginDescriptionFile pdffile = this.getDescription();
		this.logger.info(pdffile.getName() + "has been disabled");	
	}
	
	public void addRecipes() {
		//Quarry
		
		ItemStack quarryBlock = new ItemStack(Material.BEDROCK, 1);
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
		 
		//Path marker									this doesnt work?
		ItemStack Path_marker = new ItemStack(Material.REDSTONE_TORCH_OFF,1);
		
		 ShapedRecipe Marker = new ShapedRecipe(Path_marker);
		Marker.shape("   ",
					 "L  ",
					 "T  ");
		Marker.shape("   ",
				 	 " L ",
					 " T ");
		Marker.shape("   ",
			 	 	 "  L",
				 	 "  T");
		Marker.shape("L  ",
		 	 		 "T  ",
					 "   ");
		Marker.shape(" L ",
					 " T ",
					 "   ");
		Marker.shape("  L",
				  	 "  T",
					 "   ");
		Marker.setIngredient('L', Material.LAPIS_BLOCK);
		Marker.setIngredient('T', Material.REDSTONE_TORCH_ON);
		
		getServer().addRecipe(Quarry);
		getServer().addRecipe(Marker);
	}

}
