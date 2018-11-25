package model;

import java.util.Random;

import enumeration.Direction;

/**
 * 
 * @author nicolas
 *
 */
public class Grille {
	private Case[][] cases;
	private int size;

	public Grille(int _size) {
		this.size = _size;
		this.cases = new Case[this.size][this.size];
	}

	public void initGrille() {
		init();
		// AJOUT DES MURS
		for (int j = 1; j < this.size - 1; j++) {
			this.cases[0][j] = new Case();
			this.cases[this.size - 1][j] = new Case();
		}
		for (int i = 0; i < 7; i++) {
			this.cases[i][1] = new Case();
			this.cases[i][this.size - 2] = new Case();
		}
		for (int i = this.size - 1; i > this.size - 10; i--) {
			this.cases[i][1] = new Case();
			this.cases[i][this.size - 2] = new Case();
		}
		for (int j = 3; j < 5; j++) {
			this.cases[2][j] = new Case();
			this.cases[4][j] = new Case();
			this.cases[6][j] = new Case();
			this.cases[12][j] = new Case();
			this.cases[14][j] = new Case();
			this.cases[18][j] = new Case();
		}
		for (int j = this.size - 4; j > this.size - 6; j--) {
			this.cases[2][j] = new Case();
			this.cases[4][j] = new Case();
			this.cases[6][j] = new Case();
			this.cases[12][j] = new Case();
			this.cases[14][j] = new Case();
			this.cases[18][j] = new Case();
		}
		this.cases[18][5] = new Case();
		this.cases[18][this.size - 6] = new Case();
		this.cases[6][2] = new Case();
		this.cases[12][2] = new Case();
		this.cases[6][this.size - 3] = new Case();
		this.cases[12][this.size - 3] = new Case();
		for (int j = 0; j < 5; j++) {
			this.cases[8][j] = new Case();
			this.cases[10][j] = new Case();
		}
		for (int j = this.size - 1; j > this.size - 6; j--) {
			this.cases[8][j] = new Case();
			this.cases[10][j] = new Case();
		}
		for (int i = 6; i < 9; i++) {
			this.cases[i][4] = new Case();
			this.cases[i][this.size - 5] = new Case();
		}
		for (int i = 10; i < 13; i++) {
			this.cases[i][4] = new Case();
			this.cases[i][this.size - 5] = new Case();
		}
		for (int i = 15; i < 17; i++) {
			this.cases[i][4] = new Case();
			this.cases[i][this.size - 5] = new Case();
		}
		for (int i = 4; i < 9; i++) {
			this.cases[i][6] = new Case();
			this.cases[i][this.size - 7] = new Case();
		}
		for (int i = 10; i < 13; i++) {
			this.cases[i][6] = new Case();
			this.cases[i][this.size - 7] = new Case();
		}
		for (int i = 16; i < 19; i++) {
			this.cases[i][6] = new Case();
			this.cases[i][this.size - 7] = new Case();
		}
		for (int i = 8; i < 11; i++) {
			this.cases[i][8] = new Case();
			this.cases[i][this.size - 9] = new Case();
		}
		for (int i = 0; i < 3; i++) {
			this.cases[i][10] = new Case();
		}
		for (int i = 4; i < 7; i++) {
			this.cases[i][10] = new Case();
		}
		for (int i = 12; i < 15; i++) {
			this.cases[i][10] = new Case();
		}
		for (int i = 16; i < 19; i++) {
			this.cases[i][10] = new Case();
		}
		this.cases[16][2] = new Case();
		this.cases[16][this.size - 3] = new Case();
		for (int j = 6; j < 9; j++) {
			this.cases[2][j] = new Case();
			this.cases[6][j] = new Case();
			this.cases[14][j] = new Case();
			this.cases[18][j] = new Case();
		}
		for (int j = 12; j < 15; j++) {
			this.cases[2][j] = new Case();
			this.cases[6][j] = new Case();
			this.cases[14][j] = new Case();
			this.cases[18][j] = new Case();
		}
		for (int j = 8; j < 13; j++) {
			this.cases[4][j] = new Case();
			this.cases[10][j] = new Case();
			this.cases[12][j] = new Case();
			this.cases[16][j] = new Case();
		}
		for (int j = 8; j < 10; j++) {
			this.cases[8][j] = new Case();
			this.cases[10][j] = new Case();
		}
		for (int j = 11; j < 13; j++) {
			this.cases[8][j] = new Case();
			this.cases[10][j] = new Case();
		}

		// AJOUT DE PACMAN ET DES FANTÔMES
		this.cases[7][10] = new Case(new Fantome());
		this.cases[9][9] = new Case(new Fantome());
		this.cases[9][10] = new Case(new Fantome());
		this.cases[9][11] = new Case(new Fantome());
		this.cases[15][10] = new Case(new Pacman());
	}

	public void init() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.cases[i][j] = new Case(null);
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
	public Case[][] getCases() {
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
}
