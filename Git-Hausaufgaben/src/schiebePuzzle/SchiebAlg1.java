package schiebePuzzle;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class SchiebAlg1 implements Loesungsalgorithmus{

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
