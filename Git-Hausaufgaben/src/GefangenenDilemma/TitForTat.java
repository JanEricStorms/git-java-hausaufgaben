package GefangenenDilemma;

public class TitForTat implements GefangenenStrategie {

	private boolean lastDecision; // true = kooperieren false = nicht kooperieren
	private int counter = 0;

	@Override
	public boolean getNextDecision() {

		if (this.lastDecision == false) {

			if (this.counter == 1) {
				return false;
			}
			this.counter = 1;
			return true;
		} else {
			if (this.counter == 1) {
				this.counter = 0;
				return false;
			}
			return true;
		}

	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		this.lastDecision = decision;

	}

}
