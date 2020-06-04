package de.minaty.adventure.client.raeume;

public final class Keller extends Raum {

	public Keller(String nameDesSpielobjekts) {
		super(nameDesSpielobjekts);
	}

	@Override
	public String erkunden() {
		return "Du bist in einem modrigen Keller aus Backstein-Gemäuer. Ein leiser Luftzug weht hier unten. "
				+ "Eine nackte Glühbirne taucht den Raum in fahles, gespenstisches Licht. Es ist verdächtig still.";
	}

}
