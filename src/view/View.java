package view;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Bloc;
import model.Case;
import model.Fantome;
import model.Grille;
import model.Pacman;

/**
 * 
 * @author nicolas
 *
 */
public class View extends Canvas implements Observer {
	private Grille grille;

	public View(Grille _grille) {
		this.grille = _grille;
		this.setHeight(230);
		this.setWidth(210);
	}

	/* GETTERS AND SETTERS */
	public Grille getGrille() {
		return this.grille;
	}

	public void setGrille(Grille grille) {
		this.grille = grille;
	}

	public void init() {
		GraphicsContext gc = this.getGraphicsContext2D();
		drawGrille(gc);
	}

	public void drawGrille(GraphicsContext gc) {
		int x = 0;
		int y = 0;
		int size = 10;
		for (int i = 0; i < grille.getSize(); i++) {
			for (int j = 0; j < grille.getSize(); j++) {
				if (grille.getCases()[i][j] instanceof Pacman) {
					gc.setFill(Color.YELLOW);
					gc.fillRect(x, y, size, size);
				}
				if (grille.getCases()[i][j] instanceof Fantome) {
					gc.setFill(Color.RED);
					gc.fillRect(x, y, size, size);
				}
				if (grille.getCases()[i][j] instanceof Case) {
					gc.setFill(Color.BLACK);
					gc.fillRect(x, y, size, size);
				}
				if (grille.getCases()[i][j] instanceof Bloc) {
					gc.setFill(Color.BLUE);
					gc.fillRect(x, y, size, size);
				}
				x += size;
			}
			x = 0;
			y += size;
		}
		grille.showGrille();
	}

	@Override
	public void update(Observable o, Object arg) {
		GraphicsContext gc = this.getGraphicsContext2D();
		drawGrille(gc);
	}
}
