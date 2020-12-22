package de.minaty.adventure.client;

import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import de.minaty.adventure.client.gegenstaende.Gegenstand;
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

	private Button nordButton = new Button("nach Norden gehen");
	private Button suedButton = new Button("nach Süden gehen");
	private Button ostButton = new Button("nach Osten gehen");
	private Button westButton = new Button("nach Westen gehen");
	private Button erkundungsButton = new Button();
	private List<Button> listeMitRaumAktionsButtons = new ArrayList<>(Arrays.asList());
	private List<Button> listeMitGegenstandAktionsButtons = new ArrayList<>(Arrays.asList());

	Spieler spieler = new Spieler(new Point(1, 0), "spieler", 30, 10, 10);
	Spielfeld spielfeld = new Spielfeld();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		spielfeld.initSpielfeld();
		zeigeAufenthaltsraumAktionen();

		// TODO Logik entwickeln, dass nur Gegenstände im spezifischen Raum angezeigt
		// werden und nicht wie jetzt in jedem Raum
		spielfeld.initGegenstaende();
		zeigeGegenstandButtonAktionen();
	}

	private void zeigeAufenthaltsraumAktionen() {
		raumButton.setOnAction(e -> {
			textAreaUnten.setText(spielfeld.ermittleAufenthaltsraumSpieler(spieler).getName());
			textAreaUnten.appendText("\n");
			textAreaUnten.appendText("\n");
			textAreaUnten
					.appendText("Du bist im Raum " + spielfeld.ermittleAufenthaltsraumSpieler(spieler).getName() + ".");
			starteZugLogik();
			starteErkundungsLogik();
		});
	}

	private void starteZugLogik() {
		vboxOben.getChildren().clear();
		listeMitRaumAktionsButtons.clear();
		spielfeld.ermittleDieNachbarraeume(spieler);
		spielfeld.ermittleMoeglicheHimmelsrichtungen(spieler);
		fuegeZugbuttonsInListe();
		himmelsrichtungButtonsAuflisten();
		himmelsrichtungButtonsAktivieren();
	}

	private void starteErkundungsLogik() {
		erkundungsButton.setText(spielfeld.ermittleAufenthaltsraumSpieler(spieler).getName() + " erkunden");
		buttonMitStyleVersehenUndEinhaengen(erkundungsButton);
		erkundungsButtonAktivieren();
	}

	private void fuegeZugbuttonsInListe() {
		for (Entry<Raum, Himmelsrichtung> entry : spielfeld.getMapMoeglicherHimmelsrichtungen().entrySet()) {
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
			buttonMitStyleVersehenUndEinhaengen(button);
		}
	}

	private void himmelsrichtungButtonsAktivieren() {
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

	private void erkundungsButtonAktivieren() {
		erkundungsButton.setOnAction(e -> {
			textAreaUnten.appendText("\n");
			textAreaUnten.appendText(spielfeld.ermittleAufenthaltsraumSpieler(spieler).erkunden());
		});
	}

	private void buttonMitStyleVersehenUndEinhaengen(Button button) {
		button.getStyleClass().add("buttonAuswahlAktion");
		button.setAlignment(Pos.BASELINE_LEFT);
		vboxOben.getChildren().addAll(button);
		button.setMaxWidth(Double.MAX_VALUE);
		VBox.setVgrow(button, Priority.ALWAYS);
	}

	private void fuegeGegenstandbuttonsInListe() {
		for (Gegenstand g : spielfeld.getSetMitAllenGegenstaenden()) {
			listeMitGegenstandAktionsButtons.add(new Button(g.getName()));
		}
	}

	private void gegenstandButtonsAuflisten() {
		for (Button button : listeMitGegenstandAktionsButtons) {
			buttonMitStyleVersehenUndEinhaengen(button);
		}
	}

	private void zeigeGegenstandButtonAktionen() {
		gegenstaendeButton.setOnAction(e -> {
			listeMitGegenstandAktionsButtons.clear();
			textAreaUnten.setText(spielfeld.ermittleAufenthaltsraumSpieler(spieler).getName());
			textAreaUnten.appendText("\n");
			textAreaUnten.appendText("\n");
			textAreaUnten
					.appendText("Du bist im Raum " + spielfeld.ermittleAufenthaltsraumSpieler(spieler).getName() + ".");
			vboxOben.getChildren().clear();
			fuegeGegenstandbuttonsInListe();
			gegenstandButtonsAuflisten();
		});
	}

	public Parent getRoot() {
		return root;
	}
}
