package klausurvorbereitungBlatt1;

public class Main {

    public static void main(String[] args) {
        String s1 = "funktion";
        String s2 = "funkiton";
        System.out.println(stimmenUeberein(s1,s2));
    }

    public static boolean stimmenUeberein(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        } else {
            if (s1.length() == s2.length()) {
                int count = 0;
                for (int i = 0; i < s1.length(); i++) {
                    if (count > 1) {
                        return false;
                    } else {
                        if (s1.charAt(i) != s2.charAt(i)) {
                            if (s1.charAt(i + 1) != s2.charAt(i) || s1.charAt(i) != s2.charAt(i + 1)) {
                                System.out.println("BUHU" );
                                return false;
                            }
                            count++;
                        }
                    }
                }
            } else {
                return false;
            }
            return false;
        }
    }
}

