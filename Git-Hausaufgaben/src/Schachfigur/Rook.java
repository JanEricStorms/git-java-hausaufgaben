package Schachfigur;

import java.util.ArrayList;

public class Rook extends Chessman{

	// ### attributes
	private int moves = 3;
	
	// ### parent constructor
	/**
	 * Konstruktor: Erstellt ein neues Objekt Rook mit den angegebenen Parameter
	 * @param pos > Position
	 */
	public Rook(Position pos) {
		super(pos);
	}
	// ### methods
	@Override
	public ArrayList<Position> getMoveList() throws WrongMoveException 
	{
		int currentX = super.getPosition().getX();
		int currentY = super.getPosition().getY();
		ArrayList<Position> accetableMoves = new ArrayList<>();
		int changePos = this.moves;
		// 4 directions
		for(int i = 0; i<2; i++) {
			if(i==1){
				changePos *= -1;
			}
			if(Position.isValid(currentX+changePos, currentY)) {
				accetableMoves.add(new Position(currentX+changePos, currentY));
			}
			if(Position.isValid(currentX, currentY+changePos)) {
				accetableMoves.add(new Position(currentX, currentY+changePos));
			}
		}
		return accetableMoves;
		
	}
	
	/**
	 * Ueberschreibt die standartweise toString Methode
	 * <br> Gibt die Position des (this) Objekt im String-Format zurueck
	 * <br><b>Format</b>: Turm: (x/y)
	 * 
	 * @return String > Position
	 */
	@Override
	public String toString() 
	{
		return "Turm: " + super.getPosition();
	}
}
