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
package module.timesimulation;

import module.garden.GardenSection;

/**
 * @author nishant
 *
 */
public class GardenTimer implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	private long timeInSeconds = 0;
	private long simulationSpeed = 100;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("GardenTimer: Time Started");
		
		while(true) {	
			try {
				Thread.sleep(1000/simulationSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
	        timeInSeconds++;
		}
	}
	
	
	public synchronized long getCurrentTime() {
		return timeInSeconds;
	}

}
