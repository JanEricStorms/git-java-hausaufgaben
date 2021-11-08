package uebung5jan;

public class Main {

	public static void main(String[] args) {
		int min = 0;
		int max = 10;
		Funktion fA = new FunktionA();
		Funktion fB = new FunktionB();
		Funktion fC = new FunktionC();
		Funktion fD = new FunktionD();
		Verfahren v1 = new Bisektionsverfahren();
		Verfahren v2 = new Sekantenverfahren();
		System.out.println(fA.toString());
		System.out.println(
				"  Nullstelle:		" + String.format("%.10f", v1.getNullstelle(fA, min, max)) + " (Bisektion)");
		System.out.println("  Nullstelle:		" + String.format("%.10f", v2.getNullstelle(fA, min, max))
				+ " (Sekantenverfahren)");
		System.out.println("__________________________________________________________________________________");
		System.out.println(fB.toString());
		System.out.println(
				"  Nullstelle:		" + String.format("%.10f", v1.getNullstelle(fB, min, max)) + " (Bisektion)");
		System.out.println("  Nullstelle:		" + String.format("%.10f", v2.getNullstelle(fB, min, max))
				+ " (Sekantenverfahren)");
		System.out.println("__________________________________________________________________________________");
		System.out.println(fC.toString());
		System.out.println(
				"  Nullstelle:		" + String.format("%.10f", v1.getNullstelle(fC, min, max)) + " (Bisektion)");
		System.out.println("  Nullstelle:		" + String.format("%.10f", v2.getNullstelle(fC, min, max))
				+ " (Sekantenverfahren)");
		System.out.println("__________________________________________________________________________________");
		System.out.println(fD.toString());
		System.out.println(
				"  Nullstelle:		" + String.format("%.10f", v1.getNullstelle(fD, min, max)) + " (Bisektion)");
		System.out.println("  Nullstelle:		" + String.format("%.10f", v2.getNullstelle(fD, min, max))
				+ " (Sekantenverfahren)");
		System.out.println("__________________________________________________________________________________");
	}

}
