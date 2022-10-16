package tec;

//cette classe abstraite a un lien <estUN> avec la classe abstraite
//passager.

abstract public class PassagerAbstrait extends Passager implements Usager {

    protected String nom;
    protected int destination;
    protected Position maPosition;

    public PassagerAbstrait(String nom, int destination) {
        this.nom = nom;
        this.destination = destination;
        this.maPosition = Position.dehors();
    }

    String nom() {
        return nom;
    }

    boolean estDehors() {
        return maPosition.estDehors();
    }

    boolean estAssis() {
        return maPosition.estAssis();
    }

    boolean estDebout() {
        return maPosition.estDebout();
    }

    void changerEnDehors() {
        maPosition = Position.dehors();
    }

    void changerEnAssis() {
        maPosition = Position.assis();
    }

    void changerEnDebout() {
        maPosition = Position.debout();
    }

    public void monterDans(Transport t) {
	Vehicule v=(Vehicule)t;
        choixPlaceMontee(v);
    }

    void nouvelArret(Vehicule v, int numeroArret) {
        if (numeroArret == destination)
            v.arretDemanderSortie(this);
	choixPlaceArret(v,numeroArret);
    }

    public String toString() {
        return nom + " " + maPosition;
    }

    abstract void choixPlaceMontee(Vehicule v);
    abstract void choixPlaceArret(Vehicule v, int arret);
}
