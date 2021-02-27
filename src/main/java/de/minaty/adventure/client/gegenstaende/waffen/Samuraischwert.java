package de.minaty.adventure.client.gegenstaende.waffen;

import java.awt.Point;

public final class Samuraischwert extends Waffe {

	public Samuraischwert(Point position, String name, int gewicht, int maxSchadenspunkte) {
		super(position, name, gewicht, maxSchadenspunkte);
	}

	@Override
	public String untersuchen() {
		return "Es ist ein altes japanisches Samuraischwert und die extrem scharfe Klinge glänzt in der Sonne.";
	}

	@Override
	public String mitnehmen() {
		return "Das " + super.mitnehmen();
	}

}
