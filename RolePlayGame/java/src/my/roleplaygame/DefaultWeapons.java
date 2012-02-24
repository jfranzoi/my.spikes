package my.roleplaygame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultWeapons {
	private static final Map<String, List<String>> defaultWeapons = new HashMap<String, List<String>>();
	
	static {
		defaultWeapons.put("Human", Arrays.asList("sword"));
		defaultWeapons.put("Lizard", Arrays.asList("club"));
	}

	public static List<String> forSpecies(String aSpecies) {
		return defaultWeapons.get(aSpecies);
	}
}
