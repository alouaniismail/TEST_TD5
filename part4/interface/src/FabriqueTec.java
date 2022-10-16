package tec;
public final class FabriqueTec
{

    private FabriqueTec()
    {
    }
    
    /*public static Usager fairePassagerStandard(String nom, int dst)
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
	}*/

    public static Usager fairePassager(String nom, int dst, int nbr)
    {
	if(nbr==0) {
	    return new PassagerStandard(nom,dst);}
	else if(nbr==1) {
	    return new PassagerIndecis(nom,dst);}
	else {return new PassagerStresse(nom,dst);}
	//pour eviter l'erreur du retour statement...
    }
    
    public static Transport faireAutobus(int nbr_1, int nbr2)
    {
	return new Autobus(nbr_1,nbr2);
    }
}
