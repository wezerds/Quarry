package me.cybercontroll.Quarry;


import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;

public class TorchTask {
	
	Location[] corners;
	public static ArrayList<Location[]> cornersList = new ArrayList<Location[]>();
	public static ArrayList<Location[]> torchPairs = new ArrayList<Location[]>();
	public static int instance;
	
	public TorchTask(Location[] corners) {
		this.corners = corners;
		TorchTask.cornersList.add(corners);
		callTorchTask(cornersList);
	}
	
	private void callTorchTask(final ArrayList<Location[]> cornersList) {
		instance = Bukkit.getScheduler().scheduleSyncRepeatingTask(Quarrymain.plugin, new Runnable() {
			public void run() {
				torchTask(cornersList);
			}
		}, 0, 20);
	}
	
	private void torchTask(ArrayList<Location[]> cornersList) {
		for(int i = 0; i < cornersList.size(); i++) {
			Location[] corners = cornersList.get(i);
			World world = cornersList.get(i)[0].getWorld();
			double yLevel = corners[0].clone().getBlockY() + 0.5;
			double c = 0.625;
			int sizeX = Math.abs(corners[0].clone().getBlockX()-corners[2].clone().getBlockX())+1;
			int sizeZ = Math.abs(corners[1].clone().getBlockZ()-corners[3].clone().getBlockZ())+1;
			Location[] tempLoc = corners;
			for(int j = 0; j/8 < sizeZ-1; j++) {
				double var = (double) j/8;
				world.spigot().playEffect(new Location(world, tempLoc[0].clone().getX() + c, yLevel, tempLoc[0].clone().getZ() + var + c), Effect.WATERDRIP);
				world.spigot().playEffect(new Location(world, tempLoc[2].clone().getX() + c, yLevel, tempLoc[2].clone().getZ() - var + c), Effect.WATERDRIP);
			}
			for(int k = 0; k/8 < sizeX-1; k++) {
				double var = (double) k/8;
				world.spigot().playEffect(new Location(world, tempLoc[1].clone().getX() + var + c, yLevel, tempLoc[1].clone().getZ() + c), Effect.WATERDRIP);
				world.spigot().playEffect(new Location(world, tempLoc[3].clone().getX() - var + c, yLevel, tempLoc[3].clone().getZ() + c), Effect.WATERDRIP);
			}
		}
	}
	
	public Location[] getCorners() {
		return corners;
	}
}
