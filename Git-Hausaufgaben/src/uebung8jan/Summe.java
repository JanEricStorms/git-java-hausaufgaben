package uebung8jan;

public class Summe implements Funktion {

	private Funktion[] darr = new Funktion[2];

	public Summe(Funktion f1, Funktion f2) {
		this.darr[0] = f1;
		this.darr[1] = f2;
	}

	@Override
	public double getY(double d) {
		double erg = this.darr[0].getY(d) + this.darr[1].getY(d);

		return erg;
	}

	@Override
	public Funktion getAbleitung() {
		this.darr[0] = this.darr[0].getAbleitung();
		this.darr[1] = this.darr[1].getAbleitung();

		return this;
	}

	public String toString() {
		return this.darr[0].toString() + "+" + this.darr[1].toString();
	}
}
