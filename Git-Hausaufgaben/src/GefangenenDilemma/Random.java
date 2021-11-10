package GefangenenDilemma;

/**
 * Klasse Random implementiert GefangenenStrategie <br>
 * Strategie: <br>
 * Verraet oder kooperiert aufgrund eines 50:50-Zufallsentscheids
 * 
 * @author Justin,Jonas,Jan
 * @version 1.0.0
 *
 */
public class Random implements GefangenenStrategie {

	/**
	 * Gibt die naechste Entscheidung des (this) Spieler zurueck <br>
	 * Format: true = Kooperation, false = Verrat
	 * 
	 * @return boolean > Entscheidung
	 */
	public boolean getNextDecision() {
		if ((Math.random() * 2) > 1) {
			return false;
		}
		return true;
	}

	/**
	 * Setzt die vorherige Entscheidung des Gegners mit dem angegebenen Parameter
	 * 
	 * @param decision > boolean
	 */
	public void setOpponentsLastDecision(boolean decision) {
	}

}
