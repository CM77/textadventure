package de.minaty.adventure.client.raeume;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.minaty.adventure.client.Himmelsrichtung;
import de.minaty.adventure.client.Spielfeld;
import de.minaty.adventure.client.spielakteure.Spieler;

public class RaumTest {

	Spielfeld spielfeld = new Spielfeld();
	private List<Raum> listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums = new ArrayList<>(Arrays.asList());
	private List<Himmelsrichtung> listeMitDenExitsDesAktuellenAufenthaltsraums = new ArrayList<>(Arrays.asList());

	@BeforeEach
	public void init() {
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums.clear();
		listeMitDenExitsDesAktuellenAufenthaltsraums.clear();
		spielfeld.getMapAllerRaeumeInDerSpielwelt().clear();
		spielfeld.getMapAllerAktuellenNachbarraeume().clear();
		spielfeld.initSpielfeld();
	}

	@Test
	public void test_Raum__Anzahl_der_Zugmoeglichkeiten_vom_Aufenthaltsraum_Marienplatz() {
		// Given:
		Spieler spielerActual = new Spieler(new Point(1, 0), "spieler", 30, 12, 10);

		// When:
		spielfeld.ermittleDieNachbarraeume(spielerActual);
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums
				.addAll(spielfeld.getMapAllerAktuellenNachbarraeume().values());
		spielfeld.ermittleMoeglicheHimmelsrichtungen(spielerActual);
		listeMitDenExitsDesAktuellenAufenthaltsraums.addAll(spielfeld.getMapMoeglicherHimmelsrichtungen().values());

		// Then:
		assertThat(listeMitDenExitsDesAktuellenAufenthaltsraums).hasSize(1);
	}

	@Test
	public void test_Raum__Anzahl_der_Zugmoeglichkeiten_vom_Aufenthaltsraum_Stachus() {
		// Given:
		Spieler spielerActual = new Spieler(new Point(0, 0), "spieler", 30, 12, 10);

		// When:
		spielfeld.ermittleDieNachbarraeume(spielerActual);
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums
				.addAll(spielfeld.getMapAllerAktuellenNachbarraeume().values());
		spielfeld.ermittleMoeglicheHimmelsrichtungen(spielerActual);
		listeMitDenExitsDesAktuellenAufenthaltsraums.addAll(spielfeld.getMapMoeglicherHimmelsrichtungen().values());

		// Then:
		assertThat(listeMitDenExitsDesAktuellenAufenthaltsraums).hasSize(2);
	}

	@Test
	public void test_Raum__Name_der_Exit_Himmelsrichtungen_vom_Aufenthaltsraum_Kapellenstrasse() {
		// Given:
		Spieler spielerActual = new Spieler(new Point(0, 1), "spieler", 30, 12, 10);

		// When:
		spielfeld.ermittleDieNachbarraeume(spielerActual);
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums
				.addAll(spielfeld.getMapAllerAktuellenNachbarraeume().values());
		spielfeld.ermittleMoeglicheHimmelsrichtungen(spielerActual);
		listeMitDenExitsDesAktuellenAufenthaltsraums.addAll(spielfeld.getMapMoeglicherHimmelsrichtungen().values());

		// Then:
		assertThat(listeMitDenExitsDesAktuellenAufenthaltsraums).contains(Himmelsrichtung.SUEDEN);
		assertThat(listeMitDenExitsDesAktuellenAufenthaltsraums).contains(Himmelsrichtung.NORDEN);
	}

	@Test
	public void test_Raum__Name_der_Exit_Himmelsrichtungen_vom_Aufenthaltsraum_Marienplatz() {
		// Given:
		Spieler spielerActual = new Spieler(new Point(1, 0), "spieler", 30, 12, 10);

		// When:
		spielfeld.ermittleDieNachbarraeume(spielerActual);
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums
				.addAll(spielfeld.getMapAllerAktuellenNachbarraeume().values());
		spielfeld.ermittleMoeglicheHimmelsrichtungen(spielerActual);
		listeMitDenExitsDesAktuellenAufenthaltsraums.addAll(spielfeld.getMapMoeglicherHimmelsrichtungen().values());

		// Then:
		assertThat(listeMitDenExitsDesAktuellenAufenthaltsraums).contains(Himmelsrichtung.WESTEN);
	}

