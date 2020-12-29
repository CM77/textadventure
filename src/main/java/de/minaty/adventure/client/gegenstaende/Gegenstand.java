package de.minaty.adventure.client.gegenstaende;

import java.awt.Point;

import de.minaty.adventure.client.spielakteure.Spielobjekt;

public abstract class Gegenstand extends Spielobjekt implements Untersuchbar, Versteckbar, Mitnehmbar {

	private int gewicht;

	protected Gegenstand(Point position, String name, int gewicht) {
		super(position, name);
		this.gewicht = gewicht;
	}

	public int getGewicht() {
		return gewicht;
	}

	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}
}
