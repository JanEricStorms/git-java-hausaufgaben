package uebung6jan;

import java.util.Date;

public class TestNewArrayList {

	public static void main(String[] args) throws WrongElementException {
		NewArrayList arrl = new NewArrayList();

		arrl.add(15);
		arrl.add(20.0);
		arrl.add("Hallo");
		arrl.add(100 / 5.2);
		arrl.add(Math.PI);
		arrl.add(new Date());
		arrl.add("#");
		arrl.add("ERROR 404");
		arrl.add("Page not found");
		arrl.add("Wake me Up");
		arrl.add("Befor you Go Go");

		System.out.println(arrl.getIntegers().toString());
		System.out.println();
		System.out.println(arrl.getDoubles().toString());
		System.out.println();
		System.out.println(arrl.getStrings().toString());
	}

}
