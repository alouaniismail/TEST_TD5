package tec;

public class PassagerStandard extends PassagerAbstrait
{
    public PassagerStandard(String nom, int destination)
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

    public void choixPlaceArret(Vehicule v, int arret) {
    }
}
    
