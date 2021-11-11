package uebung6jan;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class NewArrayList extends ArrayList<Object> {

//	private NewArrayList arrl = new NewArrayList();

	public void add(String x) {
		super.add(testConvert(x));
	}

	public void add(int x) {
		Integer X = Integer.valueOf(x);
		super.add(X);
	}

	public void add(double x) {
		Double X = Double.valueOf(x);
		super.add(X);
	}

	private Object testConvert(String x) {
		Object X;
		Scanner sc = new Scanner(x);
		sc.useLocale(Locale.US);
		if (sc.hasNextInt()) {
			X = Integer.valueOf(Integer.parseInt(x));
		} else if (sc.hasNextDouble()) {
			X = Double.valueOf(Double.parseDouble(x));
		} else {
			X = x;

		}
		sc.close();
		return X;

	}

	public ArrayList<Integer> getIntegers() {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < super.size(); i++) {
			if (super.get(i) instanceof Integer) {
				arr.add((Integer) super.get(i));
			}
		}
		return arr;
	}

	public ArrayList<Double> getDoubles() {
		ArrayList<Double> arr = new ArrayList<>();
		for (int i = 0; i < super.size(); i++) {
			if (super.get(i) instanceof Double) {
				arr.add((Double) super.get(i));
			}
		}
		return arr;
	}

	public ArrayList<String> getStrings() throws WrongElementException {
		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < super.size(); i++) {
			if (super.get(i) instanceof Double || super.get(i) instanceof Integer || super.get(i) instanceof String) {

				arr.add((String) super.get(i).toString());

			} else {
				throw new WrongElementException(i);
			}
		}
		return arr;
	}

}
