package de.minaty.adventure.client.raeume;

import de.minaty.adventure.client.Untersuchbar;

public abstract class Raum implements Untersuchbar {

	private String name;

	Raum(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
