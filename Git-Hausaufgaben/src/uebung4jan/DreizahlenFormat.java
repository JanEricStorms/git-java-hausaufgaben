package uebung4jan;

public class DreizahlenFormat implements BruchFormat {

	public String bruchToString(int zaehler, int nenner) {
		String erg;
		String maxs;
		String format;
		String bruchstrich = "";
		int max;
		if (zaehler > nenner) {
			maxs = zaehler + "";
		} else {
			maxs = nenner + "";
		}
		max = maxs.length();
		for (int i = 0; i < max; i++) {
			bruchstrich = bruchstrich + "-";
		}
		format = "%" + max + "s";
		erg = String.format(format, zaehler) + "\n" + String.format(format, bruchstrich) + "\n"
				+ String.format(format, nenner);
		return erg;
	}

}
