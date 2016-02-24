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

/**
 * @author nishant
 *
 */
public class SectionConfiguration {
	
	//--Variables--//
	private String plantType; 
	private int numberOfSprinklers;
	private int numberOfHeaters;
	private boolean tempratureSensors;
	private boolean humiditySensors;
	private boolean soilWaterSensors;
	
	//--Constructors--//
	public SectionConfiguration() {
		this.plantType = "Wheat";
		this.numberOfSprinklers = 10;
		this.numberOfHeaters = 10;
		this.tempratureSensors = true;
		this.humiditySensors = true;
		this.soilWaterSensors = true;
	}
	
	
	//--Getters and Setters--//
	public String getPlantType() {
		return this.plantType;
	}
	public void setPlantType(String value) {
		this.plantType = value;
	}
	
	public int getNumberOfSprinklers() {
		return this.numberOfSprinklers;
	}
	public void setNumberOfSprinklers(int value) {
		this.numberOfSprinklers = value;
	}
	
	public int getNumberOfHeaters() {
		return this.numberOfHeaters;
	}
	public void setNumberOfHeaters(int value) {
		this.numberOfHeaters = value;
	}
	
	public boolean getTempratureSensors() {
		return this.tempratureSensors;
	}
	public void setTempratureSensors(boolean value) {
		this.tempratureSensors = value;
	}
	
	public boolean getHumiditySensors() {
		return this.humiditySensors;
	}
	public void setHumiditySensors(boolean value) {
		this.humiditySensors = value;
	}
	
	public boolean getSoilWaterSensors() {
		return this.soilWaterSensors;
	}
	public void setSoilWaterSensors(boolean value) {
		this.soilWaterSensors = value;
	}
	
	//-- Rest of the Code --//
	public String getSensorTypes() {
		String sensorTypes = "";
		
		if(tempratureSensors) {
			sensorTypes = sensorTypes + " T";
		}
		if(humiditySensors) {
			sensorTypes = sensorTypes + " H";
		}
		if(soilWaterSensors) {
			sensorTypes = sensorTypes + " S";
		}
		return sensorTypes;
	}
	
}
