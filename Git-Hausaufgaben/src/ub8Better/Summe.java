package ub8Better;

public class Summe implements Funktion {

	private Funktion f1;
	private Funktion f2;

	private Summe(Funktion f1, Funktion f2) {
		this.f1 = f1;
		this.f2 = f2;
	}

	public static Funktion get(Funktion f1, Funktion f2) {
		if(f1 instanceof Null) {
			return f2;
		}
		if(f2 instanceof Null) {
			return f1;
		}
		return new Summe(f1, f2);
	}

	@Override
	public double getY(double d) {
		return this.f1.getY(d) + this.f2.getY(d);
	}

	@Override
	public Funktion getAbleitung() {
		Summe ablF = new Summe(f1.getAbleitung(), f2.getAbleitung());
		return ablF;
	}

	public String toString() {
		if(f1 instanceof Null && f2 instanceof Null) {
			return Null.get().toString();
		}
		return f1.toString() + "+" + f2.toString();
	}

}
