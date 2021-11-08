package uebung4jan;

import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bruch b1 = new Bruch(23, 3);

		b1.setFormat(new DoubleFormat());
		System.out.println(b1);

		b1.setFormat(new SchraegstrichFormat());
		System.out.println(b1);

		b1.setFormat(new BenutzerFormat("%.2f", Locale.US));
		System.out.println(b1);

		b1.setFormat(new DreizahlenFormat());
		System.out.println(b1);
	}

}
