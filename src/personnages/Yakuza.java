package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;
	
	public Yakuza(String nom, String boissonFav, int argent, String clan) {
		super(nom, boissonFav, argent);
		this.clan=clan;
	}
	
	public int getReputation() {
		return reputation;
	}

	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler("Marco, si tu tiens à la vie donne moi ta bourse !");
		int gain = victime.getArgent();
		gagnerArgent(gain);
		victime.seFaireExtorquer();
		reputation += 1;
		parler("J’ai piqué les " + gain + " sous de Marco, ce qui me fait " 
		+ getArgent() + " sous dans ma poche. Hi ! Hi !");
	}
	
	public int perdre(){
		int perte = getArgent();
		perdreArgent(perte);
		reputation -= 1;
		parler("J’ai perdu mon duel et mes " + perte + 
				" sous, snif... J'ai déshonoré le clan de "  + clan);
		return perte;
	}
	
	public void gagner(int gain) {
		gagnerArgent(gain);
		reputation += 1;
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + clan +
				" ? Je l'ai dépouillé de ses " + gain + " sous.");
	}
}
