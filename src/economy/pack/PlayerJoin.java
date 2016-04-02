package economy.pack;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
	public PlayerJoin(Main main) {
		main.getServer().getPluginManager().registerEvents(this, main);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent ev) {
		if (EconModeration.hasAccount(ev.getPlayer().getName()))
			return;
		EconModeration.setBalance(ev.getPlayer().getName(), 500);
	}

}
