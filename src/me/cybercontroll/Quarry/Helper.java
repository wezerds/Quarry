package me.cybercontroll.Quarry;

import org.bukkit.metadata.FixedMetadataValue;

public class Helper {
	public static FixedMetadataValue meta(String value) {
		return new FixedMetadataValue(Quarrymain.plugin, value);
	}
	public static FixedMetadataValue meta(int value) {
		return new FixedMetadataValue(Quarrymain.plugin, value);
	}
	public static FixedMetadataValue meta(boolean value) {
		return new FixedMetadataValue(Quarrymain.plugin, value);
	}
}
