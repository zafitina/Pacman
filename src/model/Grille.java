package model;

import java.util.Random;

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
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				cases[i][j] = new Case();
			}
		}
		int k = 3;
		while (k > 0) {
			Random rand = new Random();
			int al = rand.nextInt(this.size);
			cases[al][al] = new Case(new Fantome());
			k--;
		}
		Random rand = new Random();
		int alea = rand.nextInt(this.size);
		cases[alea][alea] = new Case(new Pacman());
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
