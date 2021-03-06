package schiebePuzzle;

/**
 * Dies ist die Test-Klasse um das Schiebepuzzel zu Testen
 * 
 * @author Justin, Jan
 * @version 1.0.0
 */

public class TestClass {
	public static void main(String[] args) {
		Schiebepuzzle sp = new Schiebepuzzle();
		sp.mischen();
		System.out.println("Vor der Sortieren");
		System.out.println(sp.toString());
		System.out.println();
		
		Loesungsalgorithmus alg1 = new SchiebAlg1();	
		alg1.loesen(sp);
		System.out.println("Nach dem Sortieren");
		System.out.println(sp);
	}
}
