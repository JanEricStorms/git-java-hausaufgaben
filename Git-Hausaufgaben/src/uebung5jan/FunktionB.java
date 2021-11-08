package uebung5jan;

public class FunktionB implements Funktion {

	@Override
	public double getY(double x) {
		double erg = Math.log(Math.abs(x + 1)) - Math.sin(2 * x) - 0.5;
		return erg;
	}

	public String toString() {
		return "Funktion:	f(x) := ln|x+1|-sin(2x)-0.5 in (0.0,10.0)";
	}

}
