package uebung4jan;

public class SchraegstrichFormat implements BruchFormat {

	public String bruchToString(int zaehler, int nenner) {
		String erg = zaehler + "/" + nenner;

		return erg;
	}

}
