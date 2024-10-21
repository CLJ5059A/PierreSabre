package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boissonFav, int argent) {
		super(nom, boissonFav, argent);
	}

	public void donner(Commercant benificiaire) {
		int donnation = getArgent()/10;
		perdreArgent(donnation);
		parler(benificiaire.getNom() + " prend ces " + donnation + " sous.");
		benificiaire.recevoir(donnation);
	}

	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu"
				+ " as fait à ce pauvre marchand!");
		int forceRonin = 2 * honneur;
		int forceAdversaire = adversaire.getReputation();
		if (forceRonin >= forceAdversaire) {
			parler("Je t’ai eu petit yakusa!");
			int gain = adversaire.perdre();
			gagnerArgent(gain);
			honneur += 1;
		}else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			int perte = getArgent();
			perdreArgent(perte);
			adversaire.gagner(perte);
			honneur -= 1;
		}
	}
	
}
