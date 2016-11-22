import java.io.IOException;
import java.util.Scanner;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

public class getPlayers {

	public static int playerid;

	public static void main(String[] args) throws IOException, ResponseException, NotFound {
		Scanner input = new Scanner(System.in);
		int id = 0;
		UserAgent userAgent = new UserAgent();
		userAgent.settings.checkSSLCerts = false;
		System.out.println("Search for players: ");
		String player = input.nextLine();
		userAgent.visit("https://stats.gflclan.com/hlstats.php?mode=search&q=" + player + "&st=player&game=csgoze");
		Element body = userAgent.doc.findFirst("<body>");
		Element div = body.findEach("<td class=\"bg2\">");
		Element div2 = body.findEach("<td style=\"text-align:right;\" class=\"bg1\">");
		
		String players = div.innerText().replace("&nbsp;","\n").trim();
		String[] ids = div2.innerXML(2).replace("<td style=\"text-align:right;\" class=\"bg1\">"," ").replace("</td>"," ").replace(",","").trim().split("\\s+");
		System.out.println();
		System.out.println(players);
		System.out.println();
		
		//System.out.println("IDs: ");
		int num = ids.length;
		//System.out.println(ids.length);
		//System.out.println(players.length());
		;
		if (players.length() == 0) {
		System.out.println("No players found! ");
		}
		else if (num == 1 && players.length() != 0) {
		playerid = Integer.parseInt(ids[0]);
		getImage.main(null);
		}
		else {
		System.out.println("Enter the number (1-" + ids.length + ") for player: ");
		id = input.nextInt();
		id = id - 1;
		if (id >= num){
		System.out.println("Enter the number (1-" + ids.length + ") for player: ");
		id = input.nextInt();
		id = id - 1;
		}
		playerid = Integer.parseInt(ids[id]);
		getImage.main(null);
		}
		}
		
	}
