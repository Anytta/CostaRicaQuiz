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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class CostaRicaControllerQuestion2 implements Initializable {

	@FXML
	public BorderPane rootPane; 
	
	@FXML
	public CheckBox Olingo;
	
	@FXML
	public CheckBox Coati;
	
	@FXML
	public CheckBox Racun;
	
	@FXML
	public ImageView imageview;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
			
		Image image = new Image("/obrazy/zwierze.jpg"); 
		imageview.setImage(image);
	}
	
	@FXML
	private void loadQuestion3(ActionEvent event) throws IOException {
		
		if ((Olingo.isSelected() == false) && (Coati.isSelected() == false) && (Racun.isSelected() == false)) {
			CostaRicaAlertBox.display("tytul", "Please choose one option"); 
		} else {
			BorderPane question1pane = FXMLLoader.load(getClass().getResource("/fxml/Question3.fxml"));
			rootPane.getChildren().setAll(question1pane);
		 }
		
			if (Coati.isSelected()) { 
				CostaRicaQuizMain.increaseScore();
			}
			
		System.out.println("Wynik po drugim pytaniu: " + CostaRicaQuizMain.giveScore());	
	}
	
	@FXML
	private void handleOlingo() {
		if (Olingo.isSelected()) {
			Coati.setSelected(false);
			Racun.setSelected(false);
		}
	}
	
	@FXML
	private void handleCoati() {
		if (Coati.isSelected()) {
			Olingo.setSelected(false);
			Racun.setSelected(false);
		}
	}
	
	@FXML
	private void handleRacun() {
		if (Racun.isSelected()) {
			Coati.setSelected(false);
			Olingo.setSelected(false);
		}
	}
}

