package schiebePuzzle;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Klasse zum Verwalten des Schiebepuzzels, bestehend aus einem 4x4 Feld
 * 
 * 
 * @author Justin, Jan
 * @version 1.0.0
 */

public class Schiebepuzzle {

	private Object[][] puzzle = new Object[4][4];
	/**
	 * Konstruktor: Erstellt ein neues (this) Objekt
	 * Das Erstellte Objekt ist ein neues Feld mit der Groesse 4x4
	 * Auf diesem Feld liegen die Puzzelteile von 1-15.
	 * Das letzte Feld (unten rechts (im Puzzel an stelle [3][3]))
	 * 
	 */
	public Schiebepuzzle() {
		int fill = 1;
		for(int i = 0; i<4;i++) {
			for(int j = 0;j<4;j++) {
				this.puzzle[i][j] = fill;
				fill++;
				if(fill == 16) {
					this.puzzle[3][3] = null;
					break;
				}
			}
		}
		
	}
	/**
	 * Gibt das Object[][] vom (this) Objekt zurueck
	 * 
	 * @return Object[][] > Puzzle
	 */
	public Object[][] getPuzzle(){
		return this.puzzle;
	}
	/**
	 * Gibt das Feld des Puzzels mit den Positionen der einzelnen Teile als String aus <br>
	 * Format: | x| x| x| x| <br>
	 *         | x| x| x| x| <br>
	 *         | x| x| x| x| <br>
	 *         | x| x| x| 0| <br>
	 *         
	 *  @return String > Puzzle als String
	 */
	public String toString() {
		String erg = "";
		StringBuilder sb = new StringBuilder(erg);
		for(int i = 0; i<4;i++) {
			for(int j = 0;j<4;j++) {
				if(this.puzzle[i][j] != null) {
					sb.append("|" + String.format("%2s", this.puzzle[i][j]+ ""));
				}else {
					sb.append("|" + String.format("%2s", ""));
				}
			}
			sb.append("|" + " \n");

			sb.append("-".repeat(13));

			sb.append(" \n");
		}
		
		return sb.toString();
	}
	/**
	 * Verschiebt das Feld mit dem angegebenen Parameter i, wenn moeglich auf das freie Feld
	 * 
	 * @throws WrongMoveException(i) > Der Zug ist nicht moeglich .
	 * @throws WrongNumberException(i) > Der Wert muss zwischen 1 und 15 liegen.
	 * 
	 * @param i > Ist der Int-Wert auf dem Feld das Verschoben werden soll
	 */
	public void schiebe(int i) {
		/*
		 * Prüft ob der Wert des Feldes das Verschoben werden soll zwischen 1 und 15 liegt
		 * @throws WrongNumber Exception > Wert muss zwischen 1 und 15 liegen
		 * @param i > Wert des Feldes das Verschoben werden soll
		 */
		if(i>=1 && i<=15) {
			/*
			 * Prueft ob man das Feld i verschieben kann
			 * @throws WrongMoveException
			 * @param i > Wert des Feldes das Verschoben werden soll
			 */
			if(istVerschiebbar(i)) {
				/*
				 * Sucht die Position des Feldes an der sich das Feld mit dem Wert i befindet
				 * @param i > Wert des Feldes
				 * Setzt die Koordinaten des Feldes mit dem Wert i auf {@value p1} und {@value p2}
				 */
				int p1 = 0;
				int p2 = 0;
				for(int k = 0; k<4;k++) {
					for(int j = 0;j<4;j++) {
						if(this.puzzle[k][j] == null) {
						}else {
							if(Integer.parseInt(this.puzzle[k][j].toString()) == i) {
								p1 = k;
								p2 = j;
							}
						}
						
					}
				}
				/*
				 * Prueft ob die Verschiebung vom Feld mit dem Wert i aus in die Himmelsrichtungen moeglich ist,
				 * und prueft dann ob das Feld frei ist und setzt die Koordinaten des neuen Punktes wenn das Feld frei war.
				 */
				if(p1-1 >= 0) {
					if(this.puzzle[p1-1][p2] == null) {
						this.puzzle[p1-1][p2] = this.puzzle[p1][p2];
					}
				}
				if(p2-1 >= 0) {
					if(this.puzzle[p1][p2-1] == null) {
						this.puzzle[p1][p2-1] = this.puzzle[p1][p2];
					}
				}
				if(p2+1<=3) {
					if(this.puzzle[p1][p2+1] == null) {
						this.puzzle[p1][p2+1] = this.puzzle[p1][p2];
					}
				}
				if(p1+1<=3) {
					if(this.puzzle[p1+1][p2] == null) {
						this.puzzle[p1+1][p2] = this.puzzle[p1][p2];
						
					}
				}
				/*
				 * Setzt die das alte Feld auf null, damit es als leeres Feld gilt
				 */
				this.puzzle[p1][p2] = null;
			}else {
				throw new WrongMoveException(i);
			}
		}else {
			throw new WrongNumberException(i);
		}
	}
	/**
	 * Testet ob man das Feld mit dem Wert i auf das freie Feld verschieben kann
	 * 
	 * @param i > Int-Wert des Feldes das Verschoben werden soll
	 * @return boolean > {@value true} wenn das Verschieben moeglich ist, {@value false} wenn der Zug nicht moeglich ist
	 */
	public boolean istVerschiebbar(int i) {
		/*
		 * Sucht die Position des Feldes an der sich das Feld mit dem Wert i befindet
		 * @param i > Wert des Feldes
		 * Setzt die Koordinaten des Feldes mit dem Wert i auf {@value p1} und {@value p2}
		 */
		int p1 = 0;
		int p2 = 0;
		for(int k = 0; k<4;k++) {
			for(int j = 0;j<4;j++) {
				if(this.puzzle[k][j] == null) {
				}else {
					if(Integer.parseInt(this.puzzle[k][j].toString()) == i) {
						p1 = k;
						p2 = j;
					}
				}
				
			}
		}
		/*
		 * Prueft ob die Verschiebung vom Feld mit dem Wert i aus in die Himmelsrichtungen moeglich ist,
		 * und returnt true wenn das moeglich ist, ansonsten wird false zurueck gegeben.
		 */
		if(p1-1 >= 0) {
			if(this.puzzle[p1-1][p2] == null) {
				return true;
			}
		}
		if(p2-1 >= 0) {
			if(this.puzzle[p1][p2-1] == null) {
				return true;
			}
		}
		if(p2+1<=3) {
			if(this.puzzle[p1][p2+1] == null) {
				return true;
			}
		}
		if(p1+1<=3) {
			if(this.puzzle[p1+1][p2] == null) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Nimmt 100 moegliche zuege vor um das Spielfeld zuvermischen
	 * Dabei wird der Wert des Feldes zufaellig zwischen 1 und 15 gewaehlt und dann versucht das Feld zu verschieben. 
	 */
	public void mischen() {
		int target;
		for(int i = 0; i<100;i++) {
				target = ThreadLocalRandom.current().nextInt(1, 15+1);
				if(istVerschiebbar(target)) {
					schiebe(target);
				}else {
					i--;
				}
		}
	}
	/**
	 * Sucht die Stelle an der das Feld mit dem Wert i ist und gibt dessen Position zurueck
	 * 
	 * @param i > Int-Wert des Feldes von dem die Position auf dem Feld gesucht wird
	 * @return int[] > Gibt einen int[] zurueck der die x und y Koordinate bzw die Position im puzzle[][] zurueck
	 */
	public int[] getPosition(int i) {
		int[] erg;
		if(i>=1 && i<=15) {
		int p1 = 0;
		int p2 = 0;
		for(int k = 0; k<4;k++) {
			for(int j = 0;j<4;j++) {
				if(this.puzzle[k][j] == null) {
				}else {
					if(Integer.parseInt(this.puzzle[k][j].toString()) == i) {
						p1 = k;
						p2 = j;
					}
				}		
			}
		}
		erg = new int[] {p1,p2};
		}else {
			throw new WrongNumberException(i);
		}
		
		return erg;
	}
	
}
