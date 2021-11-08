package GefangenenDilemma;

public class PerKind implements GefangenenStrategie {

	private int counter = 0;

	@Override
	public boolean getNextDecision() {
		if (counter == 2) {
			counter = 0;
			return false;
		}
		counter++;
		return true;
		
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
	}

}
