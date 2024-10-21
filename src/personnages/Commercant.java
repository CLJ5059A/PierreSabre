package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, int argent) {
		super(nom, "thé", argent);
	}
	
	public int seFaireExtorquer() {
		int perdu = super.getArgent();
		perdreArgent(perdu);
		parler("J'ai tout perdu! Le mode est trop injuste...");;
		return perdu;
	}
	
	public void recevoir(int argent) {
		gagnerArgent(argent);
		parler(argent + " sous! Je te remercie généreux donateur!");
	}
	
}
