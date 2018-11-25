package model;

import java.util.ArrayList;

/**
 * 
 * @author nicolas
 *
 */
public class Case {
	private ModeleEntite[] caz;
	private ModeleEntite model;
	private int index;

	public Case() {
		this.index = 1;
		this.caz = new ModeleEntite[1];
	}

	public Case(ModeleEntite _model) {
		this.index = 0;
		this.caz = new ModeleEntite[1];
		this.model = _model;
		this.caz[0] = this.model;
	}

	public Boolean isEmpty() {
		return this.index == 0;
	}

	public Boolean isFull() {
		return this.index == 1;
	}

	public void setContent(ModeleEntite model) {
		this.caz[0] = model;
	}

	/* GETTERS AND SETTERS */
	public ModeleEntite[] getCaz() {
		return caz;
	}

	public void setCaz(ModeleEntite[] caz) {
		this.caz = caz;
	}

	public ModeleEntite getModel() {
		return model;
	}

	public void setModel(ModeleEntite model) {
		this.model = model;
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String toString() {
		String s = "";
		if (this.isEmpty()) {
			s += "[   ]";
		}
		if (this.isFull()) {
			s += "[###]";
		}
		if (!this.isEmpty()) {
			s += this.model;
		}
		return s;
	}
}
