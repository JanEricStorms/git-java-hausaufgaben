package Zahlwoerter;
import java.text.DecimalFormat;
import java.util.stream.Stream;

/**
 * Class Zahlwort to translate numbers into words
 * 
 * @author Justin, Jan
 * @version 1.0.0
 *
 */
public class Zahlwort {

	// ### attributes 
	private final static String[] numTenNames = {"", "zehn", "zwanzig", "dreissig", "vierzig", "fuenfzig", "sechszig", "siebzig", "achtzig", "neunzig"};
	private final static String[] numNames = {"", "ein", "zwei", "drei", "vier", "fuenf", "sechs", "sieben", "acht", "neun", "zehn", "elf", "zwoelf", "dreizehn", "vierzehn", "fuenfzehn", "sechszehn", "siebzehn", "achtzehn", "neunzehn"};
	
	
	// ### methods
	/**
	 * Converts a given number into a word
	 * <br> [Range: 1-9999]
	 * 
	 * @param x = int number
	 * @return String = word
	 * @throws ArithmeticException = number out of range
	 */
	public static String getZahlwort(int x)
	{
		String finalThousand = "";
		String finalHundreds = "";
		
		if(x < 1 || x > 9999) {
			throw new ArithmeticException("Die Zahl liegt auﬂerhalb der Range [1-9999]");
		}
		String number = Integer.toString(x);
		String pattern = "0000";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		number = decimalFormat.format(x);

		int numberThousand = Integer.parseInt(number.substring(0, 1));
		int numberHundreds = Integer.parseInt(number.substring(1,number.length()));
		
		// translate thousands
		switch(numberThousand) {
			case 0:
				break;
			default:
				finalThousand = convertUpToThousand(numberThousand) + " tausend "; 
		}
		finalHundreds = convertUpToThousand(numberHundreds);
			
		return finalThousand + finalHundreds;
	}
	
	/**
	 * Converts an number into a word
	 * <br> [Range: 0-999]
	 * @param number
	 * @return
	 * @throws ArithmeticException = number out of range
	 */
	private static String convertUpToThousand(int number) {
		if(number < 0 || number > 999){
			throw new ArithmeticException("Die Zahl liegt auﬂerhalb der Range [0-999]");
		}
		String soFar = null;
	
	    if (number % 100 < 20){
	    	soFar = numNames[number % 100];
	    	if(number % 100 == 1) {
	    		soFar = numNames[number % 100] + "s";
	    	}
	    	number /= 100;
	    }
	    else {
	      soFar = numNames[number % 10];
	      number /= 10;
	      	
	      if(soFar != null && !soFar.isEmpty()) {
	    	  soFar = soFar + "und" + numTenNames[number % 10]; 
	      } else {
	    	  soFar = soFar + numTenNames[number % 10];  
	      }
	      number /= 10; 
	     
	    }
	    if (number == 0) return soFar;
	    return numNames[number] + " hundert " + soFar;	
	}
	
	/**
	 * Converts numbers from given parameter start to given parameter stop to an Stream of words
	 * <br> [!] both parameters are inclusive
	 * 
	 * @param start = int
	 * @param stop = int
	 * @return Stream<String> = all words
	 */
	public static Stream<String> getZahlStream(int start, int stop){
		
		return Stream.iterate(start, i -> i+1).limit(stop).map(i -> getZahlwort(i));
	}
	


}
