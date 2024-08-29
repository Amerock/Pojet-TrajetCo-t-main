package om;

public class Reservoir {

	private double capacite;
	private double contenu;

	public void initReservoir(int pPuissance) {
		if (pPuissance < 7) {
			capacite = 40;
		} else {
			capacite = 60;
		}
		contenu = capacite;
	}

	public double distanceMax(double conso) {
		return (contenu / conso) * 100;
	}

	public void diminuer(double consommation, double nbKms) {
		contenu = contenu - ((consommation / 100) * nbKms);
	}

	public double getCapacite() {
		return capacite;
	}

}
