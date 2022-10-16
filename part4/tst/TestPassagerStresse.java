package tec;

class TestPassagerStresse extends TestPassagerAbstrait {

  public static void main(String[] args) {
    boolean estMisAssertion = false;
    assert estMisAssertion = true;

    if (!estMisAssertion) {
      System.out.println("Execution impossible sans l'option -ea");
      return;
    }

    int nbTest = 0;

    // ************ Verifier l'instanciation *************
    System.out.print('.');
    nbTest++;
    new TestPassagerStresse().testInstanciation();

    // ********* Verifier changement d'etat **************
    System.out.print('.');
    nbTest++;
    new TestPassagerStresse().testGestionEtat();

    // ********* Verifier les interactions *************
    System.out.print('.');
    nbTest++;
    new TestPassagerStresse().testInteractionMontee();

    System.out.print('.');
    nbTest++;
    new TestPassagerStresse().testInteractionArret();

    System.out.println("(" + nbTest + "):OK: " + "tec.TestPassagerStresse");
  }

  
protected PassagerAbstrait creerPassager(String nom, int destination)
    {
	return new PassagerStresse(nom,destination);
    }
  /*
   * Interaction a la montee
   * Trois cas
   * - des places assises et debout
   * - pas de place assise
   * - aucune place.
   */
  public void testInteractionMontee() {
    PassagerStresse p = new PassagerStresse("yyy", 5);

    FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
    p.monterDans(faux);

    assert "monteeDemanderAssis" == getLastLog(faux) : "assis";

    faux = new FauxVehicule(FauxVehicule.DEBOUT);
    p.monterDans(faux);

    assert "monteeDemanderDebout" == getLastLog(faux) : "debout";

    faux = new FauxVehicule(FauxVehicule.PLEIN);
    p.monterDans(faux);

    assert 0 == faux.logs.size() : "pas de place";
  }

  /*
   * Interaction a un arret
   * Deux cas
   * - numero d'arret < a la destination
   * - numero d'arret >= a la destination
   */
  public void testInteractionArret() {
    PassagerStresse p = new PassagerStresse("yyy", 5);

    FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);

    p.nouvelArret(faux, 1);
    assert 0 == faux.logs.size() : "pas a destination";

    p.nouvelArret(faux,2);
    assert "arretDemanderDebout" == getLastLog(faux) ;
    
    p.nouvelArret(faux, 5);
    assert "arretDemanderSortie" == getLastLog(faux) : "destination";
  }

 
}
