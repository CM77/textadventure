package de.minaty.adventure.client.raeume;

import java.awt.Point;

public final class Kapellenstraße extends Raum {

	public Kapellenstraße(Point position, String name) {
		super(position, name);
		this.position = position;
	}

	@Override
	public String erkunden() {
		return "Du bist in der Kapellenstraße. Außer ist dir ist hier niemand und die Straße wirkt fast wie ausgestorben.\n"
				+ "Du hast fast ein bisschen Angst. Ob du vielleicht deine Oma um Beistand anrufen sollst?";
	}

}
