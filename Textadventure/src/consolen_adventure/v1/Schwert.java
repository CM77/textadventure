package consolen_adventure.v1;

public class Schwert extends Gegenstände {

	private boolean schwertDabei;

	// setter/getter
	public boolean getSchwertDabei() {
		return schwertDabei;
	}

	public void setSchwertDabei(boolean schwertDabei) {
		this.schwertDabei = schwertDabei;
	}

	// Konstruktor
	public Schwert(boolean schwertDabei) {
		this.schwertDabei = schwertDabei;
	}

}
