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
	public void moveTo(Position pos) {
		if(!this.currentPos.equals(pos)) {
			this.currentPos = pos;
		}
	}
	/**
	 * Gibt eine Liste aller möglichen Zuege der (this) Figur zurueck
	 * 
	 * @return ArrayList<Position> > Eine Liste vom Typ Position
	 */
	public abstract ArrayList<Position> getMoveList() throws WrongMoveException;
	/**
	 * 
	 * Testet ob die (this) Figur zu dem angegebenen Parameter bewegt werden kann
	 * 
	 * @param pos > Position
	 * @return boolean > Status der Bewegbarkeit: true = bewegbar 
	 */
	public boolean canMoveTo(Position pos) {
		if(Position.isValid(pos.getX(), pos.getY())) {
			return true;
		}
		return false;
	}
}
