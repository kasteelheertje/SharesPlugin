package economy.pack;

import java.util.Random;

public class SharesWorth {
	public SharesWorth(Main main) {
		
	}
	public static void randomshares(int worth, String sharename) {
		int baseworth = worth;
		Random r = new Random();
		int henk = r.nextInt(worth+(baseworth));
		worth = henk + baseworth;
		
	}

}
