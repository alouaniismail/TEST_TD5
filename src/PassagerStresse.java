package tec;

public class PassagerStresse extends PassagerStandard
{
     public PassagerStresse(String nom, int destination)
    {
	super(nom,destination);
    }

    public void nouvelArret(Vehicule v, int numeroArret)
    {
	if(this.getDest()-numeroArret==0 && v.aPlaceDebout()){
	    v.arretDemanderDebout(this);
	}
	super.nouvelArret(v,numeroArret);
    }
}

//acces a un attribut prive
//saut vers une methode publique au sein de la classe
//et retourner la destination: getter.
//extends => hérite des attributs => la classe fille aura les mêmes attributs.
