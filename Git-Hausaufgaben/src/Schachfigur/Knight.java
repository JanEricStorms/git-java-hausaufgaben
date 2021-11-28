package Schachfigur;

import java.util.ArrayList;

public class Knight extends Chessman{

	// ### attributes
	private int movesStraight = 2;
	private int movesLeftRight = 1;
	// ### parent constructor
	/**
	 * Konstruktor: Erstellt ein neues Objekt Knight mit den angegebenen Parameter
	 * @param pos > Position
	 */
	public Knight(Position pos) {
		super(pos);
	}
	// ### methods
	@Override
	public ArrayList<Position> getMoveList() throws WrongMoveException 
	{
		int currentX = super.getPosition().getX();
		int currentY = super.getPosition().getY();
		ArrayList<Position> accetableMoves = new ArrayList<>();
		
		int a = 1;
		int b = 1;
		for(int i = 0; i<4; i++) {
			if(Position.isValid(currentX+this.movesStraight*a, currentY+this.movesLeftRight*b)) {
				accetableMoves.add(new Position(currentX+this.movesStraight*a, currentY+this.movesLeftRight*b));
			}
			if(Position.isValid(currentX+this.movesLeftRight*b, currentY+this.movesStraight*a)) {
				accetableMoves.add(new Position(currentX+this.movesLeftRight*b, currentY+this.movesStraight*a));
			}
			if(i == 1) {
				a *= -1;
			}
			if(i == 2) {
				a *= -1;
				b *= -1;
			}
			if(i == 3) {
				a *= 1;
				b *= -1;
			}
		}
		return accetableMoves;
	}
	
	/**
	 * Ueberschreibt die standartweise toString Methode
	 * <br> Gibt die Position des (this) Objekt im String-Format zurueck
	 * <br><b>Format</b>: Springer (x/y)
	 * 
	 * @return String > Position
	 */
	@Override
	public String toString() 
	{
		return "Springer: " + super.getPosition();
	}
	

}
