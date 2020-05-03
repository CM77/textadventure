package de.minaty.adventure.client;


public abstract class Spielobjekt {

	private String nameDesSpielobjekts;

	public Spielobjekt(String nameDesSpielobjekts){
		this.nameDesSpielobjekts = nameDesSpielobjekts;
	}
	
	public String getNameDesSpielobjekts() {
		return nameDesSpielobjekts;
	}
	
	public abstract String untersuchen(); 
	
	public abstract boolean benutzbarBei (Spielobjekt objekt);
}
