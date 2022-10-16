package tec;

public class TestPosition {
	public static void main(String[] args) {
		boolean estMisAssertion = false;
		assert estMisAssertion = true;
		if (!estMisAssertion) {
			System.out.println("Execution impossible sans l'option -ea");
			return;
		}
		int nbrTest = 0;
		TestPosition test = new TestPosition();
		System.out.print('.');
		test.testAssis();
		nbrTest++;
		System.out.print('.');
		test.testDebout();
		nbrTest++;
		System.out.print('.');
		test.testDehors();
		nbrTest++;
		System.out.println("(" + nbrTest + "):OK: " + "tec.TestPosition");

	}

	public void testAssis() {
		// Position p = new Position();
		Position p = Position.assis();
		assert p.estAssis() == true : "estAssis() doit renvoyer vraie";
		assert p.estDebout() == false : "estDebout() doit renvoyer faux";
		assert p.estDebout() == false : "estDebout() doit renvoyer faux";
		assert p.estDehors() == false : "estDehors() doit renvoyer faux";
		assert p.estInterieur() == true : "estInterieur() doit renvoyer vraie";
	}

	public void testDebout() {
		// Position p = new Position();
		Position p = Position.debout();
		assert p.estAssis() == false : "estAssis() doit renvoyer faux";
		assert p.estDebout() == true : "estDebout() doit renvoyer vraie";
		assert p.estDebout() == true : "estDebout() doit renvoyer vraie";
		assert p.estDehors() == false : "estDehors() doit renvoyer faux";
		assert p.estInterieur() == true : "estInterieur() doit renvoyer vraie";
	}

	public void testDehors() {
		Position p = Position.dehors();
		assert p.estAssis() == false : "estAssis() doit renvoyer faux";
		assert p.estDebout() == false : "estDebout() doit renvoyer faux";
		assert p.estDehors() == true : "estDehors() doit renvoyer vraie";
		assert p.estInterieur() == false : "estInterieur() doit renvoyer faux";
	}
}
