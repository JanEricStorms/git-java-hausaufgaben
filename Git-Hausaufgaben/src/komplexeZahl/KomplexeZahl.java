package komplexeZahl;

/**
 * Klasse KomplexeZahl zum Erschaffen einer komplexen Zahl Format: z = a + i*b
 * 
 * @version 1.0.0
 * @author Justin, Jonas, Jan
 *
 */
public class KomplexeZahl {

	// #### VARIABLES ####
	private double z;
	private double a;
	private double b;

	// #### CONSTRUCTORS ####
	/**
	 * Konstruktor KomplexeZahl: erstellt eine Komplexe Zahl mit dem Realteil von
	 * Wert 1, Imaginaerteil von Wert 1
	 */
	public KomplexeZahl() {
		this.a = 1;
		this.b = 1;
	}

	/**
	 * Konstruktor KomplexeZahl: erstellt eine Komplexe Zahl mit gegebenden
	 * Parameter a, b
	 * 
	 * @param a > Realteil als double
	 * @param b > Imaginaerteil als double
	 */
	public KomplexeZahl(double a, double b) {
		this.a = a;
		this.b = b;
	}

	// #### METHODS ####
	// ## GETTER ##
	/**
	 * Gibt den Realteil der aktuellen komplexen Zahl (this) zurueck
	 * 
	 * @return double > Realteil als Double
	 */
	public double getRealteil() {
		return this.a;
	}

	/**
	 * Gibt den Imaginaerteil der aktuellen komplexen Zahl (this) zurueck
	 * 
	 * @return double > Imaginaerteil als Double
	 */
	public double getImaginaerteil() {
		return this.b;
	}

	// ## SETTER ##
	/**
	 * Setzt den Realteil der aktuellen komplexen Zahl (this)
	 * 
	 * @param double > Realteil als Double
	 */
	public void setRealteil(double a) {
		this.a = a;
	}

	/**
	 * Setzt den Imaginaerteil der aktuellen komplexen Zahl (this)
	 * 
	 * @param double > Imaginaerteil als Double
	 */
	public void setImaginaerteil(double b) {
		this.b = b;
	}

	/**
	 * Addiert zur aktuellen KomplexeZahl (this) den Parameter z dazu.
	 * 
	 * @param z > Object KomplexeZahl
	 */
	public void addiere(KomplexeZahl z) {
		this.a += z.a;
		this.b += z.b;
		this.z = (this.a + z.a) + (this.b + z.b);
	}
	// ## MAIN METHODS ##
	/**
	 * Multipliziert zur aktuellen KomplexeZahl (this) den Parameter z dazu.
	 * 
	 * @param z > Object KomplexeZahl
	 */
	public void multipliziere(KomplexeZahl z) {
		double a = this.a;
		double b = this.b;
		this.a = (a * z.a) - (b * z.b);
		this.b = (a * z.b) + (z.a * b);
		this.z = ((a * z.a) - (b * z.b)) + ((a * z.b) + (z.a * b));
	}

	/**
	 * Gibt die aktuelle komplexe Zahl (this) als String zurueck im Format: z = a +
	 * i*b
	 * 
	 * @return String > Komplexe Zahl als String
	 */
	public String toString() {
		// Format: a + b*i
		if(this.b == 0) {
			return "" +this.a;
		}else if(this.b == 1){
			return this.a + " + " + "i";
		}else {
		
			return this.a + " + " + this.b + "i";
		}
		
	}

	/**
	 * Gibt den Betrag der aktuellen komplexen Zahl (this)
	 * 
	 * @return double > Betrag als double
	 */
	public double getBetrag() {
		return Math.abs(Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2)));
	}

	/**
	 * Gibt die Quadratwurzel der aktuellen komplexen Zahl (this) zurueck Ergebeniss
	 * als Feld von 2 Elementen, Wurzel von 0 resultiert in zwei 0-Elementen
	 * 
	 * @return KomplexeZahl[] > Feld vom Typ KomplexeZahl
	 */
	public KomplexeZahl[] getWurzel() {
		double r = Math.sqrt(Math.pow(this.a, 2)+Math.pow(this.b, 2));
		double phi;
		KomplexeZahl[] arr = new KomplexeZahl[2];
		if(this.a == 0 && this.b == 0) {
			arr[0] = null;
			arr[1] = null;
			return arr;
		}else if(this.a >= 0 && this.b >= 0) {
			phi = Math.atan(this.b/this.a);
		}else if(this.a < 0 && this.b >= 0) {
			phi = Math.atan(this.b/this.a) + Math.PI;
		}else if(this.a < 0 && this.b < 0) {
			phi = Math.atan(this.b/this.a) + Math.PI;
		}else if (this.a >= 0 && this.b < 0) {
			phi = Math.atan(this.b/this.a) + 2*Math.PI;

		}else {
			//Throw an Exception for no Valid Input. One of the four statements must be true.
			phi = 0;
		}
		arr[0] = new KomplexeZahl(Math.sqrt(r)*(Math.cos((phi+2*0*Math.PI)/2)), Math.sqrt(r)*(Math.sin((phi+2*0*Math.PI)/2)));
		//Der Code muesste Funktionieren, jedoch stimmt das Ergebniss der 2 Nullstelle nicht
		//arr[1] = new KomplexeZahl(Math.sqrt(r)*(Math.cos((phi+(2*1*Math.PI))/2)), Math.sqrt(r)*(Math.sin((phi+2*1*Math.PI)/2)));
		arr[1] = new KomplexeZahl(-arr[0].a,-arr[0].b);
		return arr;
		// NOT FINISHED
	}

	/**
	 * Gibt die Summe, aus der aktuellen komplexen Zahl (this) und dem Parameter z ,
	 * zurueck
	 * 
	 * @param z > Object KomplexeZahl
	 * @return KomplexeZahl > Komplexe Zahl als Object
	 */
	public KomplexeZahl getSumme(KomplexeZahl z) {
		double a = this.a + z.a;
		double b = this.b + z.b;

		KomplexeZahl k = new KomplexeZahl(a, b);

		return k;
	}

	/**
	 * Gibt das Produkt, aus der aktuellen komplexen Zahl (this) und dem Parameter
	 * z, zurueck
	 * 
	 * @param z > Object KomplexeZahl
	 * @return KomplexeZahl > Komplexe Zahl als Object
	 */
	public KomplexeZahl getProdukt(KomplexeZahl z) {

		double a = (this.a * z.a) - (this.b * z.b);
		double b = (this.a * z.b) + (z.a * this.b);

		KomplexeZahl k = new KomplexeZahl(a, b);
		return k;

	}
}
