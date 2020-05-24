package de.minaty.adventure.client.spielakteure;

import java.awt.Point;

public abstract class Spielobjekt {

	private Point position;

	protected Spielobjekt(Point position) {
		super();
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
}