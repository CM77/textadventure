package de.minaty.adventure.client;

import java.awt.Point;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.minaty.adventure.client.gegenstaende.Gegenstand;
import de.minaty.adventure.client.gegenstaende.alltagsgegenstaende.Apfel;
import de.minaty.adventure.client.gegenstaende.waffen.Samuraischwert;
import de.minaty.adventure.client.raeume.Kapellenstraße;
import de.minaty.adventure.client.raeume.Keller;
import de.minaty.adventure.client.raeume.Marienplatz;
import de.minaty.adventure.client.raeume.Raum;
import de.minaty.adventure.client.raeume.Stachus;
import de.minaty.adventure.client.raeume.Wendeltreppe;
import de.minaty.adventure.client.spielakteure.Spieler;

public class Spielfeld {

	// TODO nicht lieber Position gleich in jeweiligen Raum konkret festschreiben
	// anstatt vom Spielfeld auszulesen?

	private static Spielfeld instance;

	private Spielfeld() {
	}

	public static Spielfeld getInstance() {
		if (instance == null) {
			instance = new Spielfeld();
		}
		return instance;
	}

	private final Point MARIENPLATZ = new Point(1, 0);
	private final Point STACHUS = new Point(0, 0);
	private final Point KAPELLENSTRASSE = new Point(0, 1);
	private final Point WENDELTREPPE = new Point(0, 2);
	private final Point KELLER = new Point(0, 3);

	private Samuraischwert samuraischwert = new Samuraischwert(STACHUS, "Samuraischwert", 10, 10);
	private Apfel gruenerApfel = new Apfel(KELLER, "grüner Apfel", 1);
	private Apfel roterApfel = new Apfel(STACHUS, "roter Apfel", 1);

	private HashMap<Point, Raum> mapAllerRaeumeInDerSpielwelt = new HashMap<>();
	private HashMap<Point, Raum> mapAllerAktuellenNachbarraeume = new HashMap<>();
	private HashMap<Raum, Himmelsrichtung> mapMoeglicherHimmelsrichtungen = new HashMap<>();
	private Set<Gegenstand> setMitAllenGegenstaenden = new HashSet<Gegenstand>();
	private Set<Gegenstand> setMitGegenstaendenAktuellerRaum = new HashSet<Gegenstand>();
	private Set<Method> setMitGegenstandAktionen = new HashSet<Method>();
	private List<Gegenstand> listeMitGegenstaendenImRucksack = new ArrayList<Gegenstand>();
	private Set<Method> setMitRucksackGegenstandAktionen = new HashSet<Method>();

	// Räume

	public HashMap<Point, Raum> getMapAllerRaeumeInDerSpielwelt() {
		return mapAllerRaeumeInDerSpielwelt;
	}

	public HashMap<Point, Raum> getMapAllerAktuellenNachbarraeume() {
		return mapAllerAktuellenNachbarraeume;
	}

	public HashMap<Raum, Himmelsrichtung> getMapMoeglicherHimmelsrichtungen() {
		return mapMoeglicherHimmelsrichtungen;
	}

	// Gegenstände

	public Samuraischwert getSamuraischwert() {
		return samuraischwert;
	}

	public void setSamuraischwert(Samuraischwert samuraischwert) {
		this.samuraischwert = samuraischwert;
	}

	public Apfel getApfel() {
		return gruenerApfel;
	}

	public void setApfel(Apfel apfel) {
		this.gruenerApfel = apfel;
	}

	// Gegenstände im Raum

	public Set<Gegenstand> getSetMitGegenstaendenAktuellerRaum() {
		return setMitGegenstaendenAktuellerRaum;
	}

	public Set<Method> getSetMitGegenstandAktionen() {
		return setMitGegenstandAktionen;
	}

	// Gegenstände im Rucksack

	public List<Gegenstand> getListeMitGegenstaendenImRucksack() {
		return listeMitGegenstaendenImRucksack;
	}

	public void setListeMitGegenstaendenImRucksack(List<Gegenstand> setMitGegenstaendenImRucksack) {
		this.listeMitGegenstaendenImRucksack = setMitGegenstaendenImRucksack;
	}

	public Set<Method> getSetMitRucksackGegenstandAktionen() {
		return setMitRucksackGegenstandAktionen;
	}

