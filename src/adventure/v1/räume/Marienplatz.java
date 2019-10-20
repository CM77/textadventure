package adventure.v1.räume;

import adventure.v1.Spielobjekt;

public class Marienplatz extends Raum {
	
	public Marienplatz(String nameDesSpielobjekts) {		
		super(nameDesSpielobjekts);
	}

	@Override
	public String untersuchen() {
		return "Das ist der Marienplatz. Viele Touristen knipsen Fotos und warten auf das Glockenspiel im Rathaus.";
	}

	@Override
	public boolean benutzbarBei(Spielobjekt objekt) {
		// TODO konkrete Gegenstände hier rein, die im Raum etwas bewirken
		return false;
	}

	
}
