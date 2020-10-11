package de.minaty.adventure.client.gegenstaende;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import de.minaty.adventure.client.Spielfeld;
import de.minaty.adventure.client.gegenstaende.waffen.Samuraischwert;
import de.minaty.adventure.client.spielakteure.Spieler;

public class GegegnstaendeVerteilungsTest {

	Point stachus = new Point(0, 0);
	Spieler spielerActual = new Spieler(stachus, "Spieler", 30, 12, 10);

	@Test
	public void test_Position__Gegenstaende_Stachus() {
		// Given:
		Spielfeld.initSpielfeld();
		Spielfeld.initGegenstaende();
		int anzahlGegenstaendeAufDemStachus = 0;

		// When:
		for (Gegenstand g : Spielfeld.getSetMitAllenGegenstaenden()) {
			if (g.getPosition().equals(stachus)) {
				anzahlGegenstaendeAufDemStachus++;
			}
		}

		// Then:
		assertEquals(anzahlGegenstaendeAufDemStachus, 1);
	}

	@Test
	public void test_Position__verschiebe_Gegenstaende_vom_Stachus_in_Keller() {
		// Given:
		Spielfeld.initSpielfeld();
		Samuraischwert s = new Samuraischwert(stachus, "schwert", 1, 3);
		s.setPosition(new Point(0, 3));
		int anzahlGegenstaendeAufDemStachus = 0;

		// When:
		Spielfeld.getSetMitAllenGegenstaenden().add(s);
		for (Gegenstand g : Spielfeld.getSetMitAllenGegenstaenden()) {
			if (g.getPosition().equals(stachus)) {
				anzahlGegenstaendeAufDemStachus++;
			}
		}

		// Then:
		assertEquals(anzahlGegenstaendeAufDemStachus, 0);
	}
}
