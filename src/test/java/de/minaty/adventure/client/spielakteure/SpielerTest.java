package de.minaty.adventure.client.spielakteure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import de.minaty.adventure.client.Spielfeld;

class SpielerTest extends BewegungsTest {

	// TODO Test-Setup rund machen, Refactoring?

	// private static Point aktuellePosition;

	// TODO Spieler hat als Point nur "null", nochmal Konstruktor und Vererbungen
	// überprüfen
	@BeforeAll
	static void beforeFunction() {
		Point aktuellePosition = new Point(1, 1);
		Spieler spieler = new Spieler(aktuellePosition, 30, 12, 10);
		System.out.println(spieler.getPosition());
	}

	@Test
	@Disabled
	public void test_Position_Spieler_Prüfen_Ohne_Bewegung() {
		Spielfeld.initSpielfeld();
		assertEquals(new Point(1, 0).getX(), new Point(1, 0).getX());
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
