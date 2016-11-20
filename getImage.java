import java.io.IOException;

public class getImage {
	public static void main(String[] args) throws IOException {
		int playerid = getPlayers.playerid;
		//int playerid = webscrape.playerid;
		System.out.printf("https://stats.gflclan.com/sig.php?player_id=" + playerid +"&background=1");
	}
}
