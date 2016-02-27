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

/**
 * @author nishant
 *
 */
public class Events {
	
	protected boolean eventStatus;
	
	public Events() {
		this.eventStatus = false;
	}
	public boolean getEventStatus() {
		return this.eventStatus;
	}
	public void setEventStatus(boolean status) {
		 this.eventStatus = status;
	}
	
	public void happens () {
		this.eventStatus = true;
	}
	
	public void ends() {
		this.eventStatus = false;
	}

}
