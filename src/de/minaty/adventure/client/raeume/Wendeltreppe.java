package de.minaty.adventure.client.raeume;

public final class Wendeltreppe extends Raum {

	Wendeltreppe(String nameDesSpielobjekts) {
		super(nameDesSpielobjekts);
	}

	@Override
	public String erkunden() {
		return "In unzählig wirkenden Stufen geht es hinab in unbekannte Tiefen. "
				+ "Fackeln säumen die aus grobem Stein gehauenen Wände. ";
	}
}
