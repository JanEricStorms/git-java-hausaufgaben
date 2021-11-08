package GefangenenDilemma;

public class DasSpiel {
	public static void main(String[] args) {
		GefangenenDilemma gd = new GefangenenDilemma(new Random(), new PerKind());

		gd.spiele(100);
	}
}
