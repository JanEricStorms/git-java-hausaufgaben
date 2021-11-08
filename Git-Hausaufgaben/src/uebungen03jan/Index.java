package uebungen03jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Index {
	private HashMap<String, String> index;
	
	public Index() {
		index = new HashMap<>();
	}
	
	public void wortHinzufuegen(String begriff, int seitenzahl){
		boolean bool = true;
		String[] work;
		String szahl = seitenzahl + "";
		if(this.index.containsKey(begriff)) {
			work = this.index.get(begriff).split(", ");
			for(int i = 0;i<work.length;i++) {
				if(work[i].equals(szahl)) {
					bool = false;
				}
				
			}
			if(bool) {
				this.index.put(begriff,this.index.get(begriff) + ", " + seitenzahl);
			}
		}else {
			this.index.put(begriff, "" +seitenzahl);
		}
	}
	
	public ArrayList<Integer> getAlleFundstellen(String wort){
		ArrayList<Integer> arr = new ArrayList<>();
		if(this.index.containsKey(wort)) {
			String[] work = this.index.get(wort).split(", ");
			for(int i = 0;i<work.length;i++) {
				arr.add(Integer.parseInt(work[i]));
			}
		}
		
		return arr;
	}
	public int getErsteFundstelle(String wort) {
		int seite;
		int min;
		int index = 0;
		String[] work;
		if(this.index.containsKey(wort)) {
			work = this.index.get(wort).split(", ");
			min = Integer.parseInt(work[0]);
			for(int i = 0;i<work.length;i++) {
				if(min>Integer.parseInt(work[i])) {
					min = Integer.parseInt(work[i]);
					index = i;
				}
			}
			seite = Integer.parseInt(work[index]);
		}else {
			seite = -1;
		}
		
		return seite;
	}
	public String toString() {
		String erg = "";
		Set<String> key = this.index.keySet();
		Object[] arr = key.toArray();
		for(int i = 0;i<arr.length;i++) {
			erg = erg + arr[i] + ": [" + this.index.get(arr[i]) + "] \n";
		}
		erg = erg + "";
		
		return erg;
	}
}
