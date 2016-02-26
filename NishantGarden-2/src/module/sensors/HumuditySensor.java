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
public class HumuditySensor {
	
	private double currentHumidity= 50;
	private int isThereSensor;
	// +ve value of this sensor indicates there is sensor
	// -ve value indicates there is no sensor
	
	public HumuditySensor(boolean sensorAvailability) {
		if(sensorAvailability) {
			isThereSensor = 1;
		}
		else {
			isThereSensor = -1;
		}
	}
	
	public double getCurrentTemprature() {
		return this.currentHumidity*isThereSensor;
	}
	public void setCurrentTemprature(double value) {
		this.currentHumidity = value;
	}

}
