package uebung5jan;

public class Sekantenverfahren implements Verfahren {

	@Override
	public double getNullstelle(Funktion f, double xMin, double xMax) {
		double x1 = xMin;
		double x2 = xMax;
		double xm = ((x1 * f.getY(x2)) - (x2 * f.getY(x1))) / (f.getY(x2) - f.getY(x1));
		double zhmz = Math.pow(10, -10);
		while (x2 - x1 > zhmz) {
			if (Math.abs(f.getY(xm)) < zhmz) {
				return xm;
			}
			if (f.getY(x1) * f.getY(xm) < 0) {
				x2 = xm;
			}
			if (f.getY(x2) * f.getY(xm) < 0) {
				x1 = xm;
			}
			xm = ((x1 * f.getY(x2)) - (x2 * f.getY(x1))) / (f.getY(x2) - f.getY(x1));
		}

		return xm;
	}

}
