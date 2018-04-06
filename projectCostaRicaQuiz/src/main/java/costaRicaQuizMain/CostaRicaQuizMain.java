package costaRicaQuizMain;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class CostaRicaQuizMain extends Application {

	public static int score; 
	

public static void main(String[] args) {
		
		launch(args); 
}
	
	public static void resetScore() {		
		
		score = 0; 
	}
	
	public static int giveScore() {
	
		return score; 	
	}
	
	public static void increaseScore() {
		
		score ++; 
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/BorderPaneWindow.fxml")); 		
		primaryStage.setTitle("Costa Rica Quiz");
		primaryStage.setScene(new Scene(root, 600, 500));
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}

}
