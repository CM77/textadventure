package consolen_adventure.v1;

public class Wendeltreppe implements Raum {

	private boolean aufDerWendeltreppe;

	// setter/getter
	public boolean getAufDerWendeltreppe() {
		return aufDerWendeltreppe;
	}

	public void setAufDerWendeltreppe(boolean aufDerWendeltreppe) {
		this.aufDerWendeltreppe = aufDerWendeltreppe;
	}

	// Konstruktor
	public Wendeltreppe(boolean aufDerWendeltreppe) {
		this.aufDerWendeltreppe = aufDerWendeltreppe;
	}
	

	public void zeigeRaum() {
		System.out.println("");
		System.out.println("-- Wendeltreppe --");
		System.out.println("");
	}

	public void untersuchen() {
		System.out.println("In unzählig wirkenden Stufen geht es hinab in unbekannte Tiefen. "
				+ "Fackeln säumen die aus grobem Stein gehauenen Wände. ");
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
