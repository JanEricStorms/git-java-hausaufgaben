package goldPreis;
/** 
 * Klasse Goldtagespreis: Zum Verwalten eines einzigen Goldpreises an einem Tag
 * 
 * @version 1.0.0
 * @author Justin, Jonas, Jan
 *
 */
public class Goldtagespreis {
	
	// ### variables
	public String datum;
	public double preis;

	// ### constructors
	/**
	 * Konstruktor: Erstellt ein Objekt mit den angebenen Parametern Datum und Preis
	 * 
	 * @param datum > String
	 * @param preis > double
	 */
	public Goldtagespreis(String datum, double preis) {
		this.datum = datum;
		this.preis = preis;
	}
	
	// ### methods
	/**
	 * Gibt das Datum und den Preis in einem String zurueck <br>
	 *
	 * @return String 
	 */
	public String toString() {
		String erg = this.datum + "\t " + this.preis;
		return erg;
	}
}
