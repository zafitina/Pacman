package model;

import java.util.Random;

import enumeration.Direction;

/**
 * 
 * @author nicolas
 *
 */
public class Grille {
	private ModeleEntite[][] cases;
	private int size;
	private Pacman pacman;
	private Fantome fant1, fant2, fant3, fant4;

	public Grille(int _size) {
		this.size = _size;
		this.cases = new ModeleEntite[this.size][this.size];
		this.pacman = new Pacman(this, "pacman", 15, 10);
		this.fant1 = new Fantome(this, "ghost1", 7, 10);
		this.fant2 = new Fantome(this, "ghost2", 9, 9);
		this.fant3 = new Fantome(this, "ghost3", 9, 10);
		this.fant4 = new Fantome(this, "ghost4", 9, 11);
	}

	public void add(ModeleEntite caz) {
		this.cases[caz.getX()][caz.getY()] = caz;
	}

	public void initGrille() {
		init();
		// AJOUT DES MURS
		for (int j = 1; j < this.size - 1; j++) {
			this.add(new Bloc("", 0, j));
			this.add(new Bloc("", this.size - 1, j));
		}
		for (int i = 0; i < 7; i++) {
			this.add(new Bloc("", i, 1));
			this.add(new Bloc("", i, this.size - 2));
		}
		for (int i = this.size - 1; i > this.size - 10; i--) {
			this.add(new Bloc("", i, 1));
			this.add(new Bloc("", i, this.size - 2));
		}
		for (int j = 3; j < 5; j++) {
			this.add(new Bloc("", 2, j));
			this.add(new Bloc("", 4, j));
			this.add(new Bloc("", 6, j));
			this.add(new Bloc("", 12, j));
			this.add(new Bloc("", 14, j));
			this.add(new Bloc("", 18, j));
		}
		for (int j = this.size - 4; j > this.size - 6; j--) {
			this.add(new Bloc("", 2, j));
			this.add(new Bloc("", 4, j));
			this.add(new Bloc("", 6, j));
			this.add(new Bloc("", 12, j));
			this.add(new Bloc("", 14, j));
			this.add(new Bloc("", 18, j));
		}
		this.add(new Bloc("", 18, 5));
		this.add(new Bloc("", 18, this.size - 6));
		this.add(new Bloc("", 6, 2));
		this.add(new Bloc("", 6, this.size - 3));
		this.add(new Bloc("", 12, 2));
		this.add(new Bloc("", 12, this.size - 3));
		for (int j = 0; j < 5; j++) {
			this.add(new Bloc("", 10, j));
			this.add(new Bloc("", 8, j));
		}
		for (int j = this.size - 1; j > this.size - 6; j--) {
			this.add(new Bloc("", 10, j));
			this.add(new Bloc("", 8, j));
		}
		for (int i = 6; i < 9; i++) {
			this.add(new Bloc("", i, this.size - 5));
			this.add(new Bloc("", i, 4));
		}
		for (int i = 10; i < 13; i++) {
			this.add(new Bloc("", i, this.size - 5));
			this.add(new Bloc("", i, 4));
		}
		for (int i = 15; i < 17; i++) {
			this.add(new Bloc("", i, this.size - 5));
			this.add(new Bloc("", i, 4));
		}
		for (int i = 4; i < 9; i++) {
			this.add(new Bloc("", i, this.size - 7));
			this.add(new Bloc("", i, 6));
		}
		for (int i = 10; i < 13; i++) {
			this.add(new Bloc("", i, this.size - 7));
			this.add(new Bloc("", i, 6));
		}
		for (int i = 16; i < 19; i++) {
			this.add(new Bloc("", i, this.size - 7));
			this.add(new Bloc("", i, 6));
		}
		for (int i = 8; i < 11; i++) {
			this.add(new Bloc("", i, this.size - 9));
			this.add(new Bloc("", i, 8));
		}
		for (int i = 0; i < 3; i++) {
			this.add(new Bloc("", i, 10));
		}
		for (int i = 4; i < 7; i++) {
			this.add(new Bloc("", i, 10));
		}
		for (int i = 12; i < 15; i++) {
			this.add(new Bloc("", i, 10));
		}
		for (int i = 16; i < 19; i++) {
			this.add(new Bloc("", i, 10));
		}
		this.add(new Bloc("", 16, this.size - 3));
		this.add(new Bloc("", 16, 2));
		for (int j = 6; j < 9; j++) {
			this.add(new Bloc("", 2, j));
			this.add(new Bloc("", 6, j));
			this.add(new Bloc("", 14, j));
			this.add(new Bloc("", 18, j));
		}
		for (int j = 12; j < 15; j++) {
			this.add(new Bloc("", 2, j));
			this.add(new Bloc("", 6, j));
			this.add(new Bloc("", 14, j));
			this.add(new Bloc("", 18, j));
		}
		for (int j = 8; j < 13; j++) {
			this.add(new Bloc("", 4, j));
			this.add(new Bloc("", 10, j));
			this.add(new Bloc("", 12, j));
			this.add(new Bloc("", 16, j));
		}
		for (int j = 8; j < 10; j++) {
			this.add(new Bloc("", 8, j));
			this.add(new Bloc("", 10, j));
		}
		for (int j = 11; j < 13; j++) {
			this.add(new Bloc("", 8, j));
			this.add(new Bloc("", 10, j));
		}

		// AJOUT DE PACMAN ET DES FANTÔMES
		this.add(this.fant1);
		this.add(this.fant2);
		this.add(this.fant3);
		this.add(this.fant4);
		this.add(this.pacman);
	}

	public void init() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.add(new Case("", i, j));
			}
		}
	}

	public void showGrille() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				System.out.print(cases[i][j]);
			}
			System.out.println();
		}
	}

	/* GETTERS AND SETTERS */
	public ModeleEntite[][] getCases() {
		return cases;
	}

	public void setCases(Case[][] cases) {
		this.cases = cases;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Pacman getPacman() {
		return pacman;
	}

	public void setPacman(Pacman pacman) {
		this.pacman = pacman;
	}

	public Fantome getFant1() {
		return fant1;
	}

	public void setFant1(Fantome fant1) {
		this.fant1 = fant1;
	}

	public Fantome getFant2() {
		return fant2;
	}

	public void setFant2(Fantome fant2) {
		this.fant2 = fant2;
	}

	public Fantome getFant3() {
		return fant3;
	}

	public void setFant3(Fantome fant3) {
		this.fant3 = fant3;
	}

	public Fantome getFant4() {
		return fant4;
	}

	public void setFant4(Fantome fant4) {
		this.fant4 = fant4;
	}
}
