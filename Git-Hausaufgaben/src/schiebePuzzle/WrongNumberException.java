package schiebePuzzle;

public class WrongNumberException extends RuntimeException{
	
	public WrongNumberException(int i) {
		super("i liegt nicht zwischen 1 und 15. Hier i = " + i);
	}
}
