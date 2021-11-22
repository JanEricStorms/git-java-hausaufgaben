package schiebePuzzle;

import java.util.concurrent.ThreadLocalRandom;

public class Schiebepuzzle {

	private Object[][] puzzle = new Object[4][4];
	
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
	
	public Object[][] getPuzzle(){
		return this.puzzle;
	}
	
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
			for(int k = 0; k<13;k++) {
				sb.append("-");
			}
			sb.append(" \n");
		}
		
		return sb.toString();
	}
	
	public void schiebe(int i) {
		if(i>=1 && i<=15) {
			if(istVerschiebbar(i)) {
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
				this.puzzle[p1][p2] = null;
			}else {
				throw new WrongMoveException();
			}
		}else {
			throw new WrongNumberException();
		}
	}
	
	public boolean istVerschiebbar(int i) {
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
	
	public void mischen() {
		int target;
		for(int i = 0; i<100;i++) {
			try {
				target = ThreadLocalRandom.current().nextInt(1, 15+1);
				schiebe(target);
			}catch(WrongMoveException e) {
				i--;
			}
		}
	}
	
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
			throw new WrongNumberException();
		}
		
		return erg;
	}
	
}
