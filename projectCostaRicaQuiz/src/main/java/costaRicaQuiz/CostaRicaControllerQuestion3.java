package costaRicaQuiz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import costaRicaQuizMain.CostaRicaQuizMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;

public class CostaRicaControllerQuestion3 implements Initializable {
	
	ObservableList<String> listDifferentMeanings = FXCollections.observableArrayList("Now", "Tomorrow", "Later"); 
		
	@FXML
	public BorderPane rootPane; 
	
	@FXML
	private ChoiceBox wordMeaning; 
	
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		wordMeaning.setValue("Later");
		wordMeaning.setItems(listDifferentMeanings);
	}
	
	
	@FXML
	private void playSound() { 

		AudioClip word = new AudioClip(this.getClass().getResource("/fxml/nagranie.wav").toString()); 
		word.play(); 
	}

	

	private void showSelected() {
		String option = wordMeaning.getValue().toString();
		System.out.println(option);
	}
	
	
	@FXML
	private void loadQuestion4(ActionEvent event) throws IOException {
		
		BorderPane question1pane = FXMLLoader.load(getClass().getResource("/fxml/Question4.fxml"));
		rootPane.getChildren().setAll(question1pane);
	
		String option = wordMeaning.getValue().toString();
		
		if (option.equals("Tomorrow")) { 			
			CostaRicaQuizMain.increaseScore();
		}
		
		System.out.println("Score: " + CostaRicaQuizMain.giveScore());
	}
}

