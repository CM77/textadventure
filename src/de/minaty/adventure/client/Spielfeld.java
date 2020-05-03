package de.minaty.adventure.client;

import java.awt.Point;
import java.util.HashMap;

import de.minaty.adventure.client.raeume.Kapellenstraße;
import de.minaty.adventure.client.raeume.Keller;
import de.minaty.adventure.client.raeume.Marienplatz;
import de.minaty.adventure.client.raeume.Raum;
import de.minaty.adventure.client.raeume.Stachus;
import de.minaty.adventure.client.spielakteure.Spieler;

public class Spielfeld {

	private static HashMap<Point, Raum> mapMitRäumenInDerSpielwelt = new HashMap<>();

	private static final Point MARIENPLATZ = new Point(1, 0);
	private static final Point STACHUS = new Point(0, 0);
	private static final Point KAPELLENSTRASSE = new Point(0, 1);
	private static final Point KELLER = new Point(0, 2);

	public static void initSpielfeld() {
		mapMitRäumenInDerSpielwelt.put(MARIENPLATZ, new Marienplatz("Marienplatz"));
		mapMitRäumenInDerSpielwelt.put(KELLER, new Keller("Keller"));
		mapMitRäumenInDerSpielwelt.put(STACHUS, new Stachus("Stachus"));
		mapMitRäumenInDerSpielwelt.put(KAPELLENSTRASSE, new Kapellenstraße("Kapellenstraße"));
	}

	public static Raum pruefePositionSpieler(Spieler spieler) {
		Point aktuelleSpielerPos = null;
		for (Point möglicheSpielerPos : Spielfeld.mapMitRäumenInDerSpielwelt.keySet()) {
			if (möglicheSpielerPos.equals(spieler.getPosition())) {
				aktuelleSpielerPos = möglicheSpielerPos;
			}
		}
		return Spielfeld.mapMitRäumenInDerSpielwelt.get(aktuelleSpielerPos);
	}
}
