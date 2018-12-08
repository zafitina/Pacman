package model;

public class Bloc extends ModeleEntite {

	public Bloc(String name, int x, int y) {
		super(name, x, y);
	}

	public String toString() {
		return "[#]";
	}

	@Override
	public void run() {

	}
}
