package costaRicaQuiz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import costaRicaQuizMain.CostaRicaQuizMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;

public class CostaRicaControllerQuestion1 implements Initializable {

	@FXML
	public BorderPane rootPane; 
	
	@FXML
	public CheckBox sanJuan;
	
	@FXML
	public CheckBox sanJose;
	
	@FXML
	public CheckBox liberia;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
			
		System.out.println(CostaRicaQuizMain.giveScore());
	}
	
	@FXML
	private void loadQuestion2(ActionEvent event) throws IOException {
		
		if ((sanJose.isSelected() == false) && (sanJuan.isSelected() == false) && (liberia.isSelected() == false)) {
			CostaRicaAlertBox.display("title", "Please choose one option"); 
		} else {
			BorderPane question1pane = FXMLLoader.load(getClass().getResource("/fxml/Question2.fxml"));
			rootPane.getChildren().setAll(question1pane);
		
				if (sanJose.isSelected()){
					CostaRicaQuizMain.increaseScore();
				}
				
			System.out.println("Score: " + CostaRicaQuizMain.giveScore());
		}
	}
	
	@FXML
	private void handleSanJuan() {
		if (sanJuan.isSelected()) {
			sanJose.setSelected(false);
			liberia.setSelected(false);
		}
	}
	
	@FXML
	private void handleSanJose() {
		if (sanJose.isSelected()) {
			sanJuan.setSelected(false);
			liberia.setSelected(false);
		}
	}
	
	@FXML
	private void handleLiberia() {
		if (liberia.isSelected()) {
			sanJose.setSelected(false);
			sanJuan.setSelected(false);
		}
	}
	
		
}
