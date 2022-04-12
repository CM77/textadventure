package de.minaty.adventure.client.gegenstaende.waffen;

public final class Samuraischwert extends Waffe {

	@Override
	public String untersuchen() {
		return "Es ist ein altes japanisches Samuraischwert und die extrem scharfe Klinge glänzt in der Sonne.";
	}

	@Override
	public String mitnehmen() {
		return "Das " + super.mitnehmen();
	}

}
