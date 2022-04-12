package de.minaty.adventure.client;

import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import de.minaty.adventure.client.spielakteure.Spieler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
	private MenuItem spielBeenden;
	@FXML
	private VBox aktionsOptionenVb;
	@FXML
	private Button raumButton;
	@FXML
	private Button gegenstandButton;
	@FXML
	private Button rucksackButton;
	@FXML
	private TextArea textausgabeTa; // TODO TextFlow für variable Schriftgröße etc?s
									// www.tutorialspoint.com/javafx/layout_panes_textflow.htm
	@FXML
	private TextField aufenthaltsraumTf;

	private Button erkundungsButton = new Button();
	private Button nordButton = new Button("nach Norden gehen");
	private Button suedButton = new Button("nach Süden gehen");
	private Button ostButton = new Button("nach Osten gehen");
	private Button westButton = new Button("nach Westen gehen");

	private List<Button> listeMitRaumAktionsButtons = new ArrayList<>(Arrays.asList());

	Spieler spieler = new Spieler();
	Spielfeld spielfeld = Spielfeld.getInstance();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		spieler.setPosition(new Point(0, 0)); // TODO
		spielfeld.initSpielfeld();
		zeigeOptionenAufenthaltsraum();
		starteMenueSetup();
		starteTastenEventHandler();
		aufenthaltsraumTf.getStyleClass().add("aufenthaltsraumTf");
	}

	// Menüsteuerung

	private void starteMenueSetup() {
		spielBeenden.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setHeaderText("Spiel wirklich beenden?");
				ButtonType btJa = new ButtonType("Ja");
				ButtonType btAbbruch = new ButtonType("Abbrechen", ButtonData.CANCEL_CLOSE);
				alert.getButtonTypes().setAll(btJa, btAbbruch);
				Optional<ButtonType> result = alert.showAndWait();

				if (result.get() == btJa) {
					System.exit(0);
				}
			}
		});
	}

	// Spielersteuerung

	// TODO in eigene Klasse auslagern

	private void starteTastenEventHandler() {
		root.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case UP:
					// TODO elegantere Lösung für Prüfung für illegalen Zug finden, sonsonsten
					// falsche Ausgabe ("Du gehst nach Norden" erscheint im Label, obgleich Zug
					// sofort rückgängig gemacht wird!
					spieler.nachNordenBewegen();
					if (spielfeld.ermittleAufenthaltsraumSpieler(spieler) == null) {
						spieler.nachSuedenBewegen();
					}
					textausgabe("Du gehst nach Norden.");
					break;
				case DOWN:
					spieler.nachSuedenBewegen();
					if (spielfeld.ermittleAufenthaltsraumSpieler(spieler) == null) {
						spieler.nachNordenBewegen();
					}
					textausgabe("Du gehst nach Süden.");
					break;
				case LEFT:
					spieler.nachWestenBewegen();
					if (spielfeld.ermittleAufenthaltsraumSpieler(spieler) == null) {
						spieler.nachOstenBewegen();
					}
					textausgabe("Du gehst nach Osten.");
					break;
				case RIGHT:
					spieler.nachOstenBewegen();
					if (spielfeld.ermittleAufenthaltsraumSpieler(spieler) == null) {
						spieler.nachWestenBewegen();
					}
					textausgabe("Du gehst nach Westen.");
					break;
				default:
					break;
				}
			}
		});
	}

	// TODO vor dem ersten Zug wirkt Leerzeile vor dem Aufenthaltsraum merkwürdig.
	// Dort könnte Intro-Text rein?
	private void textausgabe(String ausgabe) {
		zeigeAufenthaltsraum();
		textausgabeTa.appendText( //
				"\n" //
						+ "\n" //
						+ "-- " + spielfeld.ermittleAufenthaltsraumSpieler(spieler).getName() + " --" + "\n" //
						+ "\n" //
						+ ausgabe);
	}

	// TODO muss aktueller Ort noch im Label ausgegeben werden? Siehe laufende
	// Orts-Aktualisierung im textausgabeTa. Label evtl für andere wichtige Werte
	// wie Lebensenergie, Zeit etc. nutzen?
	private void zeigeAufenthaltsraum() {
		aufenthaltsraumTf.setText("Du bist hier: " //
				+ spielfeld.ermittleAufenthaltsraumSpieler(spieler).getName());
	}

	private void zeigeOptionenAufenthaltsraum() {
		raumButton.setOnAction(e -> {
			starteZugLogik();
			starteErkundungsLogik();
			zeigeAufenthaltsraum();
		});
	}

	// TODO Zug soll sofort Optionen in vBoxOben aktualisieren und nicht erst bei
	// Klick auf "Raum"!
	private void starteZugLogik() {
		aktionsOptionenVb.getChildren().clear();
		listeMitRaumAktionsButtons.clear();
		spielfeld.ermittleDieNachbarraeume(spieler);
		spielfeld.ermittleMoeglicheHimmelsrichtungen(spieler);
		fuegeZugbuttonsInListe();
		himmelsrichtungButtonsVorbereiten();
		himmelsrichtungButtonsAktivieren();
	}

	private void fuegeZugbuttonsInListe() {
		switch (spielfeld.ermittleMoeglicheHimmelsrichtungen(spieler)) {
		case NORDEN: {
			listeMitRaumAktionsButtons.add(nordButton);
			break;
		}
		case SUEDEN: {
			listeMitRaumAktionsButtons.add(suedButton);
			break;
		}
		case WESTEN: {
			listeMitRaumAktionsButtons.add(westButton);
			break;
		}
		case OSTEN: {
			listeMitRaumAktionsButtons.add(ostButton);
			break;
		}
		}
	}

	private void himmelsrichtungButtonsVorbereiten() {
		for (Button button : listeMitRaumAktionsButtons) {
			buttonMitStyleVersehenUndEinhaengen(button);
		}
	}

	private void himmelsrichtungButtonsAktivieren() {
		nordButton.setOnAction(e -> {
			textausgabe(spieler.nachNordenBewegen());
		});
		suedButton.setOnAction(e -> {
			textausgabe(spieler.nachSuedenBewegen());
		});
		ostButton.setOnAction(e -> {
			textausgabe(spieler.nachOstenBewegen());
		});
		westButton.setOnAction(e -> {
			textausgabe(spieler.nachWestenBewegen());
		});
	}

	private void starteErkundungsLogik() {
		erkundungsButton.setText(spielfeld.ermittleAufenthaltsraumSpieler(spieler).getName() + " erkunden");
		buttonMitStyleVersehenUndEinhaengen(erkundungsButton);
		erkundungsButtonAktivieren();
	}

	private void erkundungsButtonAktivieren() {
		erkundungsButton.setOnAction(e -> {
			textausgabe(spielfeld.ermittleAufenthaltsraumSpieler(spieler).erkunden());
		});
	}

	private void buttonMitStyleVersehenUndEinhaengen(Button button) {
		button.getStyleClass().add("buttonAuswahlAktion");
		button.setAlignment(Pos.BASELINE_LEFT);
		aktionsOptionenVb.getChildren().addAll(button);
		button.setMaxWidth(Double.MAX_VALUE);
		VBox.setVgrow(button, Priority.ALWAYS);
	}

	public Parent getRoot() {
		return root;
	}
}
