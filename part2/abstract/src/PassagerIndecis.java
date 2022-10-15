package tec;

public class PassagerIndecis extends PassagerAbstrait
{
    public PassagerIndecis(String nom, int destination)
    {
	super(nom,destination);
    }


    void choixPlaceMontee(Vehicule v){
     if(v.aPlaceDebout()){
	    v.monteeDemanderDebout(this);
	}
    }

    
    /*public void monterDans(Transport t)
    {
	Vehicule v=(Vehicule)t;
	if(v.aPlaceDebout()){
	    v.monteeDemanderDebout(this);
	}
    }

    void nouvelArret(Vehicule v, int numeroArret){
	super.nouvelArret(v,numeroArret);
	if(this.estDebout() && v.aPlaceAssise()){
	    v.arretDemanderAssis(this);}
	else if(this.estAssis() && v.aPlaceDebout()){
	    v.arretDemanderDebout(this);}
	    }*/

    void choixPlaceArret(Vehicule v, int arret){
	if(this.estDebout() && v.aPlaceAssise()){
	    v.arretDemanderAssis(this);}
	else if(this.estAssis() && v.aPlaceDebout()){
	    v.arretDemanderDebout(this);}
    }
}

