package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	private int niveauTraitrise = 0;

	public Traitre(String seigneur, String nom, String boissonFav, int argent) {
		super(seigneur, nom, boissonFav, argent);
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est : " + niveauTraitrise +". Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise < 3) {
			int argent = commercant.getArgent();
			int argentGagnee = argent*2/10;
			commercant.perdreArgent(argentGagnee);
			gagnerArgent(argentGagnee);
			niveauTraitrise++;
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer !" + argentGagnee 
					+ "Donne-moi 2 sous ou gare à toi !");
			commercant.parler("Tout de suite grand " + getNom() + ".");
		} else {
			parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
		}
	}
	
	public void faireLeGentil() {
		if (nbConnaissance < 1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif");
		} else {
			Random rand = new Random();
			int connaissance = rand.nextInt(nbConnaissance);
			int don = memoire[connaissance].getArgent()/20;
			String monAmi = memoire[connaissance].getNom();
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + monAmi + ".");
			parler("- Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");
			memoire[connaissance].gagnerArgent(don);
			perdreArgent(don);
			String nom = getNom();
			memoire[connaissance].parler("Merci " + nom + ". Vous êtes quelqu'un de bien.");
			if (niveauTraitrise > 1) {
				niveauTraitrise--;
			}
		}
	}
}
