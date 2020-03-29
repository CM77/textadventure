package client;


import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

import client.räume.Marienplatz;
import client.räume.Raum;
import client.spielakteure.Spieler;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TextadventureController implements Initializable {

	public static TextadventureController load() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TextadventureController.class.getResource("Textadventure.fxml"));
		loader.load();
		return loader.getController();
	}

	private static Spielfeld spielfeld = new Spielfeld();

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
		spielfeld.initSpielfeld();
		Spieler spieler = new Spieler(new Point (1,0));
		
		raumButton.setOnAction(e -> {
			textAreaUnten.setText(pruefePositionSpieler(spieler).getNameDesSpielobjekts());
			neuenButtonErzeugen();
		    });
	}

	private void neuenButtonErzeugen() {
		Button button = new Button("My Button");
		button.setAlignment(Pos.BASELINE_LEFT);
		vboxOben.getChildren().addAll(button);
		button.setMaxWidth(Double.MAX_VALUE);
vboxOben.setVgrow(button, Priority.ALWAYS);
//TODO Buttons korrekten Funktionen zuweisen (z.B. Raum-Funktionen)
	}

	public Parent getRoot() {
		return root;
	}

	private static Raum pruefePositionSpieler(Spielfigur spielfigur) {
	Point aktuelleSpielerPos = null;	
		for (Point möglicheSpielerPos : spielfeld.mapMitRäumenInDerSpielwelt.keySet()) {
			if (möglicheSpielerPos.equals(spielfigur.getPosition())) {
				aktuelleSpielerPos = möglicheSpielerPos;
			}
		}
		return spielfeld.mapMitRäumenInDerSpielwelt.get(aktuelleSpielerPos);
	}

}
