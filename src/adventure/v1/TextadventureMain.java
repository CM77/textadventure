package adventure.v1;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TextadventureMain extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		TextadventureController controller = TextadventureController.load();
		
		Parent root = controller.getRoot();
	    Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	    primaryStage.setTitle("Mein Zimmer");
	}
	
	public static void main(String[] args)  {
		launch(args);
	}
}
