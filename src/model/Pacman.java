package model;

import enumeration.Direction;

/**
 * 
 * @author nicolas
 *
 */
public class Pacman extends ModeleEntite {
	Thread t;

	public Pacman(Grille grille, String name, int x, int y) {
		super(grille, name, x, y);
		t = new Thread(this);
		t.start();
	}

	public String toString() {
		return "[P]";
	}

	@Override
	public void run() {
		while (this.isAlive() == true) {
			try {
				Thread.sleep(300);
				this.move();
				// System.out.println("ICI");
				this.setChanged();
				this.notifyObservers();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
