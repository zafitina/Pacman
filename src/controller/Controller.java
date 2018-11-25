package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Grille;
import view.View;

/**
 * 
 * @author nicolas
 *
 */
public class Controller implements EventHandler<KeyEvent> {
	private View view;
	private Grille grille;

	public Controller(Grille _grille, View _view) {
		this.grille = _grille;
		this.view = _view;
	}

	public Grille getGrille() {
		return this.grille;
	}

	public View getView() {
		return this.view;
	}

	@Override
	public void handle(KeyEvent event) {
		switch (event.getCode()) {
		case UP:
			System.out.println("UP");
			break;
		case DOWN:
			System.out.println("DOWN");
			break;
		case LEFT:
			System.out.println("LEFT");
			break;
		case RIGHT:
			System.out.println("RIGHT");
			break;
		}
	}

}
