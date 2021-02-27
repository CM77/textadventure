package de.minaty.adventure.client.gegenstaende;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.minaty.adventure.client.Spielfeld;
import de.minaty.adventure.client.gegenstaende.alltagsgegenstaende.Apfel;
import de.minaty.adventure.client.gegenstaende.waffen.Samuraischwert;
import de.minaty.adventure.client.spielakteure.Spieler;

public class RucksackTest {

	Spielfeld spielfeld = new Spielfeld();
	Point stachus = new Point(0, 0);
	Spieler spielerActual = new Spieler(stachus, "Spieler", 30, 12, 10);

	@BeforeEach
	public void init() {
		spielfeld.getSetMitGegenstaendenAktuellerRaum().clear();
		spielfeld.getListeMitGegenstaendenImRucksack().clear();
		spielfeld.initSpielfeld();
	}

	@Test
	public void test_Gegenstand__einen_mitnehmen() {
		// Given:
		Samuraischwert schwert = spielfeld.getSamuraischwert();
		spielfeld.befuelleSetMitAllenGegenstaenden();
		spielfeld.befuelleSetMitGegenstaendenAktuellerRaum(spielerActual);
		String expected = schwert.getName();

		// When:
		String actual = "";
		spielfeld.gegenstandMitnehmen(schwert);
		for (Gegenstand g : spielfeld.getListeMitGegenstaendenImRucksack()) {
			actual = g.getName();
		}

		// Then:
		assertEquals(actual, expected);
	}

	@Test
	public void test_Gegenstaende__alle_mitgenommenen_im_Rucksack() {
		// Given:
		Samuraischwert schwert = spielfeld.getSamuraischwert();
		Apfel apfel = spielfeld.getApfel();
		Point keller = new Point(0, 3);
		int expectedAnzahlGegenstaendeImRucksack = 2;

		// When:
		spielfeld.gegenstandMitnehmen(schwert);
		spielerActual.setPosition(keller);
		spielfeld.gegenstandMitnehmen(apfel);
		int actualAnzahlgegestaendeImRucksack = spielfeld.getListeMitGegenstaendenImRucksack().size();

		// Then:
		assertEquals(actualAnzahlgegestaendeImRucksack, expectedAnzahlGegenstaendeImRucksack);
	}
}
