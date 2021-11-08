package GefangenenDilemma;

public interface GefangenenStrategie {
	boolean getNextDecision();
	
	void setOpponentsLastDecision(boolean decision);
}
