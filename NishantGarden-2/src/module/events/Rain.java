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
public class Rain extends Events{
	
	private int timeRemaining;
	
	public Rain() {
		super();
	}
	
	public int getTimeRemaining() {
		return this.timeRemaining;
	}
	public void decreaseTimeReaming() {
		this.timeRemaining --;
	}
	public void happens () {	
		Random rand = new Random();
		int randomNum = rand.nextInt((24 - 1) + 1) + 1;
		this.timeRemaining = randomNum;
	}

}
