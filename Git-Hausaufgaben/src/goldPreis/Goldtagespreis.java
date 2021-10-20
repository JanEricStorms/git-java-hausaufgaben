package goldPreis;

public class Goldtagespreis {
	public String datum;
	public double preis;

	public Goldtagespreis(String datum, double preis) {
		this.datum = datum;
		this.preis = preis;
	}

	public String toString() {
		String erg = this.datum + "\t" + this.preis;

		return erg;
	}
}
