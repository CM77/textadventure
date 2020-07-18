package de.minaty.adventure.client.spielakteure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.minaty.adventure.client.Spielfeld;
import de.minaty.adventure.client.raeume.Raum;

class RaumTest {

	private List<Raum> listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums = new ArrayList<>(Arrays.asList());

	@BeforeEach
	public void init() {
		Spielfeld.initSpielfeld();
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums.clear();
	}

	@Test
	public void test_Raum__Anzahl_der_Nachbarraeume_vom_Aufenthaltsraum_Marienplatz() {
		// Given:
		Spieler spielerActual = new Spieler(new Point(1, 0), 30, 12, 10);

		// When:
		Spielfeld.ermittleDieNachbarraeumeUmAktuellenAufenthaltsraum(spielerActual);
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums.addAll(Spielfeld.getAktuelleNachbarraeume());

		// Then:
		assertThat(listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums).hasSize(1);
	}

	@Test
	public void test_Raum__Anzahl_der_Nachbarraeume_vom_Aufenthaltsraum_Stachus_ermitteln() {
		// Given:
		Spieler spielerActual = new Spieler(new Point(0, 0), 30, 12, 10);

		// When:
		Spielfeld.ermittleDieNachbarraeumeUmAktuellenAufenthaltsraum(spielerActual);
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums.addAll(Spielfeld.getAktuelleNachbarraeume());

		// Then:
		assertThat(listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums).hasSize(2);
	}

	@Test
	public void test_Raum__Name_des_Nachbarraums_vom_Aufenthaltsraum_Keller_abgleichen() {
		// Given:
		Spieler spielerActual = new Spieler(new Point(0, 2), 30, 12, 10);
		String zuFilternderNachbarraumName = null;

		// When:
		Spielfeld.ermittleDieNachbarraeumeUmAktuellenAufenthaltsraum(spielerActual);
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums.addAll(Spielfeld.getAktuelleNachbarraeume());

		for (Raum raum : listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums) {
			if (raum.getName().equals("Kapellenstraße")) {
				zuFilternderNachbarraumName = raum.getName();
			}
		}
		// Then:
		assertEquals("Kapellenstraße", zuFilternderNachbarraumName);
	}

	@Test
	public void test_Raum__Ein_Name_von_insgesamt_zwei_Nachbarraeumen_vom_Aufenthaltsraum_Kapellenstraße_abgleichen() {
		// Given:
		Spieler spielerActual = new Spieler(new Point(0, 1), 30, 12, 10);
		Raum filteredRaum = null;

		// When:
		Spielfeld.ermittleDieNachbarraeumeUmAktuellenAufenthaltsraum(spielerActual);
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums.addAll(Spielfeld.getAktuelleNachbarraeume());
		filteredRaum = listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums.stream()//
				.filter(raumName -> "Keller".equals(raumName.getName())).findAny().orElse(null);

		// Then:
		assertThat(listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums).hasSize(2);
		assertEquals("Keller", filteredRaum.getName());
	}

	@Test
	public void test_Raum__Zwei_von_zwei_Nachbarraeumen_vom_Aufenthaltsraum_Kapellenstraße_abgleichen() {
		// Given:
		Spieler spielerActual = new Spieler(new Point(0, 1), 30, 12, 10);
		boolean alleNachbarraeumeSindPraesent;

		// When:
		Spielfeld.ermittleDieNachbarraeumeUmAktuellenAufenthaltsraum(spielerActual);
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums.addAll(Spielfeld.getAktuelleNachbarraeume());
		alleNachbarraeumeSindPraesent = listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums.stream()//
				.allMatch(raumName -> (raumName.getName().equalsIgnoreCase("Keller"))
						|| (raumName.getName().equalsIgnoreCase("Stachus")));

		// Then:
		assertThat(alleNachbarraeumeSindPraesent).isTrue();
	}

	@Test
	public void test_Raum__Wenn_es_keine_Nachbarraeume_gibt() {
		// Given:
		Spieler spielerActual = new Spieler(new Point(27, 17), 30, 12, 10);

		// When:
		Spielfeld.ermittleDieNachbarraeumeUmAktuellenAufenthaltsraum(spielerActual);
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums.addAll(Spielfeld.getAktuelleNachbarraeume());

		// Then:
		assertThat(listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums).hasSize(0);
	}
}
