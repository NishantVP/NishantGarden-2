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
package module.heatingsystem;

import module.sensors.TemperatureSensor;

/**
 * @author nishant
 *
 */
public class Heater {
	
	private TemperatureSensor tempratureSensor; 
	private boolean onOffStatus;
	
	public Heater (TemperatureSensor sensor) {
		this.tempratureSensor = sensor;
		this.onOffStatus = false;
	}
	
	public void turnOnHeater() {
		onOffStatus = true;
	}

	public void turnOffHeater() {
		onOffStatus = false;
	}
	
	public boolean getHeaterStatus () {
		return onOffStatus;
	}
}