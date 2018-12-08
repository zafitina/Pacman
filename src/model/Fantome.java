package model;

/**
 * 
 * @author nicolas
 *
 */
public class Fantome extends ModeleEntite {
	Thread t;

	public Fantome(Grille grille, String name, int x, int y) {
		super(grille, name, x, y);
		t = new Thread(this);
		t.start();
	}

	public String toString() {
		return "[F]";
	}

	@Override
	public void run() {

	}
}
