package de.minaty.adventure.client.gegenstaende;

import de.minaty.adventure.client.spielakteure.Spielfigur;

public class Ereignis {

	private Gegenstand g1;
	private Gegenstand g2;
	private Spielfigur spieler;

	public Ereignis(Gegenstand g1, Gegenstand g2, Spielfigur spieler) {
		this.g1 = g1;
		this.g2 = g2;
		this.spieler = spieler;
	}

	public Gegenstand getG1() {
		return g1;
	}

	public Gegenstand getG2() {
		return g2;
	}

}
