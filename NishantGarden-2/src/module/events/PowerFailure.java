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
public class PowerFailure  extends Events {

	
	private int timeRemaining;
	
	public PowerFailure() {
		super();
	}
	
	public int getTimeRemaining() {
		return this.timeRemaining;
	}
	public void decreaseTimeReaming() {
		this.timeRemaining --;
		if(this.timeRemaining <= 0) {
			this.timeRemaining = 0;
			this.eventStatus =false;
		}
	}
	
	public void happens () {	
		this.eventStatus = true;
		Random rand = new Random();
		int randomNum = rand.nextInt((24 - 1) + 1) + 1;
		this.timeRemaining = randomNum;
	}
}
