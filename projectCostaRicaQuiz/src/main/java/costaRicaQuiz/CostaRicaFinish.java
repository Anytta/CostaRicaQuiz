package costaRicaQuiz;

import java.io.IOException;
import costaRicaQuizMain.CostaRicaQuizMain;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CostaRicaFinish  {
	
	static boolean answer; 
	
	@FXML
	public static BorderPane rootPane; 
	

	private void loadFirstPage() throws IOException{
	
		BorderPane question1pane = FXMLLoader.load(getClass().getResource("/fxml/BorderPaneWindow.fxml"));
		rootPane.getChildren().setAll(question1pane);
	}
	

	public static boolean display(String title, String message) {
		
		Stage window = new Stage(); 
		window.setTitle("End of the quiz");
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinWidth(400);
		window.setMinHeight(400);
		window.setOnCloseRequest(e -> Platform.exit()); 
	
		Label label = new Label(); 
		Label finalMessage = new Label(); 
		label.setText(message);
	
			if (CostaRicaQuizMain.giveScore() <= 3) {
				finalMessage.setText("Your knowledge is basic " + "\n" + " Your score is " + CostaRicaQuizMain.giveScore());
			} else {
				finalMessage.setText("You have done great! " + "\n" +"Your score is " + CostaRicaQuizMain.giveScore());
			}
	
		Button buttonYes = new Button("Yes");
		Button buttonNo = new Button("No");
	
			buttonYes.setOnAction( e -> {
			answer = true; 
			window.close(); 
			});

			buttonNo.setOnAction( e -> {
			answer = false; 
			window.close();
			Platform.exit(); 
			});
	
		VBox layout = new VBox(10); 
		layout.getChildren().addAll( finalMessage, label, buttonYes, buttonNo);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	
	return answer; 
	}


}