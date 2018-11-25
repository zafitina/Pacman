package model;

import enumeration.Direction;

/**
 * 
 * @author nicolas
 *
 */
public abstract class ModeleEntite {
	protected Direction direction;

	public ModeleEntite() {

	}

	/* GETTERS AND SETTERS */
	public Direction getDirection() {
		return this.direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
