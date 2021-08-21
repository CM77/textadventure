package de.minaty.adventure.client.spielakteure;

import java.awt.Point;

public final class Oger extends Monster {

	public Oger(Point position, String name, int staerke, int attacke, int parade) {
		super(position, name, staerke, attacke, parade);
	}

	public String anschauen() {
		return "Der Oger ist 2 Meter groß, trägt einen Lendenschurz, hat eine grünliche Haut und guckt echt grimmig.";
	}

	@Override
	public String nachNordenBewegen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nachSuedenBewegen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nachOstenBewegen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nachWestenBewegen() {
		// TODO Auto-generated method stub
		return null;
	}

}
