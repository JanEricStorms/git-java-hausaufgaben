package GefangenenDilemma;
/**
 * Klasse GefangenenDilemma zum Verwalten und Spielen vom Strategie-Spiel
 * 
 * @author Justin, Jonas, Jan
 * @version 1.1.0
 *
 */
public class GefangenenDilemma {

	private GefangenenStrategie playerOne;
	private GefangenenStrategie playerTwo;
	private int pointsPlayerOne;
	private int pointsPlayerTwo;
	
	// constructors
	/**
	 * Konstruktor: Erstellt ein neues this Objekt mit den angegebenen Parametern
	 * @param playerOne > GefangenenStrategie
	 * @param playerTwo > GefangenenStrategie
	 */
	public GefangenenDilemma(GefangenenStrategie playerOne, GefangenenStrategie playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}
	// methods
	/**
	 * Startet ein Spiel mit den Strategien der Spieler und dem angegebenen Parameter als Spieldauer
	 * @param length > int
	 */
	public void spiele(int length) {
		for (int i = 0; i < length; i++) {

			boolean decisionOne = playerOne.getNextDecision();
			boolean decisionTwo = playerTwo.getNextDecision();

			if (decisionOne == true && decisionTwo == true) {
				this.pointsPlayerOne += 2;
				this.pointsPlayerTwo += 2;
			} else if (decisionOne == false && decisionTwo == false) {
				this.pointsPlayerOne += 4;
				this.pointsPlayerTwo += 4;
			} else if (decisionOne == true && decisionTwo == false) {
				this.pointsPlayerOne += 6;
				this.pointsPlayerTwo += 1;
			} else {
				this.pointsPlayerOne += 1;
				this.pointsPlayerTwo += 6;
			}

			playerOne.setOpponentsLastDecision(decisionTwo);
			playerTwo.setOpponentsLastDecision(decisionOne);
		}
		String strg1 = String.format("Spieler 1 (%-8s): %5d", this.playerOne.getClass().getSimpleName(),
				this.pointsPlayerOne);
		String strg2 = String.format("Spieler 2 (%-8s): %5d", this.playerTwo.getClass().getSimpleName(),
				this.pointsPlayerTwo);
		String winner = this.getWinner(this.pointsPlayerOne, this.pointsPlayerTwo);
		
		System.out.println(strg1 + System.lineSeparator() + strg2 + System.lineSeparator() + "-".repeat(50) + System.lineSeparator() + winner);
		

	}
	/**
	 * Ermittelt den Gewinner der beiden Spieler
	 * 
	 * @param playerOnePoints > int
	 * @param PlayerTwoPoints > int 
	 * @return String > Gewinner
	 */
	private String getWinner(int playerOnePoints, int PlayerTwoPoints) {
		if (playerOnePoints > PlayerTwoPoints) {
			return "Spieler 1 hat gewonnen";
		} else if (playerOnePoints < PlayerTwoPoints) {
			return "Spieler 2 hat gewonnen";
		}

		return "Gleichstand";
	}
}
