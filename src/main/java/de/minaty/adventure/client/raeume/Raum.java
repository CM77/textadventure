package de.minaty.adventure.client.raeume;

public abstract class Raum implements Erkundbar, klickbareAktionen {

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
