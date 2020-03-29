package client;


import java.awt.Point;
import java.util.HashMap;

import client.räume.Kapellenstraße;
import client.räume.Keller;
import client.räume.Marienplatz;
import client.räume.Raum;
import client.räume.Stachus;

public class Spielfeld {

	HashMap<Point, Raum> mapMitRäumenInDerSpielwelt = new HashMap<>();

	final public Point MARIENPLATZ = new Point(1, 0);
	final public Point STACHUS = new Point(0, 0);
	final public Point KAPELLENSTRASSE = new Point(0, 1);
	final public Point KELLER = new Point(0, 2);
	
	public void initSpielfeld() {
		mapMitRäumenInDerSpielwelt.put(MARIENPLATZ, new Marienplatz("Marienplatz"));
		mapMitRäumenInDerSpielwelt.put(KELLER, new Keller("Keller"));
		mapMitRäumenInDerSpielwelt.put(STACHUS, new Stachus("Stachus"));
		mapMitRäumenInDerSpielwelt.put(KAPELLENSTRASSE, new Kapellenstraße("Kapellenstraße"));
	}
}
