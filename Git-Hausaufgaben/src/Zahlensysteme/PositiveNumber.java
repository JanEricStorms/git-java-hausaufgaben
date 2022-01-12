package Zahlensysteme;
/**
 * Class PositiveNumber to convert Binary, Decimal and Hexadecimal numbers among themselves <br>
 * Klasse PositiveNumber um Binaer, Dezimal und Hexadezimal Zahlen untereinander zu konvertieren <br>
 *
 * @author Justin, Jan
 * @version 1.0.0
 *
 */
public class PositiveNumber {

    private int value;


    /**
     * Function converts decimal String to int <br>
     * @param s > Input String witch contains the decimal number
     */
    public void setDecimal(String s){
        try {
            int a = Integer.parseInt(s);
            valueInBounds(a);
        }catch (NumberFormatException e){
            throw new NumberFormatException("There are  only numbers allowed. Here: " + e.getMessage());
        }
    }
    /**
     * Function converts the hexadecimal number to decimal number (int) <br>
     * @param s > Input String witch contains the hexadecimal number
     */
    public void setHexadecimal(String s){
        StringBuilder hd = new StringBuilder(s);
        int erg = 0;
        int length = hd.length();
        for(int i = 0;i<length;i++){
             int ascii = (int) hd.charAt(hd.length()-1);
             if(ascii>=48 && ascii<=57){
                 erg = erg + Integer.parseInt(""+hd.charAt(hd.length()-1))*(int)Math.pow(16,i);
             }else if(ascii>=65 && ascii<=70){
                 erg = erg + (ascii-55)*(int)Math.pow(16,i);
             }else if(ascii>=97 && ascii<=102){
                 erg = erg + (ascii-87)*(int)Math.pow(16,i);
             }else{
                 throw new NumberFormatException("Provided value :" + "= " + hd.charAt(hd.length()-1) + " is not allowed. Only Values containing numbers from 0 to 9 and letters from A to F and a to f.");
             }
            hd.deleteCharAt(hd.length()-1);
        }
        valueInBounds(erg);
    }

    /**
     * Function converts the binary number to decimal number <br>
     * @param s > Input String witch contains the binary number
     */
    public void setBinary(String s){
        int erg = 0;
        StringBuilder bin = new StringBuilder(s);
        int length = bin.length();
        for(int i = 0;i<length;i++){
            try {
                int binary = Integer.parseInt("" + bin.charAt(bin.length() - 1));
                if(binary == 0 || binary == 1) {
                    erg = erg + binary * (int) Math.pow(2, i);
                    bin.deleteCharAt(bin.length() - 1);
                }else{
                    throw new NumberFormatException("There are only 0 and 1 as values allowed. Here: " + binary);
                }
            }catch (NumberFormatException e){
                throw new NumberFormatException("There are only 0 and 1 as values allowed. Here: " + bin.charAt(bin.length() - 1));
            }
        }
        valueInBounds(erg);
    }

    /**
     * Function returns the currently saved attribute as decimal String <br>
     * @return > currently saved attribute as decimal
     */
    public String getDecimal(){
        return ""+value;
    }

    /**
     * Function returns the currently saved attribute as hexadecimal String <br>
     * Function converts saved decimal attribute to hexadecimal before return <br>
     *
     * @return > currently saved attribute as hexadecimal
     */
    public String getHexadecimal(){
        StringBuilder erg = new StringBuilder();
        int rest;
        int value = this.value;
        while(value/16 != 0){
            rest = value%16;
            value = value/16;
            if(rest<=9) {
                erg.insert(0, rest);
            }else{
                switch(rest){
                    case 10:
                        erg.insert(0, "A");
                        break;
                    case 11:
                        erg.insert(0, "B");
                        break;
                    case 12:
                        erg.insert(0, "C");
                        break;
                    case 13:
                        erg.insert(0, "D");
                        break;
                    case 14:
                        erg.insert(0, "E");
                        break;
                    case 15:
                        erg.insert(0, "F");
                        break;
                }
            }
        }
        erg.insert(0,value);
        return erg.toString();
    }

    /**
     * Function returns the currently saved attribute as binary String <br>
     * Function converts saved decimal attribute to binary before return <br>
     *
     * @return > currently saved attribute as binary
     */
    public String getBinary(){
        StringBuilder erg = new StringBuilder();
        int rest;
        int value = this.value;
        while(value/2 != 0){
            rest = value%2;
            value = value/2;
            erg.insert(0,rest);
        }
        erg.insert(0,value);
        return erg.toString();
    }

    /**
     * Function checks if the converted value is between 0 and Integer.MAX_VALUE <br>
     * If value is ok --> value is saved in attribute <br>
     * else --> Exception thrown <br>
     *
     * @param a > Value provided by conversion functions [setBinary, setDecimal, setHexadecimal]
     */
    private void valueInBounds(int a){
        if(a>=0 && a<=Integer.MAX_VALUE){
            this.value = a;
        }else{
            throw new ArithmeticException("There are only values between 0 and " + Integer.MAX_VALUE +" allowed. Here value = " + a + ". Value might be corrupted");
        }
    }

}
