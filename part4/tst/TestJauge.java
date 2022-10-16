package tec;

public class TestJauge {
	public static void main(String[] args) {
		boolean estMisAssertion = false;
		assert estMisAssertion = true;
		if (!estMisAssertion) {
			System.out.println("Execution impossible sans l'option -ea");
			return;
		}
		int nbrTest = 0;
		TestJauge test = new TestJauge();
		System.out.print('.');
		test.testDansIntervalle();
		nbrTest++;
		System.out.print('.');
		test.testHorsIntervalle();
		nbrTest++;
		System.out.print('.');
		test.testNegatif();
		nbrTest++;
		System.out.println("(" + nbrTest + "):OK: " + "tec.TestJauge");
	}

	public void testDansIntervalle() {
		Jauge jauge = new Jauge(500, 200);
		assert jauge.estVert() == true : "doit renvoyer vrai";
		assert jauge.estRouge() == false : "doit renvoyer faux";
	}

	public void testHorsIntervalle() {
		Jauge jauge = new Jauge(500, 501);
		assert jauge.estVert() == false : "doit renvoyer faux";
		assert jauge.estRouge() == true : "doit renvoyer vrai";
		jauge.decrementer();
		jauge.decrementer();
		assert jauge.estVert() == true : "doit renvoyer vrai";
		assert jauge.estRouge() == false : "doit renvoyer faux";
		jauge.incrementer();
		assert jauge.estVert() == false : "doit renvoyer faux";
		assert jauge.estRouge() == true : "doit renvoyer vrai";
	}

	public void testNegatif() {
		Jauge jauge = new Jauge(-10, 10);
		assert jauge.estVert() == false : "doit renvoyer faux";
		assert jauge.estRouge() == true : "doit renvoyer vrai";
	}
}
