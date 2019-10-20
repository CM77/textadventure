package spielereien;

import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class TextfeldKlickMain extends Application {
	
	@Override
	public void start(Stage primaryStage) {

	    TextFlow textFlow = new TextFlow();
	    textFlow.setOnMouseClicked(ev -> {
	        if(ev.getTarget() instanceof Text) {
	            Text clicked = (Text) ev.getTarget();
	            System.out.println(clicked);
	        }
	    });

	    IntStream.range(0, 500).mapToObj(Integer::toString).map(Text::new).forEach(textFlow.getChildren()::add);

	    BorderPane borderpane = new BorderPane(textFlow);
	    borderpane.setPadding(new Insets(20));

	    Scene scene = new Scene(borderpane, 400, 400);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	public static void main(String[] args)  {
		launch(args);
	}
	
}
