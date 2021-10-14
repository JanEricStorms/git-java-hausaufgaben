package januebungen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class JavaCode {
	private ArrayList<String> list = new ArrayList<>();

//	public JavaCode(String dateiName) {
//		File f = new File(dateiName);
//		ladeCode(f);
//	}

	public JavaCode() {

	}

	public void ladeCode(File f) {
		try {
			Scanner sc = new Scanner(f);
			ladeCode(sc);
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void schreibeCode(File f) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			schreibeCode(pw);
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ladeCode(URL url) {
		try {
			URLConnection con = url.openConnection();
			Object content = con.getContent();
			Scanner sc = new Scanner((InputStream) content);
			ladeCode(sc);
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ladeCode() throws FileNotFoundException {
		File file = null;
		JFileChooser fc = new JFileChooser(new File(System.getProperty("user.dir")));
		int state = fc.showOpenDialog(null);
		if (state == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
		} else {
			throw new FileNotFoundException("Auswahl abgebrochen");
		}
		Scanner sc = new Scanner(file);
		ladeCode(sc);
		sc.close();
	}

	public void schreibeCode() throws FileNotFoundException {
		File file = null;
		JFileChooser fc = new JFileChooser(new File(System.getProperty("user.dir")));
		int state = fc.showOpenDialog(null);
		if (state == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
		} else {
			throw new FileNotFoundException("Auswahl abgebrochen");
		}
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			schreibeCode(pw);
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void entferneKommentare() {
		String work;
		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).contains("//") || this.list.get(i).contains("/*")) {
				work = this.list.get(i);
				if (work.contains("//")) {
					for (int j = 0; j < work.length(); j++) {
						if (work.charAt(j) == '/' && work.charAt(j + 1) == '/') {
							work.substring(0, j);

						}
					}
				} else if (work.contains("/*")) {
					if (work.contains("*/")) {
						this.list.remove(i);
					} else {
						for (int j = 1; true; j++) {
							if (i + j <= this.list.size()) {
								if (this.list.get(i + j).contains("*/")) {
									for (int l = i; l < (i + j); l++) {
										this.list.remove(l);
										System.out.println(l);
									}
									break;
								}
							}
						}
					}
				}
				this.list.set(i, work);
			}
		}
	}

	private void ladeCode(Scanner sc) {
		while (sc.hasNextLine()) {
			this.list.add(sc.nextLine());
		}

	}

	private void schreibeCode(PrintWriter pw) {
		for (int i = 0; i < this.list.size(); i++) {
			pw.println(this.list.get(i));
		}
	}
}
