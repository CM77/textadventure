package de.minaty.adventure.client.raeume;

import de.minaty.adventure.client.ButtonFabrik;
import javafx.scene.control.Button;

public final class Wendeltreppe extends Raum {

	public Wendeltreppe(String nameDesSpielobjekts) {
		super(nameDesSpielobjekts);
	}

	@Override
	public String erkunden() {
		return "In unzählig wirkenden Stufen geht es hinab in unbekannte Tiefen. "
				+ "Fackeln säumen die aus grobem Stein gehauenen Wände. ";
	}

	@Override
	public Button baueButton() {
		return ButtonFabrik.erzeugeButton(getName() + " erkunden");
	}
}
