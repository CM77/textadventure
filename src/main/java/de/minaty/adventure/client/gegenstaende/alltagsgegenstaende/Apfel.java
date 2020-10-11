package de.minaty.adventure.client.gegenstaende.alltagsgegenstaende;

import java.awt.Point;

import de.minaty.adventure.client.gegenstaende.Gegenstand;

public class Apfel extends Gegenstand {

	public Apfel(Point position, String name, int gewicht) {
		super(position, name, gewicht);
	}

	@Override
	public String untersuchen() {
		return "Ein leckerer grüner Apfel";
	}

}
