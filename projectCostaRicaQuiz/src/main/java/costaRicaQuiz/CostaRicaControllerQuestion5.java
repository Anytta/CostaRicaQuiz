package costaRicaQuiz;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import costaRicaQuizMain.CostaRicaQuizMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

public class CostaRicaControllerQuestion5 implements Initializable {

	@FXML
	public BorderPane rootPane; 
	
	@FXML
	public DatePicker calendar; 

	
	final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
	               
		 @Override
	     public DateCell call(final DatePicker kalendarz) {
	           return new DateCell() {
	                        
	           @Override
	             public void updateItem(LocalDate item, boolean empty) {
	        	   super.updateItem(item, empty);
	                  if(item.isAfter(LocalDate.now())) {
	        	         setDisable(true);
	        	      }
	              }
	            };
	      }
	 };
	        

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		calendar.setDayCellFactory(dayCellFactory);	
	}
	
	@FXML
	private void loadLastPage(ActionEvent event) throws IOException {
		
		try {
			LocalDate gettedDatePickerDate = calendar.getValue();
			String chosenDate = gettedDatePickerDate.toString(); 
		
				if (chosenDate.equals("1821-09-15")) {
					CostaRicaQuizMain.increaseScore();
					playAgain();
				}
				if (calendar.getValue().isAfter(LocalDate.now())) {
					CostaRicaAlertBox.display("Future date", "Please enter a date form the past ");
				
				} else if (chosenDate.equals("1821-09-15")== false) {
			        playAgain();} 
		}	
		
		catch (NullPointerException e) {
			
			CostaRicaAlertBox.display("It is not a valid date", "Please enter a date in format dd.mm.yyyy "); 
			}	
		
		System.out.println("Score: " + CostaRicaQuizMain.giveScore());
	}	
		
	
	public void playAgain() throws IOException {
	    	
	    	CostaRicaFinish.display("title", "Do you want to play again?"); 
			
	    	if ( CostaRicaFinish.answer ==  true)  {
				BorderPane question1pane = FXMLLoader.load(getClass().getResource("/fxml/BorderPaneWindow.fxml"));
				rootPane.getChildren().setAll(question1pane);
				CostaRicaQuizMain.resetScore(); 
			   }
	}
}

