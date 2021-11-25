package uebung8jan;

public class AXhochN implements Funktion {

	private double[] darr = new double[2];

	public AXhochN(double a, double n) {

		darr[0] = a;
		darr[1] = n;
	}

	@Override
	public double getY(double d) {

		return this.darr[0] * Math.pow(d, this.darr[1]);
	}

	@Override
	public Funktion getAbleitung() {
		this.darr[0] = this.darr[0] * this.darr[1];
		this.darr[1] = this.darr[1] - 1;

		return this;
	}

	public String toString() {
		return this.darr[0] + "x^" + this.darr[1];
	}
}
