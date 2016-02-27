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
package module.sensors;

/**
 * @author nishant
 *
 */
public class SoilSensor {
	
	private double waterLevel = 10;
	private double fertilizerLevel = 500;
	
	private int isThereSensor;
	// +ve value of this sensor indicates there is sensor
	// -ve value indicates there is no sensor
	
	public SoilSensor(boolean sensorAvailability) {
		if(sensorAvailability) {
			isThereSensor = 1;
		}
		else {
			isThereSensor = -1;
		}
	}
	
	//--Getters and Setters--//
	public double getWaterLevel() {
			double temp = this.waterLevel*this.isThereSensor;
			return temp;
		
	}
	public void setWaterLevel(double value) {
		this.waterLevel = value;
	}
	
	public double getFertilizerLevel() {
		return this.fertilizerLevel*isThereSensor;
	}
	public void setFertilizerLevel(double value) {
		this.fertilizerLevel = value;
	}
	
	public void increaseWaterLevelBy(double value) {
		this.waterLevel += value;
	}
	public void increaseFertilizerLevelBy(double value) {
		this.fertilizerLevel += value;
	}
	
	public void decreaseWaterLevelBy(double value) {
		this.waterLevel -= value;
	}
	public void decreaseFertilizerLevelBy(double value) {
		this.fertilizerLevel -= value;
	}
	

}
