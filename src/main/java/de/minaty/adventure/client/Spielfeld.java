package de.minaty.adventure.client;

import java.awt.Point;
import java.util.HashMap;

import de.minaty.adventure.client.raeume.Kapellenstraße;
import de.minaty.adventure.client.raeume.Keller;
import de.minaty.adventure.client.raeume.Marienplatz;
import de.minaty.adventure.client.raeume.Raum;
import de.minaty.adventure.client.raeume.Stachus;
import de.minaty.adventure.client.raeume.Wendeltreppe;
import de.minaty.adventure.client.spielakteure.Spieler;

public class Spielfeld {

	// TODO static weg?

	private static Point aktuelleSpielerPosition;
	private static HashMap<Point, Raum> mapAllerRaeumeInDerSpielwelt = new HashMap<>();
	private static HashMap<Point, Raum> mapAllerAktuellenNachbarraeume = new HashMap<>();
	private static HashMap<Raum, Himmelsrichtung> mapMoeglicherHimmelsrichtungen = new HashMap<>();

	private static final Point MARIENPLATZ = new Point(1, 0);
	private static final Point STACHUS = new Point(0, 0);
	private static final Point KAPELLENSTRASSE = new Point(0, 1);
	private static final Point WENDELTREPPE = new Point(0, 2);
	private static final Point KELLER = new Point(0, 3);

	public static HashMap<Point, Raum> getMapAllerRaeumeInDerSpielwelt() {
		return mapAllerRaeumeInDerSpielwelt;
	}

	public static void setMapAllerRaeumeInDerSpielwelt(HashMap<Point, Raum> mapAllerRaeumeInDerSpielwelt) {
		Spielfeld.mapAllerRaeumeInDerSpielwelt = mapAllerRaeumeInDerSpielwelt;
	}

	public static HashMap<Point, Raum> getMapMitNachbarraeumen() {
		return mapAllerAktuellenNachbarraeume;
	}

	public static void setMapMitNachbarraeumen(
			HashMap<Point, Raum> listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums) {
		Spielfeld.mapAllerAktuellenNachbarraeume = listeMitDenNachbarraeumenDesAktuellenAufenthaltsraums;
	}

	public static HashMap<Raum, Himmelsrichtung> getMapMitHimmelsrichtungen() {
		return mapMoeglicherHimmelsrichtungen;
	}

	public static void setMapMitHimmelsrichtungen(HashMap<Raum, Himmelsrichtung> mapMoeglicherHimmelsrichtungen) {
		Spielfeld.mapMoeglicherHimmelsrichtungen = mapMoeglicherHimmelsrichtungen;
	}

	public static void initSpielfeld() {
		mapAllerRaeumeInDerSpielwelt.put(MARIENPLATZ, new Marienplatz("Marienplatz"));
		mapAllerRaeumeInDerSpielwelt.put(KELLER, new Keller("Keller"));
		mapAllerRaeumeInDerSpielwelt.put(STACHUS, new Stachus("Stachus"));
		mapAllerRaeumeInDerSpielwelt.put(WENDELTREPPE, new Wendeltreppe("Wendeltreppe"));
		mapAllerRaeumeInDerSpielwelt.put(KAPELLENSTRASSE, new Kapellenstraße("Kapellenstraße"));
	}

	public static Raum ermittleAufenthaltsraumSpieler(Spieler spieler) {
		aktuelleSpielerPosition = spieler.getPosition();
		Raum aufenthaltsraumSpieler = null;
		for (HashMap.Entry<Point, Raum> entry : mapAllerRaeumeInDerSpielwelt.entrySet()) {
			if (aktuelleSpielerPosition.equals(entry.getKey())) {
				aufenthaltsraumSpieler = entry.getValue();
			}
		}
		return aufenthaltsraumSpieler;
	}

	public static HashMap<Point, Raum> ermittleDieNachbarraeume(Spieler spieler) {
		aktuelleSpielerPosition = spieler.getPosition();
		mapAllerAktuellenNachbarraeume.clear();
		for (HashMap.Entry<Point, Raum> entry : mapAllerRaeumeInDerSpielwelt.entrySet()) {
			if (entry.getKey().distance(aktuelleSpielerPosition) == 1) {
				mapAllerAktuellenNachbarraeume.put(entry.getKey(), entry.getValue());
			}
		}
		return mapAllerAktuellenNachbarraeume;
	}

	public static void ermittleMoeglicheHimmelsrichtungen(Spieler spieler) {
		aktuelleSpielerPosition = spieler.getPosition();
		mapMoeglicherHimmelsrichtungen.clear();
		for (HashMap.Entry<Point, Raum> entry : mapAllerAktuellenNachbarraeume.entrySet()) {
			if (entry.getKey().y == aktuelleSpielerPosition.y + 1) {
				mapMoeglicherHimmelsrichtungen.put(entry.getValue(), Himmelsrichtung.NORDEN);
			}
			if (entry.getKey().y == aktuelleSpielerPosition.y - 1) {
				mapMoeglicherHimmelsrichtungen.put(entry.getValue(), Himmelsrichtung.SUEDEN);
			}
			if (entry.getKey().x == aktuelleSpielerPosition.x + 1) {
				mapMoeglicherHimmelsrichtungen.put(entry.getValue(), Himmelsrichtung.OSTEN);
			}
			if (entry.getKey().x == aktuelleSpielerPosition.x - 1) {
				mapMoeglicherHimmelsrichtungen.put(entry.getValue(), Himmelsrichtung.WESTEN);
			}
		}
	}
}
