package economy.pack;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import economy.pack.EconModeration;
import economy.pack.Main;

public class EconCommands extends JavaPlugin {
	public EconCommands(Main main) {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String s,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("economy")) {

			if (args.length != 3) {
				sender.sendMessage(ChatColor.RED
						+ "Three arguments are needed, here's an example: /economy <set/remove/add> <Playername> <Amount>");
			} else if (args[0].equalsIgnoreCase("add")) {
				if (!EconModeration.hasAccount(args[1])) {
					sender.sendMessage(ChatColor.RED
							+ "This player does not have a banking account");
					return true;

				}
				double amount;
				try {
					amount = Double.parseDouble(args[2]);
				} catch (Exception e) {
					sender.sendMessage(ChatColor.RED
							+ "You need to enter a number as an amount");
					return true;
				}

				EconModeration.setBalance(args[1],
						EconModeration.getBalance(args[1]) + amount);
				sender.sendMessage(ChatColor.GREEN
						+ "You have successfully added " + amount
						+ " gold to the account of " + args[1]);

			} else if (args[0].equalsIgnoreCase("remove")) {
				if (!EconModeration.hasAccount(args[1])) {
					sender.sendMessage(ChatColor.RED
							+ "This player does not have a banking account");
					return true;

				}
				double amount;
				try {
					amount = Double.parseDouble(args[2]);
				} catch (Exception e) {
					sender.sendMessage(ChatColor.RED
							+ "You need to enter a number as an amount");
					return true;
				}

				EconModeration.setBalance(args[1],
						EconModeration.getBalance(args[1]) - amount);
				sender.sendMessage(ChatColor.GREEN
						+ "You have successfully removed " + amount
						+ " gold from the account of " + args[1]);

			} else if (args[0].equalsIgnoreCase("set")) {
				if (!EconModeration.hasAccount(args[1])) {
					sender.sendMessage(ChatColor.RED
							+ "This player does not have a banking account");
					return true;

				}
				double amount;
				try {
					amount = Double.parseDouble(args[2]);
				} catch (Exception e) {
					sender.sendMessage(ChatColor.RED
							+ "You need to enter a number as an amount");
					return true;
				}

				EconModeration.setBalance(args[1], amount);
				sender.sendMessage(ChatColor.GREEN
						+ "You have successfully set the account of " + args[1]
						+ " to " + amount);

			} else {
				sender.sendMessage(ChatColor.RED + "Incorrect first argument");
			}
		} else if (cmd.getName().equalsIgnoreCase("balance") || cmd.getName().equalsIgnoreCase("bal")) {
			sender.sendMessage(ChatColor.GREEN + "Your current balance is: "
					+ EconModeration.balance.get(sender.getName() + " Gold!"));
		} else if (cmd.getName().equalsIgnoreCase("stocks")) {
			sender.sendMessage(ChatColor.GREEN + "The current stocks are: " + DayPassed.worth);
		}
		return true;
	}

}
