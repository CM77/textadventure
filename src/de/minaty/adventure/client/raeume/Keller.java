package de.minaty.adventure.client.raeume;

import de.minaty.adventure.client.spielakteure.Spielobjekt;

public class Keller extends Raum {

	public Keller(String nameDesSpielobjekts) {
		super(nameDesSpielobjekts);
	}

	@Override
	public String untersuchen() {
		return "Du bist in einem modrigen Keller aus Backstein-Gemäuer. Ein leiser Luftzug weht hier unten. "
				+ "Eine nackte Glühbirne taucht den Raum in fahles, gespenstisches Licht. Es ist verdächtig still.";
	}

	@Override
	public boolean benutzbarBei(Spielobjekt objekt) {
		// TODO konkrete Gegenstände hier rein, die im Raum etwas bewirken
		return false;
	}
}
