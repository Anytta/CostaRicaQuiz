package costaRicaQuiz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class CostaRicaControllerStart implements Initializable{

	@FXML
	public BorderPane rootPane; 
	
	@FXML
	public ImageView imageview;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Image image = new Image("/obrazy/plaza.jpg"); 
		imageview.setImage(image);
	}
	
	@FXML
	private void loadQuestion1(ActionEvent event) throws IOException {
		
		BorderPane question1pane = FXMLLoader.load(getClass().getResource("/fxml/Question1.fxml"));
		rootPane.getChildren().setAll(question1pane);
		
	}
}
