package Pokerspiel;

import java.util.Comparator;

/**
 * Klasse BlattVergleich implementiert Comparator<Blatt> zum Vergleichen vom Objekte des Types Blatt
 * 
 * @author Justin, Jonas, Jan
 * @version 1.0.0
 *
 */
public class BlattVergleich implements Comparator<Blatt> {
	
	/**
	 * Vergleicht die beiden angegebenen Parameter mit einander
	 * 
	 * @param blatt1 > Objekt vom Typ Blatt
	 * @param blatt2 > Objekt vom Typ Blatt
	 * @return int > Vergleich-Ergebniss
	 * <br>
	 *		>1 = Blatt1 größer
	 * <br>
	 *		0  = gleich groß
	 * <br>
	 *		<1 = Blatt2 größer
	 *
	 */
	public int compare(Blatt blatt1, Blatt blatt2) {

		int[] b1Valence = blatt1.getValance();
		int b1HighestValue = blatt1.getValueOutsidePair(b1Valence[1]);
		int b1ValueTotal = blatt1.getDeckValue();
		
		int[] b2Valence = blatt2.getValance();
		int b2HighestValue = blatt2.getValueOutsidePair(b2Valence[1]);
		int b2ValueTotal = blatt2.getDeckValue();
		
		// Valance check
		if(b1Valence[0] != b2Valence[0]) {
			return b1Valence[0]-b2Valence[0];
		} else {
			if(b1Valence[1] != b2Valence[1]) {
				return b1Valence[1]-b2Valence[1]; 
			} 
			else if(b1Valence[0] == 2){
				return b1HighestValue-b2HighestValue; 
			}
			else if(b1Valence[1] == 0) {
				return b1ValueTotal-b2ValueTotal;
			}
		}
	
		return 0;

	}
	
}
