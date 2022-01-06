package uebung12jan;

public class Main {
    public static void main(String[] args) {
        Tuple ab = new Tuple<>(50,100);
        ab.set2(25);
        System.out.println(ab.get1());
        System.out.println(ab);
        Pair aa = new Pair<>(10,10);
        Pair bb = new Pair<>(5,10);
        System.out.println(aa.equals(bb));
        System.out.println(Calc.calcFibonacciNuber(10));;
    }
}
