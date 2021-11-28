
package Schachfigur;

public class Position {

	
	// ### attributes
	private int posX;
	private int posY;
	
	// ### constructors
	/**
	 * Konstruktor: Erstellt ein neues Objekt und setzt die Position zu den angegebenen Parametern
	 * <br><b>Range</b>: 1-8 (inklusiv)
	 * 
	 * @param x > int
	 * @param y > int
	 * @throws WrongMoveException 
	 */
	public Position(int x, int y) throws WrongMoveException {
		if(!isValid(x, y)) {
			throw new WrongMoveException("Die Koordinanten befinden sich nicht auf dem Feld", x, y);
		}
		this.posX = x;
		this.posY = y;
	}
	
	// ### methods
	/**
	 * Gibt die x-Koordinate des (this) Objekt zurueck
	 * 
	 * @return int > x-Kordinate
	 */
	public int getX() {
		return this.posX;
	}
	/**
	 * Gibt die y-Koordinate des (this) Objekt zurueck
	 * 
	 * @return int > y-Kordinate
	 */
	public int getY() {
		return this.posY;
	}
	/**
	 * Ueberprueft ob die Position des (this) Objekt mit dem angegebenen Parameter uebereinstimmt
	 * 
	 * @param p > Position
	 * @return boolean > Status des Vergleich: true = selbe Position 
	 */
	public boolean equals(Position p) {
		if(this.posX == p.posX && this.posY == p.posY) {
			return true;
		}
		return false;
	}
	/**
	 * Ueberprueft ob die angegebenen Parameter eine gueltige Position bilden
	 * <br><b>Range</b>: 1-8 (inklusiv)
	 * 
	 * @param x > int
	 * @param y > int
	 * @return boolean > Status der Gueltigkeit: true = ist gueltig
	 */
	public static boolean isValid(int x, int y) {
		if(x > 8 || y > 8 || x < 1 || y < 1) {
			return false;		
		}
		return true;
	}
	/**
	 * Ueberschreibt die standartweise toString Methode
	 * <br> Gibt die Position des (this) Objekt im String-Format zurueck
	 * <br><b>Format</b>: (x/y)
	 * 
	 * @return String > Position
	 */
	@Override
	public String toString() {
		return String.format("(%d,%d)", this.posX, this.posY);
	}

}
