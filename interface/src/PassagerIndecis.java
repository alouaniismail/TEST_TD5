package tec;
//Cette classe hérite de PassagerStandard.
//Le passager indecis soit debout soit dehors
//et a chaque arret il change de position.
//extends pour l'héritage de même pour les classes abstraites. 
class PassagerIndecis extends PassagerStandard 
{
    public PassagerIndecis(String nom, int destination)
    {
	super(nom,destination);
    }

    public void monterDans(Transport t)
    {
	Vehicule v=(Vehicule)t;
	if(v.aPlaceDebout()){
	    v.monteeDemanderDebout(this);
	}
    }

    public void nouvelArret(Vehicule v, int numeroArret){
	super.nouvelArret(v,numeroArret);
	if(this.estDebout() && v.aPlaceAssise()){
	    v.arretDemanderAssis(this);}
	else if(this.estAssis() && v.aPlaceDebout()){
	    v.arretDemanderDebout(this);}
    }
}
