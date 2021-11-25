package ub8Better;

import java.util.Locale;

public class AXhochN implements Funktion{

	private double a;
	private double n;
	
	private AXhochN(double a, double n) {
		this.a = a;
		this.n = n;
	}
	
	public static Funktion get(double a, double n) {
		if(a==0) {
			return Null.get();
		}
		return new AXhochN(a, n);
	}
	@Override
	public double getY(double d) {
		return this.a*Math.pow(d, this.n);
	}

	@Override
	public Funktion getAbleitung() {
		double alb_a = this.a*Math.abs(this.n);
		double alb_n = this.n-1;
		if(alb_a == 0) {
			return Null.get();
		}
		return new AXhochN(alb_a, alb_n);
	}

	@Override
	public String toString() {
		if(this.a == 0) {
			return Null.get().toString();
		}
		if(this.n == 1) {
			return String.format(Locale.US, "%1.1fx", this.a*this.n);
		}
		if(this.n == 0) {
			return String.format(Locale.US, "%1.1f", this.a*1);
		}
		return String.format(Locale.US, "%1.1fx^%1.1f", this.a, this.n);
	}
}
