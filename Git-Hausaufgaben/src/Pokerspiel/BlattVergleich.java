package Pokerspiel;

import java.util.Arrays;
import java.util.Comparator;

public class BlattVergleich implements Comparator<Blatt> {

	public int compare(Blatt blatt1, Blatt blatt2) {

		Integer[] b1Valence = blatt1.getValance();
		Integer b1HighestValue = blatt1.getValueOutsidePair(b1Valence[1]);
		Integer b1ValueTotal = blatt1.getDeckValue();
		
		Integer[] b2Valence = blatt2.getValance();
		Integer b2HighestValue = blatt2.getValueOutsidePair(b2Valence[1]);
		Integer b2ValueTotal = blatt2.getDeckValue();
		
		// Valance check
		if(b1Valence[0] != b2Valence[0]) {
			return b1Valence[0]-b2Valence[0]; // greater then 0 = blatt1 gewinnt, less then  = blatt2 gewinnt
		} else {
			// same valance
			// check if some valance value is higher
			if(b1Valence[1] != b2Valence[1]) {
				return b1Valence[1]-b2Valence[1]; // greater then 0 = blatt1 gewinnt, less then 0 = blatt2 gewinnt
			} 
			else if(b1Valence[0] == 2){
				return b1HighestValue-b2HighestValue; // greater then 0 = blatt1 gewinnt, less then 0 = blatt2 gewinnt
			}
			else if(b1Valence[1] == 0) {
				return b1ValueTotal-b2ValueTotal;
			}
		}
	
		return 0; // Draw, no winner

	}
	
}
