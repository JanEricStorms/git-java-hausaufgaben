package schiebePuzzle;

public class WrongMoveException extends RuntimeException{

	public WrongMoveException(int i) {
		super("Zug ist nicht moeglich. " + i + " kann nicht verschoben werden.");
	}
	
}
