package de.minaty.adventure.client;

import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
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

	// TODO Factory Klasse für Button-Erzeugung bauen

	// TODO erkunden Button einbauen

	private Button nordButton = new Button("nach Norden gehen");
	private Button suedButton = new Button("nach Süden gehen");
	private Button ostButton = new Button("nach Osten gehen");
	private Button westButton = new Button("nach Westen gehen");
	private Button erkundungsButton = new Button();
	private List<Button> listeMitRaumAktionsButtons = new ArrayList<>(Arrays.asList());

	Spieler spieler = new Spieler(new Point(1, 0), 30, 10, 10);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Spielfeld.initSpielfeld();
		zeigeAufenthaltsraum();
	}

	private void zeigeAufenthaltsraum() {
		raumButton.setOnAction(e -> {
			textAreaUnten.setText(Spielfeld.pruefeAufenthaltsraumSpieler(spieler).getName());
			textAreaUnten.appendText("\n");
			textAreaUnten.appendText("\n");
			textAreaUnten
					.appendText("Du bist im Raum " + Spielfeld.pruefeAufenthaltsraumSpieler(spieler).getName() + ".");
			starteZugLogik();
			starteErkundungsLogik();
		});
	}

	private void starteZugLogik() {
		vboxOben.getChildren().clear();
		listeMitRaumAktionsButtons.clear();
		Spielfeld.ermittleDieNachbarraeume(spieler);
		Spielfeld.ermittleMoeglicheHimmelsrichtungen(spieler);
		fuegeZugbuttonsInListe();
		himmelsrichtungButtonsAuflisten();
		himmelsrichtungButtonsFuerBewegungsAktionScharfschalten();
	}

	private void starteErkundungsLogik() {
		listeMitRaumAktionsButtons.add(erkundenButtonBauen());
		erkundungsButtonAuflisten();
		erkundungsButtonScharfschalten();
	}

	private Button erkundenButtonBauen() {
		return Spielfeld.pruefeAufenthaltsraumSpieler(spieler).baueButton();
	}

	private void erkundungsButtonAuflisten() {
		erkundungsButton = listeMitRaumAktionsButtons.get(listeMitRaumAktionsButtons.size() - 1);
		erkundungsButton.getStyleClass().add("buttonAuswahlAktion");
		erkundungsButton.setAlignment(Pos.BASELINE_LEFT);
		vboxOben.getChildren().addAll(erkundungsButton);
		erkundungsButton.setMaxWidth(Double.MAX_VALUE);
		VBox.setVgrow(erkundungsButton, Priority.ALWAYS);
	}

	private void erkundungsButtonScharfschalten() {
		erkundungsButton.setOnAction(e -> {
			textAreaUnten.appendText("\n");
			textAreaUnten.appendText(Spielfeld.pruefeAufenthaltsraumSpieler(spieler).erkunden());
		});

	}

	private void fuegeZugbuttonsInListe() {
		for (Entry<Raum, Himmelsrichtung> entry : Spielfeld.getMapMitHimmelsrichtungen().entrySet()) {
			if (nordButton.getText().contains(entry.getValue().richtungName)) {
				listeMitRaumAktionsButtons.add(nordButton);
			}
			if (suedButton.getText().contains(entry.getValue().richtungName)) {
				listeMitRaumAktionsButtons.add(suedButton);
			}
			if (ostButton.getText().contains(entry.getValue().richtungName)) {
				listeMitRaumAktionsButtons.add(ostButton);
			}
			if (westButton.getText().contains(entry.getValue().richtungName)) {
				listeMitRaumAktionsButtons.add(westButton);
			}
		}
	}

	private void himmelsrichtungButtonsAuflisten() {
		for (Button button : listeMitRaumAktionsButtons) {
			button.getStyleClass().add("buttonAuswahlAktion");
			button.setAlignment(Pos.BASELINE_LEFT);
			vboxOben.getChildren().addAll(button);
			button.setMaxWidth(Double.MAX_VALUE);
			VBox.setVgrow(button, Priority.ALWAYS);
		}
	}

	private void himmelsrichtungButtonsFuerBewegungsAktionScharfschalten() {
		nordButton.setOnAction(e -> {
			textAreaUnten.appendText("\n");
			textAreaUnten.appendText(spieler.nachNordenBewegen());
		});
		suedButton.setOnAction(e -> {
			textAreaUnten.appendText("\n");
			textAreaUnten.appendText(spieler.nachSuedenBewegen());
		});
		ostButton.setOnAction(e -> {
			textAreaUnten.appendText("\n");
			textAreaUnten.appendText(spieler.nachOstenBewegen());
		});
		westButton.setOnAction(e -> {
			textAreaUnten.appendText("\n");
			textAreaUnten.appendText(spieler.nachWestenBewegen());
		});
	}

	public Parent getRoot() {
		return root;
	}
}
