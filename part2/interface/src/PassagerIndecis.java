package tec;

class PassagerIndecis extends PassagerAbstrait 
{
    public PassagerIndecis(String nom, int destination)
    {
	super(nom,destination);
    }

    public void choixPlaceMontee(Vehicule v)
    {
	if(v.aPlaceDebout()){
	    v.monteeDemanderDebout(this);
	}
    }

    public void choixPlaceArret(Vehicule v, int arret){
	if(this.estDebout() && v.aPlaceAssise()){
	    v.arretDemanderAssis(this);}
	else if(this.estAssis() && v.aPlaceDebout()){
	    v.arretDemanderDebout(this);}
    }
}
