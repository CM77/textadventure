package de.minaty.adventure.client.spielakteure;

import java.awt.Point;

public abstract class Spielobjekt {

	protected Point position;
	protected String name;

	protected Spielobjekt(Point position, String name) {
		super();
		this.position = position;
		this.setName(name);
	}

	protected Spielobjekt(Point position) {
		super();
		this.position = position;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}