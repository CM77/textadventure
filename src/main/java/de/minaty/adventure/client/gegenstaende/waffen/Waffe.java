package de.minaty.adventure.client.gegenstaende.waffen;

import java.awt.Point;

import de.minaty.adventure.client.gegenstaende.Gegenstand;

public abstract class Waffe extends Gegenstand {

	private int maxSchadenspunkte;

	protected Waffe(Point position, int gewicht, int maxSchadenspunkte) {
		super(position, gewicht);
		this.maxSchadenspunkte = maxSchadenspunkte;
	}

	public int getSchadenspunkte() {
		return maxSchadenspunkte;
	}

	public void setSchadenspunkte(int schadenspunkte) {
		this.maxSchadenspunkte = schadenspunkte;
	}
}
