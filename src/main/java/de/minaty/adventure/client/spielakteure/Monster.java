package de.minaty.adventure.client.spielakteure;

import java.awt.Point;

public abstract class Monster extends Spielfigur {

	Monster(Point position, String name, int staerke, int attacke, int parade) {
		super(position, name, staerke, attacke, parade);
	}

}
