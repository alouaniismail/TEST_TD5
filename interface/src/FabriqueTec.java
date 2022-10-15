package tec;
public final class FabriqueTec
{

    private FabriqueTec()
    {
    }
    
    public static Usager fairePassagerStandard(String nom, int dst)
    {
	return new PassagerStandard(nom,dst);
    }

     public static Usager fairePassagerIndecis(String nom, int dst)
    {
	return new PassagerIndecis(nom,dst);
    }

     public static Usager fairePassagerStresse(String nom, int dst)
    {
	return new PassagerStresse(nom,dst);
    }
    //probleme de factorisation qu'on verra apres.
    //on pourra ajouter un 3ieme argument qui code
    //le comportement du passager et faire un switch..///
    
    public static Transport faireAutobus(int nbr_1, int nbr2)
    {
	return new Autobus(nbr_1,nbr2);
    }
}
//n'est pas instanciee ca sert a rien:ces methodes sont en static
//ni servir de classe de base:ne contient aucune autre methode de
//modification, d'instanciation ou un constructeur particulier(
//3ieme point important revient a l'instanciation a 99%).
