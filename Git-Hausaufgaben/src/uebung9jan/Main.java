package uebung9jan;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
//		System.out.println(fakultaet(5));
//		System.out.println(fibonacci(20));
//		System.out.println(summe(15,20));
//		System.out.println(ggt(144,27));
//		System.out.println(getPascalWert(0, 0));
//		System.out.println(getPascalWert(4, 1));
//		System.out.println(getPascalWert(5, 0));
//		System.out.println(getPascalWert(5, 2));
//		rekursiveAusgabe(12345);
//		System.out.println(umkehren("Nie fragt sie: Ist gefegt? Sie ist gar fein"));
		geldautomat(5);
		System.out.println();
		System.out.println(geldautomat1(463));
	}

	public static long fakultaet(int n) {
		if(n == 0) {
			return 1;
		}else {
			long m = n * fakultaet(n-1);
			return m;
		}
	}
	
	public static long fibonacci(int n) {
		if(n==1||n==2) {
			return 1;
		}else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
	
	public static int summe(int anfang, int ende) {
		if(anfang>ende) {
			return 0;
		}else {
			return summe(anfang+1,ende)+anfang;
		}
	}
	
	public static int ggt(int a, int b) {
		if(a == b) {
			return a;
		}else if(a>b) {
			return ggt(a-b,b);
		}else {
			return ggt(a,b-a);
		}
	}
	
	public static int getPascalWert(int i, int j) {
		if(i == j || j == 0) {
			return 1;
		}else {
			return getPascalWert(i-1,j)+getPascalWert(i-1, j-1);
		}
	}
	
	public static void rekursiveAusgabe(int n) {
		if(n<=9) {
			System.out.println(n);
		}else {
			System.out.println(n%10);
			rekursiveAusgabe(n/10);
		}
	}
	//Hall -> ollaH 
	public static String umkehren(String s) {
		if(s.length() == 0) {
			return "";
		}else {
			return s.substring(s.length()-1,s.length()) + umkehren(s.substring(0,s.length()-1));
		}
	}
	
	public static void geldautomat(int betrag) {
		int[] scheine = {500,200,100,50,20,10,5};
		if(betrag>=5) {
			for(int i = 0;i<scheine.length;i++) {
				if(betrag>=scheine[i]) {
					System.out.print(scheine[i]+ "EUR |");
					geldautomat(betrag-scheine[i]);
					break;
				}
			}
		}
	}
	
	public static ArrayList<Integer> geldautomat1(int betrag) {
		int[] scheine = {500,200,100,50,20,10,5};
		if(betrag>=5) {
			for(int i = 0;i<scheine.length;i++) {
				if(betrag>=scheine[i]) {
					ArrayList<Integer> arr = geldautomat1(betrag-scheine[i]);
					arr.add(scheine[i]);
					return arr;
				}
			}
		}else {
			ArrayList<Integer> arr = new ArrayList<>();
			return arr;
		}
		return null;
	}
}
