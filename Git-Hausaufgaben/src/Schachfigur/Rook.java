package Schachfigur;

import java.util.ArrayList;

public class Rook extends Chessman{

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
	public ArrayList<Position> getMoveList(){
		ArrayList<Position> doableMoves = new ArrayList<>();
		int currentX = super.getPosition().getX();
		int currentY = super.getPosition().getY();
		for( int i = 0; i <4; i++) {
			if(i ==  0) {
				//Norden bis zum Feldrand
				for(int j = 1; Position.isValid(currentX, currentY+j);j++) {
					try {
						doableMoves.add(new Position(currentX, currentY+j));
					} catch (WrongPositionException e) {
					}
				}
			}else if(i == 1) {
				//Osten bis zum Feldrand
				for(int j = 1; Position.isValid(currentX+j, currentY);j++) {
					try {
						doableMoves.add(new Position(currentX+j, currentY));
					} catch (WrongPositionException e) {
					}
				}
			}else if(i == 2) {
				//Sueden bis zum Feldrand
				for(int j = 1; Position.isValid(currentX, currentY-j);j++) {
					try {
						doableMoves.add(new Position(currentX, currentY-j));
					} catch (WrongPositionException e) {
					}
				}
			}else if(i == 3) {
				//Westen bis zum Feldrand
				for(int j = 1; Position.isValid(currentX-j, currentY);j++) {
					try {
						doableMoves.add(new Position(currentX-j, currentY));
					} catch (WrongPositionException e) {
					}
				}
			}
		}
		
		return doableMoves;
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
