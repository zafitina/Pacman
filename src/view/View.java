package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Fantome;
import model.Grille;
import model.Pacman;

/**
 * 
 * @author nicolas
 *
 */
public class View extends Canvas {
	private Grille grille;

	public View(Grille _grille) {
		this.grille = _grille;
		this.setWidth(500);
		this.setHeight(500);
	}

	/* GETTERS AND SETTERS */
	public Grille getGrille() {
		return this.grille;
	}

	public void setGrille(Grille grille) {
		this.grille = grille;
	}

	public void init() {
		this.setHeight(500);
		this.setWidth(500);
		GraphicsContext gc = this.getGraphicsContext2D();
		drawGrille(gc);
	}

	public void drawGrille(GraphicsContext gc) {
		int x = 20;
		int y = 20;
		int size = 15;
		for (int i = 0; i < grille.getSize(); i++) {
			for (int j = 0; j < grille.getSize(); j++) {
				if (grille.getCases()[i][j].getModel() != null) {
					if (grille.getCases()[i][j].getModel() instanceof Pacman) {
						gc.setFill(Color.YELLOW);
						gc.fillRect(x, y, size, size);
					}
					if (grille.getCases()[i][j].getModel() instanceof Fantome) {
						gc.setFill(Color.RED);
						gc.fillRect(x, y, size, size);
					}
				} else {
					if (grille.getCases()[i][j].isEmpty()) {
						gc.setFill(Color.BLACK);
						gc.fillRect(x, y, size, size);
					}
					if (grille.getCases()[i][j].isFull()) {
						gc.setFill(Color.BLUE);
						gc.fillRect(x, y, size, size);
					}
				}
				x += size;
			}
			x = 20;
			y += size;
		}
		grille.showGrille();
	}
}
