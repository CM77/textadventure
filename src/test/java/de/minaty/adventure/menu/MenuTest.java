package de.minaty.adventure.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import de.minaty.adventure.client.Spielfeld;
import de.minaty.adventure.client.spielakteure.Spieler;

public class MenuTest {

	Spielfeld spielfeld = new Spielfeld();
	Point startPosition = new Point(1, 0);
	Spieler spielerActual = new Spieler(startPosition, "spieler", 30, 12, 10);

	@Test
	public void test_menu_spielstand_sichern() {
		// given
		spielfeld.schreibeProperties(spielerActual);

		Properties propsExpected = new Properties();
		propsExpected.setProperty("userPositionX", String.valueOf(spielerActual.getPosition().x));
		propsExpected.setProperty("userPositionY", String.valueOf(spielerActual.getPosition().y));

		// when
		Properties propsActual = new Properties();
		try {
			FileInputStream fos = new FileInputStream("TextAdPropsDatei.txt");
			propsActual.load(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// then
		assertEquals(propsActual, propsExpected);
	}

}
