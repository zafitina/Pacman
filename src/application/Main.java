package application;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import model.Grille;
import view.View;

/**
 * 
 * @author nicolas
 *
 */

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		Grille grille = new Grille(21);
		grille.initGrille();
		View vue = new View(grille);
		vue.init();
		Controller controller = new Controller(grille, vue);
		try {
			Group root = new Group();
			root.getChildren().add(vue);
			Scene scene = new Scene(root);
			scene.setOnKeyPressed(controller);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
