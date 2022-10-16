package tec;

class TestPassagerStresse {

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

  // ********************************************************
  /*
   * Etat apres instanciation
   * Un seul cas
   */
  public void testInstanciation() {
    PassagerStresse p = new PassagerStresse("xxx", 3);

    assert false == p.estAssis();
    assert false == p.estDebout();
    assert true == p.estDehors();
  }

  /*
   * Gestion des changement d'état.
   * 
   * Changer Debout puis Dehors puis assis.
   */
  public void testGestionEtat() {
    PassagerStresse p = new PassagerStresse("yyy", 3);

    p.changerEnDebout();
    assert false == p.estAssis();
    assert true == p.estDebout();
    assert false == p.estDehors();

    p.changerEnDehors();
    assert false == p.estAssis();
    assert false == p.estDebout();
    assert true == p.estDehors();

    p.changerEnAssis();
    assert true == p.estAssis();
    assert false == p.estDebout();
    assert false == p.estDehors();
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

  private String getLastLog(FauxVehicule f) {
    return f.logs.get(f.logs.size() - 1);
  }
}
