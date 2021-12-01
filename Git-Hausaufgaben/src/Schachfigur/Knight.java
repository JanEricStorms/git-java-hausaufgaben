package Schachfigur;

import java.util.ArrayList;

public class Knight extends Chessman{

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
	public ArrayList<Position> getMoveList(){
		ArrayList<Position> doableMoves = new ArrayList<>();
		int currenX = super.getPosition().getX();
		int currenY = super.getPosition().getY();
		//Prueft die 4 Himmelsrichtungen
		for(int i = 0; i < 4;i++) {
			if(i == 0 && Position.isValid(currenX, currenY+2)) {
				//Norden
				if(Position.isValid(currenX-1, currenY+2)) {
					//Links
					try {
					doableMoves.add(new Position(currenX-1, currenY+2));
					}catch (WrongPositionException e){
					}
				}
				if(Position.isValid(currenX+1, currenY+2)) {
					//Rechts
					try {
						doableMoves.add(new Position(currenX+1, currenY+2));
						}catch (WrongPositionException e){
						}
				}
			}else if(i == 1 && Position.isValid(currenX+2, currenY)) {
				//Osten
				if(Position.isValid(currenX+2, currenY+1)) {
					//Oben
					try {
					doableMoves.add(new Position(currenX+2, currenY+1));
					}catch (WrongPositionException e){
					}
				}
				if(Position.isValid(currenX+2, currenY-1)) {
					//Unten
					try {
						doableMoves.add(new Position(currenX+2, currenY-1));
						}catch (WrongPositionException e){
						}
				}
			}else if ( i == 2 && Position.isValid(currenX, currenY-2)) {
				//Sueden
				if(Position.isValid(currenX+1, currenY-2)) {
					//Rechts
					try {
					doableMoves.add(new Position(currenX+1, currenY-2));
					}catch (WrongPositionException e){
					}
				}
				if(Position.isValid(currenX-1, currenY-2)) {
					//Links
					try {
						doableMoves.add(new Position(currenX-1, currenY-2));
						}catch (WrongPositionException e){
						}
				}
			}else if(i == 3 && Position.isValid(currenX-2, currenY)){
				//Westen
				if(Position.isValid(currenX-2, currenY-1)) {
					//Unten
					try {
					doableMoves.add(new Position(currenX-2, currenY-1));
					}catch (WrongPositionException e){
					}
				}
				if(Position.isValid(currenX-2, currenY+1)) {
					//Oben
					try {
						doableMoves.add(new Position(currenX-2, currenY+1));
						}catch (WrongPositionException e){
						}
				}
			}
		}
		return doableMoves;
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
