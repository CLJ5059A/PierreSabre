package histoire;

import personnages.Commercant;
import personnages.Ronin;
import personnages.Yakuza;

public class HistoireTP4 {
	
	public static void main(String args[]) {
		Commercant marco =  new Commercant("Marco",15);
		Yakuza yaku = new Yakuza("Yaku Le Noir", "whisky", 30, "undefined");
		Ronin roco = new Ronin("Roco", "Shochu", 60);
		yaku.extorquer(marco);
		roco.direBonjour();
		roco.donner(marco);
		roco.provoquer(yaku);
	}
}
