package de.minaty.adventure.client.spielakteure;

import java.awt.Point;

public abstract class Monster extends Spielfigur {

	Monster(String name, Point position, int staerke, int attacke, int parade) {
		super(name, position, staerke, attacke, parade);
	}

}
