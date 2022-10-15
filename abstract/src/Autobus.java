package tec;

public class Autobus extends Vehicule implements Transport {
    //ajout de transport (division en deux)
	private Jauge jaugeAssis;
	private Jauge jaugeDebout;

	private Passager[] passagers;
	// private int nbPassagers;

	private int arretCourant;

	public Autobus(int nbPlaceAssise, int nbPlaceDebout) {
		jaugeAssis = new Jauge(nbPlaceAssise, 0);
		jaugeDebout = new Jauge(nbPlaceDebout, 0);
		arretCourant = 0;
		passagers = new Passager[nbPlaceAssise + nbPlaceDebout];
	}

	private void enleverPassager(Passager p) {
		int i = 0;
		while (passagers[i] == null || !passagers[i].equals(p)) {
			i++;
		}
		passagers[i] = null;
	}

	private void ajouterPassager(Passager p) {
		int i = 0;
		while (passagers[i] != null) {
			i++;
		}
		passagers[i] = p;
	}

	public void allerArretSuivant() {
		arretCourant++;
		for (Passager p : passagers) {
			if (p != null)
				p.nouvelArret(this, arretCourant);
		}
	}

	boolean aPlaceAssise() {
		return jaugeAssis.estVert();
	}

	boolean aPlaceDebout() {
		return jaugeDebout.estVert();
	}

	void arretDemanderAssis(Passager p) {
		jaugeDebout.decrementer();
		jaugeAssis.incrementer();
		p.changerEnAssis();
	}

	void arretDemanderDebout(Passager p) {
		jaugeAssis.decrementer();
		jaugeDebout.incrementer();
		p.changerEnDebout();
	}

	void arretDemanderSortie(Passager p) {
		if (p.estAssis()) {
			jaugeAssis.decrementer();
		} else {
			jaugeDebout.decrementer();
		}
		p.changerEnDehors();
		this.enleverPassager(p);
	}

	void monteeDemanderAssis(Passager p) {
		jaugeAssis.incrementer();
		p.changerEnAssis();
		this.ajouterPassager(p);
	}

	void monteeDemanderDebout(Passager p) {
		jaugeDebout.incrementer();
		p.changerEnDebout();
		this.ajouterPassager(p);
	}

	@Override
	public String toString() {
		String res = "[arret " + arretCourant + "] " + "assis" + jaugeAssis + " debout" + jaugeDebout;
		return res;
	}
}
