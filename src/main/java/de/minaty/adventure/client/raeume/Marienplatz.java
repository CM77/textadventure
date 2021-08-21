package de.minaty.adventure.client.raeume;

import java.awt.Point;

public final class Marienplatz extends Raum {

	public Marienplatz(Point position, String name) {
		super(position, name);
		this.position = position;
	}

	@Override
	public String erkunden() {
		return "Viele Touristen knipsen Fotos und warten auf das Glockenspiel im Rathaus.";
	}

}
