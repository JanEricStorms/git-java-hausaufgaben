package GefangenenDilemma;

/**
 * Klasse Spite implementiert GefangenenStrategie <br>
 * Strategie: <br>
 * Kooperiert solange, bis der Mitspieler zum ersten Mal verraet. Verraet danach
 * immer. Kooperiert bis zum ersten Vertrauensmissbrauch
 * 
 * @author Justin,Jonas,Jan
 * @version 1.0.0
 *
 */
public class Spite implements GefangenenStrategie {

	private boolean lastDecision;
	private int counter = 0;

	/**
	 * Gibt die naechste Entscheidung des (this) Spieler zurueck <br>
	 * Format: true = Kooperation, false = Verrat
	 * 
	 * @return boolean > Entscheidung
	 */
	public boolean getNextDecision() {

		if (this.lastDecision == false) {
			this.counter = 1;
			return true;
		} else if (this.lastDecision == true && this.counter == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Setzt die vorherige Entscheidung des Gegners mit dem angegebenen Parameter
	 * 
	 * @param decision > boolean
	 */
	public void setOpponentsLastDecision(boolean decision) {
		this.lastDecision = decision;

	}

}
