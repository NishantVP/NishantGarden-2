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

import java.util.Random;

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
	
	public void naturalIncreaseTemp() {
		 Random rand = new Random();
		 int randomNum = rand.nextInt((5 - 1) + 1) + 1;
		 currentTemprature += randomNum;
		
	}
	public void naturalDecreaseTemp() {
		Random rand = new Random();
		int randomNum = rand.nextInt((8 - 3) + 1) + 3;
		currentTemprature -= randomNum;
	}
	
	public void heaterIncreaseTemp() {
		 
		 currentTemprature += 0.08;
		
	}
	

}
