package client.räume;

import client.Spielobjekt;

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
		// TODO Auto-generated method stub
		return false;
	}

}
