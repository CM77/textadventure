package client;

import java.awt.Point;

public class Spielfigur {

	private String nameSpielfigur;
//  TODO Eigenschaften ausfeilen
//  private int staerke;
//	private int attacke;
//	private int parade;
//	private String waffe;
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
