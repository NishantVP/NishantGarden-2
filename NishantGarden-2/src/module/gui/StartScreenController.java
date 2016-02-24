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
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class StartScreenController implements Initializable {
	
	
	@FXML
	private Label GardenStatus;
	@FXML
	private Label Instructions;
	@FXML
	private Button StartGarden;
	
	@FXML
	private void ButtonStartGarden(ActionEvent event) {
		System.out.println("New Garden Created");
		this.GardenStatus.setText("Congratulations ! Your new garden has been created");
	}
	
	@FXML
	private void ButtonEditSection1(ActionEvent event) throws IOException {
		System.out.println("Section 1 Edit Clicked");
		this.GardenStatus.setText("Editing Section 1");
		this.StartGarden.setDisable(true);
		
		Parent root;
		root = FXMLLoader.load(getClass().getResource("SectionEditorView.fxml")); //FXMLLoader.load(getClass().getClassLoader().getResource("path/to/other/view.fxml"), resources);
        Stage stage = (Stage) this.StartGarden.getScene().getWindow();//new Stage();
        stage.setTitle("Section Properties Editor");
        stage.setScene(new Scene(root));
        stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
