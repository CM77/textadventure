package de.minaty.adventure.client.spielakteure;

public abstract class Spielobjekt {

	private String name;

	Spielobjekt(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
