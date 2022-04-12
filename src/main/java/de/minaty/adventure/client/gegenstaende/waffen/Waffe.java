package de.minaty.adventure.client.gegenstaende.waffen;

import de.minaty.adventure.client.gegenstaende.Gegenstand;

public abstract class Waffe extends Gegenstand {

	private int maxSchadenspunkte;

	public int getSchadenspunkte() {
		return maxSchadenspunkte;
	}

	public void setSchadenspunkte(int schadenspunkte) {
		this.maxSchadenspunkte = schadenspunkte;
	}
}
