package uebung7jan;

import java.awt.Point;

public class RechteckTest {

	public static void main(String[] args) {
		Point p1 = new Point(10,10);
		Point p2 = new Point(60,50);
		
		Rechteck r = new Rechteck(p1, p2);
		System.out.println(r.toString());
		

	    // neues Grafikfenster mit einer Zeichenflaeche der
	    // angegebenen Breite und Hoehe oeffnen:
	    Grafik g = new Grafik(300, 300);
	    // => Der Koordinatenursprung liegt links oben!

	    g.add(r);           // die Linie in die Zeichenflaeche einfuegen
	    g.aktualisiere(0);  // die Zeichenflaeche sofort aktualisieren
	}
}
