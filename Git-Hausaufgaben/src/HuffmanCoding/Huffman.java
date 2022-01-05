package HuffmanCoding;
/**
 * Die Klasse beinhaltet die Dekodier Funktion
 * @author Justin, Jan
 * @version 1.0.0
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Huffman {

    /**
     * Die Funtion wertet zuerst die Text-Datei aus. <br>
     * Dazu wird ein Scanner auf die Datei angewendet. <br>
     * Die erste Zeile ist der verschluesellte Code der zwischen gespeichert wird. <br>
     * Danach wird eine HashMap befüllt und dem Schluesell aus der Dekodier-Tabelle der passende Buchstabe zugewiesen. <br>
     * Zuletzt wird der Verschluesselte Code schritt fuer schritt aufgeschluesselt. <br>
     *
     *
     * @param f > Die Text-Datei die den Huffmann Code und die Dekodier-Tabelle beinhaltet
     * @return String > Gibt den Entschluesseltet Text zurueck
     */
    public static String decode(File f){
        try {
            Scanner check = new Scanner(f);
            int line =0;
            for(int i = 1;check.hasNextLine();i++){
                check.nextLine();
                line = i;
            }
            if(line != 28){
                throw new IllegalArgumentException("Die Datei entspricht nicht dem Vorrausgesetztem Format von 28 Zeilen laenge. " + line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder erg = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        String space;
        Map keys = new HashMap();
        try(Scanner sc = new Scanner(f)){
            String codedText = sc.nextLine();
            sb.append(codedText);
            for(int i = 0;i<26;i++){
                space = sc.nextLine();
                if(!space.equals("")) {
                    keys.put(space, (char) (65 + i));
                }
            }
            keys.put(sc.nextLine(), (char) 32);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String key = "";
        for(int i = 0;sb.length() >1;i++){
            key = key + sb.charAt(i);
            if(keys.containsKey(key)){
                sb.delete(0,i);
                erg.append(keys.get(key));
                key = "";
                i = 0;
            }
        }


        return erg.toString();
    }

}
