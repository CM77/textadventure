package de.minaty.adventure.client.raeume;

import de.minaty.adventure.client.spielakteure.Spielobjekt;

public class Kapellenstraße extends Raum {

public Kapellenstraße(String nameDesSpielobjekts) {
		super(nameDesSpielobjekts);
	}

@Override
	public String untersuchen() {
	return "Du bist in der Kapellenstraße. Außer ist dir ist hier niemand und die Straße wirkt fast wie ausgestorben.\n"
						+ "Du hast fast ein bisschen Angst. Ob du vielleicht deine Oma um Beistand anrufen sollst?";
	}

@Override
public boolean benutzbarBei(Spielobjekt objekt) {
	// TODO konkrete Gegenstände hier rein, die im Raum etwas bewirken
	return false;
}

}
