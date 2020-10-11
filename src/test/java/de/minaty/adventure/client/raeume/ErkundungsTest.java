package de.minaty.adventure.client.raeume;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import de.minaty.adventure.client.Spielfeld;
import de.minaty.adventure.client.spielakteure.Spieler;

public class ErkundungsTest {

	Point startPosition = new Point(0, 0);
	Spieler spielerActual = new Spieler(startPosition, "spieler", 30, 12, 10);

	@Test
	public void test_Position_Spieler__Erkundung_vom_Raum_Stachus() {
		// Given:
		Stachus stachus = new Stachus("Stachus");
		String stachusErkundungstext = stachus.erkunden();
		Spielfeld.initSpielfeld();

		// When:
		Raum raum = Spielfeld.ermittleAufenthaltsraumSpieler(spielerActual);

		// Then:
		assertEquals(stachusErkundungstext, raum.erkunden());
	}

}
