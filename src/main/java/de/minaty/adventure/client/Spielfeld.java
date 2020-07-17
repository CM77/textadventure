package de.minaty.adventure.client;

import java.awt.Point;
import java.util.ArrayList;
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

	private static HashMap<Point, Raum> mapMitRäumenInDerSpielwelt = new HashMap<>();
	private static Point aktuelleSpielerPos;
	private static List<Raum[]> aktuelleNachbarraeume = new ArrayList<Raum[]>();

	private static final Point MARIENPLATZ = new Point(1, 0);
	private static final Point STACHUS = new Point(0, 0);
	private static final Point KAPELLENSTRASSE = new Point(0, 1);
	private static final Point KELLER = new Point(0, 2);

	public static HashMap<Point, Raum> getMapMitRäumenInDerSpielwelt() {
		return mapMitRäumenInDerSpielwelt;
	}

	public static void setMapMitRäumenInDerSpielwelt(HashMap<Point, Raum> mapMitRäumenInDerSpielwelt) {
		Spielfeld.mapMitRäumenInDerSpielwelt = mapMitRäumenInDerSpielwelt;
	}

	public static void initSpielfeld() {
		mapMitRäumenInDerSpielwelt.put(MARIENPLATZ, new Marienplatz("Marienplatz"));
		mapMitRäumenInDerSpielwelt.put(KELLER, new Keller("Keller"));
		mapMitRäumenInDerSpielwelt.put(STACHUS, new Stachus("Stachus"));
		mapMitRäumenInDerSpielwelt.put(KAPELLENSTRASSE, new Kapellenstraße("Kapellenstraße"));
	}

	public static Raum pruefeObPositionSpielerMitPositionRaumUebereinstimmt(Spieler spieler) {
		aktuelleSpielerPos = spieler.getPosition();
		for (HashMap.Entry<Point, Raum> entry : mapMitRäumenInDerSpielwelt.entrySet()) {
			if (aktuelleSpielerPos.equals(entry.getKey())) {
				return entry.getValue();
			}
		}
		return null; // TODO kann man das besser lösen?
	}

	public static List<Raum[]> ermittleAktuelleNachbarraeume(Spieler spieler) {
		aktuelleSpielerPos = spieler.getPosition();
		aktuelleNachbarraeume.clear();
		for (HashMap.Entry<Point, Raum> entry : mapMitRäumenInDerSpielwelt.entrySet()) {
			if (aktuelleSpielerPos.x == entry.getKey().x - 1 //
					|| aktuelleSpielerPos.x == entry.getKey().x + 1 //
					|| aktuelleSpielerPos.y == entry.getKey().y - 1 //
					|| aktuelleSpielerPos.y == entry.getKey().y + 1 //
			) {
				aktuelleNachbarraeume.add(new Raum[] { entry.getValue() });
			}
		}
		return aktuelleNachbarraeume;
	}
}
