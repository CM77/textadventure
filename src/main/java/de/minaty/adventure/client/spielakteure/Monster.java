package de.minaty.adventure.client.spielakteure;

import java.awt.Point;

public abstract class Monster extends Spielfigur {

	Monster(Point position, int staerke, int attacke, int parade) {
		super(position, staerke, attacke, parade);
	}

}
