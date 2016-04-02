package economy.pack;

public class Economy {
	private static Main plugin = EconModeration.getPlugin();
	public Economy(Main main) {
		
	}
	public static void saveBalances() {
		for (String p : EconModeration.getBalanceMap().keySet()){
			plugin.getConfig().set("balance" + p, EconModeration.getBalanceMap().get(p));
			
		}
		plugin.saveConfig();
	}
	
	public static void loadBalances() {
		if (plugin.getConfig().contains("balance")) return;
		for (String s : plugin.getConfig().getConfigurationSection("balance").getKeys(false)) {
		EconModeration.setBalance(s, plugin.getConfig().getDouble("balance."+ s));	
		}
	}
	public static void saveShares() {
	for (String p : Shares.shares.keySet()) {
		plugin.getConfig().set("shares" + p, Shares.shares.get(p));
	}
	}
	public static void loadShares() {
		if (plugin.getConfig().contains("shares")) return;
		for (String s : plugin.getConfig().getConfigurationSection("shares").getKeys(false)) {
		EconModeration.getShares(s);	
		}
	}

}
