package schiebePuzzle;

/**
 * Klasse der WrongNumber Exception
 * Dient als Exception wenn der Uebergebene int Wert nicht zwischen 1 und 15 liegt.
 * 
 * @author Justin, Jan
 * @version 1.0.0
 */

public class WrongNumberException extends RuntimeException{
	
	public WrongNumberException(int i) {
		super("i liegt nicht zwischen 1 und 15. Hier i = " + i);
	}
}
