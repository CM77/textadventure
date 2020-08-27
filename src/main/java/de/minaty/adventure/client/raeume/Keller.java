package de.minaty.adventure.client.raeume;

import de.minaty.adventure.client.ButtonFabrik;
import javafx.scene.control.Button;

public final class Keller extends Raum {

	public Keller(String nameDesSpielobjekts) {
		super(nameDesSpielobjekts);
	}

	@Override
	public String erkunden() {
		return "Du bist in einem modrigen Keller aus Backstein-Gemäuer. Ein leiser Luftzug weht hier unten. "
				+ "Eine nackte Glühbirne taucht den Raum in fahles, gespenstisches Licht. Es ist verdächtig still.";
	}

	@Override
	public Button baueButton() {
		return ButtonFabrik.erzeugeButton(getName() + " erkunden");
	}

}
