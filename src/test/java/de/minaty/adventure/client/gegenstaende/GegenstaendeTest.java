package de.minaty.adventure.client.gegenstaende;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

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
		spielfeld.getMapAllerRaeumeInDerSpielwelt().clear();
		spielfeld.getMapAllerAktuellenNachbarraeume().clear();
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
	public void test_Position__bewege_mehrere_Gegenstaende_in_verschiedene_Raeume() {
		// Given:
		Samuraischwert schwert = spielfeld.getSamuraischwert();
		Apfel apfel = spielfeld.getApfel();
		Point expectedRaumEinsMitGegenstand = new Point(0, 4);
		Point expectedRaumZweiMitGegenstand = new Point(3, 4);

		// When:
		schwert.setPosition(expectedRaumEinsMitGegenstand);
		apfel.setPosition(expectedRaumZweiMitGegenstand);

		// Then:
		assertEquals(schwert.getPosition(), expectedRaumEinsMitGegenstand);
		assertEquals(apfel.getPosition(), expectedRaumZweiMitGegenstand);
	}

}
