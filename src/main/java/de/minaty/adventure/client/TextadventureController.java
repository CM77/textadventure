package de.minaty.adventure.client;

import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.minaty.adventure.client.raeume.Raum;
import de.minaty.adventure.client.spielakteure.Spieler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TextadventureController implements Initializable {

	public static TextadventureController load() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TextadventureController.class.getResource("Textadventure.fxml"));
		loader.load();
		return loader.getController();
	}

	@FXML
	private Parent root;
	@FXML
	private Button raumButton;
	@FXML
	private Button gegenstaendeButton;
	@FXML
	private Button rucksackButton;
	@FXML
	private VBox vboxOben;
	@FXML
	private TextArea textAreaUnten;

	private boolean raumButtonBereitsErzeugt = false;

	// TODO Methode für individuellen Spielernamen und Zufallszahl bei Stärke,
	// Attacke und Parade
	Spieler spieler = new Spieler(new Point(1, 0), 30, 10, 10);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Spielfeld.initSpielfeld();
		zeigeAufenthaltsraum();
		zeigeZugmoeglichtenInNachbarraeume();
	}

	private void zeigeAufenthaltsraum() {
		textAreaUnten.setText(Spielfeld.pruefeObPositionSpielerMitPositionRaumUebereinstimmt(spieler).getName());
		textAreaUnten.appendText("\n");
		textAreaUnten.appendText("\n");
		// TODO "im Raum" durch ne Art Status Formatter allgemeiner halten"
		textAreaUnten.appendText("Du bist im Raum "
				+ Spielfeld.pruefeObPositionSpielerMitPositionRaumUebereinstimmt(spieler).getName() + ".");
	}

	private void zeigeZugmoeglichtenInNachbarraeume() {
		raumButton.setOnAction(e -> {
			Spielfeld.ermittleDieNachbarraeumeUmAktuellenAufenthaltsraum(spieler);
			if (raumButtonBereitsErzeugt) {
				zeigeAufenthaltsraum();
			} else {
				for (Raum raum : Spielfeld.getAktuelleNachbarraeume()) {
					neuenButtonErzeugen(raum.getName());
				}
				raumButtonBereitsErzeugt = true;
			}
		});
	}

	private void neuenButtonErzeugen(String buttonBeschriftung) {
		Button buttonAuswahlAktion = new Button(buttonBeschriftung);
		buttonAuswahlAktion.getStyleClass().add("buttonAuswahlAktion");
		buttonAuswahlAktion.setAlignment(Pos.BASELINE_LEFT);
		vboxOben.getChildren().addAll(buttonAuswahlAktion);
		buttonAuswahlAktion.setMaxWidth(Double.MAX_VALUE);
		VBox.setVgrow(buttonAuswahlAktion, Priority.ALWAYS);
	}

	public Parent getRoot() {
		return root;
	}

}
