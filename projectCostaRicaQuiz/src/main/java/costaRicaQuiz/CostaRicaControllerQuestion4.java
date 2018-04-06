package costaRicaQuiz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import costaRicaQuizMain.CostaRicaQuizMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class CostaRicaControllerQuestion4  implements Initializable  {

	@FXML
	public BorderPane rootPane; 
	
	@FXML
	public TextField altitude; 
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	private void loadNewPage() throws IOException{
		BorderPane question1pane = FXMLLoader.load(getClass().getResource("/fxml/Question5.fxml"));
		rootPane.getChildren().setAll(question1pane);
	}
	
	@FXML
	private void loadQuestion5(ActionEvent event) throws IOException {
		
		isCorrectNumber(altitude);
	}
		 
	
	public void isCorrectNumber(TextField input) throws IOException  {
			
		try {
			int inputAltitude = Integer.parseInt(input.getText());
				   
				if (inputAltitude < 0) {
					CostaRicaAlertBox.display("It is not a correct number", "Please enter a positive number");	
					}			
				if (inputAltitude == 3820 ) {	
					CostaRicaQuizMain.increaseScore();
					}
				if (inputAltitude > 0) {
					loadNewPage();
					}
					
				System.out.println("Score: " + CostaRicaQuizMain.giveScore());
			}
			
		catch (NumberFormatException e) {
			CostaRicaAlertBox.display("It is not a correct number", "Please no letters. Only a number smaller than 2147483647");	
			}
	}
}
