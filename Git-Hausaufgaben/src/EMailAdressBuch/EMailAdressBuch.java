package EMailAdressBuch;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Klasse zum verwalten von einem Email-Adressbuch
 * 
 * @author Justin, Jonas, Jan
 * @version 1.0.0
 *
 */
public class EMailAdressBuch {

	HashMap<String, String> adresseBuch = new HashMap<String, String>();

	// ## CONSTRUCTORS
	/**
	 * Konstruktor: Erstellt ein leeres Email Adressbuch
	 */
	public EMailAdressBuch() {
		
	}

	// ## METHODS
	/**
	 * Fuegt in das (this) AdresseBuch mit den angegebenen Parameter einen neuen Eintrag hinzu
	 * 
	 * @param name > String
	 * @param email > String
	 */
	public void einfuegen(String name, String email) {
		if (!email.isEmpty() && !name.isEmpty()) {
			adresseBuch.put(name, email);
		}
	}
	/**
	 * Gibt die Email des angegebenen Parameter im (this) AdresseBuch zurueck 
	 * 
	 * @param key > String
	 * @return String > Die Email des Namen
	 * @throws EMailAdressBuch.UnknownNameException > Name existiert nicht in Adressebuch
	 */
	public String abfrage(String key) throws EMailAdressBuch.UnknownNameException {
		if (!adresseBuch.containsKey(key)) {
			throw new UnknownNameException("Der Key 'Name' ist nicht im Adresse-Buch vorhanden");
		}
		return adresseBuch.get(key);
	}
	/**
	 * Ersetzt die Standart toString() Methode <br>
	 * Format: {Name=email}
	 * 
	 * @return String > EMailAdressBuch
	 */
	public String toString() {
		String result = "{";

		for (String i : adresseBuch.keySet()) {
			result += i + "=" + adresseBuch.get(i) + ", ";
		}
		result += "}";
		return result;
	}
	/**
	 * Liest den angebenen Parameter als Datei ein und fuegt alle Eintraege im Format zum (this) Adressbuch hinzu
	 * <br> Format: name;email
	 * 
	 * @param dateiname > String
	 * @throws FileNotFoundException > Datei konnte nicht eingelesen werden
	 */
	public void einlesen(String dateiname) {
		try {
			// create file and scanner object
			File myfile = new File(dateiname);
			Scanner sc = new Scanner(myfile);
			
			String content_array[] = new String[2];
			//read file
			while(sc.hasNextLine()) {
				String data = sc.nextLine();
				// slit data which has Format "name,email" at ,
				content_array = data.split(";");
				
				// put content in Hashmap
				adresseBuch.put(content_array[0], content_array[1]);
			}
			sc.close();
		}catch(FileNotFoundException e) {
			System.out.println("Ein Fehler ist aufgetreten: "+ e);
		}
	}

	// ## CUSTOM EXCEPTION
	public class UnknownNameException extends Exception {

		public UnknownNameException(String message) {
			super(message);
		}
	}

}
