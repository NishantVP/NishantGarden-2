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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author nishant
 *
 */
public class SectionEditorController implements Initializable {
	
	@FXML
	private Button SaveButton;
	
	@FXML
	private void ButtonSave(ActionEvent event) throws IOException {
		System.out.println("Save Clicked");
		
		Parent root;
		root = FXMLLoader.load(getClass().getResource("StartScreenView.fxml")); 
        Stage stage = (Stage) this.SaveButton.getScene().getWindow();//new Stage();
        stage.setTitle("Garden Configuration");
        stage.setScene(new Scene(root));
        stage.show();
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
