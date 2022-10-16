package tec;

class PassagerStresse extends PassagerAbstrait
{
     public PassagerStresse(String nom, int destination)
    {
	super(nom,destination);
    }

    public void choixPlaceMontee(Vehicule v)
    {
	if (v.aPlaceAssise()) {
            v.monteeDemanderAssis(this);
        } else if (v.aPlaceDebout()) {
            v.monteeDemanderDebout(this);
        }
    }
	

    
    public void choixPlaceArret(Vehicule v, int arret)
    {
	if(destination-arret==3 && v.aPlaceDebout()){
	    v.arretDemanderDebout(this);
	}
    }
}
