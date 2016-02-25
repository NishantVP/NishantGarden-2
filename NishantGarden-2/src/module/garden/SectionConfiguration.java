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
public class SectionConfiguration implements InterfaceSectionCharacteristics {
	
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
	@Override
	public String getPlantType() {
		return this.plantType;
	}
	@Override
	public void setPlantType(String value) {
		this.plantType = value;
	}
	
	@Override
	public int getNumberOfSprinklers() {
		return this.numberOfSprinklers;
	}
	@Override
	public void setNumberOfSprinklers(int value) {
		this.numberOfSprinklers = value;
	}
	
	@Override
	public int getNumberOfHeaters() {
		return this.numberOfHeaters;
	}
	@Override
	public void setNumberOfHeaters(int value) {
		this.numberOfHeaters = value;
	}
	
	@Override
	public boolean getTempratureSensors() {
		return this.tempratureSensors;
	}
	@Override
	public void setTempratureSensors(boolean value) {
		this.tempratureSensors = value;
	}
	
	@Override
	public boolean getHumiditySensors() {
		return this.humiditySensors;
	}
	@Override
	public void setHumiditySensors(boolean value) {
		this.humiditySensors = value;
	}
	
	@Override
	public boolean getSoilWaterSensors() {
		return this.soilWaterSensors;
	}
	@Override
	public void setSoilWaterSensors(boolean value) {
		this.soilWaterSensors = value;
	}
	
	//-- Rest of the Code --//
	@Override
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
