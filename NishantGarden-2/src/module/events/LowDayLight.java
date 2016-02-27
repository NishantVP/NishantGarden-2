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
package module.events;

import java.util.Random;

/**
 * @author nishant
 *
 */
public class LowDayLight extends Events{
	
	private double severity;
	
	public LowDayLight() {
		super();
	}
	
	public double getSeverity() {
		return this.severity;
	}
	
	public void happens () {	
		Random rand = new Random();
		int randomNum = rand.nextInt((100 - 10) + 1) + 10;
		this.severity = randomNum;
	}
	
	
}
