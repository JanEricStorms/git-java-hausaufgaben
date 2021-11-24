package schiebePuzzle;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Ist ein einfacher Loesungsalgorithmus der nur die 1 auf die erste Stelle des Spiel Feldes bringen soll
 * 
 * @author Justin, Jan
 * @version 1.0.0
 */
public class SchiebAlg1 implements Loesungsalgorithmus{

	/**
	 * Nimmt solange zufaellige Zuege vor bist das Feld mit dem Wert 1 an der Position [0][0] im Schiebepuzzel ist
	 * 
	 * @param Schiebepuzzle > Erhaelt das Schiebepuzzel das geloest werden soll
	 */
	@Override
	public void loesen(Schiebepuzzle puzzle) {
		try {
			int[] arr = new int[] {0,0};
		while(!Arrays.toString(puzzle.getPosition(1)).equals(Arrays.toString(arr))) {
			int target;
			
				target = ThreadLocalRandom.current().nextInt(1, 15+1);
				if(puzzle.istVerschiebbar(target) == true) {
				puzzle.schiebe(target);
				}
				
		}
		}catch (NullPointerException e) {
		}
	}

}
