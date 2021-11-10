package GefangenenDilemma;
/**
 * Klasse Pavlov implementiert GefangenenStrategie <br>
 * Strategie: <br> Kooperiert in der ersten Runde und verrät, falls der vorherige Zug des Mitspielers anders als der eigene war. Kooperiert, wenn in der Vorrunde beide Spieler kooperierten oder beide verrieten
 * 
 * @author Justin,Jonas,Jan
 * @version 1.0.0
 *
 */
public class Pavlov implements GefangenenStrategie {
	
	
	private boolean opponentLastDecision;
	private boolean myLastDecision;
	
	/**
	 * Gibt die nächste Entscheidung des (this) Spieler zurück <br>
	 * Format: true = Kooperation, false = Verrat
	 * 
	 * @return boolean > Entscheidung
	 */
	public boolean getNextDecision() {
		
		if(myLastDecision != opponentLastDecision) {
			return myLastDecision = false;
		} else {
			return myLastDecision = true;
		}
	

	}
	/**
	 * Setzt die vorherige Entscheidung des Gegners mit dem angegebenen Parameter
	 * @param decision > boolean
	 */
	public void setOpponentsLastDecision(boolean decision) {
		this.opponentLastDecision = decision;

	}

}
