package tec;

abstract class PassagerAbstrait implements Passager,Usager {

    protected String nom;
    protected int destination;
    protected Position maPosition;

    public PassagerAbstrait(String nom, int destination) {
        this.nom = nom;
        this.destination = destination;
        this.maPosition = Position.dehors();
    }
    
    public String nom() {
        return nom;
    }

    public boolean estDehors() {
        return maPosition.estDehors();
    }

    public boolean estAssis() {
        return maPosition.estAssis();
    }

    public boolean estDebout() {
        return maPosition.estDebout();
    }

    public void changerEnDehors() {
        maPosition = Position.dehors();
    }

    public void changerEnAssis() {
        maPosition = Position.assis();
    }

    public void changerEnDebout() {
        maPosition = Position.debout();
    }

    public void monterDans(Transport t) {
	Vehicule v=(Vehicule)t;
        choixPlaceMontee(v);
    }

    public void nouvelArret(Vehicule v, int numeroArret) {
        if (numeroArret == destination)
            v.arretDemanderSortie(this);
	choixPlaceArret(v,numeroArret);
    }

    public String toString() {
        return nom + " " + maPosition;
    }

    abstract public void choixPlaceMontee(Vehicule v);
    abstract public void choixPlaceArret(Vehicule v, int arret);
}
