package GefangenenDilemma;

public class Main {
	public static void main(String[] args) {
		GefangenenDilemma gd = new GefangenenDilemma(new Pavlov(), new Random());

		gd.spiele(100);
	}
}
