package client;

import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import client.spielakteure.Spieler;
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
//	@FXML
//	private TextArea textAreaOben;
	@FXML
	private VBox vboxOben;
	@FXML
	private TextArea textAreaUnten;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Spielfeld spielfeld = new Spielfeld();
		spielfeld.initSpielfeld();
		Spieler spieler = new Spieler(new Point(1, 0));

		raumButton.setOnAction(e -> {
			textAreaUnten.setText(spielfeld.pruefePositionSpieler(spieler).getNameDesSpielobjekts());
			neuenButtonErzeugen();
		});
	}

	private void neuenButtonErzeugen() {
		Button buttonAuswahlAktion = new Button("button-auswahl");
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
