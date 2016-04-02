package economy.pack;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Shares {
	public static HashMap<String, Double> shares = new HashMap<>();
	public static HashMap<String, Double> Sharenames = new HashMap<>();
	double costs;

	public Shares(Main main) {

	}

	public void giveShares(String player, double amount) {
		shares.put(player, amount);
	}

	public void buyShares(String player, String sharesname, double price,
			double amount) {
		costs = amount * price;
	}

	public void takeMoney(String player, Double cost) {
		EconModeration.balance.put(player, EconModeration.balance.get(player)
				- cost);
	}
	public void sellShares(String player, String sharesname, double price, double amount) {
		if (shares.containsKey(player)) {
			shares.put(player, shares.get(player) - amount);
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		double amount;
		if (sender instanceof Player
				&& cmd.getName().equalsIgnoreCase("shares")) {
			if (args.length != 3) {
				sender.sendMessage(ChatColor.RED
						+ "Correct usage: /shares <buy/sell> <Sharesname> <amount>");
			} else if (args[0].equalsIgnoreCase("buy")) {
				try {
					amount = Double.parseDouble(args[1]);
				} catch (Exception e) {
					sender.sendMessage(ChatColor.RED
							+ "You need to enter a number as an amount");
					return true;

				}
				buyShares(sender.getName(), args[1], (double) DayPassed.worth,
						amount);
				giveShares(sender.getName(), amount);
				takeMoney(sender.getName(), costs);
			} else if (args[0].equalsIgnoreCase("sell")) {
				sellShares(sender.getName(), args[1],(double) DayPassed.worth, Double.parseDouble(args[2]));

			}
		}
		return true;
	}
}
