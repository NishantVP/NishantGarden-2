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
package module.wateringsystem;

import module.sensors.SoilSensor;

/**
 * @author nishant
 *
 */
public class Sprinkler {
	
	private SoilSensor soilSensor; 
	private boolean onOffStatus;
	private double hourlyWaterSupply;
	
	public Sprinkler () {
		
		this.onOffStatus = false;
		this.hourlyWaterSupply = 50;
	}
	
	public void turnOnSprinkler() {
		onOffStatus = true;
	}

	public void turnOffSprinkler() {
		onOffStatus = false;
	}
	
	public boolean getSprinklerStatus () {
		return onOffStatus;
	}
	
	public double getHourlySupply() {
		return this.hourlyWaterSupply;
	
	}
	public void setHourlySupply(double value) {
		this.hourlyWaterSupply = value;
	}

}
