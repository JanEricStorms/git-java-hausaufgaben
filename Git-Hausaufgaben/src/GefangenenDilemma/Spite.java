package GefangenenDilemma;

public class Spite implements GefangenenStrategie {

	private boolean lastDecision;
	private int counter = 0;

	@Override
	public boolean getNextDecision() {

		if (this.lastDecision == false) {
			this.counter = 1;
			return true;
		} else if (this.lastDecision == true && this.counter == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		this.lastDecision = decision;

	}

}
