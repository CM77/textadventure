package de.minaty.adventure.client.spielakteure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.minaty.adventure.client.Spielfeld;

public class SpielerBewegungTest {

	Spielfeld spielfeld = Spielfeld.getInstance();
	Point startPosition = new Point(1, 0);
	Spieler spielerActual = new Spieler(startPosition, "spieler", 30, 12, 10);

	@BeforeEach
	public void init() {
		spielfeld.getMapAllerRaeumeInDerSpielwelt().clear();
		spielfeld.getMapAllerAktuellenNachbarraeume().clear();
		spielfeld.initSpielfeld();
	}

	@Test
	public void test_Position_Spieler__Mit_einfacher_Bewegung_nach_Norden() {
		// Given:

		// When:
		spielerActual.nachNordenBewegen();

		// Then:
		assertEquals(spielerActual.getPosition(), new Point(1, 0 + 1));
	}

	@Test
	public void test_Position_Spieler__Mit_mehrfachen_Bewegungen_nach_Westen() {
		// Given:
		Random random = new Random();
		int zufallszahlBisFuenfzehn = random.nextInt(15);

		// When:
		for (int i = 0; i < zufallszahlBisFuenfzehn; i++) {
			spielerActual.nachWestenBewegen();
		}

		// Then:
		assertEquals(spielerActual.getPosition(), new Point(1 - zufallszahlBisFuenfzehn, 0));
	}

	@Test
	public void test_Position_Spieler__Mit_mehrfachen_Bewegungen_nach_Sueden_und_Osten() {
		// Given:
		Random random = new Random();
		int zufallszahlBisFuenfzehn = random.nextInt(15);

		// When:
		for (int i = 0; i < zufallszahlBisFuenfzehn; i++) {
			spielerActual.nachSuedenBewegen();
			spielerActual.nachOstenBewegen();
		}

		// Then:
		assertEquals(spielerActual.getPosition(), new Point(1 + zufallszahlBisFuenfzehn, 0 - zufallszahlBisFuenfzehn));
	}

	@Test
	public void test_Position_Spieler__Mit_Raum_in_dem_Spiel_startet() {
		// Given:
		spielfeld.initSpielfeld();

		// When:
		spielfeld.ermittleAufenthaltsraumSpieler(spielerActual);

		// Then:
		assertEquals("Marienplatz", spielfeld.ermittleAufenthaltsraumSpieler(spielerActual).getName());
	}

	@Test
	public void test_Position_Spieler__Mit_Raum_in_den_sich_Spieler_bewegt() {
		// Given:
		spielfeld.initSpielfeld();
		spielerActual.setPosition(new Point(0, 0));

		// When:
		spielfeld.ermittleAufenthaltsraumSpieler(spielerActual);

		// Then:
		assertEquals("Stachus", spielfeld.ermittleAufenthaltsraumSpieler(spielerActual).getName());
	}

}
