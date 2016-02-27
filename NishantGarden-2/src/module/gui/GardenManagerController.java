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
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import module.garden.Garden;
import module.garden.SectionConfiguration;

/**
 * @author nishant
 *
 */
public class GardenManagerController implements Initializable {
	
	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	
	private List<SectionConfiguration> sectionConfigList;
	private String GardenStatus;
	private Garden NishantGarden;
	
	@FXML private Label gardenStatus;
	@FXML private Label time;
	@FXML private Label section1;
	@FXML private Label section2;
	@FXML private Label section3;
	@FXML private Label section4;
	@FXML private Label section5;
	@FXML private Label section6;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	public void setInitialConfiguration(List<SectionConfiguration> incomingList) {
		this.sectionConfigList = incomingList;
		System.out.println("GardenManagerController: Garden Manager Controller is now active");
		NishantGarden = new Garden(sectionConfigList,this);
	}
	
	
	//Interface to update the Status of the Garden on UI
	public synchronized void updateLabel(String s, int SectionID) {
		
		Task<Boolean> task = new Task<Boolean>() {
            @Override 
            public Boolean call() {    
            	//System.out.println("GardenManagerController: Inside Task ");
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                    	//gardenStatus.setText(GardenStatus); 
                    	if(SectionID == 1) {
                    		section1.setText(s);
                    	}
                    	else if(SectionID == 2) {
                    		section2.setText(s);
                    	}
                    	else if(SectionID == 3) {
                    		section3.setText(s);
                    	}
                    	else if(SectionID == 4) {
                    		section4.setText(s);
                    	}
                    	else if(SectionID == 5) {
                    		section5.setText(s);
                    	}
                    	else if(SectionID == 6) {
                    		section6.setText(s);
                    	}
                    }
                });
                try {
                  Thread.sleep(1000);
                }
                catch (InterruptedException e) {}
            return Boolean.valueOf(true);               
          }        
       };           
       Thread t = new Thread(task);
       t.setDaemon(true);
       t.start();
	}
	
	public synchronized void updateTime(String s, int SectionID) {
		//this.GardenStatus = "Garden Status: " +s;
		
		if(SectionID ==1) {
			Task<Boolean> task = new Task<Boolean>() {
	            @Override 
	            public Boolean call() {    
	            	//System.out.println("GardenManagerController: Inside Task ");
	                Platform.runLater(new Runnable() {
	                    @Override
	                    public void run() {
	                    	//gardenStatus.setText(GardenStatus);
	                    	
	                    	time.setText(s);
	                    	
	                    }
	                });
	                try {
	                  Thread.sleep(1000);
	                }
	                catch (InterruptedException e) {}
	            return Boolean.valueOf(true);               
	          }        
	       };           
	       Thread t = new Thread(task);
	       t.setDaemon(true);
	       t.start();
		}
		
	}

	
}
