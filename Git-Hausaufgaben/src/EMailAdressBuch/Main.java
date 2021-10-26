
public class Main {

	public static void main(String[] args) throws EMailAdressBuch.UnknownNameException {
		
		EMailAdressBuch buch = new EMailAdressBuch();
		EMailAdressBuch buch2 = new EMailAdressBuch();
		
		buch.einfuegen("Justin", "j02.jans31en@icloud.com");
		buch.einfuegen("Justin", "j02.jansen@icloud.com");
		buch.einfuegen("Jonas", "jonas.gerschau@gmail.com");
		buch.einfuegen("Justin", "");
		
		buch2.einlesen("mitarbeiter_matse_extern.txt");
		buch2.einlesen("mitarbeiter_matse_intern.txt");
		System.out.println(buch.abfrage("Justin"));
		
		System.out.println(buch);
		System.out.println(buch2);
		
	}

}
