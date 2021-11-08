package Rechenoperation;
/**
 * Klasse Quadratwurzel implemenziert Rechenoperation <br>
 * Zum Berechnen von Quadratwurzeln
 * 
 * @author Justin,Jonas,Jan
 * @version 1.0.0
 */
public class Quadratwurzel implements Rechenoperation{

	/**
	 * Berechnet die Quadratwurzel vom angegebenen Parameter
	 * 
	 * @param x > double
	 * @return double > Das Ergebniss
	 * @throws ArithmeticException > Parameter x ist eine negative Zahl
	 */
	public double berechne(double x) {
		if(x < 0) {
			throw new ArithmeticException("Die Zahl darf nicht negativ sein");
		}
		return Math.sqrt((double)x);
	}

}
