package economy.pack;

import java.util.HashMap;

public class EconModeration {
	private static Main plugin;
	public EconModeration(Main instance) {
		plugin = instance;
	}
	public static HashMap<String, Double> balance = new HashMap<>();
	
	public static void setBalance(String player, double amount) {
		balance.put(player,amount);
	}
	public static Double getBalance(String player) {
		return balance.get(player);
	}
	public static Double getShares(String player) {
		return Shares.shares.get(player);
	}
	public static void setShares(String player,double amount) {
		Shares.shares.put(player, amount);
	}
	public static boolean hasAccount(String player) {
		return balance.containsKey(player);
	}
	
	public static HashMap<String,Double> getBalanceMap() {
		return balance;
	}
	public static Main getPlugin() {
		return plugin;
	}

}
