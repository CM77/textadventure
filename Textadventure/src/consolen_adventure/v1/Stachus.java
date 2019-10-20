package consolen_adventure.v1;

public class Stachus implements Raum {

	private boolean imStachus;

	// setter/getter
	public boolean getImStachus() {
		return imStachus;
	}

	public void setImStachus(boolean imStachus) {
		this.imStachus = imStachus;
	}

	// Konstruktor
	public Stachus(boolean imStachus) {
		this.setImStachus(imStachus);
	}

	public void zeigeRaum() {
		System.out.println("");
		System.out.println("-- Stachus --");
		System.out.println("");
	}

	public void untersuchen() {

		System.out.println(
				"Du bist auf dem Stachus. Vor dir ist der große Stachus-Brunnen, hinter dir McDonalds und das Stachus-Tor.");
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
