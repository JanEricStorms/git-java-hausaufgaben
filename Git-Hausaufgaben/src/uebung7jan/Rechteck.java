package uebung7jan;

import java.awt.Point;

public class Rechteck extends Figur{
	
	private Point[] punkte;
	
	@Override
	public int getPunktCount() {
		// TODO Auto-generated method stub
		return this.punkte.length;
	}

	@Override
	public Point getPunkt(int i) {
		// TODO Auto-generated method stub
		return this.punkte[i];
	}
	
	public Rechteck(Point p1, Point p2) {
		double p1x = p1.getX();
		double p1y = p1.getY();
		double p2x = p2.getX();
		double p2y = p2.getY();
		Point p3 = new Point();
		p3.setLocation(p1x,p2y);
		Point p4 = new Point();
		p4.setLocation(p2x,p1y);
		
		
		this.punkte = new Point[] {p1,p3, p2, p4, p1};
	}
	
	public Rechteck(Rechteck r) {
		this.punkte = new Point[] {r.punkte[0], r.punkte[1]};
	}

	public void skaliere(double d) {
		
	}
	
	public Rechteck vereinige(Rechteck r) {
	return null;	
	}
	
	public String toString() {
		Point p1 = this.punkte[0];
		Point p2 = this.punkte[1];
		double p1x = p1.getX();
		double p1y = p1.getY();
		double p2x = p2.getX();
		double p2y = p2.getY();
		Point p3 = new Point();
		p3.setLocation(p1x,p2y);
		Point p4 = new Point();
		p4.setLocation(p2x,p1y);
		System.out.println("HUND");
		double value1 = Math.sqrt(Math.pow((p3.getX() - p1x),2) + Math.pow((p3.getY() - p1y),2));
		double value2 = Math.sqrt(Math.pow((p4.getX() - p1x),2) + Math.pow((p4.getY() - p1y),2));
		
		return "Rechteck: Hoehe = " + value1 + ", Breite = " + value2;
		
	}
	
	

}
