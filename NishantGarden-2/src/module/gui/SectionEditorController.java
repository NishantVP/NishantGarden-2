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
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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
	private String plantType = "Wheat";
	private int numberOfSprinklers = 10;
	private int numberOfHeaters = 10;
	private boolean isTempSensors = true;
	private boolean isHumSensors = true;
	private boolean isSoilSensors = true;
	
	@FXML private ToggleGroup plantsToggleGroup;
	@FXML private ToggleGroup sprinklersToggleGroup;
	@FXML private ToggleGroup heatersToggleGroup;
	
	@FXML private RadioButton Wheat;
	@FXML private RadioButton Lemons;
	@FXML private RadioButton Vegitables;
	@FXML private RadioButton Rice;
	@FXML private RadioButton Corn;
	@FXML private RadioButton Potatoes;
	
	@FXML private RadioButton sprink1;
	@FXML private RadioButton sprink5;
	@FXML private RadioButton sprink10;
	
	@FXML private RadioButton heater1;
	@FXML private RadioButton heater5;
	@FXML private RadioButton heater10;
	
	@FXML private CheckBox tempSensor;
	@FXML private CheckBox humiditySensor;
	@FXML private CheckBox soilSensor;
	
	@FXML private Button SaveButton;
	
	@FXML
	private void plantsRadioButtonAction(ActionEvent event) {
		if(Wheat.isSelected()) {
			plantType = "Wheat";
			sectionConfig.setPlantType(plantType);
			System.out.println(plantType +" Selected");
		}
		else if(Lemons.isSelected()) {
			plantType = "Lemons";
			sectionConfig.setPlantType(plantType);
			System.out.println(plantType +" Selected");
		}
		else if(Vegitables.isSelected()) {
			plantType = "Vegitables";
			sectionConfig.setPlantType(plantType);
			System.out.println(plantType +" Selected");
		}
		else if(Rice.isSelected()) {
			plantType = "Rice";
			sectionConfig.setPlantType(plantType);
			System.out.println(plantType +" Selected");
		}
		else if(Corn.isSelected()) {	
			plantType = "Corn";
			sectionConfig.setPlantType(plantType);
			System.out.println(plantType +" Selected");
		}
		else  {			
			plantType = "Potatoes";
			sectionConfig.setPlantType(plantType);
			System.out.println(plantType +" Selected");
		}
	}
	
	@FXML
	private void sprinklersRadioButtonAction(ActionEvent event) {
		if(sprink1.isSelected()) {
			numberOfSprinklers = 1;
			sectionConfig.setNumberOfSprinklers(numberOfSprinklers);
			System.out.println("Number of Sprinklers Selected " +numberOfSprinklers);
		}
		else if(sprink5.isSelected()) {
			numberOfSprinklers = 5;
			sectionConfig.setNumberOfSprinklers(numberOfSprinklers);
			System.out.println("Number of Sprinklers Selected " +numberOfSprinklers);
		}
		else  {
			numberOfSprinklers = 10;
			sectionConfig.setNumberOfSprinklers(numberOfSprinklers);
			System.out.println("Number of Sprinklers Selected " +numberOfSprinklers);
		}
	}

	@FXML
	private void heatersRadioButtonAction(ActionEvent event) {
		if(heater1.isSelected()) {
			numberOfHeaters = 1;
			sectionConfig.setNumberOfHeaters(numberOfHeaters);
			System.out.println("Number of Heaters Selected " +numberOfHeaters);
		}
		else if(heater5.isSelected()) {
			numberOfHeaters = 5;
			sectionConfig.setNumberOfHeaters(numberOfHeaters);
			System.out.println("Number of Heaters Selected " +numberOfHeaters);
		}
		else  {
			numberOfHeaters = 10;
			sectionConfig.setNumberOfHeaters(numberOfHeaters);
			System.out.println("Number of Heaters Selected " +numberOfHeaters);
		}
	}
	
	@FXML
	private void sensorsCheckBoxAction(ActionEvent event) {
		if(tempSensor.isSelected()) {
			isTempSensors = true;
			sectionConfig.setTempratureSensors(isTempSensors);
			System.out.println("Temperature Sensors " +isTempSensors);
		}
		else {
			isTempSensors = false;
			sectionConfig.setTempratureSensors(isTempSensors);
			System.out.println("Temperature Sensors " +isTempSensors);
		}
		if(humiditySensor.isSelected()) {
			isHumSensors = true;
			sectionConfig.setHumiditySensors(isHumSensors);
			System.out.println("Humidity Sensors " +isHumSensors);
		}
		else {
			isHumSensors = false;
			sectionConfig.setHumiditySensors(isHumSensors);
			System.out.println("Humidity Sensors " +isHumSensors);
		}
		if(soilSensor.isSelected()) {
			isSoilSensors = true;
			sectionConfig.setSoilWaterSensors(isSoilSensors);
			System.out.println("Soil Sensors " +isSoilSensors);
		}
		else {
			isSoilSensors = false;
			sectionConfig.setSoilWaterSensors(isSoilSensors);
			System.out.println("Soil Sensors " +isSoilSensors);
		}
	}

	
	
	@FXML
	private void ButtonSave(ActionEvent event) throws IOException {
		System.out.println("Save Clicked");
		
		sectionConfigList.set(sectionNumber, sectionConfig);
		
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
	
	private void setViewOfCurrentSection()
	{
		plantType = sectionConfig.getPlantType();
		numberOfSprinklers = sectionConfig.getNumberOfSprinklers();
		numberOfHeaters = sectionConfig.getNumberOfHeaters();
		isTempSensors = sectionConfig.getTempratureSensors();
		isHumSensors = sectionConfig.getHumiditySensors();
		isSoilSensors = sectionConfig.getSoilWaterSensors();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
