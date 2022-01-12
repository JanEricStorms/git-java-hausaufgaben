package Zahlensysteme;
/**
 * Test Class for PositiveNumber
 * Test Klasse fuer PositiveNumber
 *
 * @author Justin, Jan
 * @version 1.0.0
 *
 */
public class Main {

    public static void main(String[] args) {
        PositiveNumber zs = new PositiveNumber();
        zs.setDecimal("144");
        System.out.println("Binaer: " + zs.getBinary());
        zs.setHexadecimal("affe");
        System.out.println("Dezimal: " + zs.getDecimal());
        zs.setBinary("1000101011");
        System.out.println("Hexadezimal: " + zs.getHexadecimal());

    }


}
