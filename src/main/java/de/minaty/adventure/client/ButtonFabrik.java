package de.minaty.adventure.client;

import javafx.scene.control.Button;

public class ButtonFabrik {

	public static Button erzeugeButton(String string) {
		return new Button(string);
	}
}
