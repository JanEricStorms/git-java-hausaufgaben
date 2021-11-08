package GefangenenDilemma;

public class GefangenenDilemma {

	private GefangenenStrategie playerOne;
	private GefangenenStrategie playerTwo;
	private int pointsPlayerOne;
	private int pointsPlayerTwo;

	public GefangenenDilemma(GefangenenStrategie playerOne, GefangenenStrategie playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}

	public void spiele(int n) {
		for (int i = 0; i < n; i++) {

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

		System.out.println("Spieler 1: "+ this.playerOne.getClass() + this.pointsPlayerOne + "    Spieler 2: " + this.pointsPlayerTwo);

	}
}
