package uebung5jan;

public class FunktionA implements Funktion {

	@Override
	public double getY(double x) {
		double erg = Math.pow(Math.E, x) - 4;
		return erg;
	}

	public String toString() {
		return "Funktion:	f(x) := exp(x)-4 in (0.0,10.0)";
	}

}
