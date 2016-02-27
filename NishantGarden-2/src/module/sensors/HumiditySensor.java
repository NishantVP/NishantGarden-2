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
public class HumiditySensor {
	
	private double currentHumidity= 50;
	
	// +ve value of this sensor indicates there is sensor
	// -ve value indicates there is no sensor
	
	public HumiditySensor() {
		
	}
	
	public double getCurrentTemprature() {
		return this.currentHumidity;
	}
	public void setCurrentTemprature(double value) {
		this.currentHumidity = value;
	}


}
