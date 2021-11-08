package Rechenoperation;
/**
 * Klasse Addition implemenziert Rechenoperation <br>
 * Zum Berechnen von Werten nach Addition
 * 
 * @author Justin, Jonas, Jan
 * @version 1.0.0
 */
public class Addition implements Rechenoperation {

	private double number; 
	
	/**
	 * Konstruktor: Erstellt ein neues Objekt mit dem angegebenen Parameter
	 * 
	 * @param value > double
	 */
	public Addition(double value) {
		this.number = value;
	}
	/**
	 * Berechnet die Addition vom (this) Objekt und den angegebenen Parameter
	 * 
	 * @param x > double
	 * @return double > Das Ergebniss
	 */
	public double berechne(double x) {
		return (double) this.number + (double) x;
	}
	
}
