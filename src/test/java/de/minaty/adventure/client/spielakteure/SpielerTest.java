package de.minaty.adventure.client.spielakteure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import de.minaty.adventure.client.Spielfeld;

class SpielerTest {

	// TODO Test rund machen

	@Test
	void test_Position_Spieler_Prüfen_Ohne_Bewegung() {
		Point aktuellePosition = new Point(1, 0);
		Spielfeld.initSpielfeld();
		Spieler spieler = new Spieler(aktuellePosition, 30, 12, 10);

		assertEquals(aktuellePosition, Spielfeld.pruefeObPositionSpielerMitPositionRaumUebereinstimmt(spieler));
	}

}
