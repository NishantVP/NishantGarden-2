package module.gui;
/**
 * COEN 275 OOAD - Individual Project
 * Automated Gardening System
 * 
 * By Nishant Phatangare (W1108022)
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * --About this <file>--
 * 
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import module.garden.SectionConfiguration;

public class GardenStart extends Application {
	

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		List<SectionConfiguration> sectionConfigList;
		SectionConfiguration section1Config,section2Config,section3Config;
		SectionConfiguration section4Config,section5Config,section6Config;

		sectionConfigList = new ArrayList<SectionConfiguration>();
		
		section1Config = new SectionConfiguration();
		section2Config = new SectionConfiguration();
		section3Config = new SectionConfiguration();
		section4Config = new SectionConfiguration();
		section5Config = new SectionConfiguration();
		section6Config = new SectionConfiguration();
		
		sectionConfigList.add(section2Config);
		sectionConfigList.add(section1Config);
		sectionConfigList.add(section3Config);
		sectionConfigList.add(section4Config);
		sectionConfigList.add(section5Config);
		sectionConfigList.add(section6Config);
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartScreenView.fxml"));
		Parent root =  (Parent)fxmlLoader.load(); 
		
		StartScreenController controller = fxmlLoader.<StartScreenController>getController();
		controller.setSectionConfigList(sectionConfigList);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Garden Configuration");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
