package Rechenoperation;
/**
 * Klasse Quadrat implemenziert Rechenoperation <br>
 * Zum Berechnen von Quadrierungen
 * 
 * @author Justin,Jonas,Jan
 * @version 1.0.0
 */
public class Quadrat implements Rechenoperation{

	/**
	 * Berechnet die Quadrierung vom angegebenen Parameter
	 * 
	 * @param x > double
	 * @return double > Das Ergebniss
	 */
	public double berechne(double x) {
		return Math.pow((double)x, 2);
	}

}
