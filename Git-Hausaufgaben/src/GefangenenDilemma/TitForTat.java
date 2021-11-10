package GefangenenDilemma;
/**
 * Klasse TitForTat implementiert GefangenenStrategie <br>
 * Strategie: <br> Kooperiert in der ersten Runde und kopiert in den nächsten Runden den vorherigen Spielzug des Spielpartners. Diese Strategie ist prinzipiell kooperationswillig, übt aber bei Verrat Vergeltung. Bei erneuter Kooperation des Mitspielers ist sie nicht nachtragend, sondern reagiert ihrerseits mit Kooperation
 * 
 * @author Justin,Jonas,Jan
 * @version 1.0.0
 *
 */
public class TitForTat implements GefangenenStrategie {

	private boolean lastDecision;
	private int counter = 0;

	/**
	 * Gibt die nächste Entscheidung des (this) Spieler zurück <br>
	 * Format: true = Kooperation, false = Verrat
	 * 
	 * @return boolean > Entscheidung
	 */
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

	/**
	 * Setzt die vorherige Entscheidung des Gegners mit dem angegebenen Parameter
	 * @param decision > boolean
	 */
	public void setOpponentsLastDecision(boolean decision) {
		this.lastDecision = decision;

	}

}
