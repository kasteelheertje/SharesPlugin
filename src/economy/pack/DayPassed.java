package economy.pack;

import java.util.Random;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class DayPassed implements Listener {
	public DayPassed(Main main) {
		main.getServer().getPluginManager().registerEvents(this, main);
	}
	public static  void onDayPassed() {
		Thread thread = new Thread();
		for (int i = 0; i <=12000; i++) {
			int worth = 90;
			int baseworth = worth;
			Random r = new Random();
			int henk = r.nextInt(worth+(baseworth));
			worth = henk + baseworth;
			SharesWorth.randomshares(baseworth, "Apples");
			SharesWorth.randomshares(baseworth, "Cookies");
		}
		
	}

}
