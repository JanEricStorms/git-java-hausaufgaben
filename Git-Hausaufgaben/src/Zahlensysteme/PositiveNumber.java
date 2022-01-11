package Zahlensysteme;

public class PositiveNumber {

    private int value;



    public void setDecimal(String s){
        int a = Integer.parseInt(s);
        valueInBounds(a);
    }

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
             }
            hd.deleteCharAt(hd.length()-1);
        }
        valueInBounds(erg);
    }

    public void setBinary(String s){
        int erg = 0;
        StringBuilder bin = new StringBuilder(s);
        int length = bin.length();
        for(int i = 0;i<length;i++){
            erg = erg + Integer.parseInt(""+bin.charAt(bin.length()-1))*(int)Math.pow(2,i);
            bin.deleteCharAt(bin.length()-1);
        }
        valueInBounds(erg);
    }

    public String getDecimal(){
        return ""+value;
    }

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

    private void valueInBounds(int a){
        if(a>=0 && a<=Integer.MAX_VALUE){
            this.value = a;
        }else{
            throw new ArithmeticException("There are only values between 0 and " + Integer.MAX_VALUE +" allowed. Here value = " + a);
        }
    }

}
