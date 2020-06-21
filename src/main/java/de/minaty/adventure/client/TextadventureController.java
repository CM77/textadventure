package de.minaty.adventure.client;

import java.awt.Point;
import java.awt.TextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.minaty.adventure.client.spielakteure.Spieler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
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

	// TODO Methode für individuellen Spielernamen und Zufallszahl bei Stärke,
	// Attacke und Parade
	Spieler spieler = new Spieler(new Point(1, 0), 30, 10, 10);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Spielfeld.initSpielfeld();

//		raumButton.setOnAction(e -> {
//			textAreaUnten.setText(Spielfeld.pruefePositionSpieler(spieler).getNameDesSpielobjekts());
//			neuenButtonErzeugen();
//		});
		zeigeRaumUndBewegungsmöglichkeitenAn();
	}

	private void zeigeRaumUndBewegungsmöglichkeitenAn() {
		raumButton.setOnAction(e -> {
			textAreaUnten.setText(Spielfeld.pruefeObPositionSpielerMitPositionRaumUebereinstimmt(spieler).getName());
			neuenButtonErzeugen();
		});
	}

	private void neuenButtonErzeugen() {
		String buttonBeschriftung = "";
		Button buttonAuswahlAktion = new Button(buttonBeschriftung);
		buttonAuswahlAktion.getStyleClass().add("buttonAuswahlAktion");
		buttonAuswahlAktion.setAlignment(Pos.BASELINE_LEFT);
		vboxOben.getChildren().addAll(buttonAuswahlAktion);
		buttonAuswahlAktion.setMaxWidth(Double.MAX_VALUE);
		VBox.setVgrow(buttonAuswahlAktion, Priority.ALWAYS);

//TODO Methode entwickeln, die - angepasst auf die jeweiligen Ebene (Raum, Gegenstände, Rucksack), 
		// in die der User geklickt hat - entsprechenden Aktionen als Buttons anzeigt

	}

	public Parent getRoot() {
		return root;
	}

}
