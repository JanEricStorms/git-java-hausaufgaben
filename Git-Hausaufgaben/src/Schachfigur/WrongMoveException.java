package Schachfigur;

public class WrongMoveException extends Exception{

	public WrongMoveException(String message, int x , int y) {
		super(String.format("%s (%d,%d)", message, x, y));
	}

}
