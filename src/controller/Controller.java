package controller;

import enumeration.Direction;
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
		this.grille.getPacman().addObserver(this.getView());
		this.grille.getFant1().addObserver(this.getView());
		this.grille.getFant2().addObserver(this.getView());
		this.grille.getFant3().addObserver(this.getView());
		this.grille.getFant4().addObserver(this.getView());
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
			this.grille.getPacman().setDirection(Direction.HAUT);
			// this.grille.getPacman().move();
			this.view.init();
			System.out.println(this.grille.getPacman().getDirection());
			break;
		case DOWN:
			System.out.println("DOWN");
			this.grille.getPacman().setDirection(Direction.BAS);
			// this.grille.getPacman().move();
			this.view.init();
			System.out.println(this.grille.getPacman().getDirection());
			break;
		case LEFT:
			System.out.println("LEFT");
			this.grille.getPacman().setDirection(Direction.GAUCHE);
			// this.grille.getPacman().move();
			this.view.init();
			System.out.println(this.grille.getPacman().getDirection());
			break;
		case RIGHT:
			System.out.println("RIGHT");
			this.grille.getPacman().setDirection(Direction.DROITE);
			// this.grille.getPacman().move();
			this.view.init();
			System.out.println(this.grille.getPacman().getDirection());
			break;
		}
	}

}
