package uebungen03jan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
//		Index index = new Index();
		Index index2 = new Index();
//		index.wortHinzufuegen("boolean", 1);
//		index.wortHinzufuegen("boolean", 15);
//		index.wortHinzufuegen("boolean", 3);
//		index.wortHinzufuegen("boolean", 15);
//		
//		index.wortHinzufuegen("if", 45);
//		index.wortHinzufuegen("if", 2);
//		index.wortHinzufuegen("if", 10);
//		index.wortHinzufuegen("if", 45);
//		
//		System.out.println("index");
//		System.out.println(index);
//		
//		ArrayList<Integer> seiten = index.getAlleFundstellen("boolean");
//		System.out.println("seiten = " + seiten);
//		int ersteStelle = index.getErsteFundstelle("if");
//		System.out.println("ersteStelle = " + ersteStelle);
//		System.out.println();
		
		einlesen("zauberlehrling.txt", index2);
		System.out.println(index2);
	}
	
	public static void einlesen(String dateiname, Index index) throws FileNotFoundException {
		File file = new File(dateiname);
		Scanner sc = new Scanner(file);
		String[] work;
		int zeile = 0;
		while(sc.hasNextLine()) {
			zeile++;
			work = sc.nextLine().split(" ");
			if(work.length>1) {
				for(int i = 0;i<work.length;i++) {
					if(work[i].length() >3 || (work[i].charAt(0) >=65 && work[i].charAt(0) <=90)) {
						index.wortHinzufuegen(work[i], zeile);
					}
				}
			}
		}
	}

}
