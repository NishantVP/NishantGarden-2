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
	
	
	private boolean onOffStatus;
	
	public Heater () {
		
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
