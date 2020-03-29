package client.räume;

import client.Spielobjekt;

public class Wendeltreppe extends Raum {
	
Wendeltreppe(String nameDesSpielobjekts) {
		super(nameDesSpielobjekts);
	}

@Override
	public String untersuchen() {
		return "In unzählig wirkenden Stufen geht es hinab in unbekannte Tiefen. "
				+ "Fackeln säumen die aus grobem Stein gehauenen Wände. ";
	}

@Override
public boolean benutzbarBei(Spielobjekt objekt) {
	// TODO konkrete Gegenstände hier rein, die im Raum etwas bewirken
	return false;
}

}
