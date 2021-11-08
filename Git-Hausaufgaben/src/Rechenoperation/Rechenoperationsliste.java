package Rechenoperation;
import java.util.ArrayList;

/**
 * Klasse Rechenoperationsliste zum Verwalten von Listen fuer Rechenoperationen
 * 
 * @author Justin, Jonas, Jan
 * @version 1.0.0
 *
 */
public class Rechenoperationsliste {
	
	ArrayList<Rechenoperation> list = new ArrayList<>();
	
	/**
	 * Konstruktor: Initializiert die Rechenoperationsliste
	 */
	public Rechenoperationsliste() {
		list.clear();
	}
	/**
	 * Fuegt zur Liste des (this) Objekt eine neue Rechenoperation hinzu
	 * 
	 * @param operation > Objekt Rechenoperation
	 */
	public void add(Rechenoperation operation) {
		list.add(operation);
	}
	/**
	 * Transformiert fuer jeden Wert des angegebenen Parameter die Rechenoperationne der (this) Liste 
	 * 
	 * @param feld > double[]
	 * @return double[] > Ergebnisse
	 */
	public double[] transform(double[] feld) {
		double[] result = feld.clone();
		for(int i = 0; i<result.length; i++) {
			for(int z = 0; z<list.size(); z++) {
				result[i] = list.get(z).berechne(result[i]);
			}
		}
		return result;
	}

}
