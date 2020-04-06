package client;

import java.awt.Point;

public class Spielfigur {

	private String nameSpielfigur;
	private int staerke;
	private int attacke;
	private int parade;
	private String waffe;
	private Point spielerPosition;

	public String getNameSpielfigur() {
		return nameSpielfigur;
	}
	
	public void setNameSpielfigur(String nameSpielfigur) {
		this.nameSpielfigur = nameSpielfigur;
	}

	public void attackieren() {
	}

	public void parieren() {
	}

	public Spielfigur(Point spielerPosition) {
		this.spielerPosition = spielerPosition;
	}

	public Point getPosition() {
		return spielerPosition;
	}

	public String untersuchen() {
		return "Du siehst hier nix Besonderes";
	}

	public void nachNordenGehen(Point spielerPosition) {
		spielerPosition.y = Math.max(0, spielerPosition.y + 1);
		System.out.println("Du gehst nach Norden.");
	}

	public void nachSüdenGehen(Point spielerPosition) {
		spielerPosition.y = Math.min(4, spielerPosition.y - 1);
		System.out.println("Du gehst nach Süden.");
	}

	public void nachOstenGehen(Point spielerPosition) {
		spielerPosition.x = Math.max(0, spielerPosition.x + 1);
		System.out.println("Du gehst nach Osten.");
	}

	public void nachWestenGehen(Point spielerPosition) {
		spielerPosition.x = Math.min(4, spielerPosition.x - 1);
		System.out.println("Du gehst nach Westen.");
	}
}
