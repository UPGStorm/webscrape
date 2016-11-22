import java.io.IOException;
import java.text.MessageFormat;
import java.util.Scanner;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import com.jaunt.UserAgentSettings;

public class webscrape {
	public static int playerid;
	static boolean search = true; //Search for players instead of by steamid.
	static boolean stats = true; //return plain text of stats instead of image generated.

	public static void main(String[] args) throws IOException, ResponseException, NotFound {
		Scanner input = new Scanner(System.in);
		UserAgent userAgent = new UserAgent(); 
		userAgent.settings.checkSSLCerts = false;
		if (search == true) {
			getPlayers.main(null);
		} else {
		System.out.println("Enter steamid for Player: ");
		String steamid = input.nextLine();
		userAgent.visit("https://stats.gflclan.com/hlstats.php?mode=search&q=" + steamid + "&st=uniqueid&game=csgoze");
		 
		Element div = userAgent.doc.findFirst("<td style=\"text-align:right;\" class=\"bg2\">");
		
		String formatedID =  div.innerHTML();
		
		formatedID = formatedID.replace(",","");
		
		System.out.println();
		System.out.println("Player ID: " + formatedID);
		
		playerid = Integer.parseInt(formatedID);
		
		//getStats.main(null);
		getImage.main(null);
		}
	}
}
