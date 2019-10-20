package adventure.v1;

import java.awt.Point;
import java.util.HashMap;

import adventure.v1.räume.Kapellenstraße;
import adventure.v1.räume.Keller;
import adventure.v1.räume.Marienplatz;
import adventure.v1.räume.Raum;
import adventure.v1.räume.Stachus;

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
