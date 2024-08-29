package om;

public class Voiture {

	private static final double prixLitre = 1;
	private static final double prixDepannage = 100;
	@SuppressWarnings("unused")
	private String numero;
	private int puissance;
	private double cout;
	private Compteur monCompteur = new Compteur();
	private Reservoir monReservoir = new Reservoir();

	public void initVoiture(int pPuissance, String pNumero) {
		puissance = pPuissance;
		numero = pNumero;
		cout = 0;
		monCompteur.initCompteur();
		monReservoir.initReservoir(puissance);
	}

	public void rouler(double nbKms, double pVitesse) {
		double consommation;
		double maxKms;
		double distanceRestante;

		if (pVitesse > 130) {
			pVitesse = 130;
		}

		consommation = conso();

		maxKms = monReservoir.distanceMax(consommation);

		monCompteur.setVitesse(pVitesse);

		if (nbKms > maxKms) {
			distanceRestante = nbKms - maxKms;
			rouler(maxKms, pVitesse);
			tomberEnPanne();
			fairePlein();
			rouler(distanceRestante, pVitesse);
		} else {
			monCompteur.setKmParcourus(monCompteur.getKmParcourus() + nbKms);
			monReservoir.diminuer(consommation, nbKms);

			cout += (nbKms / 100) * consommation * prixLitre;
		}

	}

	private double conso() {
		double consommation = 0;
		double vitesse = monCompteur.getVitesse();

		if (vitesse > 120) {
			consommation = 9;
		} else if (vitesse > 100) {
			consommation = 8;
		} else if (vitesse > 80) {
			consommation = 7;
		} else {
			consommation = 6;
		}

		if (puissance > 4) {
			consommation = consommation * (1 + (puissance - 4) * 0.0015);
		}

		return consommation;
	}

	private void fairePlein() {
		cout = cout + monReservoir.getCapacite() * prixLitre;
		monReservoir.initReservoir(puissance);
	}

	private void tomberEnPanne() {
		cout = cout + prixDepannage;
	}

	public double getCout() {
		double roundCout = Math.round(cout);
		return roundCout;
	}

	public boolean getScenario(double nbKms) {
		double consommation = conso();
		double maxKms = monReservoir.distanceMax(consommation);
		boolean scenario = true;

		if (nbKms > maxKms) {
			scenario = false;
		}

		return scenario;
	}

}
