package tec;

abstract public class TestPassagerAbstrait
{
    abstract protected PassagerAbstrait creerPassager(String nom, int destination);

  public void testInstanciation() {
    PassagerAbstrait p = creerPassager("xxx", 3);

    assert false == p.estAssis();
    assert false == p.estDebout();
    assert true == p.estDehors();
  }

  public void testGestionEtat() {
    PassagerAbstrait p = creerPassager("yyy", 3);

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


    abstract public void testInteractionMontee();
    abstract public void testInteractionArret();

   public String getLastLog(FauxVehicule f) {
    return f.logs.get(f.logs.size() - 1);
  }
}
