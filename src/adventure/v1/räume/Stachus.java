package adventure.v1.räume;

import adventure.v1.Spielobjekt;

public class Stachus extends Raum {

	public Stachus(String nameDesSpielobjekts) {
		super(nameDesSpielobjekts);
	}

	@Override
	public String untersuchen() {
		return "Der große Springbrunnen spritzt unablässig Wasserfontänen in die Luft. Du siehst"
				+ "das Karlstor vor dir.";
	}

	@Override
	public boolean benutzbarBei(Spielobjekt objekt) {
		// TODO konkrete Gegenstände hier rein, die im Raum etwas bewirken
		return false;
	}

}
