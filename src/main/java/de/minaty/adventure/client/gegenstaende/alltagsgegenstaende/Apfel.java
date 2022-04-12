package de.minaty.adventure.client.gegenstaende.alltagsgegenstaende;

import de.minaty.adventure.client.gegenstaende.Gegenstand;

public class Apfel extends Gegenstand {

	boolean aufgegessen;

	@Override
	public String untersuchen() {
		if (aufgegessen) {
			return "Bis auf das Kerngehäuse ist nix mehr übrig vom Apfel.";
		}
		return "Es ist ein leckerer " + name + ".";
	}

	public String aufessen() {
		if (aufgegessen) {
			return "Der Apfel ist gänzlich abgenagt.";
		} else {
			aufgegessen = true;
			return "Du futterst den Apfel in nullkommanix auf.";
		}
	}
}
