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
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import module.garden.SectionConfiguration;

/**
 * @author nishant
 *
 */
public class SectionEditorController implements Initializable {
	
	private List<SectionConfiguration> sectionConfigList;
	private SectionConfiguration sectionConfig;
	private int sectionNumber;
	
	@FXML
	private Button SaveButton;
	
	@FXML
	private void ButtonSave(ActionEvent event) throws IOException {
		System.out.println("Save Clicked");
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartScreenView.fxml"));
		Parent root =  (Parent)fxmlLoader.load(); 
		
		StartScreenController controller = fxmlLoader.<StartScreenController>getController();
		controller.updateSectionConfiguration(sectionConfigList,sectionConfig,sectionNumber);
		
		Scene scene = new Scene(root);
		Stage stage = (Stage) this.SaveButton.getScene().getWindow();
		stage.setTitle("Garden Configuration");
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void setSectionConfiguration(List<SectionConfiguration> incomingList,SectionConfiguration incomingConfig, int secNumber) {
		
		this.sectionConfigList = incomingList;
		sectionConfig = new SectionConfiguration();
		this.sectionConfig = incomingConfig;
		this.sectionNumber = secNumber;
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
