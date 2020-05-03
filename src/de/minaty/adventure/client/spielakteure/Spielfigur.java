package de.minaty.adventure.client.spielakteure;

import java.awt.Point;

public abstract class Spielfigur extends Spielobjekt {

	private Point position;
	private int staerke;
	private int attacke;
	private int parade;

	Spielfigur(String name, Point position, int staerke, int attacke, int parade) {
		super(name);
		this.staerke = staerke;
		this.position = position;
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

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
}
