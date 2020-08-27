package de.minaty.adventure.client.raeume;

import de.minaty.adventure.client.ButtonFabrik;
import javafx.scene.control.Button;

public final class Kapellenstraße extends Raum {

	public Kapellenstraße(String nameDesSpielobjekts) {
		super(nameDesSpielobjekts);
	}

	@Override
	public String erkunden() {
		return "Du bist in der Kapellenstraße. Außer ist dir ist hier niemand und die Straße wirkt fast wie ausgestorben.\n"
				+ "Du hast fast ein bisschen Angst. Ob du vielleicht deine Oma um Beistand anrufen sollst?";
	}

	@Override
	public Button baueButton() {
		return ButtonFabrik.erzeugeButton(getName() + " erkunden");
	}

}
