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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import module.garden.SectionConfiguration;

public class StartScreenController implements Initializable {
	
	private List<SectionConfiguration> sectionConfigList;
	
	private SectionConfiguration section1Config,section2Config,section3Config;
	private SectionConfiguration section4Config,section5Config,section6Config;
	
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
	
	public void setSectionConfigList( List<SectionConfiguration> incomingList) {
		this.sectionConfigList = incomingList;
		
		section1Config = new SectionConfiguration();
		section2Config = new SectionConfiguration();
		section3Config = new SectionConfiguration();
		section4Config = new SectionConfiguration();
		section5Config = new SectionConfiguration();
		section6Config = new SectionConfiguration();
		
		section1Config = sectionConfigList.get(0);
		section2Config = sectionConfigList.get(1);
		section3Config = sectionConfigList.get(2);
		section4Config = sectionConfigList.get(3);
		section5Config = sectionConfigList.get(4);
		section6Config = sectionConfigList.get(5);
		
		//System.out.println(section1Config.getPlantType());
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// this.GardenStatus.setText("Welcome");
		
	}

}
