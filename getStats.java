import java.io.IOException;
import java.util.Arrays;

import com.jaunt.Element;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

public class getStats {
	public static void main(String[] args) throws IOException, ResponseException, NotFound {
		UserAgent userAgent = new UserAgent(); 
		userAgent.settings.checkSSLCerts = false;
		int playerid = webscrape.playerid;
		if (playerid == 0) {
			playerid = getPlayers.playerid;
			}
		userAgent.visit("https://stats.gflclan.com/hlstats.php?mode=playerinfo&player=" + playerid);
		Element body = userAgent.doc.findFirst("<body>");
		Element div = body.findEach("<tr class=\"bg1\">");
		Element div2 = body.findEach("<tr class=\"bg2\">");
		//System.out.println(div.innerText());
		//System.out.println(div2.innerText());
		String stats =  div.innerText();
		String info = div2.innerText();
		String[] player = info.split("\\r?\\n");
		String[] data = stats.split("\\r?\\n");
		String time = data[18].trim();
		String status = data[4].trim();
		String name = player[2].trim();
		name = name.replace("&nbsp;","");
		time = time.replace("&nbsp;"," ");
		time = time.replace("d","");
		time = time.replace(":"," ");
		time = time.replace("h","");
		String[] hours = time.split("\\s+");
		int d = Integer.parseInt(hours[0]);
		int h = Integer.parseInt(hours[1]);
		double m = Integer.parseInt(hours[2]);
		double s = Integer.parseInt(hours[3]);
		
		d = d * 24;
		m = (m / 60);
		s = ((s / 60) / 60);
		double total = d + h + m + s;
		System.out.println("Username: " + name);
		System.out.println(status);
		System.out.printf("Total Hours: %.2f", total);
	}
	
}
