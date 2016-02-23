/**
 * COEN 275 OOAD - Individual Project
 * Automated Gardening System
 * 
 * By Nishant Phatangare (W1108022)
 */

/*
 * --About this <file>--
 * 
 */
package module.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class StartScreenController implements Initializable {
	
	@FXML
	private Label GardenStatus;
	
	@FXML
	private void clickedButtonStartGarden(ActionEvent event) {
		System.out.println("New Garden Created");
		GardenStatus.setText("Congratulations ! Your new garden has been created");
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
