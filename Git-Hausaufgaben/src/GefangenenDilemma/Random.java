package GefangenenDilemma;

public class Random implements GefangenenStrategie{

	@Override
	public boolean getNextDecision() {
		double rmd = Math.random()*2;
		if(rmd>1) {
			return false;
		}
		return true;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
	}

}
