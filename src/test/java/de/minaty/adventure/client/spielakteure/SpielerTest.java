package de.minaty.adventure.client.spielakteure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import de.minaty.adventure.client.Spielfeld;
import de.minaty.adventure.client.raeume.Marienplatz;

class SpielerTest extends BewegungsTest {

	// TODO Test-Setup rund machen, Refactoring?

	@Test
	public void test_Position_Spieler_Prüfen_Ohne_Bewegung() {
		Point aktuellePosition = new Point(1, 0);
		Spielfeld.initSpielfeld();
		Spieler spieler = new Spieler(aktuellePosition, 30, 12, 10);

		assertEquals(Spielfeld.mapMitRäumenInDerSpielwelt.containsValue(new Marienplatz("Marienplatz")),
				Spielfeld.pruefeObPositionSpielerMitPositionRaumUebereinstimmt(spieler));
	}

	// TODO weitere Tests

	@Override
	public String nachNordenBewegen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nachSüdenBewegen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nachOstenBewegen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nachWestenBewegen() {
		// TODO Auto-generated method stub
		return null;
	}

}
