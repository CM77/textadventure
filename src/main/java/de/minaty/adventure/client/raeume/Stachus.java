package de.minaty.adventure.client.raeume;

import java.awt.Point;

public final class Stachus extends Raum {

	public Stachus(Point position, String name) {
		super(position, name);
		this.position = position;
	}

	@Override
	public String erkunden() {
		return "Der große Springbrunnen spritzt unablässig Wasserfontänen in die Luft. Du siehst"
				+ "das Karlstor vor dir.";
	}

}
