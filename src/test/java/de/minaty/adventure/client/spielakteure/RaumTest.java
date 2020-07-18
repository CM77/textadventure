package de.minaty.adventure.client.spielakteure;

import java.awt.Point;
import java.util.List;

import org.junit.jupiter.api.Test;

import de.minaty.adventure.client.Spielfeld;
import de.minaty.adventure.client.raeume.Raum;

class RaumTest {

	// TODO Test für Methode entwickeln, die Zugmöglichkeiten für den Spieler per
	// Button anbietet

	Point startPosition = new Point(1, 0);
	Spieler spielerActual = new Spieler(startPosition, 30, 12, 10);

	@Test
	void test_Raum__Moegliche_Nachbarraeume_von_Marienplatz_anzeigen() {
		// Given:
		Spielfeld.initSpielfeld();
		List<Raum> raumName;

		// When:
		raumName = Spielfeld.ermittleAktuelleNachbarraeume(spielerActual);
		for (Raum r : raumName) {
			System.out.println(r.getName());
		}

		// Then:
//		assertEquals("Stachus", raumName.stream().);
//		assertEquals("Kapellenstraße", raumName);
	}

}
