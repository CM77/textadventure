package de.minaty.adventure.client.raeume;

import de.minaty.adventure.client.ButtonFabrik;
import javafx.scene.control.Button;

public final class Stachus extends Raum {

	public Stachus(String name) {
		super(name);
	}

	@Override
	public String erkunden() {
		return "Der große Springbrunnen spritzt unablässig Wasserfontänen in die Luft. Du siehst"
				+ "das Karlstor vor dir.";
	}

	@Override
	public Button baueButton() {
		return ButtonFabrik.erzeugeButton(getName() + " erkunden");
	}
}
