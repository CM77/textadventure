package de.minaty.adventure.client.spielakteure;

import java.awt.Point;

public final class Spieler extends Spielfigur {

	// TODO Interface Waffe für Spieler und Monster

	public Spieler(String name, Point position, int staerke, int attacke, int parade) {
		super(name, position, staerke, attacke, parade);
	}

	public String nachNordenGehen(Point spielerPosition) {
		spielerPosition.y = Math.max(0, spielerPosition.y + 1);
		return "Du gehst nach Norden.";
	}

	public String nachSüdenGehen(Point spielerPosition) {
		spielerPosition.y = Math.min(4, spielerPosition.y - 1);
		return "Du gehst nach Süden.";
	}

	public String nachOstenGehen(Point spielerPosition) {
		spielerPosition.x = Math.max(0, spielerPosition.x + 1);
		return "Du gehst nach Osten.";
	}

	public String nachWestenGehen(Point spielerPosition) {
		spielerPosition.x = Math.min(4, spielerPosition.x - 1);
		return "Du gehst nach Westen.";
	}
}
