package model;

import java.util.Random;

import enumeration.Direction;

/**
 * 
 * @author nicolas
 *
 */
public class Fantome extends ModeleEntite {
	/**
	 * Le processus qui va lancer le fantôme
	 */
	Thread t;

	public Fantome(Grille grille, String name, int x, int y) {
		super(grille, name, x, y);
		t = new Thread(this);
		t.start();
	}

	public String toString() {
		return "[F]";
	}

	/**
	 * Récupération d'une direction aléatoire quand le fantôme est bloqué
	 * 
	 * @return
	 */
	public Direction randomDirection() {
		Random rand = new Random();
		int alea = rand.nextInt(4);
		switch (alea) {
		case 0:
			this.setDirection(Direction.HAUT);
			break;
		case 1:
			this.setDirection(Direction.BAS);
			break;
		case 2:
			this.setDirection(Direction.GAUCHE);
			break;
		case 3:
			this.setDirection(Direction.DROITE);
			break;
		}
		;
		return this.getDirection();
	}

	public void goUP() {
		if (this.grille.getCases()[this.x - 1][this.y] instanceof Case) {
			this.setDirection(Direction.HAUT);
			this.grille.add(new Case("", this.x, this.y));
			this.grille.getCases()[this.x - 1][this.y] = this;
			this.setX(this.x - 1);
			this.setY(this.y);
		} else if (this.grille.getCases()[this.x - 1][this.y] instanceof Pacman) {
			// Tuer le pacman devant lui
			this.grille.getCases()[this.x - 1][this.y].dead();
		} else {
			this.randomDirection();
		}
	}

	public void goDown() {
		if (this.grille.getCases()[this.x + 1][this.y] instanceof Case) {
			this.setDirection(Direction.BAS);
			this.grille.getCases()[this.x + 1][this.y] = this;
			this.grille.add(new Case("", this.x, this.y));
			this.setX(this.x + 1);
			this.setY(this.y);
		} else if (this.grille.getCases()[this.x + 1][this.y] instanceof Pacman) {
			this.grille.getCases()[this.x + 1][this.y].dead();
		} else {
			this.randomDirection();
		}
	}

	public void goLeft() {
		if (this.grille.getCases()[this.x][this.y - 1] instanceof Case) {
			this.setDirection(Direction.GAUCHE);
			this.grille.getCases()[this.x][this.y - 1] = this;
			this.grille.add(new Case("", this.x, this.y));
			this.setX(this.x);
			this.setY(this.y - 1);
		} else if (this.grille.getCases()[this.x][this.y - 1] instanceof Pacman) {
			this.grille.getCases()[this.x][this.y - 1].dead();
		} else {
			this.randomDirection();
		}
	}

	public void goRight() {
		if (this.grille.getCases()[this.x][this.y + 1] instanceof Case) {
			this.setDirection(Direction.DROITE);
			this.grille.add(new Case("", this.x, this.y));
			this.grille.getCases()[this.x][this.y + 1] = this;
			this.setX(this.x);
			this.setY(this.y + 1);
		} else if (this.grille.getCases()[this.x][this.y + 1] instanceof Pacman) {
			// Si le pacman est devant lui, il le tue
			this.grille.getCases()[this.x][this.y + 1].dead();
		} else {
			this.randomDirection();
		}
	}

	@Override
	public void run() {
		while (this.isAlive() == true) {
			try {
				// vitesse de déplacement
				Thread.sleep(250);
				this.move();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
