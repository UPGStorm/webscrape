import java.io.IOException;

import com.jaunt.NotFound;
import com.jaunt.ResponseException;

public class getImage {
	public static void main(String[] args) throws IOException, NotFound, ResponseException {
		
		int playerid = getPlayers.playerid;
		if (playerid == 0) {
		playerid = webscrape.playerid;
		}
		if (webscrape.stats == true) {
			getStats.main(null);
		} else {
		System.out.printf("https://stats.gflclan.com/sig.php?player_id=" + playerid +"&background=1");
		}
	}
}
