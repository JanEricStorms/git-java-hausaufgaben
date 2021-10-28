package uebung4jan;

import java.util.Locale;

public class BenutzerFormat implements BruchFormat {

	private String format;
	double bruch;

	public BenutzerFormat(String format) {
		this.format = format;
	}

	public BenutzerFormat(String format, Locale land) {
		this.format = format;
		Locale.setDefault(land);
	}

	public String bruchToString(int zaehler, int nenner) {
		String erg;
		bruch = (double) zaehler / nenner;
		erg = String.format(this.format, bruch);

		return erg;
	}

}
