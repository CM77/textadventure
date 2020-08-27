package de.minaty.adventure.client.raeume;

import de.minaty.adventure.client.ButtonFabrik;
import javafx.scene.control.Button;

public final class Marienplatz extends Raum {

	public Marienplatz(String nameDesSpielobjekts) {
		super(nameDesSpielobjekts);
	}

	@Override
	public String erkunden() {
		return "Das ist der Marienplatz. Viele Touristen knipsen Fotos und warten auf das Glockenspiel im Rathaus.";
	}

	@Override
	public Button baueButton() {
		return ButtonFabrik.erzeugeButton(getName() + " erkunden");
	}
}
