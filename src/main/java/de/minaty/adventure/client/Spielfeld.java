package de.minaty.adventure.client;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import de.minaty.adventure.client.raeume.Kapellenstraße;
import de.minaty.adventure.client.raeume.Keller;
import de.minaty.adventure.client.raeume.Marienplatz;
import de.minaty.adventure.client.raeume.Raum;
import de.minaty.adventure.client.raeume.Stachus;
import de.minaty.adventure.client.spielakteure.Spieler;

public class Spielfeld {

	// TODO static weg?

	private static HashMap<Point, Raum> mapAllerRaeumeInDerSpielwelt = new HashMap<>();
	private static Point aktuelleSpielerPosition;
	private static List<Raum> listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums = new ArrayList<>(Arrays.asList());

	private static final Point MARIENPLATZ = new Point(1, 0);
	private static final Point STACHUS = new Point(0, 0);
	private static final Point KAPELLENSTRASSE = new Point(0, 1);
	private static final Point KELLER = new Point(0, 2);

	public static HashMap<Point, Raum> getMapAllerRaeumeInDerSpielwelt() {
		return mapAllerRaeumeInDerSpielwelt;
	}

	public static void setMapAllerRaeumeInDerSpielwelt(HashMap<Point, Raum> mapAllerRaeumeInDerSpielwelt) {
		Spielfeld.mapAllerRaeumeInDerSpielwelt = mapAllerRaeumeInDerSpielwelt;
	}

	public static List<Raum> getAktuelleNachbarraeume() {
		return listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums;
	}

	public static void setAktuelleNachbarraeume(ArrayList<Raum> aktuelleNachbarraeume) {
		Spielfeld.listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums = aktuelleNachbarraeume;
	}

	public static void initSpielfeld() {
		mapAllerRaeumeInDerSpielwelt.put(MARIENPLATZ, new Marienplatz("Marienplatz"));
		mapAllerRaeumeInDerSpielwelt.put(KELLER, new Keller("Keller"));
		mapAllerRaeumeInDerSpielwelt.put(STACHUS, new Stachus("Stachus"));
		mapAllerRaeumeInDerSpielwelt.put(KAPELLENSTRASSE, new Kapellenstraße("Kapellenstraße"));
	}

	public static Raum pruefeObPositionSpielerMitPositionRaumUebereinstimmt(Spieler spieler) {
		aktuelleSpielerPosition = spieler.getPosition();
		for (HashMap.Entry<Point, Raum> entry : mapAllerRaeumeInDerSpielwelt.entrySet()) {
			if (aktuelleSpielerPosition.equals(entry.getKey())) {
				return entry.getValue();
			}
		}
		return null; // TODO kann man das besser lösen?
	}

	public static List<Raum> ermittleDieNachbarraeumeUmAktuellenAufenthaltsraum(Spieler spieler) {
		aktuelleSpielerPosition = spieler.getPosition();
		listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums.clear();
		for (HashMap.Entry<Point, Raum> entry : mapAllerRaeumeInDerSpielwelt.entrySet()) {
			if (entry.getKey().distance(aktuelleSpielerPosition) == 1) {
				listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums.add(entry.getValue());
			}
		}
		return listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums;
	}
}
