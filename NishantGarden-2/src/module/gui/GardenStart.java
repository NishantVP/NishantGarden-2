package module.gui;
/**
 * COEN 275 OOAD - Individual Project
 * Automated Gardening System
 * 
 * By Nishant Phatangare (W1108022)
 */

import java.io.IOException;

/*
 * --About this <file>--
 * 
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GardenStart extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Parent root =  FXMLLoader.load(getClass().getResource("StartScreenView.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Garden Configuration");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
