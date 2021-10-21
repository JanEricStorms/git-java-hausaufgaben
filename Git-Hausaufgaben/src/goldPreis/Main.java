package goldPreis;

public class Main {

	public static void main(String[] args) {
		
		Goldpreis test = new Goldpreis("gold.txt");
		
		System.out.println(test.getPreis("2009-10-20"));
		System.out.println(test.getPreis("2009-02-07"));
		test.printMinMax();
		
	}

}
