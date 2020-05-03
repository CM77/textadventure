package de.minaty.adventure.client.raeume;

import de.minaty.adventure.client.spielakteure.Spielobjekt;

public abstract class Raum extends Spielobjekt {

	Raum(String nameDesSpielobjekts) {
		super(nameDesSpielobjekts);
	}
	
	public String getNameDesRaums() {
		return super.getName();
	}

	public abstract String untersuchen();
}
