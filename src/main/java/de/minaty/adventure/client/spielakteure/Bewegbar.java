package de.minaty.adventure.client.spielakteure;

import java.awt.Point;

public interface Bewegbar {

	public abstract String nachNordenBewegen(Point position);

	public abstract String nachSüdenBewegen(Point position);

	public abstract String nachOstenBewegen(Point position);

	public abstract String nachWestenBewegen(Point position);
}
