package Schachfigur;

public class WrongPositionException extends Exception{

	public WrongPositionException(String message, int x , int y) {
		super(String.format("%s (%d,%d)", message, x, y));
	}

}