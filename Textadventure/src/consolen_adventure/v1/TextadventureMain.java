package consolen_adventure.v1;

import java.io.IOException;
import java.util.Scanner;

public class TextadventureMain {

	// Das Spielfeld des Abenteuers
	
	final static int X = '5';
	final static int Y = '5';
	final static char RAUM = 'R';
	final static char KEINRAUM = 'K';
	final static int MAXRAUM = 10;

	static void init(char[][] feld, boolean raumGefunden[]) {
        // Spielfeld vorbereiten
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                feld[i][j] = '+';
            }
        }
	}   

	// Ausgabe, wenn eine Himmelsrichtung nicht in einen Raum führt
	static void keinDurchgang() {
		System.out.println("In dieser Richtung geht's nicht weiter.");

	}

	// Ausgabe, wenn nix zu untersuchen ist
	static void nichtsZuFinden() {
		System.out.println("Weitergehen! Hier gibt es nix zu sehen.");
	}

	public static void main(String[] args) throws IOException {

		System.out.println("Textadventure");
		System.out.println();

		// alle Räume mit Konstruktor für Aufenthaltsort des Spielers (mit boolean)
		Stachus stachus = new Stachus(true); // Start-Raum, daher true
		Marienplatz marienplatz = new Marienplatz(false);
		Kapellenstraße kapellenstraße = new Kapellenstraße(false);
		Wendeltreppe wendeltreppe = new Wendeltreppe(false);
		Keller keller = new Keller(false, true); // 2. Parameter für Monster anwesend

		// Gegenstände
		Schwert schwert = new Schwert(false);

		Scanner scanner = new Scanner(System.in);
		boolean eingabe = true;

		while (eingabe) {
			System.out.println();
			System.out.print("> ");

			String s = scanner.next();

			switch (s) {

			case ("Ende"):
				eingabe = false;
				System.out.println("Bye...");
				scanner.close();
				break;

			// Test, ob Raumlogik nicht kürzer geht als s.u.

//			case ("w"):
//				Spielwelt.prüfeRaum();

			case ("untersuchen"):
				System.out.println();
				if (stachus.getImStachus() == true) {
					stachus.zeigeRaum();
					stachus.untersuchen();
				} else if (marienplatz.getImMarienplatz() == true) {
					marienplatz.zeigeRaum();
					marienplatz.untersuchen();
				} else if (kapellenstraße.getInDerKapellenstraße() == true) {
					kapellenstraße.zeigeRaum();
					kapellenstraße.untersuchen();
				} else if (wendeltreppe.getAufDerWendeltreppe() == true) {
					wendeltreppe.zeigeRaum();
					wendeltreppe.untersuchen();
				} else if (keller.getImKeller() == true) {
					keller.zeigeRaum();
					keller.untersuchen();
				} else {
					nichtsZuFinden();
				}

				break;

			// Bewegungen zu anderen Räumen
			case ("Osten"):
				System.out.println();
				if (stachus.getImStachus() == true) {
					stachus.zeigeRaum();
					stachus.nachOstenGehen();
					stachus.setImStachus(false);
					marienplatz.setImMarienplatz(true);
					marienplatz.zeigeRaum();
				} else if (kapellenstraße.getInDerKapellenstraße() == true) {
					kapellenstraße.zeigeRaum();
					kapellenstraße.nachOstenGehen();
					kapellenstraße.setInDerKapellenstraße(false);
					wendeltreppe.setAufDerWendeltreppe(true);
					wendeltreppe.zeigeRaum();
				} else if (wendeltreppe.getAufDerWendeltreppe() == true) {
					wendeltreppe.zeigeRaum();
					wendeltreppe.nachOstenGehen();
					wendeltreppe.setAufDerWendeltreppe(false);
					keller.setImKeller(true);
					keller.zeigeRaum();
				} else {
					keinDurchgang();
				}
				break;

			case ("Westen"):
				System.out.println();
				if (marienplatz.getImMarienplatz() == true) {
					marienplatz.zeigeRaum();
					marienplatz.nachOstenGehen();
					marienplatz.setImMarienplatz(false);
					stachus.setImStachus(true);
					stachus.zeigeRaum();
				} else if (keller.getImKeller() == true && keller.getMonsterIstHier() == false) {
					keller.zeigeRaum();
					keller.nachWestenGehen();
					keller.setImKeller(false);
					kapellenstraße.setInDerKapellenstraße(true);
					kapellenstraße.zeigeRaum();
				} else if (kapellenstraße.getInDerKapellenstraße() == true) {
					kapellenstraße.zeigeRaum();
					kapellenstraße.nachWestenGehen();
					kapellenstraße.setInDerKapellenstraße(false);
					stachus.setImStachus(true);
					stachus.zeigeRaum();
				} else if (wendeltreppe.getAufDerWendeltreppe() == true) {
					wendeltreppe.zeigeRaum();
					wendeltreppe.nachWestenGehen();
					wendeltreppe.setAufDerWendeltreppe(false);
					kapellenstraße.setInDerKapellenstraße(true);
					kapellenstraße.zeigeRaum();
				} else {
					keinDurchgang();
				}
				break;

			case ("Norden"):
				System.out.println();
				if (stachus.getImStachus() == true) {
					stachus.zeigeRaum();
					stachus.nachNordenGehen();
					stachus.setImStachus(false);
					kapellenstraße.setInDerKapellenstraße(true);
					kapellenstraße.zeigeRaum();
				} else if (marienplatz.getImMarienplatz() == true) {
					marienplatz.zeigeRaum();
					marienplatz.nachOstenGehen();
					marienplatz.setImMarienplatz(false);
					kapellenstraße.setInDerKapellenstraße(true);
					kapellenstraße.zeigeRaum();
				} else {
					keinDurchgang();
				}
				break;

			case ("Süden"):
				System.out.println();
				if (keller.getImKeller() == true && keller.getMonsterIstHier() == false) {
					keller.zeigeRaum();
					keller.nachSüdenGehen();
					keller.setImKeller(false);
					wendeltreppe.setAufDerWendeltreppe(true);
					wendeltreppe.zeigeRaum();
				} else if (wendeltreppe.getAufDerWendeltreppe() == true) {
					wendeltreppe.zeigeRaum();
					wendeltreppe.nachSüdenGehen();
					wendeltreppe.setAufDerWendeltreppe(false);
					kapellenstraße.setInDerKapellenstraße(true);
					kapellenstraße.zeigeRaum();
				} else if (kapellenstraße.getInDerKapellenstraße() == true) {
					kapellenstraße.zeigeRaum();
					kapellenstraße.nachSüdenGehen();
					kapellenstraße.setInDerKapellenstraße(false);
					stachus.setImStachus(true);
					stachus.zeigeRaum();
				} else {
					keinDurchgang();
				}
				break;

			default:
				System.out.println("Was genau willst du tun? " + s
						+ " klingt jetzt n bisschen arg merkwürdig. Hast du überhaupt mal ne Schule von innen gesehen?");
				break;
			}
		}
	}
}
