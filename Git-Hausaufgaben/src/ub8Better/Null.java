package ub8Better;

public class Null implements Funktion{
	
	private static final Null N = new Null();
	
	private Null() {
		
	}
	
	public static Funktion get() {
		return N;
	}
	@Override
	public double getY(double d) {
		return 0;
	}

	@Override
	public Funktion getAbleitung() {
		return this;
	}
	public String toString() {
		return "0";
	}
}
