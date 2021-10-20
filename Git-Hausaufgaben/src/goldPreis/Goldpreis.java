import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Klasse zum Verwalten von Goldpreisen <br>
 * Erschafft eine ArrayListe, die Goldpreise an verschiedenen Tagen beinhaltet
 * 
 * @version 1.0.0
 * @author Justin, Jonas, Jan
 */
public class Goldpreis {
	
	// ### variables
	private ArrayList<Goldtagespreis> List = new ArrayList<>();
	
	// ### constructors
	/**
	 *  Konstruktor: Erstellt ein neues Objekt mit dem angegebenen Parameter als Datei
	 *  
	 * @param dateiname > String
	 */
	public Goldpreis(String dateiname) {
		String[] arr;
		double preis = 0;
		try{
			File file = new File(dateiname);
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				arr = sc.nextLine().split("\t");
				try {
					preis = Double.parseDouble(arr[1].substring(0, 2) + arr[1].substring(3, arr[1].length() - 3));
					//System.out.println(preis);
				} catch (NumberFormatException nfe) {
					preis = -1.0;
				}
				Goldtagespreis gtp = new Goldtagespreis(arr[0], preis);
				List.add(gtp);
				preis = 0;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden");
		}
	}
	
	// ### methods
	/**
	 * Gibt den passenden Preis zum angebenen Parameter Datum zurueck <br>
	 * Datum Format: "y-d-m", "2009-02-07"
	 * 
	 * @param datum > String
	 * @return String 
	 * @throws NumberFormatException > Die Liste enthält nicht das Datum, falsches Format Datum
	 */
	public String getPreis(String datum) {
		for (int i = 0; i < List.size(); i++) {
			if (List.get(i).datum.equals(datum)) {
				return "" + List.get(i).preis;
			}
		}
		throw new NumberFormatException("Der angegebene Tag ist nicht in der Liste aufgeführt");
	}
	/**
	 * Gibt den Tag aus an denen das Gold, vom (this) Objekt am teuersten/billigsten war
	 */
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
		System.out.print(" |");
		System.out.println();
		System.out.println("Den höchsten Goldpreis von " + max.preis + " gab es an folgenden Tagen:");
		for (int i = 0; i < maxlist.size(); i++) {
			System.out.print("| " + maxlist.get(i).datum);
		}
		System.out.print(" |");
		System.out.println();

	}
}
