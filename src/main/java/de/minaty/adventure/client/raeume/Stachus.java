package de.minaty.adventure.client.raeume;

public final class Stachus extends Raum {

	public Stachus(String name) {
		super(name);
	}

	@Override
	public String erkunden() {
		return "Der große Springbrunnen spritzt unablässig Wasserfontänen in die Luft. Du siehst"
				+ "das Karlstor vor dir.";
	}
}
