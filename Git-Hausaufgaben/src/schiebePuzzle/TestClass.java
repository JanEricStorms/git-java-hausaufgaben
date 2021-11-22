package schiebePuzzle;

public class TestClass {
	public static void main(String[] args) {
		Schiebepuzzle sp = new Schiebepuzzle();
		sp.mischen();
		System.out.println(sp.toString());
		Loesungsalgorithmus alg1 = new SchiebAlg1();
		alg1.loesen(sp);
		System.out.println(sp);
	}
}
