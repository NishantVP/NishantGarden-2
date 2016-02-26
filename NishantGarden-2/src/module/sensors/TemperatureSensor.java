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
public class TemperatureSensor {
	
	private double currentTemprature = 50;
	
	private int isThereSensor;
	// +ve value of this sensor indicates there is sensor
	// -ve value indicates there is no sensor
	
	public TemperatureSensor(boolean sensorAvailability) {
		if(sensorAvailability) {
			isThereSensor = 1;
		}
		else {
			isThereSensor = -1;
		}
	}
	
	public double getCurrentTemprature() {
		return this.currentTemprature*isThereSensor;
	}
	public void setCurrentTemprature(double value) {
		this.currentTemprature = value;
	}
	

}
