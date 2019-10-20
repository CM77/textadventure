package consolen_adventure.v1;

public class Keller implements Raum {

	private boolean imKeller;
	private boolean monsterIstHier;

	// setter/getter
	public boolean getImKeller() {
		return imKeller;
	}

	public void setImKeller(boolean imKeller) {
		this.imKeller = imKeller;
	}

	public boolean getMonsterIstHier() {
		return monsterIstHier;
	}

	public void setMonsterIstHier(boolean monsterIstHier) {
		this.monsterIstHier = monsterIstHier;
	}

	// Konstruktor
	public Keller(boolean imKeller, boolean monsterIstHier) {
		this.setImKeller(imKeller);
		this.setMonsterIstHier(monsterIstHier);
	}

	public void zeigeRaum() {
		System.out.println("");
		System.out.println("-- Keller --");
		System.out.println("");
	}

	public void untersuchen() {
		System.out
				.println("Du bist in einem modrigen Keller aus Backstein-Gemäuer. Ein leiser Luftzug weht hier unten. "
						+ "Eine nackte Glühbirne taucht den Raum in fahles, gespenstisches Licht. Es ist verdächtig still.");
		if (monsterIstHier == true) {
			System.out.println(
					"Du meinst kurz, ein beunruhigendes Kratzen in deiner Nähe zu vernehmen. Als du genau hinhörst, "
							+ "spürst du dein Herz bis zum Halse schlagen.");
		}
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
