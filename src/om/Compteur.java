package om;

public class Compteur {

	double vitesse;
	double kmParcourus;

	public void initCompteur() {
		kmParcourus = 0;
	}

	public void setVitesse(double pVitesse) {

		vitesse = pVitesse;
	}

	public double getVitesse() {

		return vitesse;
	}

	public void setKmParcourus(double pKmParcourus) {
		kmParcourus = pKmParcourus;
	}

	public double getKmParcourus() {

		return kmParcourus;
	}
}
