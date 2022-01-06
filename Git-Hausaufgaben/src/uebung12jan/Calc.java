package uebung12jan;

import java.nio.BufferOverflowException;

public class Calc {

    public static Tuple<Double, Integer> getMax(double[] arr){
        double value = arr[0];
        int index = 0;
        for(int i = 0;i<arr.length;i++){
            if(value<arr[i]){
                value = arr[i];
                index = i;
            }
        }
        return new Tuple<>(value, index);
    }

    public static int calcFibonacciNuber(int n) {
        if(n>0) {
            Pair zz = new Pair<>(1, 0);
            for (int i = 1; i < n; i++) {
                int n1 = (int) zz.get1();
                int n2 = (int) zz.get2();
                    zz.set1(n1 + n2);
                    zz.set2(n1);
//                    if((int) zz.get1() < (int) zz.get2()){
//                        throw new ArithmeticException(" Speicher Ueberlauf. Letzte moegliche Zahl: " + zz.get2() + " fuer n = " + i);
//                    }
            }
            return (int) zz.get1();
        }else{
            throw new IllegalArgumentException("Fuer n sind nur Werte >0 erlaubt. Hier: " + n );
        }

    }

}
