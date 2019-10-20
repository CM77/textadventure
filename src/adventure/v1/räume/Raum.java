package adventure.v1.räume;

import adventure.v1.Spielobjekt;

public abstract class Raum extends Spielobjekt {

	Raum(String nameDesSpielobjekts) {
		super(nameDesSpielobjekts);
	}
	
	public String getNameDesRaums() {
		return super.getNameDesSpielobjekts();
	}

	public abstract String untersuchen();
}
