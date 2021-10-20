package goldPreis;

/**
 * Klasse @Goldpreis. Erschafft eine ArrayListe, die Goldpreise an verschiedenen Tagen beinhaltet
 * 
 * @version 1.0.0
 * @author Justin, Jonas, Jan
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Goldpreis {
	/**
	 * Attribute der Klasse @Goldpreis
	 * 
	 * @List Ist eine ArrayListe, die @Goldtagespreis enthaelt
	 */
	private ArrayList<Goldtagespreis> List = new ArrayList<>();

	public Goldpreis(String dateiname) {
		String[] arr;
		double preis = 0;
		try {
			File file = new File(dateiname);
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				arr = sc.nextLine().split("\t");
				try {
					preis = Double.parseDouble(arr[1].substring(0, 2) + arr[1].substring(3, arr[1].length() - 3));
					System.out.println(preis + " -hallo");
				} catch (NumberFormatException nfe) {
					preis = -1.0;
				}
				Goldtagespreis gtp = new Goldtagespreis(arr[0], preis);
				List.add(gtp);
				preis = 0;
			}

		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden");
		}
	}

	public String getPreis(String datum) {
		for (int i = 0; i < List.size(); i++) {
			if (List.get(i).datum.equals(datum)) {
				return List.get(i).toString();
			}
		}
		throw new NumberFormatException("Der angegebene Tag ist nicht in der Liste aufgeführt");
	}

	public void printMinMax() {
		ArrayList<Goldtagespreis> minlist = new ArrayList<>();
		ArrayList<Goldtagespreis> maxlist = new ArrayList<>();

		Goldtagespreis min = List.get(0);
		Goldtagespreis max = List.get(0);
		Goldtagespreis aktuell;

		for (int i = 0; i < List.size(); i++) {
			aktuell = List.get(i);
			if (aktuell.preis < min.preis && aktuell.preis > -1) {
				min = aktuell;
			} else if (aktuell.preis > max.preis) {
				max = aktuell;
			}
		}
		minlist.add(min);
		maxlist.add(max);
		for (int i = 0; i < List.size(); i++) {
			if (List.get(i).preis == min.preis && List.get(i).datum != min.datum) {
				minlist.add(List.get(i));
			} else if (List.get(i).preis == max.preis && List.get(i).datum != max.datum) {
				maxlist.add(List.get(i));
			}
		}
		System.out.println("Den niedrigsten Goldpreis von " + min.preis + " gab es an folgenden Tagen:");
		for (int i = 0; i < minlist.size(); i++) {
			System.out.print("| " + minlist.get(i).datum);
		}
		System.out.print("|");
		System.out.println();
		System.out.println("Den höchsten Goldpreis von " + max.preis + " gab es an folgenden Tagen:");
		for (int i = 0; i < maxlist.size(); i++) {
			System.out.print("| " + maxlist.get(i).datum);
		}
		System.out.print("|");
		System.out.println();

	}
}
