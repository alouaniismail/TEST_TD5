package tec;

public class PassagerStandard extends PassagerAbstrait {


    public PassagerStandard(String nom, int destination) {
        super(nom,destination);
    }

    void choixPlaceMontee(Vehicule v)
    {
	if (v.aPlaceAssise()) {
            v.monteeDemanderAssis(this);
        } else if (v.aPlaceDebout()) {
            v.monteeDemanderDebout(this);
        }
    }

    void choixPlaceArret(Vehicule v, int arret)
    {
    }
}
