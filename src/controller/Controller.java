package controller;

import model.Grille;
import view.View;

/**
 * 
 * @author nicolas
 *
 */
public class Controller {
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
}
