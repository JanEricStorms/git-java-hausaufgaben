package uebung11jan;

public class IEEE {

    final static int BIAS = 127;

    public static float fromIEEEToFloat(String eingabe){
        String[] einArr = eingabe.split("/");
        float erg = 0;
        double exp = 0;
        float mantisse;
        int vorzeichen;
        if(Integer.parseInt(einArr[0]) == 0){
            vorzeichen = 1;
        }else{
            vorzeichen = -1;
        }
        int length = einArr[1].length();
        for(int i = 0; i<length;i++) {
            if (Integer.parseInt(String.valueOf(einArr[1].charAt(i))) == 1) {
                exp = exp + Math.pow(2, (length - Integer.parseInt(String.valueOf(einArr[1].charAt(i)))));
                System.out.println(Math.pow(2, (length - Integer.parseInt(String.valueOf(einArr[1].charAt(i))))));

            }
        }
        exp = exp - BIAS;
        mantisse = Float.parseFloat("1." + einArr[2]);
        erg = (float) (mantisse* Math.pow(2,exp));
        erg = erg * vorzeichen;
        return erg;
    }

    public static String fromFloatToIEEE(float eingabe){
        return "";
    }
}
