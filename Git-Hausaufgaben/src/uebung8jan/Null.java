package uebung8jan;

public class Null implements Funktion {

	@Override
	public double getY(double d) {
		return 0;
	}

	@Override
	public Funktion getAbleitung() {
		return this;
	}

	public String toString() {
		String erg;

		return "0";
	}

}
