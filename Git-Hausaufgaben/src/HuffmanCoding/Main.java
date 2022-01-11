package HuffmanCoding;
/**
 * Die Klasse dient dem Start des Programms
 * @author Justin, Jan
 * @version 1.0.0
 */

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File f = new File("src/HuffmanCoding/message.txt");
        String ergebnis = Huffman.decode(f);
        System.out.println("Der Entschluesselte Text ist: " + ergebnis);
    }
}
