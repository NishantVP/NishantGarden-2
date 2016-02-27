/**
 * COEN 275 OOAD - Individual Project
 * Automated Gardening System
 * 
 * By Nishant Phatangare (W1108022)
 */

/*
 * --About this Class--
 *  This class is the blueprint for the garden. After getting configuration of a garden from user,
 *  the object of garden class is created. It has 6 sections that operate independently. This Class create
 *  each section of the garden as per specified configurations
 */
package module.garden;

import java.util.List;

import module.gui.GardenManagerController;
import module.timesimulation.GardenTimer;


/**
 * @author nishant
 *
 */
public class Garden {
	
	//--Variables--//
	private GardenSection section1,section2,section3,section4,section5,section6; 
	private List<SectionConfiguration> sectionConfigList;
	private GardenManagerController GardenManagerScreen;
	private GardenTimer GlobalTime;
	
	//Future tip: change this to list to allow dynamic addition of sections
	
	public Garden(List<SectionConfiguration> incomingSectionConfigList,GardenManagerController screen) {
		this.sectionConfigList = incomingSectionConfigList;
		this.GardenManagerScreen = screen;
		System.out.println("Garden: New Garden Created");
		//GardenManagerScreen.updateLabel("Garden Object Created");
		
		GlobalTime = new GardenTimer();
		new Thread(GlobalTime).start();
		//-- Create Garden Section threads -- //
		section1 = new GardenSection(sectionConfigList.get(0),1,GardenManagerScreen,GlobalTime);
	    new Thread(section1).start();
		section2 = new GardenSection(sectionConfigList.get(1),2,GardenManagerScreen,GlobalTime);
	    new Thread(section2).start();
		section3 = new GardenSection(sectionConfigList.get(2),3,GardenManagerScreen,GlobalTime);
	    new Thread(section3).start();
		section4 = new GardenSection(sectionConfigList.get(3),4,GardenManagerScreen,GlobalTime);
	    new Thread(section4).start();
		section5 = new GardenSection(sectionConfigList.get(4),5,GardenManagerScreen,GlobalTime);
	    new Thread(section5).start();
		section6 = new GardenSection(sectionConfigList.get(5),6,GardenManagerScreen,GlobalTime);
	    new Thread(section6).start();
	}
	

}
