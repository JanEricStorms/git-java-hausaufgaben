package Pokerspiel;

import java.util.Arrays;
/**
 * Klasse Blatt zum Verwalten eines Blatt bestehend aus drei Karten
 * 
 * @author Justin, Jonas, Jan
 * @version 1.1.0
 */
public class Blatt {

	private int[] blatt = new int[3];
	/**
	 * Konstruktor: Erstellt ein neues (this) Objekt mit den angebenen Parameter
	 * 
	 * @param cards > int[]
	 * @throws NumberFormatException > Array muss 3 Werte enthalten
	 */
	public Blatt(int[] cards) {
		if (cards.length != blatt.length) {
			throw new NumberFormatException("Der Array muss 3 Werte enthalten");
		}
		this.blatt = cards.clone();
	}
	/**
	 * Gibt das Blatt des (this) Objekt im String-Format zurueck <br>
	 * Format: 1, 2, 3
	 * 
	 * @return String > Blatt als String-Format
	 */
	public String toString() {
		
		String result = "";
		for(int i = 0; i<this.blatt.length; i++) {
			if(i == this.blatt.length-1) {
				result +=  this.blatt[i];
			}else {
				result +=  this.blatt[i]+", ";
			}
		}
		return result;
	}
	/**
	 * Gibt das Integer-Feld vom (this) Objekt zurueck
	 * 
	 * @return int[] > Blatt
	 */
	public int[] getValues() {
		return this.blatt;
	}
	
	/**
	 * Gibt die Summe der Werte vom Blatt des (this) Objekt zurueck
	 * 
	 * @return int > Summe
	 */
	public int getDeckValue() {

		int deckValue = 0;
		for (int i = 0; i < this.blatt.length; i++) {
			deckValue += this.blatt[i];
		}
		return deckValue;
	}
	/**
	 * Gibt das Paar und den Wert des Paares vom (this) Object zurueck <br>
	 * Format: [Paar,PaarSumme]
	 * 
	 * @return int[] > Paar
	 */
	public int[] getValance() {

		int deckValence = 0;
		int valanceValue = 0;
		int count = 0;
		boolean checked[] = new boolean[this.blatt.length];
		Arrays.fill(checked, false);
		Integer[] arrayCounted = new Integer[this.blatt.length];
		Arrays.fill(arrayCounted, 0);
		
		for (int i = 0; i < this.blatt.length; i++) {

			if (checked[i] == true) {
				continue;
			}

			count = 1;
			for (int z = i + 1; z < this.blatt.length; z++) {
				if (this.blatt[i] == this.blatt[z]) {
					checked[z] = true;
					count++;
				}
				if(z == this.blatt.length-1) {
					if(valanceValue < count*this.blatt[i] && count!=1) {
						valanceValue = count*this.blatt[i];
					}
				}
			}
			arrayCounted[i] = count;
			
			if(arrayCounted[i] >= count) {
				deckValence = arrayCounted[i];
			}
		}
		
		int[] result = {deckValence, valanceValue};
		return result;
	}
	/**
	 * Gibt den Wert der alleinstehende Karte vom (this) Objekt zurueck mit dem angebenen Parameter
	 * 
	 * @param int > ValanceValue (Summe des Paares)
	 * @return int > alleinstehende Karte
	 */
	public int getValueOutsidePair(int ValanceValue) {

		int sumArray = 0;
		
		for (int i = 0; i < this.blatt.length; i++) {
			sumArray += this.blatt[i];
		}
		return sumArray-ValanceValue;
	}
}
