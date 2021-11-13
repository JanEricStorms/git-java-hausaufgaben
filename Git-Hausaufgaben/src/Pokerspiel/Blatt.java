package Pokerspiel;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Blatt {

	private int[] blatt = new int[3];

	public Blatt(int[] cards) {
		// datenkapeslung
		if (cards.length > blatt.length) {
			throw new NumberFormatException("Der Array darf max. 3 Werte enthalten");
		}
		this.blatt = cards.clone();
	}

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

	public int[] getValues() {
		return this.blatt;
	}

	public Integer getDeckValue() {

		Integer deckValue = 0;
		for (int i = 0; i < this.blatt.length; i++) {
			deckValue += this.blatt[i];
		}
		return deckValue;
	}

	public Integer[] getValance() {

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
		
		Integer[] result = {deckValence, valanceValue};
		return result;
	}

	public Integer getValueOutsidePair(Integer ValanceValue) {

		Integer sumArray = 0;
		
		for (int i = 0; i < this.blatt.length; i++) {
			sumArray += this.blatt[i];
		}
		return sumArray-ValanceValue;
	}
}
