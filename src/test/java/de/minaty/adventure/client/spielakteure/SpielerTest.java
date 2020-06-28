package de.minaty.adventure.client.spielakteure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.minaty.adventure.client.Spielfeld;

class SpielerTest extends BewegungsTest {

	// TODO Test-Setup rund machen, Refactoring?

	// private static Point aktuellePosition;

	// TODO Spieler hat als Point nur "null", nochmal Konstruktor und Vererbungen
	// überprüfen
	Point aktuellePosition = new Point(1, 0);
	Spieler spieler = new Spieler(aktuellePosition, 30, 12, 10);

	@BeforeAll
	static void beforeFunction() {
	}

	@Test
	public void test_Position_Spieler__Ohne_Bewegung() {
		System.out.println(spieler.getPosition());
		Spielfeld.initSpielfeld();
		assertEquals(spieler.getPosition(), new Point(1, 0));
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
