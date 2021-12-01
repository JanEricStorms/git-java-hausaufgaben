package Schachfigur;

public class main {

	public static void main(String[] args) throws WrongPositionException, WrongMoveException {
		/*
		Position p = new Position(3, 5);

		Rook rook = new Rook(new Position(3,5));
		
		System.out.println("\n" + rook + "\n");
		for(Position pTest : rook.getMoveList()) {
			rook.moveTo(pTest);
			System.out.println(rook);
		}
		
		Knight knight = new Knight(new Position(5,5));
		System.out.println("\n" + knight + "\n");
		for(Position pTest : knight.getMoveList()) {
			knight.moveTo(pTest);
			System.out.println(knight);
		}
		*/
		Rook rook = new Rook(new Position(4,5));
		System.out.println(rook);
		rook.moveTo(new Position(4,1));
		System.out.println(rook);
		System.out.println(rook.getMoveList());
		// Test eines Springers
		Knight knight = new Knight(new Position(5,4));
		System.out.println(knight);
		knight.moveTo(new Position(6,6)); // mitten auf dem Feld
		System.out.println(knight);
		System.out.println(knight.getMoveList());
		knight.moveTo(new Position(8,5)); // am Rand des Feldes
		System.out.println(knight);
		System.out.println(knight.getMoveList());

	}

}
