package de.minaty.adventure.client.gegenstaende;

import de.minaty.adventure.client.spielakteure.Spielobjekt;

public abstract class Gegenstand extends Spielobjekt implements Untersuchbar, Versteckbar, Mitnehmbar {

	private int gewicht;
	private boolean mitgenommen = false;

	public int getGewicht() {
		return gewicht;
	}

	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}

	public boolean isMitgenommen() {
		return mitgenommen;
	}

	public void setMitgenommen(boolean mitgenommen) {
		this.mitgenommen = mitgenommen;
	}

	// TODO passiert hier was?
	@Override
	public String mitnehmen() {
		if (mitgenommen) {
			return name + " liegt bereits in deinem Rucksack!";
		} else {
			mitgenommen = true;
			return name + " wird von dir in den Rucksack gepackt.";
		}
	}
}
