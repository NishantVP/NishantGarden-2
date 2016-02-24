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

/**
 * @author nishant
 *
 */
public class Garden {
	
	//--Variables--//
	private GardenSection section1,section2,section3,section4,section5,section6; 
	//Future tip: change this to list to allow dynamic addition of sections
	
	public Garden() {
		this.section1 = new GardenSection();
		this.section2 = new GardenSection();
		this.section3 = new GardenSection();
		this.section4 = new GardenSection();
		this.section5 = new GardenSection();
		this.section6 = new GardenSection();
	}
	

}
