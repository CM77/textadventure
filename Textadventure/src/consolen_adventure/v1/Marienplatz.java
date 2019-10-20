package consolen_adventure.v1;

public class Marienplatz implements Raum {

	private boolean imMarienplatz;

	// setter/getter
	public boolean getImMarienplatz() {
		return imMarienplatz;
	}

	public void setImMarienplatz(boolean imMarienplatz) {
		this.imMarienplatz = imMarienplatz;
	}

	// Konstruktor
	public Marienplatz(boolean imMarienplatz) {
		this.setImMarienplatz(imMarienplatz);
	}

	// vom Interface Raum implementierte abstrakte Methoden
	public void zeigeRaum() {
		System.out.println("");
		System.out.println("-- Marienplatz --");
		System.out.println("");
	}

	public void untersuchen() {
		System.out.println(
				"Das ist der Marienplatz. Viele Touristen knipsen Fotos und warten auf das Glockenspiel im Rathaus.");
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