	public void initSpielfeld() {
		mapAllerRaeumeInDerSpielwelt.put(MARIENPLATZ, new Marienplatz(MARIENPLATZ, "Marienplatz"));
		mapAllerRaeumeInDerSpielwelt.put(KELLER, new Keller(KELLER, "Keller"));
		mapAllerRaeumeInDerSpielwelt.put(STACHUS, new Stachus(STACHUS, "Stachus"));
		mapAllerRaeumeInDerSpielwelt.put(WENDELTREPPE, new Wendeltreppe(WENDELTREPPE, "Wendeltreppe"));
		mapAllerRaeumeInDerSpielwelt.put(KAPELLENSTRASSE, new Kapellenstraße(KAPELLENSTRASSE, "Kapellenstraße"));
	}

	public Raum ermittleAufenthaltsraumSpieler(Spieler spieler) {
		Raum aufenthaltsraumSpieler = null;
		for (HashMap.Entry<Point, Raum> entry : mapAllerRaeumeInDerSpielwelt.entrySet()) {
			if (spieler.getPosition().equals(entry.getKey())) {
				aufenthaltsraumSpieler = entry.getValue();
			}
		}
		return aufenthaltsraumSpieler;
	}

	public HashMap<Point, Raum> ermittleDieNachbarraeume(Spieler spieler) {
		mapAllerAktuellenNachbarraeume.clear();
		for (HashMap.Entry<Point, Raum> entry : mapAllerRaeumeInDerSpielwelt.entrySet()) {
			if (entry.getKey().distance(spieler.getPosition()) == 1) {
				mapAllerAktuellenNachbarraeume.put(entry.getKey(), entry.getValue());
			}
		}
		return mapAllerAktuellenNachbarraeume;
	}

	public void ermittleMoeglicheHimmelsrichtungen(Spieler spieler) {
		mapMoeglicherHimmelsrichtungen.clear();
		for (HashMap.Entry<Point, Raum> entry : mapAllerAktuellenNachbarraeume.entrySet()) {
			if (entry.getKey().y == spieler.getPosition().y + 1) {
				mapMoeglicherHimmelsrichtungen.put(entry.getValue(), Himmelsrichtung.NORDEN);
			}
			if (entry.getKey().y == spieler.getPosition().y - 1) {
				mapMoeglicherHimmelsrichtungen.put(entry.getValue(), Himmelsrichtung.SUEDEN);
			}
			if (entry.getKey().x == spieler.getPosition().x + 1) {
				mapMoeglicherHimmelsrichtungen.put(entry.getValue(), Himmelsrichtung.OSTEN);
			}
			if (entry.getKey().x == spieler.getPosition().x - 1) {
				mapMoeglicherHimmelsrichtungen.put(entry.getValue(), Himmelsrichtung.WESTEN);
			}
		}
	}

	public Set<Gegenstand> befuelleSetMitAllenGegenstaenden() {
		setMitAllenGegenstaenden.add(gruenerApfel);
		setMitAllenGegenstaenden.add(roterApfel);
		setMitAllenGegenstaenden.add(samuraischwert);
		return setMitAllenGegenstaenden;
	}

	public Set<Gegenstand> befuelleSetMitGegenstaendenAktuellerRaum(Spieler spieler) {
		setMitGegenstaendenAktuellerRaum.clear();
		for (Gegenstand gegenstand : setMitAllenGegenstaenden) {
			if (gegenstand.getPosition().equals(spieler.getPosition())) {
				setMitGegenstaendenAktuellerRaum.add(gegenstand);
				if (gegenstand.isMitgenommen()) {
					setMitGegenstaendenAktuellerRaum.remove(gegenstand);
				}
			}
		}
		return setMitGegenstaendenAktuellerRaum;
	}

	public Set<Method> befuelleSetMitGegenstandAktionen(Gegenstand gegenstand) {
		setMitGegenstandAktionen.clear();
		for (Method methode : gegenstand.getClass().getDeclaredMethods()) {
			setMitGegenstandAktionen.add(methode);
		}
		return setMitGegenstandAktionen;
	}

	public void gegenstandMitnehmen(Gegenstand gegenstand) {
		listeMitGegenstaendenImRucksack.add(gegenstand);
	}

	public Set<Method> befuelleSetMitGegenstandImRucksackAktionen(Gegenstand g) {
		setMitRucksackGegenstandAktionen.clear();
		for (Method methode : g.getClass().getDeclaredMethods()) {
			setMitRucksackGegenstandAktionen.add(methode);
		}
		return setMitRucksackGegenstandAktionen;
	}
}
