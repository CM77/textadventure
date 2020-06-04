package de.minaty.adventure.client.spielakteure;

import java.awt.Point;

public final class Spieler extends Spielfigur implements Bewegbar {

	// TODO Interface Waffe für Spieler und Monster

	public Spieler(Point position, int staerke, int attacke, int parade) {
		super(position, staerke, attacke, parade);
	}

	@Override
	public String anschauen() {
		return "Du schaust dich selber an, aber irgendwie siehst du nur deine Hände, deine Hose und deine Schuhe. Ein Spiegel verrät vielleicht mehr über dein (hoffentlich) Top-Model-haftes Aussehen.";
	}

	@Override
	public String nachNordenBewegen(Point spielerPosition) {
		return "Du gehst nach Norden.";
	}

	@Override
	public String nachSüdenBewegen(Point spielerPosition) {
		return "Du gehst nach Süden.";
	}

	@Override
	public String nachOstenBewegen(Point spielerPosition) {
		return "Du gehst nach Osten.";
	}

	@Override
	public String nachWestenBewegen(Point spielerPosition) {
		return "Du gehst nach Westen.";
	}
}
