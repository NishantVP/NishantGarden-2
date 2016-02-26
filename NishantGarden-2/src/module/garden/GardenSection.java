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
package module.garden;

import module.gui.GardenManagerController;
import module.plants.CornPlant;
import module.plants.LemonsPlant;
import module.plants.Plants;
import module.plants.PotatoesPlant;
import module.plants.RicePlant;
import module.plants.VegitablesPlant;
import module.plants.WheatPlant;
import module.timesimulation.GardenTimer;

/**
 * @author nishant
 *
 */
public class GardenSection implements Runnable{
	
	private SectionConfiguration SectionConfig;
	private int SectionID;
	private Plants plants;
	private GardenManagerController GardenManagerScreen;
	private GardenTimer GlobalTime;
	
	
	public GardenSection(SectionConfiguration incomingConfig, int id, 
							GardenManagerController screen, GardenTimer time) {
		this.SectionConfig = incomingConfig;
		this.SectionID = id;
		this.GardenManagerScreen = screen;
		this.GlobalTime = time;
		//System.out.println("GardenSection: " +"In contructor of " +SectionID );
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("GardenSection: " +"Thread for Section " +this.SectionID +" created");
		
		if(SectionConfig.getPlantType().equals("Wheat")) {
			plants = new WheatPlant();
			System.out.println("GardenSection: " +"Water Need " +plants.getCurrentWaterNeed());
		}
		else if(SectionConfig.getPlantType().equals("Lemons")) {
			plants = new LemonsPlant();
		}
		else if(SectionConfig.getPlantType().equals("Vegitables")) {
			plants = new VegitablesPlant();
		}
		else if(SectionConfig.getPlantType().equals("Rice")) {
			plants = new RicePlant();
		}
		else if(SectionConfig.getPlantType().equals("Corn")) {
			plants = new CornPlant();
		}
		else if(SectionConfig.getPlantType().equals("Potatoes")) {
			plants = new PotatoesPlant();
		}
		//Default plant is Wheat
		//Error Proofing :P if something goes wrong, it will create wheat plants 
		else {
			plants = new WheatPlant();
		}
		
	
		while(true) {
			System.out.println("GardenSection " +this.SectionID +": time- " +GlobalTime.getCurrentTime());
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
