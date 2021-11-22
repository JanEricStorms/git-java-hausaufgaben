package schiebePuzzle;

import java.util.concurrent.ThreadLocalRandom;

public class SchiebAlg1 implements Loesungsalgorithmus{

	@Override
	public void loesen(Schiebepuzzle puzzle) {
		try {
			int[] arr = new int[] {0,0};
		while(puzzle.getPosition(1) != arr) {
			int target;
			try {
				target = ThreadLocalRandom.current().nextInt(1, 15+1);
				puzzle.schiebe(target);
				System.out.println(puzzle);
			}catch(WrongMoveException e) {
			}
		}
		}catch (NullPointerException e) {
			System.out.println("FAIL");
		}
	}

}
