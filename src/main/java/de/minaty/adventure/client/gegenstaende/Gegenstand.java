package de.minaty.adventure.client.gegenstaende;

import java.awt.Point;

import de.minaty.adventure.client.spielakteure.Spielobjekt;

public abstract class Gegenstand extends Spielobjekt implements Untersuchbar, Versteckbar {

	private int gewicht;

	protected Gegenstand(Point position, int gewicht) {
		super(position);
		this.gewicht = gewicht;
	}

	public int getGewicht() {
		return gewicht;
	}

	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}
}
