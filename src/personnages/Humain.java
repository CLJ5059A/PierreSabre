package personnages;

public class Humain {
	private String nom;
	private String boissonFav;
	private int argent;
	protected int nbConnaissance = 0;
	protected Humain[] memoire = new Humain[30];
		
	public Humain(String nom, String boissonFav, int argent) {
		this.nom = nom;
		this.boissonFav = boissonFav;
		this.argent = argent;
	}
	
	public String getNom() {
		return nom;
	}
	public int getArgent() {
		return argent;
	}
	
	protected void parler(String texte) {
		System.out.println("("+ nom + ") - " +  texte );
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + getNom() + 
				" et j'aime boire " + boissonFav + ".");
	}
	
	public void boire() {
		parler("Mmmm , un bon verre de " + boissonFav + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (argent<prix) {
			parler("Je n'ai plus que" + argent + " sous en poche. Je ne peux même pas m'offrir "
		+ bien +" à " + prix + " sous");
		}else {
		perdreArgent(prix);
		parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " 
		+ bien + " à " + prix + " sous");
		}
	}
	
	public void gagnerArgent(int gain) {
		argent += gain;
	}
	
	public void perdreArgent(int perte) {
		argent -= perte;
	}
	
	private void memoriser(Humain autreHumain) {
		if (nbConnaissance == memoire.length) {
			for (int i=0;i<memoire.length-1;i++) {
				memoire[i]=memoire[i+1];
			}
		} else {
			nbConnaissance++;
		}
		memoire[nbConnaissance-1] = autreHumain;
	}
	
	private void repondre(Humain autreHumain) {
		direBonjour();
		memoriser(autreHumain);
	}
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		memoriser(autreHumain);
	}
	
	public void listerConnaissance() {
		parler("Je connais beaucoup de monde dont : ");
		System.out.print(memoire[0].getNom());
		for (int i=1;i<nbConnaissance;i++) {
			System.out.print(", " + memoire[i].getNom());
		}
		System.out.println("");
	}
	
}
