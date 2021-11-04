package uebung5jan;

public class FunktionC implements Funktion {

	@Override
	public double getY(double x) {
		double erg = Math.pow(x, 2) - Math.sin(x) - 1;
		return erg;
	}

	public String toString() {
		return "Funktion:	f(x) := x^2-sin(x)-1 in (0.0,10.0)";
	}

}
