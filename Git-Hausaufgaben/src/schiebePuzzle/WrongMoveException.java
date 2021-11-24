package schiebePuzzle;

/**
 * Klasse der WrongMoveException 
 * Dient als Exception wenn der Zug nicht moeglich ist.
 * 
 * @author Justin, Jan
 * @version 1.0.0
 */

public class WrongMoveException extends RuntimeException{

	public WrongMoveException(int i) {
		super("Zug ist nicht moeglich. " + i + " kann nicht verschoben werden.");
	}
	
}
