package de.minaty.adventure.client.gegenstaende;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.minaty.adventure.client.Spielfeld;
import de.minaty.adventure.client.gegenstaende.alltagsgegenstaende.Apfel;
import de.minaty.adventure.client.gegenstaende.waffen.Samuraischwert;
import de.minaty.adventure.client.spielakteure.Spieler;

public class GegenstaendeTest {

	Spielfeld spielfeld = new Spielfeld();
	Point stachus = new Point(0, 0);
	Spieler spielerActual = new Spieler(stachus, "Spieler", 30, 12, 10);

	@BeforeEach
	public void init() {
		spielfeld.getSetMitAllenGegenstaendenAktuellerRaum().clear();
		spielfeld.initSpielfeld();
	}

	@Test
	public void test_Position__default_Gegenstaende_Stachus_neu() {
		// Given:
		Samuraischwert schwert = spielfeld.getSamuraischwert();
		Point expectedRaumMitGegenstand = spielfeld.getSTACHUS();

		// When:

		// Then:
		assertEquals(schwert.getPosition(), expectedRaumMitGegenstand);
	}

	@Test
	public void test_Position__bewege_Gegenstand_in_anderen_Raum() {
		// Given:
		Samuraischwert schwert = spielfeld.getSamuraischwert();
		Point expectedRaumMitGegenstand = new Point(0, 3);

		// When:
		schwert.setPosition(expectedRaumMitGegenstand);

		// Then:
		assertEquals(schwert.getPosition(), expectedRaumMitGegenstand);
	}

	@Test
	public void test_Position__bewege_mehrere_Gegenstaende_in_anderen_Raum() {
		// Given:
		Samuraischwert schwert = spielfeld.getSamuraischwert();
		Apfel apfel = spielfeld.getApfel();
		Point expectedRaumMitGegenstand = new Point(0, 4);

		// When:
		schwert.setPosition(expectedRaumMitGegenstand);
		apfel.setPosition(expectedRaumMitGegenstand);

		// Then:
		assertEquals(schwert.getPosition(), expectedRaumMitGegenstand);
		assertEquals(apfel.getPosition(), expectedRaumMitGegenstand);
	}

	@Test
	public void test_Set_Gegenstaende__alle_im_Spielfeld() {
		// Given:
		Set<Gegenstand> setMitAllenGegenstaenden = new HashSet<Gegenstand>();
		setMitAllenGegenstaenden = spielfeld.befuelleSetMitAllenGegenstaenden();

		// When:

		// Then:
		assertFalse(setMitAllenGegenstaenden.isEmpty());
	}

	@Test
	public void test_Set_Gegenstaende__alle_in_einem_Raum() {
		// Given:
		Samuraischwert schwert = spielfeld.getSamuraischwert();
		Set<Gegenstand> setMitGegenstaendenAktuellerRaum = new HashSet<Gegenstand>();
		setMitGegenstaendenAktuellerRaum = spielfeld.befuelleSetMitGegenstaendenAktuellerRaum(spielerActual);
		boolean gegenstandImRichtigenRaum = false;

		// When:
		for (Gegenstand g : setMitGegenstaendenAktuellerRaum) {
			if (g.getClass().equals(schwert.getClass())) {
				gegenstandImRichtigenRaum = true;
			}
		}

		// Then:
		assertTrue(gegenstandImRichtigenRaum);
	}
}
