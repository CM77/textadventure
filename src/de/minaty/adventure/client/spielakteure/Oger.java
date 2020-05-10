package de.minaty.adventure.client.spielakteure;

import java.awt.Point;

public final class Oger extends Monster {

	public Oger(Point position, int staerke, int attacke, int parade) {
		super(position, staerke, attacke, parade);
	}

	@Override
	public String anschauen() {
		return "Der Oger ist 2 Meter groß, trägt einen Lendenschurz, hat eine grünliche Haut und guckt echt grimmig.";
	}

}
