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
	
	@FXML private Label GardenStatus;
	@FXML private Label Instructions;
	@FXML private Button StartGarden;
	@FXML private Label sec_1_Plant;
	@FXML private Label sec_1_Sprinklers;
	@FXML private Label sec_1_Heaters;
	@FXML private Label sec_1_Sensors;
	@FXML private Label sec_2_Plant;
	@FXML private Label sec_2_Sprinklers;
	@FXML private Label sec_2_Heaters;
	@FXML private Label sec_2_Sensors;
	@FXML private Label sec_3_Plant;
	@FXML private Label sec_3_Sprinklers;
	@FXML private Label sec_3_Heaters;
	@FXML private Label sec_3_Sensors;
	@FXML private Label sec_4_Plant;
	@FXML private Label sec_4_Sprinklers;
	@FXML private Label sec_4_Heaters;
	@FXML private Label sec_4_Sensors;
	@FXML private Label sec_5_Plant;
	@FXML private Label sec_5_Sprinklers;
	@FXML private Label sec_5_Heaters;
	@FXML private Label sec_5_Sensors;
	@FXML private Label sec_6_Plant;
	@FXML private Label sec_6_Sprinklers;
	@FXML private Label sec_6_Heaters;
	@FXML private Label sec_6_Sensors;
	
	
	@FXML
	private void ButtonStartGarden(ActionEvent event) {
		System.out.println("New Garden Created");
		this.GardenStatus.setText("Congratulations ! Your new garden has been created");
	}
	
	@FXML
	private void ButtonEditSection1(ActionEvent event) throws IOException {
		
		System.out.println("Section 1 Edit Clicked");
		//this.GardenStatus.setText("Editing Section 1");
		//this.StartGarden.setDisable(true);
		
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SectionEditorView.fxml"));
		Parent root =  (Parent)fxmlLoader.load(); 
		
		SectionEditorController controller = fxmlLoader.<SectionEditorController>getController();
		controller.setSectionConfiguration(sectionConfigList,section1Config,0);
		
		Scene scene = new Scene(root);
		Stage stage = (Stage) this.StartGarden.getScene().getWindow();//new Stage();
		stage.setTitle("Section Properties Editor");
		stage.setScene(scene);
		stage.show();    
	}
	

	@FXML
	private void ButtonEditSection2(ActionEvent event) throws IOException {
		
		System.out.println("Section 2 Edit Clicked");
		//this.GardenStatus.setText("Editing Section 2");
		//this.StartGarden.setDisable(true);
		
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SectionEditorView.fxml"));
		Parent root =  (Parent)fxmlLoader.load(); 
		
		SectionEditorController controller = fxmlLoader.<SectionEditorController>getController();
		controller.setSectionConfiguration(sectionConfigList,section2Config,1);
		
		Scene scene = new Scene(root);
		Stage stage = (Stage) this.StartGarden.getScene().getWindow();//new Stage();
		stage.setTitle("Section Properties Editor");
		stage.setScene(scene);
		stage.show();    
	}
	

	@FXML
	private void ButtonEditSection3(ActionEvent event) throws IOException {
		
		System.out.println("Section 3 Edit Clicked");
		//this.GardenStatus.setText("Editing Section 3");
		//this.StartGarden.setDisable(true);
		
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SectionEditorView.fxml"));
		Parent root =  (Parent)fxmlLoader.load(); 
		
		SectionEditorController controller = fxmlLoader.<SectionEditorController>getController();
		controller.setSectionConfiguration(sectionConfigList,section3Config,2);
		
		Scene scene = new Scene(root);
		Stage stage = (Stage) this.StartGarden.getScene().getWindow();//new Stage();
		stage.setTitle("Section Properties Editor");
		stage.setScene(scene);
		stage.show();    
	}
	

	@FXML
	private void ButtonEditSection4(ActionEvent event) throws IOException {
		
		System.out.println("Section 4 Edit Clicked");
		//this.GardenStatus.setText("Editing Section 4");
		//this.StartGarden.setDisable(true);
		
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SectionEditorView.fxml"));
		Parent root =  (Parent)fxmlLoader.load(); 
		
		SectionEditorController controller = fxmlLoader.<SectionEditorController>getController();
		controller.setSectionConfiguration(sectionConfigList,section4Config,3);
		
		Scene scene = new Scene(root);
		Stage stage = (Stage) this.StartGarden.getScene().getWindow();//new Stage();
		stage.setTitle("Section Properties Editor");
		stage.setScene(scene);
		stage.show();    
	}
	

	@FXML
	private void ButtonEditSection5(ActionEvent event) throws IOException {
		
		System.out.println("Section 5 Edit Clicked");
		//this.GardenStatus.setText("Editing Section 5");
		//this.StartGarden.setDisable(true);
		
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SectionEditorView.fxml"));
		Parent root =  (Parent)fxmlLoader.load(); 
		
		SectionEditorController controller = fxmlLoader.<SectionEditorController>getController();
		controller.setSectionConfiguration(sectionConfigList,section5Config,4);
		
		Scene scene = new Scene(root);
		Stage stage = (Stage) this.StartGarden.getScene().getWindow();//new Stage();
		stage.setTitle("Section Properties Editor");
		stage.setScene(scene);
		stage.show();    
	}
	

	@FXML
	private void ButtonEditSection6(ActionEvent event) throws IOException {
		
		System.out.println("Section 6 Edit Clicked");
		//this.GardenStatus.setText("Editing Section 6");
		//this.StartGarden.setDisable(true);
		
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SectionEditorView.fxml"));
		Parent root =  (Parent)fxmlLoader.load(); 
		
		SectionEditorController controller = fxmlLoader.<SectionEditorController>getController();
		controller.setSectionConfiguration(sectionConfigList,section6Config,5);
		
		Scene scene = new Scene(root);
		Stage stage = (Stage) this.StartGarden.getScene().getWindow();//new Stage();
		stage.setTitle("Section Properties Editor");
		stage.setScene(scene);
		stage.show();    
	}
	
	public void setSectionConfigList( List<SectionConfiguration> incomingList) {
		
		this.sectionConfigList = incomingList;
		
		getDefaultSectionConfigurations();
		updateSectionConfigurationViews();
		
	}
	
	public void updateSectionConfiguration(List<SectionConfiguration> incomingList,SectionConfiguration incomingConfig, int secNumber) {
		
		this.sectionConfigList = incomingList;
		//this.section1Config = incomingConfig;
		getDefaultSectionConfigurations();
		updateSectionConfigurationViews();
		
	}
	
	private void getDefaultSectionConfigurations() {
		
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
	}
	
	private void updateSectionConfigurationViews() {
		
		//System.out.println(section1Config.getPlantType());
		sec_1_Plant.setText(section1Config.getPlantType());
		sec_2_Plant.setText(section2Config.getPlantType());
		sec_3_Plant.setText(section3Config.getPlantType());
		sec_4_Plant.setText(section4Config.getPlantType());
		sec_5_Plant.setText(section5Config.getPlantType());
		sec_6_Plant.setText(section6Config.getPlantType());
		
		sec_1_Sprinklers.setText(Integer.toString(section1Config.getNumberOfSprinklers()));
		sec_2_Sprinklers.setText(Integer.toString(section2Config.getNumberOfSprinklers()));
		sec_3_Sprinklers.setText(Integer.toString(section3Config.getNumberOfSprinklers()));
		sec_4_Sprinklers.setText(Integer.toString(section4Config.getNumberOfSprinklers()));
		sec_5_Sprinklers.setText(Integer.toString(section5Config.getNumberOfSprinklers()));
		sec_6_Sprinklers.setText(Integer.toString(section6Config.getNumberOfSprinklers()));
		
		sec_1_Heaters.setText(Integer.toString(section1Config.getNumberOfHeaters()));
		sec_2_Heaters.setText(Integer.toString(section2Config.getNumberOfHeaters()));
		sec_3_Heaters.setText(Integer.toString(section3Config.getNumberOfHeaters()));
		sec_4_Heaters.setText(Integer.toString(section4Config.getNumberOfHeaters()));
		sec_5_Heaters.setText(Integer.toString(section5Config.getNumberOfHeaters()));
		sec_6_Heaters.setText(Integer.toString(section6Config.getNumberOfHeaters()));
		
		sec_1_Sensors.setText(section1Config.getSensorTypes());
		sec_2_Sensors.setText(section2Config.getSensorTypes());
		sec_3_Sensors.setText(section3Config.getSensorTypes());
		sec_4_Sensors.setText(section4Config.getSensorTypes());
		sec_5_Sensors.setText(section5Config.getSensorTypes());
		sec_6_Sensors.setText(section6Config.getSensorTypes());
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// this.GardenStatus.setText("Welcome");

	}

}
