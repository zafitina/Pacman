package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Fantome;
import model.Grille;
import model.Pacman;

/**
 * 
 * @author nicolas
 *
 */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Canvas canvas = new Canvas(500, 500);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			drawScene(gc);
			root.getChildren().add(canvas);
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void drawScene(GraphicsContext gc) {
		Grille grille = new Grille(21);
		grille.initGrille();
		int x = 20;
		int y = 20;
		int size = 15;
		for (int i = 0; i < grille.getSize(); i++) {
			for (int j = 0; j < grille.getSize(); j++) {
				if (grille.getCases()[i][j].getModel() instanceof Pacman) {
					gc.setFill(Color.YELLOW);
					gc.fillRect(x, y, size, size);
				}
				if (grille.getCases()[i][j].getModel() instanceof Fantome) {
					gc.setFill(Color.RED);
					gc.fillRect(x, y, size, size);
				}
				if (grille.getCases()[i][j].isFull() == false && grille.getCases()[i][j] == null) {
					gc.setFill(Color.BLACK);
					gc.fillRect(x, y, size, size);
				}
				if (grille.getCases()[i][j].isFull() == true) {
					gc.setFill(Color.BLUE);
					gc.fillRect(x, y, size, size);
				}
				x += size;
			}
			x = 20;
			y += size;
		}
		grille.showGrille();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
