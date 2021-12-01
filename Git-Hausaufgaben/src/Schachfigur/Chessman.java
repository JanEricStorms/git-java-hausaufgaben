package Schachfigur;

import java.util.ArrayList;

public abstract class Chessman {

	// ### attributes
	private Position currentPos;
	
	// ### constructors
	/**
	 * Konstruktor: Erstellt ein neues Objekt Chessman mit der Position aus dem angegebenen Parameter
	 * 
	 * @param pos > Position
	 */
	public Chessman (Position pos) {
		this.currentPos = pos;
	}
	
	// ### methods
	/**
	 * Gibt die aktuelle Position der (this) Figur zurueck
	 * 
	 * @return Position > Aktuelle Position der Figur
	 */
	public Position getPosition() {
		return this.currentPos;
	}
	
	/**
	 * Setzt die (this) Figur auf einem Punkt mit dem angegebenen Parameter
	 * 
	 * @param pos > Objekt Typ Position
	 * @throws WrongMoveException > Feld nicht erreichbar in einem Zug
	 */
	public void moveTo(Position pos) throws WrongMoveException {
		if(canMoveTo(pos)) {
			this.currentPos = pos;
		}else {
			throw new WrongMoveException("Das Feld ist nicht in einem Zug erreichbar", pos.getX(), pos.getY());
		}
	}
	/**
	 * Gibt eine Liste aller moeglichen Zuege der (this) Figur zurueck
	 * 
	 * @return ArrayList<Position> > Eine Liste vom Typ Position
	 * 
	 */
	public abstract ArrayList<Position> getMoveList();
	/**
	 * 
	 * Testet ob die (this) Figur zu dem angegebenen Parameter bewegt werden kann
	 * 
	 * @param pos > Position
	 * @return boolean > Status der Bewegbarkeit: true = bewegbar 
	 */
	public boolean canMoveTo(Position pos) {
		for(int i = 0; i< getMoveList().size();i++) {
			if(getMoveList().get(i).toString().equals(pos.toString())) {
				return true;
			}
		}
		return false;
	}
}
