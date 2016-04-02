package economy.pack;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public void onEnable() {
		getLogger().info("Shares-plugin has been enabled.");
		new EconModeration(this);
		new Economy(this);
		new Shares(this);
		new EconCommands(this);
		new PlayerJoin(this);
		new DayPassed(this);
		new SharesWorth(this);
		Economy.loadBalances();
		if (!Shares.Sharenames.containsKey("Apples")) {
			Shares.Sharenames.put("Apples", (double) 90);
			if (DayPassed.onDayPassed()) {
				Shares.Sharenames.put("Apples", (double) 90);
			}
		}
		if (!Shares.Sharenames.containsKey("Cookies")) {
			Shares.Sharenames.put("Cookies", (double) 90);
		}
	}
	public void onDisable() {
		getLogger().info("Shares-plugin has been disabled.");
		Economy.saveBalances();
	}

}
