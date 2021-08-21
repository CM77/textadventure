package de.minaty.adventure.client.raeume;

import java.awt.Point;

import de.minaty.adventure.client.spielakteure.Spielobjekt;

public abstract class Raum extends Spielobjekt implements Erkundbar {

	private String name;

	Raum(Point position, String name) {
		super(position, name);
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
