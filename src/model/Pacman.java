package model;

import enumeration.Direction;

/**
 * 
 * @author nicolas
 *
 */
public class Pacman extends ModeleEntite {

	public Pacman() {
		super();
		this.direction = Direction.HAUT;
	}

	public String toString() {
		return "[P]";
	}
}
