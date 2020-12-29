package de.minaty.adventure.client;

import java.awt.Point;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
	private Button gegenstandButton;
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
	private List<Button> listeMitGegenstandButtons = new ArrayList<>(Arrays.asList());
	private List<Button> listeMitGegenstandAktionenButtons = new ArrayList<>(Arrays.asList());
	private Gegenstand aktuellerGegenstand;
	private Button aktuellerGegenstandButton = new Button();

	Spieler spieler = new Spieler(new Point(1, 0), "spieler", 30, 10, 10);
	Spielfeld spielfeld = new Spielfeld();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		spielfeld.initSpielfeld();
		zeigeAufenthaltsraumAktionen();
		spielfeld.befuelleSetMitAllenGegenstaenden();
		zeigeGegenstaende();
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
		himmelsrichtungButtonsVorbereiten();
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

	private void himmelsrichtungButtonsVorbereiten() {
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

	private void zeigeGegenstaende() {
		gegenstandButton.setOnAction(e -> {
			textAreaUnten.setText(spielfeld.ermittleAufenthaltsraumSpieler(spieler).getName());
			textAreaUnten.appendText("\n");
			starteGegenstandsLogik();
		});
	}

	private void starteGegenstandsLogik() {
		vboxOben.getChildren().clear();
		listeMitGegenstandButtons.clear();
		fuegeGegenstandButtonsInListe();
		gegenstandButtonsVorbereiten();
		gegenstandButtonsAktivieren();
	}

	private void fuegeGegenstandButtonsInListe() {
		spielfeld.befuelleSetMitGegenstaendenAktuellerRaum(spieler);
		for (Gegenstand gegenstand : spielfeld.getSetMitGegenstaendenAktuellerRaum()) {
			listeMitGegenstandButtons.add(new Button(gegenstand.getName()));
		}
	}

	private void gegenstandButtonsVorbereiten() {
		for (Button button : listeMitGegenstandButtons) {
			buttonMitStyleVersehenUndEinhaengen(button);
		}
	}

	private void gegenstandButtonsAktivieren() {
		for (Button button : listeMitGegenstandButtons) {
			button.setOnAction(e -> {
				textAreaUnten.appendText("\n");
				aktuellerGegenstandButton = button;
				starteGegenstandAktionenLogik();
			});
		}
	}

	private void starteGegenstandAktionenLogik() {
		vboxOben.getChildren().clear();
		fuegeGegenstandAktionenButtonsInListe();
		gegenstandAktionenButtonsVorbereiten();
		gegenstandAktionenButtonsAktivieren();
		listeMitGegenstandAktionenButtons.clear();
	}

	private void fuegeGegenstandAktionenButtonsInListe() {
		for (Gegenstand gegenstand : spielfeld.getSetMitGegenstaendenAktuellerRaum()) {
			if (aktuellerGegenstandButton.getText().equalsIgnoreCase(gegenstand.getName())) {
				spielfeld.befuelleSetMitGegenstandAktionen(gegenstand);
				aktuellerGegenstand = gegenstand;
				for (Method m : spielfeld.getSetMitGegenstandAktionen()) {
					listeMitGegenstandAktionenButtons.add(new Button(m.getName()));
				}
			}
		}
	}

	private void gegenstandAktionenButtonsVorbereiten() {
		for (Button button : listeMitGegenstandAktionenButtons) {
			buttonMitStyleVersehenUndEinhaengen(button);
		}
	}

	private void gegenstandAktionenButtonsAktivieren() {
		for (Button button : listeMitGegenstandAktionenButtons) {
			button.setOnAction(e -> {
				textAreaUnten.appendText("\n");
				for (Method methode : spielfeld.getSetMitGegenstandAktionen()) {
					if (button.getText().equals(methode.getName())) {
						try {
							methode = aktuellerGegenstand.getClass().getDeclaredMethod(methode.getName());
							methode.setAccessible(true);
							textAreaUnten.appendText(methode.invoke(aktuellerGegenstand).toString());
						} catch (NoSuchMethodException | SecurityException | IllegalAccessException
								| IllegalArgumentException | InvocationTargetException excep) {
							// TODO Excep-Message
							System.err.println("Opala, somethign went wrong here!");
						}
					}
				}
			});
		}
	}

	private void buttonMitStyleVersehenUndEinhaengen(Button button) {
		button.getStyleClass().add("buttonAuswahlAktion");
		button.setAlignment(Pos.BASELINE_LEFT);
		vboxOben.getChildren().addAll(button);
		button.setMaxWidth(Double.MAX_VALUE);
		VBox.setVgrow(button, Priority.ALWAYS);
	}

	public Parent getRoot() {
		return root;
	}
}
