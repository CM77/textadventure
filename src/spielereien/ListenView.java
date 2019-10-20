package spielereien;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 

public class ListenView  extends Application {
	 
	public static void main(String[] args) {
	      launch(args);
	  }
	 
	  @Override
	  public void start(Stage primaryStage) {
	     
	      primaryStage.setTitle("http://java-buddy.blogspot.com/");
	     
	      final Label label = new Label("Selected: ");
	     
	      final ListView<String> listView = new ListView<>();
	      ObservableList<String> list =FXCollections.observableArrayList (
	              "Sunday",
	              "Monday",
	              "Tuesday",
	              "Wednesday",
	              "Thursday",
	              "Friday",
	              "Saturday");
	      listView.setItems(list);
	 
	      listView.setOnMouseClicked(new EventHandler<MouseEvent>(){
	 
	          @Override
	          public void handle(MouseEvent arg0) {
	             
	              label.setText("Selected: " +
	                  listView.getSelectionModel().getSelectedItems());
	          }
	 
	      });
	     
	      VBox vBox = new VBox();
	      vBox.getChildren().addAll(label, listView);
	     
	      StackPane root = new StackPane();
	      root.getChildren().add(vBox);
	      primaryStage.setScene(new Scene(root, 300, 250));
	      primaryStage.show();
	  }
	}
	

