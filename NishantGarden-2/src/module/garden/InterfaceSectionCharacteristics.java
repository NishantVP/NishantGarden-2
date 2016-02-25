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
public interface InterfaceSectionCharacteristics {
	
	String getPlantType();
	void setPlantType(String value);
	
	int getNumberOfSprinklers();
	void setNumberOfSprinklers(int value);
	
	int getNumberOfHeaters();
	void setNumberOfHeaters(int value);
	
	boolean getTempratureSensors();
	void setTempratureSensors(boolean value);
	
	boolean getHumiditySensors();
	void setHumiditySensors(boolean value);
	
	boolean getSoilWaterSensors();
	void setSoilWaterSensors(boolean value);
	
	public String getSensorTypes();

}
