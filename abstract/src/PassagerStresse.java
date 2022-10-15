package tec;

public class PassagerStresse extends PassagerStandard
{
     public PassagerStresse(String nom, int destination)
    {
	super(nom,destination);
    }

    void nouvelArret(Vehicule v, int numeroArret)
    {
	if(this.getDest()-numeroArret==3 && v.aPlaceDebout()){
	    v.arretDemanderDebout(this);
	}
	super.nouvelArret(v,numeroArret);
    }
}

//acces a un attribut prive
//saut vers une methode publique au sein de la classe
//et retourner la destination: getter.
//extends => hérite des attributs => la classe fille aura les mêmes attributs.

//classes abstraites: methodes non publiques implementables pour
//passagerstandard(& portee paquet) donc invisibles à l'user.
