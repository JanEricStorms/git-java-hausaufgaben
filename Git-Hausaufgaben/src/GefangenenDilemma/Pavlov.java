package GefangenenDilemma;

public class Pavlov implements GefangenenStrategie {

	private boolean opponentLastDecision;
	private boolean myLastDecision;
	private int counter;

	public boolean getNextDecision() {
		
		if(myLastDecision != opponentLastDecision) {
			return myLastDecision = false;
		} else {
			return myLastDecision = true;
		}
	

	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		this.opponentLastDecision = decision;

	}

}
