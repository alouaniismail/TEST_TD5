package tec;

abstract public class PassagerAbstrait implements Passager,Usager
{
    protected String nom;
    protected int destination;
    protected Position maPosition;

    public PassagerAbstrait(String nom, int destination) {
        this.nom = nom;
        this.destination = destination;
        this.maPosition = Position.dehors();
    }

    /*public int getDest(){
	return destination;
	}*/
    //pas la peine now..////
    
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

    /*abstract public void monterDans(Transport t);
      abstract public void nouvelArret(Vehicule v, int numeroArret);*/
    //Les 2 methodes qui posent probleme.
    //=>optimisation::

    public void monterDans(Transport t) {
	Vehicule v=(Vehicule)t;
        choixPlaceMontee(v);
    }

    public void nouvelArret(Vehicule v, int numeroArret) {
        if (numeroArret == destination)
            v.arretDemanderSortie(this);
	choixPlaceArret(v,numeroArret);
    }

    abstract public void choixPlaceMontee(Vehicule v);
    abstract public void choixPlaceArret(Vehicule v, int arret);

    public String toString() {
        return nom + " " + maPosition;
    }
}
