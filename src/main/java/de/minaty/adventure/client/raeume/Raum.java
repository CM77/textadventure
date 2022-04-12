package de.minaty.adventure.client.raeume;

import java.awt.Point;

import javax.annotation.Nullable;

import de.minaty.adventure.client.spielakteure.Spielobjekt;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "raum")
public class Raum extends Spielobjekt implements Erkundbar {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "x_wert", nullable = false)
	private int xWert;

	@Column(name = "y_wert", nullable = false)
	private int yWert;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "beschaffenheit")
	private @Nullable String beschaffenheit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public Point getPosition() {
		return new Point(xWert, yWert); // TODO die Umwandlung int -> Point in Dto-Factoryklasse auslagern, sobald
										// vorhanden
	}

	@Override
	public void setPosition(Point position) { // TODO Umwandlung DtoFactory s.o.
		this.xWert = position.x;
		this.yWert = position.y;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public @Nullable String erkunden() {
		return beschaffenheit;
	}

	@Override
	public String toString() {
		return "Raum [id=" + id + ", xWert=" + xWert + ", yWert=" + yWert + ", name=" + name + ", beschaffenheit="
				+ beschaffenheit + "]";
	}
}
