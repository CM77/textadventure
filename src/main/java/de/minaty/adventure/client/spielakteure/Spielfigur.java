package de.minaty.adventure.client.spielakteure;

import java.awt.Point;

public abstract class Spielfigur extends Spielobjekt implements Bewegbar {

	private int staerke;
	private int attacke;
	private int parade;

	Spielfigur(Point position, String name, int staerke, int attacke, int parade) {
		super(position, name);
		this.staerke = staerke;
		this.attacke = attacke;
		this.parade = parade;
	}

	public void attackieren() {
	}

	public void parieren() {
	}

	public int getStaerke() {
		return staerke;
	}

	public void setStaerke(int staerke) {
		this.staerke = staerke;
	}

	public int getAttacke() {
		return attacke;
	}

	public void setAttacke(int attacke) {
		this.attacke = attacke;
	}

	public int getParade() {
		return parade;
	}

	public void setParade(int parade) {
		this.parade = parade;
	}

}
