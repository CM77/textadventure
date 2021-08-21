package de.minaty.adventure.client.raeume;

import java.awt.Point;

public final class Wendeltreppe extends Raum {

	public Wendeltreppe(Point position, String name) {
		super(position, name);
		this.position = position;
	}

	@Override
	public String erkunden() {
		return "In unzählig wirkenden Stufen geht es hinab in unbekannte Tiefen. "
				+ "Fackeln säumen die aus grobem Stein gehauenen Wände. ";
	}

}
