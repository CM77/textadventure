package de.minaty.adventure.client.gegenstaende.alltagsgegenstaende;

import java.awt.Point;

import de.minaty.adventure.client.gegenstaende.Gegenstand;

public class Apfel extends Gegenstand {

	public Apfel(Point position, int gewicht) {
		super(position, gewicht);
	}

	@Override
	public String untersuchen() {
		return "Ein leckerer grüner Apfel";
	}

}
