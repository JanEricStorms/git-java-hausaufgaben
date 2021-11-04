package uebung5jan;

public class FunktionD implements Funktion {

	@Override
	public double getY(double x) {
		double erg = Math.pow(x, 4) + Math.pow(x, 3) - 5;
		return erg;
	}

	public String toString() {
		return "Funktion:	f(x) := x^4+x^3-5 in (0.0,10.0)";
	}

}
