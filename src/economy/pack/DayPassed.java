package economy.pack;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class DayPassed implements Listener {
	
	private static Main main;
	
	public DayPassed(Main main) {
		DayPassed.main = main;
		main.getServer().getPluginManager().registerEvents(this, main);
	}

	static int worth;

	public static boolean onDayPassed() {
		
		return true;
	}
	
	public static void startSharesTimer() {
		Bukkit.getScheduler().runTaskTimerAsynchronously(main, new UpdateSharesTimer(), 0L, 20L * 60L * 20L);
	}

	private static class UpdateSharesTimer implements Runnable {
		
		public void run() {
			int baseworth = worth;
			Random r = new Random();
			int henk = r.nextInt(worth + (baseworth));
			worth = henk + baseworth;
			SharesWorth.randomshares(baseworth, "Apples");
		}
		
	}

}