	@Test
	public void test_Raum__Name_der_Exit_Himmelsrichtungen_vom_Aufenthaltsraum_Stachus() {
		// Given:
		Spieler spielerActual = new Spieler(new Point(0, 0), "spieler", 30, 12, 10);

		// When:
		spielfeld.ermittleDieNachbarraeume(spielerActual);
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums
				.addAll(spielfeld.getMapAllerAktuellenNachbarraeume().values());
		spielfeld.ermittleMoeglicheHimmelsrichtungen(spielerActual);
		listeMitDenExitsDesAktuellenAufenthaltsraums.addAll(spielfeld.getMapMoeglicherHimmelsrichtungen().values());

		// Then:
		assertThat(listeMitDenExitsDesAktuellenAufenthaltsraums).contains(Himmelsrichtung.OSTEN);
		assertThat(listeMitDenExitsDesAktuellenAufenthaltsraums).contains(Himmelsrichtung.NORDEN);
	}

	@Test
	public void test_Raum__Anzahl_der_Nachbarraeume_vom_Aufenthaltsraum_Marienplatz() {
		// Given:
		Spieler spielerActual = new Spieler(new Point(1, 0), "spieler", 30, 12, 10);

		// When:
		spielfeld.ermittleDieNachbarraeume(spielerActual);
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums
				.addAll(spielfeld.getMapAllerAktuellenNachbarraeume().values());

		// Then:
		assertThat(listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums).hasSize(1);
	}

	@Test
	public void test_Raum__Anzahl_der_Nachbarraeume_vom_Aufenthaltsraum_Stachus_ermitteln() {
		// Given:
		Spieler spielerActual = new Spieler(new Point(0, 0), "spieler", 30, 12, 10);

		// When:
		spielfeld.ermittleDieNachbarraeume(spielerActual);
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums
				.addAll(spielfeld.getMapAllerAktuellenNachbarraeume().values());

		// Then:
		assertThat(listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums).hasSize(2);
	}

	@Test
	public void test_Raum__Name_des_Nachbarraums_vom_Aufenthaltsraum_Keller_abgleichen() {
		// Given:
		Spieler spielerActual = new Spieler(new Point(0, 3), "spieler", 30, 12, 10);

		// When:
		spielfeld.ermittleDieNachbarraeume(spielerActual);
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums
				.addAll(spielfeld.getMapAllerAktuellenNachbarraeume().values());

		// Then:
		assertTrue(listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums.stream()
				.anyMatch(raumName -> (raumName.getName().equalsIgnoreCase("Wendeltreppe"))));
	}

	@Test
	public void test_Raum__Namen_der_Nachbarraeume_vom_Aufenthaltsraum_Kapellenstraße_abgleichen() {
		// Given:
		Spieler spielerActual = new Spieler(new Point(0, 1), "spieler", 30, 12, 10);

		// When:
		spielfeld.ermittleDieNachbarraeume(spielerActual);
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums
				.addAll(spielfeld.getMapAllerAktuellenNachbarraeume().values());

		// Then:
		assertTrue(listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums.stream()
				.anyMatch(raumName -> (raumName.getName().equalsIgnoreCase("Wendeltreppe"))));
		assertTrue(listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums.stream()
				.anyMatch(raumName -> (raumName.getName().equalsIgnoreCase("Stachus"))));
	}

	@Test
	public void test_Raum__Zwei_von_zwei_Nachbarraeumen_vom_Aufenthaltsraum_Wendeltreppe_abgleichen() {
		// Given:
		Spieler spielerActual = new Spieler(new Point(0, 2), "spieler", 30, 12, 10);

		// When:
		spielfeld.ermittleDieNachbarraeume(spielerActual);
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums
				.addAll(spielfeld.getMapAllerAktuellenNachbarraeume().values());

		// Then:
		assertTrue(listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums.stream()
				.anyMatch(raumName -> (raumName.getName().equalsIgnoreCase("Keller"))));
		assertTrue(listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums.stream()
				.anyMatch(raumName -> (raumName.getName().equalsIgnoreCase("Kapellenstraße"))));
	}

	@Test
	public void test_Raum__Wenn_es_keine_Nachbarraeume_gibt() {
		// Given:
		Spieler spielerActual = new Spieler(new Point(99, 99), "spieler", 30, 12, 10);

		// When:
		spielfeld.ermittleDieNachbarraeume(spielerActual);
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums
				.addAll(spielfeld.getMapAllerAktuellenNachbarraeume().values());

		// Then:
		assertThat(listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums).hasSize(0);
	}
}
