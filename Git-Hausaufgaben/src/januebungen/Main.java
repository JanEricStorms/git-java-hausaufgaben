package januebungen;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		JavaCode jc = new JavaCode();
		// jc.ladeCode(new File("src/januebungen/KommentarTest.java"));
//		try {
//			jc.ladeCode(new URL("https://www.matse.itc.rwth-aachen.de/dienste/public/show_document.php?id=59769278"));
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			jc.ladeCode();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jc.schreibeCode(new File("output.dat"));
//		try {
//			jc.schreibeCode();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		jc.entferneKommentare();
		jc.schreibeCode(new File("output.dat"));
	}

}
