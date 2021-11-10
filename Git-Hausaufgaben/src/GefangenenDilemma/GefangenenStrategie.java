package GefangenenDilemma;
/**
 * Interface GefangenenStrategie
 * 
 * @author Justin,Jonas,Jan
 * @version 1.0.0
 *
 */
public interface GefangenenStrategie {
	boolean getNextDecision();
	
	void setOpponentsLastDecision(boolean decision);
}
