package de.minaty.adventure.client.raeume;

public final class Marienplatz extends Raum {

	public Marienplatz(String nameDesSpielobjekts) {
		super(nameDesSpielobjekts);
	}

	@Override
	public String erkunden() {
		return "Viele Touristen knipsen Fotos und warten auf das Glockenspiel im Rathaus.";
	}

}
