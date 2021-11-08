package uebung4jan;

public class DoubleFormat implements BruchFormat {

	public String bruchToString(int zaehler, int nenner) {
		String erg;
		erg = "" + (double) zaehler / nenner;

		return erg;
	}

}
