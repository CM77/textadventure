package de.minaty.adventure.client;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;
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

	private final Point MARIENPLATZ = new Point(1, 0);
	private final Point STACHUS = new Point(0, 0);
	private final Point KAPELLENSTRASSE = new Point(0, 1);
	private final Point WENDELTREPPE = new Point(0, 2);
	private final Point KELLER = new Point(0, 3);

	private Samuraischwert samuraischwert = new Samuraischwert(STACHUS, "Samuraischwert", 10, 10);
	private Apfel gruenerApfel = new Apfel(KELLER, "grüner Apfel", 1);
	private Apfel roterApfel = new Apfel(STACHUS, "roter Apfel", 1);

	private Point aktuelleSpielerPosition;
	private HashMap<Point, Raum> mapAllerRaeumeInDerSpielwelt = new HashMap<>();
	private HashMap<Point, Raum> mapAllerAktuellenNachbarraeume = new HashMap<>();
	private HashMap<Raum, Himmelsrichtung> mapMoeglicherHimmelsrichtungen = new HashMap<>();
	private Set<Gegenstand> setMitAllenGegenstaenden = new HashSet<Gegenstand>();
	private Set<Gegenstand> setMitGegenstaendenAktuellerRaum = new HashSet<Gegenstand>();
	private Set<Method> setMitGegenstandAktionen = new HashSet<Method>();

	public Point getMARIENPLATZ() {
		return MARIENPLATZ;
	}

	public Point getSTACHUS() {
		return STACHUS;
	}

	public Point getKAPELLENSTRASSE() {
		return KAPELLENSTRASSE;
	}

	public Point getWENDELTREPPE() {
		return WENDELTREPPE;
	}

	public Point getKELLER() {
		return KELLER;
	}

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

	public Point getAktuelleSpielerPosition() {
		return aktuelleSpielerPosition;
	}

	public void setAktuelleSpielerPosition(Point aktuelleSpielerPosition) {
		this.aktuelleSpielerPosition = aktuelleSpielerPosition;
	}

	public HashMap<Point, Raum> getMapAllerRaeumeInDerSpielwelt() {
		return mapAllerRaeumeInDerSpielwelt;
	}

	public void setMapAllerRaeumeInDerSpielwelt(HashMap<Point, Raum> mapAllerRaeumeInDerSpielwelt) {
		this.mapAllerRaeumeInDerSpielwelt = mapAllerRaeumeInDerSpielwelt;
	}

	public HashMap<Point, Raum> getMapAllerAktuellenNachbarraeume() {
		return mapAllerAktuellenNachbarraeume;
	}

	public void setMapAllerAktuellenNachbarraeume(HashMap<Point, Raum> mapAllerAktuellenNachbarraeume) {
		this.mapAllerAktuellenNachbarraeume = mapAllerAktuellenNachbarraeume;
	}

	public HashMap<Raum, Himmelsrichtung> getMapMoeglicherHimmelsrichtungen() {
		return mapMoeglicherHimmelsrichtungen;
	}

	public void setMapMoeglicherHimmelsrichtungen(HashMap<Raum, Himmelsrichtung> mapMoeglicherHimmelsrichtungen) {
		this.mapMoeglicherHimmelsrichtungen = mapMoeglicherHimmelsrichtungen;
	}

	public Set<Gegenstand> getSetMitAllenGegenstaenden() {
		return setMitAllenGegenstaenden;
	}

	public void setSetMitAllenGegenstaenden(Set<Gegenstand> setMitAllenGegenstaenden) {
		this.setMitAllenGegenstaenden = setMitAllenGegenstaenden;
	}

	public Set<Gegenstand> getSetMitGegenstaendenAktuellerRaum() {
		return setMitGegenstaendenAktuellerRaum;
	}

	public void setSetMitGegenstaendenAktuellerRaum(Set<Gegenstand> setMitAllenGegenstaendenAktuellerRaum) {
		this.setMitGegenstaendenAktuellerRaum = setMitAllenGegenstaendenAktuellerRaum;
	}

	public Set<Method> getSetMitGegenstandAktionen() {
		return setMitGegenstandAktionen;
	}

	public void setSetMitGegenstandAktionen(Set<Method> setMitGegenstandAktionen) {
		this.setMitGegenstandAktionen = setMitGegenstandAktionen;
	}

	public void initSpielfeld() {
		mapAllerRaeumeInDerSpielwelt.put(MARIENPLATZ, new Marienplatz("Marienplatz"));
		mapAllerRaeumeInDerSpielwelt.put(KELLER, new Keller("Keller"));
		mapAllerRaeumeInDerSpielwelt.put(STACHUS, new Stachus("Stachus"));
		mapAllerRaeumeInDerSpielwelt.put(WENDELTREPPE, new Wendeltreppe("Wendeltreppe"));
		mapAllerRaeumeInDerSpielwelt.put(KAPELLENSTRASSE, new Kapellenstraße("Kapellenstraße"));
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

	// Menüsteuerung

	public void schreibeProperties(Spieler spieler) {
		Properties props = new Properties();
		props.setProperty("userPositionX", String.valueOf(spieler.getPosition().x));
		props.setProperty("userPositionY", String.valueOf(spieler.getPosition().y));

		try {
			FileOutputStream fos = new FileOutputStream("TextAdPropsDatei.txt");
			props.store(fos, "");
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
