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

/**
 * @author nishant
 *
 */
public class Garden {
	
	//--Variables--//
	private GardenSection section1,section2,section3,section4,section5,section6; 
	private List<SectionConfiguration> sectionConfigList;
	private GardenManagerController GardenManagerScreen;
	
	//Future tip: change this to list to allow dynamic addition of sections
	
	public Garden(List<SectionConfiguration> incomingSectionConfigList,GardenManagerController screen) {
		this.sectionConfigList = incomingSectionConfigList;
		this.GardenManagerScreen = screen;
		System.out.println("Garden: New Garden Created");
		GardenManagerScreen.updateLabel("Garden Object Created");
	}
	

}
