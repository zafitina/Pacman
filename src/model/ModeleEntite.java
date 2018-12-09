package model;

import java.util.Observable;

import enumeration.Direction;

/**
 * 
 * @author nicolas
 *
 */
public abstract class ModeleEntite extends Observable implements Runnable {
	/**
	 * Direction de pour pacman et les fantômes
	 */
	protected Direction direction;
	/**
	 * les position des modèles dans la grille
	 */
	protected int x, y;
	/**
	 * Le nom de chaque entité
	 */
	protected String name;
	/**
	 * la grille où les ajouté
	 */
	protected Grille grille;
	/**
	 * attribut pour savoir i l'enttité est vivant ou pas
	 */
	protected Boolean alive;

	/**
	 * Constructeur des fantômes et pacman
	 * 
	 * @param grille
	 * @param name
	 * @param i
	 * @param j
	 */
	public ModeleEntite(Grille grille, String name, int i, int j) {
		this.direction = Direction.HAUT;
		this.grille = grille;
		this.x = i;
		this.y = j;
		this.name = name;
		this.alive = true;
	}

	/**
	 * COnstructeur de case vides et blocs
	 * 
	 * @param name
	 * @param i
	 * @param j
	 */
	public ModeleEntite(String name, int i, int j) {
		this.x = i;
		this.y = j;
		this.name = name;
	}

	/**
	 * Direction haut
	 */
	public void goUP() {
		if (this.grille.getCases()[this.x - 1][this.y] instanceof Case) {
			this.setDirection(Direction.HAUT);
			this.grille.add(new Case("", this.x, this.y));
			this.grille.getCases()[this.x - 1][this.y] = this;
			this.setX(this.x - 1);
			this.setY(this.y);
		} else if (this.grille.getCases()[this.x - 1][this.y] instanceof Fantome) {
			this.dead();
		}
	}

	/**
	 * Direction bas
	 */
	public void goDown() {
		if (this.grille.getCases()[this.x + 1][this.y] instanceof Case) {
			this.setDirection(Direction.BAS);
			this.grille.getCases()[this.x + 1][this.y] = this;
			this.grille.add(new Case("", this.x, this.y));
			this.setX(this.x + 1);
			this.setY(this.y);
		} else if (this.grille.getCases()[this.x + 1][this.y] instanceof Fantome) {
			this.dead();
		}
	}

	/**
	 * Direction gauche
	 */
	public void goLeft() {
		if (this.grille.getCases()[this.x][this.y - 1] instanceof Case) {
			this.setDirection(Direction.GAUCHE);
			this.grille.getCases()[this.x][this.y - 1] = this;
			this.grille.add(new Case("", this.x, this.y));
			this.setX(this.x);
			this.setY(this.y - 1);
		} else if (this.grille.getCases()[this.x][this.y - 1] instanceof Fantome) {
			this.dead();
		}
	}

	/**
	 * Direction droite
	 */
	public void goRight() {
		if (this.grille.getCases()[this.x][this.y + 1] instanceof Case) {
			this.setDirection(Direction.DROITE);
			this.grille.add(new Case("", this.x, this.y));
			this.grille.getCases()[this.x][this.y + 1] = this;
			this.setX(this.x);
			this.setY(this.y + 1);
		} else if (this.grille.getCases()[this.x][this.y + 1] instanceof Fantome) {
			this.dead();
		}
	}

	/**
	 * Fonction pour tuer une entité
	 */
	public void dead() {
		this.setAlive(false);
		this.grille.add(new Case("", this.x, this.y));
	}

	/**
	 * Déplacement d'une entitéen fonction de sa direction
	 */
	public void move() {
		switch (this.getDirection()) {
		case HAUT:
			this.goUP();
			break;
		case DROITE:
			this.goRight();
			break;
		case GAUCHE:
			this.goLeft();
			break;
		case BAS:
			this.goDown();
			break;
		}

	}

	/* GETTERS AND SETTERS */
	public Direction getDirection() {
		return this.direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean isAlive() {
		return this.alive;
	}

	public void setAlive(Boolean dead) {
		this.alive = dead;
	}
}
