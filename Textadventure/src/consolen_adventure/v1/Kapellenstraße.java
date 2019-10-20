package consolen_adventure.v1;

public class Kapellenstraße implements Raum {

	private boolean inDerKapellenstraße;

	// setter/getter
	public boolean getInDerKapellenstraße() {
		return inDerKapellenstraße;
	}

	public void setInDerKapellenstraße(boolean inDerKapellenstraße) {
		this.inDerKapellenstraße = inDerKapellenstraße;
	}

	// Konstruktor
	public Kapellenstraße(boolean inDerKapellenstraße) {
		this.setInDerKapellenstraße(inDerKapellenstraße);
	}

	public void zeigeRaum() {
		System.out.println("");
		System.out.println("-- Kapellenstraße --");
		System.out.println("");
	}

	public void untersuchen() {
		System.out.println(
				"Du bist in der Kapellenstraße. Außer ist dir ist hier niemand und die Straße wirkt fast wie ausgestorben.\n"
						+ "Du hast fast ein bisschen Angst. Ob du vielleicht deine Oma um Beistand anrufen sollst?");
	}

	public void nachNordenGehen() {
		System.out.println("Du gehst nach Norden.");
	}

	public void nachSüdenGehen() {
		System.out.println("Du gehst nach Süden.");
	}

	public void nachOstenGehen() {
		System.out.println("Du gehst nach Osten.");
	}

	public void nachWestenGehen() {
		System.out.println("Du gehst nach Westen.");
	}
}
