package de.minaty.adventure.client.gegenstaende;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.minaty.adventure.client.Spielfeld;
import de.minaty.adventure.client.gegenstaende.waffen.Samuraischwert;
import de.minaty.adventure.client.spielakteure.Spieler;

public class GegenstaendeTest {

	Spielfeld spielfeld = new Spielfeld();
	Point stachus = new Point(0, 0);
	Spieler spielerActual = new Spieler(stachus, "Spieler", 30, 12, 10);

	private Set<Gegenstand> setMitAllenGegenstaenden = new HashSet<Gegenstand>();

	@BeforeEach
	public void init() {
		spielfeld.getMapAllerRaeumeInDerSpielwelt().clear();
		spielfeld.getMapAllerAktuellenNachbarraeume().clear();
		spielfeld.getSetMitAllenGegenstaenden().clear();
		setMitAllenGegenstaenden.clear();
		spielfeld.initSpielfeld();
		spielfeld.initGegenstaende();
	}

	@Test
	public void test_Position__default_Gegenstaende_Stachus() {
		// Given:
		setMitAllenGegenstaenden = spielfeld.getSetMitAllenGegenstaenden();

		// When:
		boolean schwertAufStachusVorhanden = setMitAllenGegenstaenden.stream()
				.anyMatch((p) -> p.getPosition().equals(stachus));

		// Then:
		assertTrue(schwertAufStachusVorhanden);
	}

	@Test
	public void test_Position__verschiebe_Gegenstaende_vom_Stachus_in_fiktiven_Raum() {
		// Given:
		Samuraischwert schwert = new Samuraischwert(stachus, "schwert", 1, 3);
		Point expectedRaumMitGegenstand = new Point(0, 3);

		// When:
		schwert.setPosition(new Point(0, 3));

		// Then:
		assertEquals(schwert.getPosition(), expectedRaumMitGegenstand);
	}
}
