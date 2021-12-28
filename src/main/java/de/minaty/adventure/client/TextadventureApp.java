package de.minaty.adventure.client;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TextadventureApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		TextadventureController controller = TextadventureController.load();

		Parent root = controller.getRoot();
		Scene scene = new Scene(root);
		scene.getStylesheets().add("de/minaty/adventure/client/stylesheet.css");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Mein Zimmer");
	}

	public static void main(String[] args) {
		launch(args);
		System.out.println("javafx.runtime.version: " + System.getProperties().get("javafx.runtime.version")); // TODO
																												// löschen
	}
}
