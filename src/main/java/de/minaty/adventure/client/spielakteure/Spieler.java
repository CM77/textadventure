package de.minaty.adventure.client.spielakteure;

import java.awt.Point;

public final class Spieler extends Spielfigur implements Bewegbar {

	// TODO Interface Waffe für Spieler und Monster

	public Spieler(Point position, String name, int staerke, int attacke, int parade) {
		super(position, name, staerke, attacke, parade);
	}

	public String anschauen() {
		return "Du schaust dich selber an, aber irgendwie siehst du nur deine Hände, deine Hose und deine Schuhe. Ein Spiegel verrät vielleicht mehr über dein (hoffentlich) Top-Model-haftes Aussehen.";
	}

	@Override
	public String nachNordenBewegen() {
		position.y = Math.max(0, position.y + 1);
		return "Du gehst nach Norden.";
	}

	@Override
	public String nachSuedenBewegen() {
		position.y = Math.min(4, position.y - 1);
		return "Du gehst nach Süden.";
	}

	@Override
	public String nachOstenBewegen() {
		position.x = Math.max(0, position.x + 1);
		return "Du gehst nach Osten.";
	}

	@Override
	public String nachWestenBewegen() {
		position.x = Math.min(4, position.x - 1);
		return "Du gehst nach Westen.";
	}
}
