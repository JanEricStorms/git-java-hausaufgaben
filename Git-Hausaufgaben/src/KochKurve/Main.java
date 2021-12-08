package KochKurve;
/**
 * Die Klasse beinhaltet die Rekursive Koch Funktion sowie die Ausgabe
 * @author Justin, Jan
 * @version 1.0.0
 */
public class Main {
    /**
     * Main Methode der Funktion zum Aufrufen der kochKurve
     * @param args
     */
    public static void main(String[] args) {
        //Ruft eine Hilfsmethode auf, die fuer die Ausgabe Zustaendig ist
        for(int i = 0; i<3;i++){
            rekAufruf(i);
        }
    }

    /**
     * Die Funktion berechnen aus den 2 gegebenen Punkten A (ax | ay) und B (bx | by)
     * jeweils 3 neue Punkte und ruft sich selber wieder damit auf bis die Rekursionstiefe = 0 ist.
     *
     * @param ax > Die X-Koordinate des start Punktes der Geraden
     * @param ay > Die Y-Koordinate des start Punktes der Geraden
     * @param bx > Die X-Koordinate des end Punktes der Geraden
     * @param by > Die Y-Koordinate des end Punktes der Geraden
     * @param rek > Gibt die Anzahl der Rekursiven durchlaeufe an
     */
    public static void kochKurve(double ax, double ay, double bx, double by, int rek){
        if(rek == 0){
            System.out.print(" (" + String.format("%.1f", ax) + "|" + String.format("%.1f",ay) + ") ");
        }else{
            //Berechnen des "Vektors" von Punkt a zu Punkt b
            double x = bx-ax;
            double y = by-ay;
            //Berechnen der 3 weiteren Koordinaten der Teilgeraden
            double dx = ax + x/3.;
            double dy = ay + y/3.;
            double ex = 0.5 * ((ax+bx) + Math.sqrt(3)*(ay-by)/6);
            double ey =500- ((0.5 * (ay+by) + Math.sqrt(3) * (bx-ax)/6)-500);
            double fx = ax + 2*x/3.;
            double fy = ay + 2*y/3.;

            //Rekursiver aufruf
            kochKurve(ax,ay,dx,dy,rek-1);
            kochKurve(dx,dy,ex,ey,rek-1);
            kochKurve(ex,ey,fx,fy,rek-1);
            kochKurve(fx,fy,bx,by,rek-1);
        }

    }

    /**
     * Die Funktion dient der sauberen und formatierten Ausgabe
     *
     * @param i > Gibt die Rekursionstiefe an
     */
    public static void rekAufruf(int i){
        System.out.print("Rekursionstiefe "+ i + ": ");
        kochKurve(0,500,500,500,i);
        System.out.print("(" + 500 + "|" + 500 + ")");
        System.out.println(" \n");
    }


}


