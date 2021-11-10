package GefangenenDilemma;
/**
 * Klasse PerKind implementiert GefangenenStrategie <br>
 * Strategie: <br>  Spielt periodisch die Folge kooperieren/kooperieren/verraten
 * 
 * @author Justin,Jonas,Jan
 * @version 1.0.0
 *
 */
public class PerKind implements GefangenenStrategie {

	private int counter = 0;
	/**
	 * Gibt die nächste Entscheidung des (this) Spieler zurück <br>
	 * Format: true = Kooperation, false = Verrat
	 * 
	 * @return boolean > Entscheidung
	 */
	public boolean getNextDecision() {
		if (counter == 2) {
			counter = 0;
			return false;
		}
		counter++;
		return true;
		
	}
	/**
	 * Setzt die vorherige Entscheidung des Gegners mit dem angegebenen Parameter
	 * @param decision > boolean
	 */
	public void setOpponentsLastDecision(boolean decision) {
	}

}
